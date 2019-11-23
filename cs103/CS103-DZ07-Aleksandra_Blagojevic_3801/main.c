/*2.Napisati funkciju koja pronalazi najveću vrednost
 * u binarnom stablu.*/
#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
#define COUNT 10

typedef struct node{
    int data;
    struct node *left;
    struct node *right;
} node_t;

node_t* newNode(int);

void print2dTree(node_t*, int);

void print2d(node_t*);

int biggestLeaf(node_t*);


int main() {

    node_t *root   = newNode(1);
    root->left   = newNode(2);
    root->right  = newNode(3);

    root->left->left  = newNode(4);
    root->left->right = newNode(5);
    root->right->left  = newNode(6);
    root->right->right = newNode(7);

    root->left->left->left  = newNode(8);
    root->left->left->right  = newNode(9);
    root->left->right->left  = newNode(10);
    root->left->right->right  = newNode(11);
    root->right->left->left  = newNode(12);
    root->right->left->right  = newNode(13);
    root->right->right->left  = newNode(14);
    root->right->right->right  = newNode(15);

    //print2d(root);
    int res = biggestLeaf(root);
    printf("%d", res);

    return 0;
}

node_t* newNode(int data){
    node_t* node = (node_t*) malloc (sizeof(node_t));

    if(node == NULL){
        fprintf(stderr, "memory not allocated properly");
        return NULL;
    }

    node->data = data;
    node->left = NULL;
    node->right = NULL;
    return node;
}

void print2dTree(node_t* root, int space){
    if(root == NULL)
        return;

        space += COUNT;
        print2dTree(root->right, space);

        printf("\n");

        for(int i = COUNT; i < space; i++)
            printf(" ");
            printf("%d\n", root->data);

        print2dTree(root->left, space);
}

void print2d(node_t* root){
    print2dTree(root, 0);
}

int biggestLeaf(node_t* root) {
    if (root == NULL) {
        return INT_MIN;
    }

    int res = root->data;
    int lLeaf = biggestLeaf(root->left);
    int rLeaf = biggestLeaf(root->right);

    if (lLeaf > res){
        res = lLeaf;
    }
    if(rLeaf > res) {
        res = rLeaf;
    }
    return res;
}