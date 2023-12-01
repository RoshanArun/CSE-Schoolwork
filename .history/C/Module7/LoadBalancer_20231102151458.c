#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>

int main(void) {
  // Create a socket to listen for connections.
  int sockfd = socket(AF_INET, SOCK_STREAM, 0);
  if (sockfd < 0) {
    perror("socket");
    exit(1);
  }

  // Bind the socket to a port.
  struct sockaddr_in servaddr;
  servaddr.sin_family = AF_INET;
  servaddr.sin_port = htons(8080);
  servaddr.sin_addr.s_addr = INADDR_ANY;
  if (bind(sockfd, (struct sockaddr *)&servaddr, sizeof(servaddr)) < 0) {
    perror("bind");
    exit(1);
  }

  // Listen for connections.
  listen(sockfd, 5);

  // Accept connections and dispatch them to workers.
  while (1) {
    int clientfd = accept(sockfd, NULL, NULL);
    if (clientfd < 0) {
      perror("accept");
      continue;
    }

    // Create a new worker thread to handle the connection.
    pthread_t thread;
    pthread_create(&thread, NULL, worker, (void *)clientfd);
  }

  return 0;
}

void worker(void *arg) {
  // Get the client socket from the thread argument.
  int clientfd = (int)arg;

  // Read data from the client.
  char buf[1024];
  int bytes_read = read(clientfd, buf, sizeof(buf));
  if (bytes_read < 0) {
    perror("read");
    close(clientfd);
    return;
  }

  // Write the data back to the client.
  write(clientfd, buf, bytes_read);

  // Close the client socket.
  close(clientfd);
}