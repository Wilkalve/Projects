#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/*
Macro defined variables
*/
#define MAX_STUDENTS 100
#define PASSING_GRADE 60
#define NAME_LENGTH 50
#define GRADE_COUNT 3

/*
Fucntion protoType
*/
float calculate_average(int *grades, int count);

int main(){

    /*
    Initialize variables
    */
    char **names;
    int **grades;
    float *averages;
    int *student_num;
    int i, j;

    printf("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
    printf("|| Student grade System. ||");
    printf("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");

    /*
     Allocate memory for number of Student 
   */  
  student_num = (int *)malloc(sizeof(int));
  if(student_num == NULL){

    printf("Memory allocation fail\n");
    
    return 1;
  }
     
    printf("Enter the number of students (up to %d): ", MAX_STUDENTS);
    scanf("%d", student_num); 

    /*
    Check if the number input by the user is a valid number.
    */
    while(*student_num > MAX_STUDENTS || *student_num < 0){
        printf("Error! The number of student cannot be %d or exceed %d.\n", *student_num, MAX_STUDENTS);
        printf("Please enter a valid number: ");
         scanf("%d", student_num);
    }
    
    /*
    allocating memory for students names, grades and average.*/
    names = (char **)malloc(*student_num * sizeof(char *));
    grades = (int **)malloc(*student_num * sizeof(int *));
    averages = (float *)malloc(*student_num * sizeof(float *));

    if (names == NULL || grades == NULL || averages == NULL) {
        printf("Memory allocation failed!\n");
        return 1;
    }

    for(i = 0; i < *student_num; i++){
        names[i] = (char *)malloc(NAME_LENGTH * sizeof(char));
        grades[i] = (int *)malloc(GRADE_COUNT * sizeof(int));

        if (names[i] == NULL || grades[i] == NULL) {
            printf("Memory allocation failed!\n");
            return 1;
        }
    }

    /*
    Take the student names and student grades
    */

    for(i = 0; i < *student_num; i++){

        printf("Enter the name of student %d: ", i + 1);
        fgets(names[i], NAME_LENGTH, stdin);
       
        if (fgets(names[i], NAME_LENGTH, stdin) != NULL) {
            size_t len = strlen(names[i]);
            if (len > 0 && names[i][len - 1] == '\n') {
                names[i][len - 1] = '\0';
            }
        } else {
            printf("Error reading input.\n");
            return 1;
        }
        
        for( j = 0; j < 3; j++) {
        
        printf("Enter the grade %d for %s (0-100): ", (j + 1), names[i]);
       
        scanf("%d", &grades[i][j]);
            
         while (grades[i][j] > 100 || grades[i][j] < 0) {
                printf("Error! The input grade cannot be greater than 100 or less than 0.\nInput number: %d\n", grades[i][j]);
                printf("Please enter a valid grade number: ");
                scanf("%d", &grades[i][j]);
            }

            

        }

        /*
        Calculate average for the current student
       */   
       
        averages[i] = calculate_average(grades[i], GRADE_COUNT);

    }

    
 /*
 Display the final result for student grade average and status.
 */
    printf("  \n  Student Grades Report\n");
    printf("==========================\n");
    
        printf("Number of students: %d\n", *student_num);
         

         for(i = 0; i < *student_num; i++){
            
            if( averages[i] >= PASSING_GRADE){

                printf("Student  %d: Name = %s, Average = %.2f, Status: Pass\n", i + 1, names[i], averages[i]);

            }else{

                 printf("Student  %d: Name = %s, Average = %.2f, Status: Fail\n", i + 1, names[i], averages[i]);
            }

        }
    
    
    
    

    /*
    Free memory Used
    */
     
     for(i = 0; i < *student_num; i++) {
        free(names[i]);
        free(grades[i]);
    }
    free(names);
    free(grades);
    free(averages);
    free(student_num);
   
    return 0;
    

}


float calculate_average(int *grades, int count){

    int sum = 0;
    int i;
    for (i = 0; i < count; i++) {
        sum += grades[i];
    }
   
   return (float) sum / count;

}