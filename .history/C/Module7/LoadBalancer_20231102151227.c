/**
 * Initializes the load balancer. Takes batch size as parameter.
 */
#include Loadbalancer.h;
balancer *balancer_create(int batch_size)
{
    if (batch_size <= 0)
    {
        printf("Balancer: batch size cannot be negative or zero.\n");
        pthread_exit(NULL);
    }
    // request memory and zero out contents of structure
    balancer *b = (balancer *)malloc(sizeof(balancer));
    if (b == NULL)
    {
        printf("Balancer: could not allocate memory for work balancer\n");
        pthread_exit(NULL);
    }
    b->current_batch = NULL;
    b->tail = NULL;
    b->batch_counter = 0;
    b->current_batch_size = batch_size;
    // initialize the semaphore drain_pipes to the number of requests to fill a batch..
    if (sem_init(&(b->drain_pipes), 0, batch_size) != 0)
    {
        printf("Balancer: unable to initialize semaphore\n.");
        free(b);
        pthread_exit(NULL);
    }
    // initialize the semaphore to force a unique requestor at a time.
    if (sem_init(&(b->least_load), 0, 1) != 0)
    {
        printf("Balancer: unable to initialize lock semaphore\n.");
        sem_destroy(&(b->drain_pipes));
        free(b);
        pthread_exit(NULL);
    }
    // initialize the pthread mutex.
    if (pthread_mutex_init(&(b->lock), NULL) != 0)
    {
        printf("Balancer: mutex init failed\n");
        sem_destroy(&(b->least_load));
        sem_destroy(&(b->drain_pipes));
        free(b);
        pthread_exit(NULL);
    }
    return b;
}

/**
 * Shuts down the load balancer. Ensures any outstanding batches have
 * completed.
 */
void balancer_destroy(balancer **lb)
{
    if (lb == NULL)
    {
        printf("Balancer: cannot destroy Load Balancer as there's no longer a reference.");
        return;
    }
    if (*lb == NULL)
    {
        printf("Balancer: a reference to the buffer was never created, nothing to destroy.");
        return;
    }
    while ((*lb)->current_batch != NULL)
    {
        struct job_node *tmp = (*lb)->tail->next;
        (*lb)->tail->next = NULL; // cut loose before not freeing.
        free(tmp);
    }
    sem_destroy(&((*lb)->drain_pipes));
    pthread_mutex_destroy(&((*lb)->lock));
    free((*lb));
    *lb = NULL;
    return;
}

/**
 * Adds a job to the load balancer. If enough jobs have been added to fill a
 * batch, will request a new instance from InstanceHost. When job is complete,
 * *data_result will be updated with the result.
 *
 * @param user_id the id of the user making the request.
 * @param data the data the user wants to process.
 * @param data_return a pointer to a location to store the result of processing.
 */
void balancer_add_job(balancer *lb, int user_id, int data, int *data_return)
{
    // create a job entry
    struct job_node *job = (struct job_node *)malloc(sizeof(struct job_node));
    if (job == NULL)
    { // wish full thinking (completely validated memories)
        printf("Balancer: Job cannot be null, aborting\n");
        pthread_exit(0);
    }
    job->user_id = user_id;
    job->data = data;
    job->data_result = data_return;
    job->next = NULL;
    lb->tail->next = job;
    lb->tail = job;      // render everything functional.
    lb->batch_counter++; // increment the batch thread counter.
    sem_wait(&(lb->drain_pipes));
    // all data is sent to the bucket it bucked and set
    if (lb->current_batch == NULL)
    {
        lb->current_batch = job;
        // queue the first instance.
        return;
    }
    lb->current_batch_size--;
    lb->current_batch->next = job;
    if (lb->current_batch_size == 0 && lb->batch_counter == (lb->current_batch_size + 1))
    {
        host_request_instance(NULL, lb->current_batch);
        lb->batch_counter = 0;
        lb->current_batch_size = 0;
        lb->current_batch = NULL;
        return;
    }
}