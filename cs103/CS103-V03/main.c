#include <stdio.h>
#include <string.h>
// 1/3 + 2/5 + 3/7... n/2*n+1
int sum(int n){
    return n == 1 ? 1.0 / 3 : sum(n - 1) + n * 1.0 / (2 * n + 1);
}

char* reverse(char* str){
    static int i = 0;
    static char rev[50];

    if(*str){
        reverse(str + 1);
        rev[i++] = *str;
    }
    return rev;
}

int isPalindrome(char* str, int len){
    if(len <= 0){
        return 1;
    }
    if(str[0] == str[len - 1]){
        return isPalindrome(str + 1, len - 2);
    } else {
        return 0;
    }
}

int main() {
    
    char str[10] = "aya";

    printf("%d", isPalindrome(str, 3));
    return 0;
}