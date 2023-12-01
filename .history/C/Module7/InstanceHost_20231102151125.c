/**
 * Implementation of the instance host.
 */
#include "InstanceHost.h"
#include <pthread.h>
#include <semaphore.h>
#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>

// struct for storing necessary data in host list.
struct job_node
{
    sem_t *semaphore;      // value used to manage list condition.
    pthread_t *thread;     // thread ID of current thread.
    struct job_node *next; // pointer to next node in list.
};

/**
 * Struct to encapsulate all data related to an instance host.
 */
struct host
{
    int thread_count;
    int job_count;
    pthread_mutex_t lock;
    pthread_cond_t runnable_instance;
    struct job_node *head;
};

/**
 * Entry point for a host's thread. Handles any jobs passed to it and marks the
 * job complete so the creating thread can continue execution.
 */
void *host_run(void *arg)
{
    struct job_node *current = (struct job_node *)arg;
    if (current == NULL)
    {
        printf("Host: Value passed to thread is null, will attempt to run anyway.");
        pthread_exit(NULL);
    }
    sem_wait(current->semaphore);
    pthread_exit(NULL);
}

/**
 * Initializes the host environment.
 */
host *host_create()
{
    host *h = NULL;
    // allocate the host.
    h = (host *)malloc(sizeof(host));
    h->job_count = 0;
    h->thread_count = 0;
    // initialize the linked list, semaphore and lock.
    h->head = (struct job_node *)malloc(sizeof(struct job_node));
    h->head->thread = NULL;
    h->head->semaphore = (sem_t *)malloc(sizeof(sem_t));
    sem_init(h->head->semaphore, 0, 0);
    h->head->next = NULL;
    if (pthread_mutex_init(&(h->lock), NULL) != 0)
    {
        printf("Host: mutex init failed\n");
        h->head = NULL;
        free(h->head->semaphore);
        free(h->head);
        free(h);
        pthread_exit(NULL);
    }
    return h;
}

/**
 * Shuts down the host environment. Ensures any outstanding batches have
 * completed.
 */
void host_destroy(host **h)
{
    struct job_node *next = (*h)->head;
    struct job_node *current = next;
    // clean up any remaining jobs in job list.
    while (next != NULL)
    {
        next = next->next;
        free(current->semaphore);
        free(current);
        current = NULL;
    }
    if (pthread_mutex_destroy(&((*h)->lock)) != 0)
    {
        printf("Host: mutex destroy failed\n");
    }
    free((*h)->head);
    free(*h);
    *h = NULL;
}

/**
 * Creates and runs a new server instance (i.e., thread) to handle processing
 * the items contained in a batch (i.e., a listed list of job_node).
 *
 * @param job_batch_list A list containing the jobs in a batch to process.
 */
void host_request_instance(host *h, struct job_node *batch)
{
    if (h == NULL || batch == NULL)
    {
        printf("Host: Either host or job batch submission is NULL, aborting.\n");
        pthread_exit(NULL);
    }
    // attempt to find a thread from the cloned list.
    struct job_node *tmp = h->head;
    if (tmp->semaphore == NULL)
    {
        // thread failed or has not run exit quietly.
        pthread_exit(NULL);
    }
    pthread_t thread;
    sem_t semaphore;
    sem_init(&semaphore, 0, 0);
    int error = pthread_create(&thread, NULL, &host_run, (void *)tmp);
    if (error != 0)
    {
        printf("Host: could not request additional thread (%d).", (error));
        pthread_exit(NULL);
    }
    pthread_mutex_lock(&(h->lock));
    h->head = tmp->next;
    h->job_count -= h->thread_count;
    h->thread_count++;
    pthread_mutex_unlock(&(h->lock));
    // don't return until the thread comes back online and work completes..
    sem_wait(&semaphore);
    h->thread_count--;
    sem_destroy(&semaphore);
}