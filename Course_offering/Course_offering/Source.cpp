#include<stdio.h>

#include<stdlib.h>

#include<time.h>

#include<string.h>

#define SIZE 4

struct students
{
	char name[20];
	int id;
	int crns[5];
}std1,std2,std3;

int availblity[4][4];

char* availblityCRN[4][4][40];


int ids[3][5] = {};
int ID, counter;
const char* second_semester[5] = {"Physics2", "progI", "Differential", "DS1", "Electric circuits"};
const char* first_semester[5] = {"Calculus", "Linear Algebra", "Intro_To_Engineering", "Dynamics", "Physics1"};
const char** First_year[2] = {first_semester, second_semester};
const char*** computer_engineer[4] = { First_year};
const char**** engineering[3] = { computer_engineer, NULL, NULL };
const char** biomedical_engineer[4];
const char** mechanical_engineer[4];

const char* first_year[2] = { "First Semester","Second Semester"};
const char* second_year[2] = { "First Semester","Second Semester" };
const char* third_year[2]  = { "First Semester","Second Semester" };
const char* fourth_year[2] = { "First Semester","Second Semester" };
const char* year[4] = {"First Year","Second Year","Third Year","Fourth Year"};
const char* Engineering[3] = { "Computer Engineering","Biomedical Engineering","Mechanical Engineering" };
const char* debbieh[4] = { "Engineering", "Architecture", "Science", "Business" };
const char* campus[3] = { "Debbieh", "Bierut", "Tripoli" };

int showCrn(int tempcrn);

void printcourse(int i, int j, int c);

void printsche(int c);
int course_offering();

int main()
{
	int IDs, x, i1 = 0, i2 = 0,i3=0,choice;
	printf("available IDs: 20230|20231|20232 and -1 to exit\n");
	scanf_s("%d", &IDs);
	while(IDs!=-1){
		
		printf("enter 1 to add course,2 to print schedule\n");
		scanf_s("%d", &choice);
		while (choice != 3) {
			if (choice == 1) {
				switch (IDs)
				{
				case 20230:
					fgets(std1.name, sizeof(std1.name), stdin);
					std1.id = IDs;
					x = course_offering();
					x = x + showCrn(x);
					std1.crns[i1] += x;
					i1++;
					break;
				case 20231:
					fgets(std1.name, sizeof(std1.name), stdin);
					std1.id = IDs;
					x = course_offering();
					x = x + showCrn(x);
					std2.crns[i2] += x;
					i2++;
					break;
				case 20232:
					fgets(std1.name, sizeof(std1.name), stdin);
					std1.id = IDs;
					x = course_offering();
					x = x + showCrn(x);
					std3.crns[i3] += x;
					i3++;
					break;
				default:
					printf("enter a valid crn");

				}
			}
			else if (choice == 2)
			{
				printsche(IDs);
			}
			printf("enter 1 to add course,2 to print schedule,3 to logout\n");
			scanf_s("%d", &choice);
		}
		printf("available IDs: 20230|20231|20232\n");
		scanf_s("%d", &IDs);
	}
	return 0;
}

int course_offering() {
	int v1 = 0, v2 = 0, v3 = 0, v4 = 0,v5=0,v6=0;
	int fa[] = { 3, 2, 4 };
	int ma[] = { 4,4,3 };

	printf("Choose your \"Campus\":\n");
	printf("%s\t%s\t%s\n%7d\t%6d\t%7d\n", campus[0], campus[1], campus[2], 1, 2, 3);
	scanf_s("%d", &v1);
	v1 -= 1;
	if (v1 == 0) {
		printf("Campus \"%s\":\n", campus[v1]);
		printf("Choose your \"Faculty\":\n");
		printf("%s\t%s\t%s\n%11d\t%12d\t%7d\n", debbieh[0], debbieh[1], debbieh[2], 1, 2, 3);
		scanf_s("%d", &v2);
		v2 -= 1;
		if (v2 == 0) {
			printf("Campus \"%s\"==>Faculty \"%s\":\n", campus[v1], debbieh[v2]);
			printf("Choose your \"Major\":\n");
			printf("%s\t%s\t%s\n%20d\t%22d\t%22d\n", Engineering[0], Engineering[1], Engineering[2], 1, 2, 3);
			scanf_s("%d", &v3);
			v3 -= 1;
			if (v3 == 0) {
				printf("Campus \"%s\"==>Faculty \"%s\"==>Major \"%s\":\n", campus[v1], debbieh[v2], Engineering[v3]);
				printf("Choose your \"Year\":\n");
				printf("%s\t%s\t%s\t%s\n%10d\t%11d\t%10d\t%11d\n", year[0], year[1], year[2], year[3], 1, 2, 3, 4);
				scanf_s("%d", &v4);
				v4 -= 1;
			}if (v4==0)
			{
				printf("Campus \"%s\"==>Faculty \"%s\"==>Major \"%s\"==>year \"%s\":\n", campus[v1], debbieh[v2], Engineering[v3], year[v4]);
				printf("Choose your \"semester\":\n");
				printf("%s\t%s\n%14d\t%15d\n",first_year[0],first_year[1],1,2);
				scanf_s("%d", &v5);
				v5--;
				if (v5 == 0)
				{
					printf("Campus \"%s\"==>Faculty \"%s\"==>Major \"%s\"==>Year \"%s\"==>Semester \"%s\"\n", campus[v1], debbieh[v2], Engineering[v3], year[v4],first_year[v5]);
					printf("Choose your \"course\":\n");
					printf("%s\t%s\t%s\t%s\t%s\n%8d\t%14d\t%20d\t%8d\t%8d\n", first_semester[0], first_semester[1], first_semester[2], first_semester[3], first_semester[4], 1, 2, 3, 4,5);
					scanf_s("%d", &v6);
				}
				else
				{
					printf("Campus \"%s\"==>Faculty \"%s\"==>Major \"%s\"==>Year \"%s\"==>Semester \"%s\"\n", campus[v1], debbieh[v2], Engineering[v3], year[v4], first_year[v5]);
					printf("Choose your \"course\":\n");
					printf("%s\t%s\t%s\t%s\t%s\n%8d\t%5d\t%12d\t%3d\t%17d\n", second_semester[0], second_semester[1], second_semester[2], second_semester[3], second_semester[4], 1, 2, 3, 4, 5);
					scanf_s("%d", &v6);
				
				}
			}


		}

	}
	return  ((v1 + 1) * 100000 + (v2 + 1) * 10000 + (v3 + 1) * 1000 + (v4 + 1)*100+(v5+1)*10+v6)*100;
}

int showCrn(int y) {
	int crns[5] = {0, 0, 0, 0, 0},flag=0;
	y = y / 100;
	int ma=(y/1000)%10, ye=(y/100)%10, sem=(y/10)%10, course=y%10;
	printf("%d,%d,%d,%d\n", ma, ye, sem, course);
	int crn = 0;
	char day[2][5] = { "M-W","T-TH" };

	char hour[4][6] = { "08-10","10-12","12-02","02-04" };

	int days = rand() % 2 +1;

	int hours = rand() % 4 +1;
	availblity[hours-1][days-1] = 1;
	crns[0] = days * 10 + hours;

	printf("\n%d-%-10d %-10s %-10s\n",0 + 1, crns[0], day[days-1], hour[hours-1]);
	for (int i = 1; i < SIZE; i++) {

		while (availblity[hours-1][days-1] != 0) {

			days = rand() % 2+1;

			hours = rand() % 4+1;

			
		}
		availblity[hours-1][days-1] = 1;

		crns[i] = days * 10 + hours;

		printf("\n%d-%-10d %-10s %-10s\n", i + 1, crns[i], day[days-1], hour[hours-1]);

	}
	
	int choiceCrn;
	scanf_s("%d", &choiceCrn);
	return crns[choiceCrn-1];
	

}

void printsche(int c) {
	
	char days[4][4] = { "MON","TUE","WED","THU" };
	for (int i = 0; i < 4; i++) {

		printf("%-10s\t\t\t", days[i]);

	}
	printf("\t\t\t");
	printf("\n");
	for (int j = 0; j <4 ; j++)
	{
		
		for (int i = 0; i < 4; i++) 
		{

			printcourse(i, j,c);
			printf("\t\t\t");

		}
		printf("\n\n");
	}
	

}

void printcourse(int i, int j,int c)
{
	int f = 1;
	if (c == 20230)
	{
		for (int x = 0; x < 5; x++)
		{
			if (std1.crns[x] == 0)
				continue;
			else
			{

				if ((std1.crns[x]%100-11) == (i * 10 + j)|| (std1.crns[x] % 100 - 11 + 20) == (i * 10 + j))
				{

					printf("%-10s", engineering[(std1.crns[x] / 100000 - 1) % 10][(std1.crns[x] / 10000 - 1) % 10][((std1.crns[x] / 1000) % 10) - 1][((std1.crns[x] / 100) % 10) - 1]);
					f = 0;
				}
			}
		}
	}
	else if (c == 20231)
	{
		for (int x = 0; x < 5; x++)
		{
			if (std2.crns[x] == 0)
				continue;
			else
			{

				if ((std2.crns[x] % 100 - 11) == (i * 10 + j) || (std2.crns[x] % 100 - 11 + 20) == (i * 10 + j))
				{

					printf("%-10s", engineering[(std2.crns[x] / 100000 - 1) % 10][(std2.crns[x] / 10000 - 1) % 10][((std2.crns[x] / 1000) % 10) - 1][((std2.crns[x] / 100) % 10) - 1]);
					f = 0;
				}
			}
		}
	}
	else
	{
		for (int x = 0; x < 5; x++)
		{
			if (std3.crns[x] == 0)
				continue;
			else
			{

				if ((std3.crns[x] % 100 - 11) == (i * 10 + j) || (std3.crns[x] % 100 - 11 + 20) == (i * 10 + j))
				{

					printf("%-10s", engineering[(std3.crns[x] / 100000 - 1) % 10][(std3.crns[x] / 10000 - 1) % 10][((std3.crns[x] / 1000) % 10) - 1][((std3.crns[x] / 100) % 10) - 1]);
					f = 0;
				}
			}
		}
	}
	if (f == 1)
		printf("%-10s","break");
}