#include <stdlib.h>
#include <pthread.h>
#include "LoadBalancer.h"
#include "InstanceHost.h"

struct balancer
{
    int size;
    struct job_node *list;
    pthread_mutex_t mutex;
};

balancer *balancer_create(int batch_size)
{
    balancer *lb = (balancer *)malloc(sizeof(balancer));
    lb->size = batch_size;
    lb->list = NULL;
    pthread_mutex_init(&lb->mutex, NULL);
    return lb;
}

void balancer_destroy(balancer **lb)
{
    pthread_mutex_destroy(&(*lb)->mutex);
    free(*lb);
    *lb = NULL;
}

void balancer_add_job(balancer *lb, int user_id, int data, int *data_return)
{
    struct job_node *job = (struct job_node *)malloc(sizeof(struct job_node));
    job->user_id = user_id;
    job->data = data;
    job->data_result = data_return;
    job->next = NULL;

    pthread_mutex_lock(&lb->mutex);

    if (lb->list == NULL)
    {
        lb->list = job;
    }
    else
    {
        struct job_node *current = lb->list;
        while (current->next != NULL)
        {
            current = current->next;
        }
        current->next = job;
    }

    if (count(lb->list) >= lb->size)
    {
        host_request_instance(host_create(), lb->list);
        lb->list = NULL;
    }

    pthread_mutex_unlock(&lb->mutex);
}