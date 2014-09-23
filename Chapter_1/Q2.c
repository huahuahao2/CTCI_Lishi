//
//  Chapter_1 Q2.c
//  CTCI
//
//  Created by Lishi Jiang on 3/1/14.
//  Copyright (c) 2014 Lishi Jiang. All rights reserved.
//

#include <stdio.h>
#include <stdlib.h>

char * reverse( char *str);

int main(int argc, char *argv[])
{
    char *str = argv[1];
    char *str_r = NULL;
    printf("the orignal string: %s\n", str);
    str_r = reverse(str);
    printf("the reverse string: %s\n", str_r);
}

char * reverse(char *str)
{
    int i = 0;
    char *ptr = str;
    char *str_r = NULL;
    str_r = malloc(sizeof(*str));
    while (*ptr != '\0') {
        ptr++;
    }
    for (i = 0, ptr--; ptr != str; i++, ptr--) {
        str_r[i] = *ptr;
    }
    str_r[i] = *ptr;
    return str_r;
}