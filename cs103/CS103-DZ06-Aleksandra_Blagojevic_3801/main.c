#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

#define BUFSIZE 8

//zadatak -> 2

typedef struct node {
    int data;
    struct node* next;
} node_t;

typedef struct stack {
    node_t* top;
    node_t* root;
} stack_t;

stack_t stack_new() {
    stack_t newstack;
    newstack.top = NULL;
    newstack.root = NULL;
    return newstack;
}

node_t* node_new(int data) {
    node_t* newnode = calloc(1, sizeof(node_t));
    newnode->data = data;
    newnode->next = NULL;
    return newnode;
}

int stack_isempty(stack_t* stack) {
    return stack->top == NULL && stack->root == NULL;
}

void stack_push(stack_t* stack, node_t* node) {
    if (stack_isempty(stack)) {
        stack->top = node;
        stack->root = node;
    } else {
        node->next = stack->top;
        stack->top = node;
    }
}

node_t* stack_peek(stack_t* stack) {
    return stack->top;
}

int main() {
    char buf[BUFSIZE];
    int num = INT_MAX;

    stack_t stack = stack_new();

    while (1) {
        printf("enter num: ");
        fgets(buf, BUFSIZE - 1, stdin);
        num = (int) strtol(buf, NULL, 10);

        if (stack_peek(&stack) == NULL || num >= stack_peek(&stack)->data) {
            printf("num: %d\n", num);
            stack_push(&stack, node_new(num));
        } else {
            break;
        }
    }

}