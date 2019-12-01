#include <stdio.h>
#include <stdlib.h>

struct treenode {
    int val;
    int h;
    struct treenode* left;
    struct treenode* right;
};

int max(int a, int b) {
    return a > b ? a : b;
}

int height(struct treenode* node) {
    if (node == NULL) {
        return 0;
    }
    int h1 = height(node->left) + 1;
    int h2 = height(node->right) + 1;
    int m = max(h1, h2);
    node->h = m;
    return m;
}

void ll_rotate(struct treenode* parent) {
    struct treenode* node = parent->right;
    parent->right = node->right;
    parent->right->left = node;
    node->right = NULL;
    parent->h = height(parent);
    node->h = height(node);
}

//    10
// 12    8
//         4
//           2

//    10
// 12    4
//      8  2
//


int main(int argc, char** argv) {
    struct treenode root;
    root.val = 10;
    root.right = calloc(1, sizeof(struct treenode));
    root.right->val = 8;

    root.right->right = calloc(1, sizeof(struct treenode));
    root.right->right->val = 4;

    root.right->right->right = calloc(1, sizeof(struct treenode));
    root.right->right->right->val = 2;

    root.left = calloc(1, sizeof(struct treenode));
    root.left->val = 12;

    printf("%d l: %d r: %d\n", root.right->val, root.right->right ? root.right->right->val : -1,
           root.right->left ? root.right->left->val : -1);
    root.h = height(&root);
    printf("root h: %d\n", root.h);
    ll_rotate(&root);
    printf("%d l: %d r: %d\n", root.right->val, root.right->right ? root.right->right->val : -1,
           root.right->left ? root.right->left->val : -1);
    printf("root h: %d\n", root.h);

    return 0;
}