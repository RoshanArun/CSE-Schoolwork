#include <stdlib.h>
#include <pthread.h>
#include "LoadBalancer.h"
#include "InstanceHost.h"

// Define the structure for LoadBalancer
struct balancer {
    int batch_size;
    struct job_node* job_list;
    pthread_mutex_t mutex;
};

// Function to initialize the load balancer
balancer* balancer_create(int batch_size) {
    balancer* lb = (balancer*)malloc(sizeof(balancer));
    lb->batch_size = batch_size;
    lb->job_list = NULL;
    pthread_mutex_init(&lb->mutex, NULL);
    return lb;
}

// Function to shut down the load balancer
void balancer_destroy(balancer** lb) {
    pthread_mutex_destroy(&(*lb)->mutex);
    free(*lb);
    *lb = NULL;
}

// Function to add a job to the load balancer
void balancer_add_job(balancer* lb, int user_id, int data, int* data_return) {
    struct job_node* new_job = (struct job_node*)malloc(sizeof(struct job_node));
    new_job->user_id = user_id;
    new_job->data = data;
    new_job->data_result = data_return;
    new_job->next = NULL;

    pthread_mutex_lock(&lb->mutex);

    // Add the job to the list
    if (lb->job_list == NULL) {
        lb->job_list = new_job;
    } else {
        struct job_node* current = lb->job_list;
        while (current->next != NULL) {
            current = current->next;
        }
        current->next = new_job;
    }

    // Check if enough jobs to fill a batch
    if (count_jobs(lb->job_list) >= lb->batch_size) {
        // Request a new instance from InstanceHost
        host_request_instance(host_create(), lb->job_list);
        lb->job_list = NULL; // Clear the job list
    }

    pthread_mutex_unlock(&lb->mutex);