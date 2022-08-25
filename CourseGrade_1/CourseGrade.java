//@author : Ersin Aydoğmuş
//since : 15.11.2020

import java.util.Scanner;

public class CourseGrade_20190808028 {
    public static void main(String[] args) {
        Scanner data = new Scanner(System.in);

//The names of the categories and their properties
        String[] categories = new String[4];
        int[] cateh = new int[4];
        int[] catep = new int[4];
        int totalWeight = 0;
//Data retrieval part from the user
        for (int i = 0; i < 4; i++) {
            System.out.print("Please enter the name of the category "
                    + (i + 1) + " : ");
            categories[i] = capitalize(data.nextLine());

            while (!validQuantity(cateh[i])) {
                System.out.print("Please enter how many items of type "
                        + categories[i] + " were given : ");
                cateh[i] = data.nextInt();
            }
            do {
                System.out.print("Please enter the percentage weight of "
                        + categories[i] + " : ");
                catep[i] = data.nextInt();
            }
            while (!validWeight(catep[i], totalWeight));

            totalWeight += catep[i];
            data.nextLine();
        }
//Requirements inquiry part
        if (totalWeight < 100){
            System.out.println("ERROR : The values sum to " + totalWeight +
                    " but should sum to 100.");
            System.exit(0);
        }

        System.out.println("\n******** Student Grades Entry ********\n");
        System.out.println("Please enter values that the student earned" +
                " for each item:");
//The part where the grades to be entered will be kept
        double[] cate1points = new double[cateh[0]];
        double[] cate2points = new double[cateh[1]];
        double[] cate3points = new double[cateh[2]];
        double[] cate4points = new double[cateh[3]];
//Averages
        double cate1Average = 0;
        double cate2Average = 0;
        double cate3Average = 0;
        double cate4Average = 0;
//Part where grades are entered
        for (int i=0 ; i < cateh[0]; i++){
            System.out.print(categories[0]+ " " + (i+1) + ": ");
            cate1points[i] = data.nextDouble();
            cate1Average = cate1Average + cate1points[i];
        }
        for (int i=0 ; i < cateh[1]; i++){
            System.out.print(categories[1]+ " " + (i+1) + ": ");
            cate2points[i] = data.nextDouble();
            cate2Average = cate2Average + cate2points[i];
        }
        for (int i=0 ; i < cateh[2]; i++){
            System.out.print(categories[2]+ " " + (i+1) + ": ");
            cate3points[i] = data.nextDouble();
            cate3Average = cate3Average + cate3points[i];
        }
        for (int i=0 ; i < cateh[3]; i++){
            System.out.print(categories[3]+ " " + (i+1) + ": ");
            cate4points[i] = data.nextDouble();
            cate4Average = cate4Average + cate4points[i];
        }

        System.out.println("\n******** Student Results ********\n");
//Section showing averages
        cate1Average = cate1Average / cateh[0];
        System.out.println(categories[0] + ": " + cate1Average);
        cate2Average = cate2Average / cateh[1];
        System.out.println(categories[1] + ": " + cate2Average);
        cate3Average = cate3Average / cateh[2];
        System.out.println(categories[2] + ": " + cate3Average);
        cate4Average = cate4Average / cateh[3];
        System.out.println(categories[3] + ": " + cate4Average);
//The section where grade information and score are calculated
        double score;
        score = (cate1Average * catep[0] /100) + (cate2Average * catep[1] / 100)
                + (cate3Average * catep[2] / 100) +
                (cate4Average * catep[3] / 100);
        double gpaPoints = gpaPoints(score);
        String gradeLetter = gradeLetter(score);
        String status = status(score);

        System.out.println("The student has " + status +
                " CSE 101 with a score of " + score + ", GPA points of "
                + gpaPoints + ", and a grade letter of " + gradeLetter);
    }
//The part that makes the first letter uppercase and other letters lowercase
    public static String capitalize(String name) {
        name = name.substring(0, 1).toUpperCase() +
                name.substring(1).toLowerCase();
        return name;
    }
//The part that checks that the number is positive
    public static boolean validQuantity(int quantity) {
        return (quantity > 0);
    }
//The part that controls the percentage of grade point average.
    private static boolean validWeight(int weight, int totalWeight) {
        return (weight >= 0) && (weight + totalWeight <= 100);
    }
//Grade controlling part
    private static String gradeLetter(double grade){
        String gradeLetter;
        if      (grade >= 88) gradeLetter = "AA";
        else if (grade >= 81) gradeLetter = "BA";
        else if (grade >= 74) gradeLetter = "BB";
        else if (grade >= 67) gradeLetter = "CB";
        else if (grade >= 60) gradeLetter = "CC";
        else if (grade >= 53) gradeLetter = "DC";
        else if (grade >= 46) gradeLetter = "DD";
        else if (grade >= 35) gradeLetter = "FD";
        else if (grade >= 0) gradeLetter = "FF";
        else gradeLetter = "Undefined";
        return gradeLetter;
    }
//Grade controlling part
    public static double gpaPoints(double grade){
        double gradePoint;
        if      (grade >= 88) gradePoint = 4;
        else if (grade >= 81) gradePoint = 3.5;
        else if (grade >= 74) gradePoint = 3.0;
        else if (grade >= 67) gradePoint = 2.5;
        else if (grade >= 60) gradePoint = 2.0;
        else if (grade >= 53) gradePoint = 1.5;
        else if (grade >= 46) gradePoint = 1.0;
        else if (grade >= 35) gradePoint = 0.5;
        else gradePoint = 0;
        return gradePoint;
    }
//The part that checks whether the student has passed or not
    public static String status(double grade){
        String status;
        if (grade <= 100 && grade >= 60) status = "passed";
        else if(grade <59 && grade >= 46) status = "conditionally passed";
        else status = "failed";
        return status;
    }
}