#include "LoadBalancer.h"
#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>

// mutex and condition variable for synchronization
static pthread_mutex_t mutex = PTHREAD_MUTEX_INITIALIZER;
static pthread_cond_t cond = PTHREAD_COND_INITIALIZER;

static int batch_size;
static struct job_node *job_list = NULL;
static int job_count = 0;
static pthread_t instance_thread;
static int instance_id = 0;

// forward declaration for internal (private) function
void *instance_thread_func(void *arg);

void balancer_init(int batch_size_param)
{
    batch_size = batch_size_param;
    pthread_create(&instance_thread, NULL, &instance_thread_func, NULL);
}

void balancer_shutdown()
{
    // wait for the instance thread to finish before program exit
    pthread_join(instance_thread, NULL);

    // free dynamically allocated job nodes
    struct job_node *current = job_list;
    while (current != NULL)
    {
        struct job_node *next = current->next;
        free(current);
        current = next;
    }
}

void balancer_add_job(int user_id, int data, int *data_result)
{
    // create a new job node
    struct job_node *new_job = (struct job_node *)malloc(sizeof(struct job_node));
    new_job->user_id = user_id;
    new_job->data = data;
    new_job->data_result = data_result;
    new_job->next = NULL;

    // add the job node to the end of the job list
    pthread_mutex_lock(&mutex);
    if (job_list == NULL)
    {
        job_list = new_job;
    }
    else
    {
        struct job_node *current = job_list;
        while (current->next != NULL)
        {
            current = current->next;
        }
        current->next = new_job;
    }
    job_count++;

    // signal the instance thread to check the job list
    pthread_cond_signal(&cond);
    pthread_mutex_unlock(&mutex);
}

void *instance_thread_func(void *arg)
{
    while (1)
    {
        // wait for the job list to have enough jobs to form a batch
        pthread_mutex_lock(&mutex);
        while (job_count < batch_size)
        {
            pthread_cond_wait(&cond, &mutex);
        }

        // create a new instance host thread to process the batch
        printf("Instance Host #%d: Processing batch with %d jobs.\n", instance_id, batch_size);
        instance_host_create_thread(job_list, batch_size, instance_id);

        // update the job list and job count
        struct job_node *new_job_list = NULL;
        struct job_node *current = job_list;
        for (int i = 0; i < batch_size; i++)
        {
            struct job_node *next = current->next;
            current->next = NULL;
            if (new_job_list == NULL)
            {
                new_job_list = current;
            }
            else
            {
                struct job_node *temp = new_job_list;
                while (temp->next != NULL)
                {
                    temp = temp->temp->next;
                }
                temp->next = current;
            }
            current = next;
        }
        job_list = new_job_list;
        job_count -= batch_size;
        // increment instance ID for the next batch
        instance_id++;

        pthread_mutex_unlock(&mutex);
    }

    return NULL;
}
