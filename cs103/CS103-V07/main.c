#include <stdio.h>
#include <stdlib.h>

typedef struct node{
  int data;
  struct node* left;
  struct node* right;
} node_t;

node_t* new_node(int);

void add_to_tree(node_t**, int);

int main() {
    node_t* root = NULL;
    add_to_tree(root, 15);

    printf("%d \n", root->data);

    return 0;
}

node_t* new_node(int data){
    node_t* node = (node_t*)malloc(sizeof(node_t));

    if(node == NULL){
        fprintf(stderr, "memory not allocated properly");
        return NULL;
    }
    node->data = data;
    node->left = NULL;
    node->right = NULL;

    return node;
}

void add_to_tree(node_t** root, int newNodeData){
    if (*root == NULL) {
        (*root) = new_node(newNodeData);
    }
    else if ((*root)->data < newNodeData) {
        add_to_tree(&(*root)->left, newNodeData);
    }
    else{
        add_to_tree(&(*root)->right, newNodeData);
    }
    }

void print_infix(node_t* root){
    if(root != NULL){
        print_infix(root->left);
        printf("%d ", root->data);
        print_infix(root->right);
    }
}

void print_prefix(node_t* root){
    if(root != NULL){
        printf("%d ", root->data);
        print_prefix(root->left);
        print_prefix(root->right);
    }
}

void print_postfix(node_t* root){
    if(root != NULL){
        print_postfix(root->left);
        print_postfix(root->right);
        printf("%d ", root->data);
    }
}

int sum_of_nodes(node_t* root){
    int sum = 0;
    if(root == NULL){
       return 1;
    }
    return sum += (int) (sum_of_nodes(root->left) + root->data + root->right);
}

int sum_of_left_nodes(node_t* root){
    int sum = 0;
    if(root == NULL){
        return 1;
    }
    if(root->left == NULL && root->right == NULL){
        sum += root->data;
    }

}