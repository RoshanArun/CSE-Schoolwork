/**
* Header file definition of functions to simulate a load balancer.
* 
* @uthor Khan, Acuna
* @version 1.1
*/

#include "LoadBalancer.h"

//struct for representing the load balancer
typedef struct balancer {
    struct job_node* batch_list;
    int batch_size;
} balancer;

/**
* Initializes the load balancer. Takes batch size as parameter.
*/
balancer* balancer_create(int batch_size) {
    if (batch_size < 1)
        return NULL;
    
    balancer* lb = (balancer*)malloc(sizeof(balancer));
    if (lb == NULL) return NULL;
    
    lb->batch_list = NULL;
    lb->batch_size = batch_size;
    
    //temp fix to link instancehost into this module!
    host* h = host_create();
    host_destroy(&h);
    
    return lb;    
}

/**
* Shuts down the load balancer. Ensures any outstanding batches have
* completed.
*/
void balancer_destroy(balancer** lb) {
    if (lb == NULL || *lb == NULL)
        return;
    
    free(*lb);
    *lb = NULL;
}

/**
* Adds a job to the load balancer. If enough jobs have been added to fill a
* batch, will request a new instance from the InstanceHost. When job is complete,
* *data_return will be updated with the result.
* 
* @param user_id the id of the user making the request.
* @param data the data the user wants to process.
* @param data_return a pointer to a location to store the result of processing.
*/
void balancer_add_job(balancer* lb, int user_id, int data, int* data_return) {
    if (lb == NULL || data_return == NULL) //data input validation and ptr safety.
        return;
    
    struct job_node* job = (struct job_node*)malloc(sizeof(struct job_node)); //create new job.
    if (job == NULL) return; //instance pointer safety.
    job->user_id = user_id;
    job->data = data;
    job->data_result = data_return;
    job->next = NULL; //Warning! If using with instance host, must link job before attaching job.
    
    //Add job to linked list of jobs.
    
    struct job_node* p = lb->batch_list; //traverse batch list (init to the first).
    
    if (p != NULL) //if at least one item, append job to the end.
        while (p->next != NULL) //trav until final item.
            p = p->next;
    
    if (lb->batch_size == 1 || p == NULL) //iff @size 1 or list is empty, attach job and return.
        lb->batch_list = job;
    else if (p != NULL) { //occurs when batch list contains more than one but less than batch_size.
        p->next = job;
    } else {
        //log ("Unhandled case in balancer::add_job ??"
    }
}
