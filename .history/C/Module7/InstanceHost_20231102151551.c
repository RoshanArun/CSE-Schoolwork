#include <stdlib.h>
#include <pthread.h>
#include "InstanceHost.h"
#include "LoadBalancer.h"

// Define the structure for InstanceHost
struct host {
    pthread_t thread;
};

// Helper function to process data (square the value)
void process_data(struct job_node* job) {
    if (job != NULL) {
        *(job->data_result) = job->data * job->data;
    }
}

// Helper function to count the number of jobs in a list
int count_jobs(struct job_node* list) {
    int count = 0;
    struct job_node* current = list;
    while (current != NULL) {
        count++;
        current = current->next;
    }
    return count;
}

// Function to initialize the host environment
host* host_create() {
    host* h = (host*)malloc(sizeof(host));
    return h;
}

// Function to shut down the host environment
void host_destroy(host** h) {
    free(*h);
    *h = NULL;
}

// Function to create a new server instance (thread) to handle processing
void host_request_instance(host* h, struct job_node* batch) {
    pthread_create(&h->thread, NULL, (void*)process_data, (void*)batch);
    pthread_join(h->thread, NULL); // Wait for the thread to finish
}