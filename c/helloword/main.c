//
//  main.c
//  helloword
//
//  Created by dstkdevhrp on 2022/7/7.
//

#include <stdio.h>

int main(int argc, const char * argv[]) {
    
    // Input '\n' to ensure the output, 
    // otherwise the result will be put in the buffer temporarily
    printf("Hello, World!\n\n");

    // More variables, more memory occupation
    int a1 = 20, a2 = 345, a3 = 700, a4 = 22;
    int b1 = 56720, b2 = 9999, b3 = 20098, b4 = 2;
    int c1 = 233, c2 = 205, c3 = 1, c4 = 6666;
    int d1 = 34, d2 = 0, d3 = 23, d4 = 23006783;

    // Align on left
    printf("%-9d %-9d %-9d %-9d\n", a1, a2, a3, a4);
    printf("%-9d %-9d %-9d %-9d\n", b1, b2, b3, b4);
    printf("%-9d %-9d %-9d %-9d\n", c1, c2, c3, c4);
    printf("%-9d %-9d %-9d %-9d\n", d1, d2, d3, d4);

    // Align on right
    printf("%9d %9d %9d %9d\n", a1, a2, a3, a4);
    printf("%9d %9d %9d %9d\n", b1, b2, b3, b4);
    printf("%9d %9d %9d %9d\n", c1, c2, c3, c4);
    printf("%9d %9d %9d %9d\n", d1, d2, d3, d4);

    // Can be initialized without length
    // Must ended with '\0', to avoid chaos
    // array[] can be used in both printf and scanf
    char init_1[] = {'c', ' ', 'p', 'r', 'o',
                'g', 'r', 'a', 'm', '\0'};

    // pointer * can only be used in printf
    char *init_2 = "j program";

    // char pointer is the address of the char variable
    // array name is the address of the array (the address of the first char data of the array)
    char *init1 = init_1;
    char *init11 = &init_1[0];
    // Although the address of &init_1 and init_1 is the same,
    // but the type is not the same, &init_1 can only be char(*)[10]
    char *init111 = &init_1; // <- there'll be warning here
    printf("array init_1 address: %p\n", init111);
    printf("array init_1 address: %p\n", init1);
    printf("array init_1 address: %p\n", init11);
    printf("1st node of array init_1: %c\n\n", init_1[0]);

    // If using pointer pointing to an array,
    // then the pointer value is the array address
    // but pointer address is not the same as the array address
    // pointer = arrayName/&firstNode, but &pointer != arrayName/&firstNode
    // Be always custious when using &pointer
    char *init2 = init_2;
    char *init22 = &init_2[0];
    printf("init_2 address: %p\n", &init_2);
    printf("init_2 address: %p\n", init2);
    printf("init_2 address: %p\n", init22);
    printf("1st node of init_2: %c\n\n", init_2[0]);

    // When using scanf to input arg,
    // be cautious that if there's only 1 input arg, 
    // there should be no space or tab in the input, 
    // otherwise the send part will be stored in buffer
    printf("Please enter new init_1:\n");
    scanf("%s", init_1);
    printf("new array init_1 address: %p\n", init111);
    printf("new array init_1 address: %p\n", init1);
    printf("new array init_1 address: %p\n", init11);
    printf("1st node of new array init_1: %c\n\n", init_1[0]);

    char fname[30] = {0};
    char lname[30] = {0};
    int age;

    printf("Please enter your first name:\n");
    scanf("%29s", fname);
    printf("Please enter your last name:\n");
    scanf("%s", lname);
    printf("Please enter your age:\n");
    scanf("%d", &age);

    printf("Welcome, %s %s! Your age %d has been well received.\n", fname, lname, age);

    return 0;
}
