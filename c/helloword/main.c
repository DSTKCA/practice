//
//  main.c
//  helloword
//
//  Created by dstkdevhrp on 2022/7/7.
//

#include <stdio.h>

int main(int argc, const char * argv[]) {
    
    // insert code here...
    printf("Hello, World!\n");

    int a1 = 20, a2 = 345, a3 = 700, a4 = 22;
    int b1 = 56720, b2 = 9999, b3 = 20098, b4 = 2;
    int c1 = 233, c2 = 205, c3 = 1, c4 = 6666;
    int d1 = 34, d2 = 0, d3 = 23, d4 = 23006783;
    printf("%-9d %-9d %-9d %-9d\n", a1, a2, a3, a4);
    printf("%-9d %-9d %-9d %-9d\n", b1, b2, b3, b4);
    printf("%-9d %-9d %-9d %-9d\n", c1, c2, c3, c4);
    printf("%-9d %-9d %-9d %-9d\n", d1, d2, d3, d4);

    printf("%9d %9d %9d %9d\n", a1, a2, a3, a4);
    printf("%9d %9d %9d %9d\n", b1, b2, b3, b4);
    printf("%9d %9d %9d %9d\n", c1, c2, c3, c4);
    printf("%9d %9d %9d %9d\n", d1, d2, d3, d4);

    // Can be initialized without length
    // Must ended with '\0', to avoid chaos
    char init[] = {'c', ' ', 'p', 'r', 'o',
                'g', 'r', 'a', 'm', '\0'}; 
    printf("%s\n", init);

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
