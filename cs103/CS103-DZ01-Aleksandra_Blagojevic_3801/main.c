#include <stdio.h>
#include <math.h>

int biggestPrimeFactor(int n) {
    int i = 2;
    int largestPrimeFactor = 2;

    while (n != 1) {
        while (n % i == 0) {
            n = n / i;
            largestPrimeFactor = i;
        }
        i++;
    }
    return largestPrimeFactor;
}

int main() {

    int n = 13195;
    printf("%d ", biggestPrimeFactor(n));
    printf("%d ", biggestPrimeFactor(12));
    printf("%d", biggestPrimeFactor(73));

    return 0;
}