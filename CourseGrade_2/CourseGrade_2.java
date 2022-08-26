import java.util.Scanner;
/**
*@author : Ersin Aydogmus
*@since : 20.12.2020
*/
public class CourseGrade_20190808028 {
    public static void main(String[] args) {
        String[] category = {"QUIZ", "homework", "MidTerm exam","FINAL Exam"};
        int[] quantity = {4, 3, 1, 1};
        int[] weight = {10, 20, 30, 40};
        courseGrade(category, quantity, weight);
    }
    public static int displayMenu(String [] item,Scanner input){
        System.out.println("\nPlease enter a choice below :");
        for (String s : item) System.out.println(s);
        return input.nextInt();
    }
    public static void courseGrade
    (String[] category, int[] quantity, int[] weight) {
        Scanner input = new Scanner(System.in);
        int totalWeight = 0;
        if (!validQuantity(quantity)) {
            System.out.println("Invalid quantity entered");
            System.exit(1);
        }
        if (validWeight(weight,totalWeight)) {
            System.out.println("Invalid weight entered");
            System.exit(1);
        }
        double[][] grade = new double[category.length][];
        double[] averageScore = new double[category.length];
        capitalize(category);
        double totalScore;
        for (int i = 0; i < category.length; i++)
            grade[i] = new double[quantity[i]];
        String[] options = {"1 - Enter all grades", "2 - Change a single grade",
                "3 - Display grade information", "0 - to Exit"};
        System.out.println("Welcome to our university grade system.");
        for ( ; ; ) {
            switch (displayMenu(options, input)) {
                case 1 -> {
                    for (int i = 0; i < category.length; i++)
                        for (int j = 0; j < quantity[i]; j++) {
                            System.out.print("Please enter grade for " +
                            (category[i]) + " " + (j + 1) + " >> ");
                            grade[i][j] = input.nextDouble();
                        }
                }
                case 2 -> {
                    System.out.println("Please enter the category");
                    for (int i = 0; i < category.length; i++)
                        System.out.println((i + 1) + " - " + (category[i]));
                    System.out.println("0 - to Exit");
                    int choice = input.nextInt();
                    if (choice < 0 || choice > category.length) {
                        System.out.println("Invalid Choice");
                        break;
                    }
                    System.out.print("Please enter which " +
                    category[choice - 1] + " you would like to change (1 - " +
                    quantity[choice - 1] + ") >> ");
                    int cho = input.nextInt();
                    System.out.println("The current grade for " +
                    category[choice - 1] + " " + cho + " is " +
                    grade[choice - 1][cho - 1]);
                    System.out.print("Please enter the new grade value >> ");
                    grade[choice - 1][cho - 1] = input.nextDouble();
                }
                case 3 -> {
                    System.out.println("Category information:");
                    totalScore = 0;
                    for (int i = 0; i < category.length; i++)
                    averageScore[i] = 0;
                    for (int i = 0; i < category.length; i++)
                        for (int j = 0; j < quantity[i]; j++) averageScore[i] =
                        averageScore[i] + (grade[i][j] / quantity[i]);


                    for (int i = 0; i < category.length; i++) totalScore =
                    totalScore + (averageScore[i] * weight[i] / 100);

                    for (int i = 0; i < category.length; i++) System.out.println
                    ((category[i]) + " - " + averageScore[i]);

                    System.out.println("\nOverall Grade -  " + totalScore);
                    System.out.println("Grade Letter - " +
                    gradeLetter(totalScore));
                    System.out.println("GPA Points - " + gpaPoints(totalScore));
                    System.out.println("Status - " + status(totalScore));
                }
                case 0 -> {
                    System.out.println("Thank you for using our system. " +
                    "Have a nice day.");
                    System.exit(1);
                }
                default -> System.out.println("Invalid Choice");
            }
        }
    }
    public static void capitalize(String[] name){
        for (int i = 0; i < name.length; i++) name[i] = name[i].substring(0, 1).
        toUpperCase() + name[i].substring(1).toLowerCase();
    }
    public static boolean validQuantity(int[] quantity) {
        boolean a = true;
        for (int j : quantity)
            if (j < 0) {
                a = false;
                break;
            }
        return a;
    }
    public static boolean validWeight(int[] weight, int totalWeight) {
        boolean a = false;
        for (int j : weight) {
            if ((j < 0) || ((j + totalWeight) > 100)) {
                a = true;
                break; }
            totalWeight = totalWeight + j;
        }return a;
    }
    public static String gradeLetter(double grade){
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
    public static String status(double grade){
        String status;
        if (grade <= 100 && grade >= 60) status = "passed";
        else if(grade <59 && grade >= 46) status = "conditionally passed";
        else status = "failed";
        return status;
    }
}