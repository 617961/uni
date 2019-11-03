#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void randomFill(int*, int);
void printArr(int*, int);
void swap(int*, int*);
int partition(int*, int, int);
void quickSort(int*, int, int);
int removeDuplicates(int*, int);

int main() {

    srand(time(0));
    int n = 10;
    int *arr = (int*)calloc(n, sizeof(int));

    randomFill(arr, n);
    printArr(arr, n);

    quickSort(arr, 0, n);
    printf("sorted: \n");
    printArr(arr, n);

    int m = removeDuplicates(arr, n);
    printf("without duplicates:\n");
    printArr(arr, m);

    return 0;
}

void randomFill(int *arr, int n){
    for(int i = 0; i < n - 1; i++){
        arr[i] = rand() % 20;
    }
}

void printArr(int *arr, int n){
    for(int i = 0; i < n; i++){
        printf("%d ", arr[i]);
    }
    printf("\n");
}

void swap(int *a, int *b){
    int t = *a;
    *a = *b;
    *b = t;
}

int partition(int *arr, int low, int high){
    int pivot = arr[high];
    int i = low - 1;

    for(int j = low; j <= high - 1; j++){
        if(arr[j] < pivot){
            i++;
            swap(&arr[i], &arr[j]);
        }
    }
    swap(&arr[i + 1], &arr[high]);
    return i + 1;
}

void quickSort(int *arr, int low, int high){
    if(low < high){
        int pi = partition(arr, low, high);
        quickSort(arr, low, pi - 1);
        quickSort(arr, pi + 1, high);
    }
}

int removeDuplicates(int *arr, int n){
    int j = 0;
    if(n == 0 || n == 1){
        return n;
    }

    for (int i=0; i < n-1; i++)
        if (arr[i] != arr[i+1])
            arr[j++] = arr[i];

    arr[j++] = arr[n-1];

    return j;
}