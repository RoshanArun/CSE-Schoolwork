#include <stdlib.h>
#include <pthread.h>
#include "InstanceHost.h"
#include "LoadBalancer.h"

struct host
{
    pthread_t thread;
};

void process(struct job_node *j)
{
    if (j != NULL)
    {
        *(j->data_result) = j->data * j->data;
    }
}

int count_jobs(struct job_node *list)
{
    int count = 0;
    struct job_node *current = list;
    while (current != NULL)
    {
        count++;
        current = current->next;
    }
    return count;
}

host *host_create()
{
    host *h = (host *)malloc(sizeof(host));
    return h;
}

void host_destroy(host **h)
{
    free(*h);
    *h = NULL;
}

void host_request_instance(host *h, struct job_node *batch)
{
    pthread_create(&h->thread, NULL, (void *)process, (void *)batch);
    pthread_join(h->thread, NULL); 
}