#include <stdio.h>
#include <stdlib.h>

#define MAX_STUDENTS 100
#define PASSING_GRADE 60

int main()
{
    char names[MAX_STUDENTS][50];
    int grades[MAX_STUDENTS];
    int student_num;
    

    printf("Enter the number of students (up to %d): ", MAX_STUDENTS);
    scanf("%d", &student_num);
    
    if(student_num > MAX_STUDENTS || student_num < 0){
        printf("Error! The number of student cannot be a negative value or exceed %d.\n", MAX_STUDENTS);
        return 1;
    }
    
    {
        int i;

    for(i = 0; i < student_num; i++){
        printf("Enter the name of student %d: ", i + 1);
        scanf("%s", names[i]);
        printf("Enter the grade of student %d: ", i + 1);
        scanf("%d", &grades[i]);

        if(grades[i] > 100 || grades[i] < 0)
        {
        printf("Error! the input grade cannot be greater than 100 or less than 0.\nInput number: %d\n.", grades[i]);
        return 1;
        }

    }

    printf("\n Student informations: \n ");
    printf("=====================\n");
    
    {
        int i;
        printf("Number of students: %d\n", student_num);

         for(i = 0; i < student_num; i++){
            
            if( grades[i] >= PASSING_GRADE){

                printf("Student  %d: Name = %s, Status: Pass\n", i + 1, names[i]);

            }else{

                 printf("Student  %d: Name = %s, Status: Fail\n", i + 1, names[i]);
            }
        }
    
    }
    
    }

    return 0;
}