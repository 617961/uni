#include <stdio.h>
#include <stdlib.h>
#define N 8

typedef struct node{
    int dest;
    struct node* next;
}node_t;

typedef struct graph{
    node_t* head[N];
}graph_t;

typedef struct edge{
    int src, dest;
}edge_t;


graph_t* createGraph(edge_t[], int);

void print_graph(graph_t*);


int main() {

    edge_t edges[] = {
            {0, 1}, {1, 2}, {2, 3}, {3, 4},
            {4, 5}, {5, 6}, {5, 4}
    };

    int n = sizeof(edges)/ sizeof(edges[0]);

    graph_t* graphG = createGraph(edges, n);
    print_graph(graphG);
    return 0;
}


graph_t* createGraph(edge_t edges[], int n){
    unsigned i;
    graph_t* graphG = (graph_t*) malloc(sizeof(graph_t));

    for(i = 0; i < N; i++)
        graphG->head[i] = NULL;

        for(i = 0; i < n; i++){
            int src = edges[i].src;
            int dest = edges[i].dest;

            node_t* newNode = (node_t*) malloc(sizeof(node_t));
            newNode->dest = dest;

            newNode->next = graphG->head[src];
            graphG->head[src] = newNode;

            newNode = (node_t*) malloc(sizeof(node_t));
            newNode->dest = src;

            newNode->next = graphG->head[dest];
            graphG->head[dest] = newNode;
        }
    return graphG;
}

void print_graph(graph_t* graph){
    for(int i = 0; i < N; i++){
        node_t* ptr = graph->head[i];
        while(ptr != NULL){
            printf("(%d -> %d\t", i, ptr->dest);
            ptr = ptr->next;
        }
        printf("\n");
    }
}