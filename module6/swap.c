#include <stdio.h>

void swap(int *a, int *b) {
    int temp = *a;
    *a = *b;
    *b = temp;
}

/* broken_swap receives copies of the values, not their addresses.
   Changes made inside the function do not affect the caller's variables. */
void broken_swap(int a, int b) {
    int temp = a;
    a = b;
    b = temp;
}

int main(void) {
    int x = 10, y = 20;

    printf("Before swap: x = %d, y = %d\n", x, y);
    swap(&x, &y);
    printf("After swap:  x = %d, y = %d\n", x, y);

    int p = 10, q = 20;
    printf("\nBefore broken_swap: p = %d, q = %d\n", p, q);
    broken_swap(p, q);
    printf("After broken_swap:  p = %d, q = %d\n", p, q);

    return 0;
}
