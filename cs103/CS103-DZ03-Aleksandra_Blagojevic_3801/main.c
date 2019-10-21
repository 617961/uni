#include <stdio.h>

long pascal(int n, int i) {
    if (i < 0 || n < 0 || i > n) { return 0; }
    if (n == 1) {
        return 1;
    } else {
        return pascal(n - 1, i) + pascal(n - 1, i - 1);
    }
}

int main() {
    int n = 7, m = 0, k = 0, s = 0;

    for (k = 0; n >= k; k++) {
        for (s = 0; s < n - k; s++)
            printf(" ");
        for (m = 0; k >= m; m++) {
            long f = pascal(k, m);
            printf("%ld ", f);
        }
        printf("\n");
    }

    return 0;
}