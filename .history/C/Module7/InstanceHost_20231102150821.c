//Struct for representing a job
struct job_node {
    int user_id; //unique id of user
    int data; //input data provided by user.
    int* data_result; //pointer to place in global memory to store result.
    //negative one (-1) means result not computed.
    struct job_node* next; //pointer to the next job in a list of jobs.
    };

//Structure to represent an instance host
typedef struct host {
    int running; //flag to determine if host is running.
    struct job_node* active_jobs; //pointer to a list of jobs the host is working on.
    pthread_mutex_t jobs_lock; //list cover lock
    pthread_mutex_t res_lock; //lock for the shared resource struct above.
    pthread_t* active_instance_id; //pointer to a list of active instance ids.
    unsigned int n_active_instances;//number of active instances
    } host;

/**
* Initializes the host environment.
*/
host* host_create() {
    struct host* h;
    if ((h = (host*)malloc(sizeof(host))) == NULL)
        return NULL;
    
    h->active_jobs = NULL;
    pthread_mutex_init(&h->jobs_lock, NULL);
    pthread_mutex_init(&h->res_lock, NULL);
    h->active_instance_id = NULL;
    h->n_active_instances = 0;
    h->running  = 1;
    
    return h;
}

/**
* Shuts down the host environment. Ensures any outstanding batches have
* completed.
*/
void host_destroy(host** h) {
    if (h != NULL && *h != NULL) {
        free((*h)->active_instance_id);
        free(*h);
        *h = NULL;
    }
}

/**
* Creates a new server instance (i.e., thread) to handle processing the items
* contained in a batch (i.e., a linked list of job_node). Instance host will
* maintain a list of active instances, and if the host is requested to
* shutdown, ensures that all jobs are completed.
*
* @param job_batch_list A list containing the jobs in a batch to process.
*/
void host_request_instance(host* h, struct job_node* batch) {
    return;
}
