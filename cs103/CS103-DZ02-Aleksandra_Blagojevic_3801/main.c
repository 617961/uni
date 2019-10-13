#include <math.h>
#include <stdio.h>

// 1234 int arr[10] int n
// 1|234
// 12|34
// 123|4

int isPrime(int n) {
    if (n < 2) {
        return 0;
    }
    for (int i = 2; i <= sqrt(n); i++) {
        if (n % i == 0) {
            return 0;
        }
    }
    return 1;
}

void reverse(int arr[], int n) {
    for (int i = 0; i < n / 2; ++i) {
        int temp = arr[i];
        arr[i] = arr[n - i - 1];
        arr[n - i - 1] = temp;
    }
}

int test_digit(int * arr, int n, int digcount) {
    int left = 0, right = 0;
    for (int i = 0; i < n; ++i) {
        left += arr[i] * pow(10, n - i - 1);
    }
    for (int j = n; j < digcount; ++j) {
        right += arr[j] * pow(10, digcount - j - 1);
    }
    // printf("%d %d\n", left, right);
    return isPrime(left) == 1 && isPrime(right) == 1;
}

int split_digit(int n) {
    int digits[10];
    int digcount = 0;

    while (n != 0) {
        int x = n % 10;
        n /= 10;
        digits[digcount] = x;
        digcount++;
    }
    reverse(digits, digcount);
    for (int j = 1; j < digcount; ++j) {
        if (test_digit(digits, j, digcount)) {
            return 1;
        }
    }

    return 0;

}

int main(void) {
    for (int i = 0; i < 200; ++i) {
        if (split_digit(i)){
            printf("%d\n", i);
        }
    }
}