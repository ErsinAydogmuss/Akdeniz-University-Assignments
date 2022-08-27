/*
 @author : Ersin Aydogmus
 @since : 13.01.2021
 */
import java.io.*;
import java.util.Scanner;
public class CourseGrade_20190808028 {
    public static void main(String[] args) {
        String baseFileName = args[0];
        int arrayLength1 = countCategory
                (baseFileName+"_CourseDetails.txt");
        int arrayLength2 = countCategory
                (baseFileName+"_StudentScores.txt");
        String[] category = new String[arrayLength1];
        String[] studentName = new String[arrayLength2];
        int[] quantity = new int[arrayLength1];
        int[] weight = new int[arrayLength1];
        double[] gradePoints = new double[arrayLength2];
        getCategory(category,quantity,weight,
                baseFileName+"_CourseDetails.txt");
        int totalWeight = 0;
        if (!validQuantity(quantity)) logWriteQuantity();
        if (validWeight(weight,totalWeight)) logWriteWeight();
        int sum = 0,i=0;
        for (int value : quantity) sum += value;
        String str ;
        boolean control = false;
        try {
            Scanner data = new Scanner
                    (new FileReader(baseFileName+"_StudentScores.txt"));

            while (data.hasNextLine()){
                str = data.nextLine();
                String[] lineInformation = str.split(" ");
                double[] oneStudentGrade = new double[sum];
                for (int j = 0, k=1; k < lineInformation.length ; j++,k++)
                    oneStudentGrade[j] = Double.parseDouble(lineInformation[k]);
                for (double v : oneStudentGrade) {
                    if (v < 0) {
                        control = true;
                        break;
                    }
                }
                if (!control){
                    studentName[i] = lineInformation[0];
                    gradePoints[i] = averageCalculate
                            (oneStudentGrade,weight,quantity);
                }
                else {
                    lineInformation[1] = "invalid";
                    writeGrades(lineInformation,gradePoints,
                            "CSE101_log.txt");
                }
                i++;
            }
        }
        catch (Exception e){
            System.err.println("ERROR : " + e.getMessage());
        }
        writeGrades(studentName,gradePoints,
                baseFileName+"_StudentGrades.txt");

    }
    public static int countCategory(String fileName){
        int count = 0;
        try {
            Scanner data = new Scanner(new FileReader(fileName));
            while (data.hasNextLine()){
                data.nextLine();
                count++;
            }
        }
        catch (Exception e){
            System.err.println("ERROR : " + e.getMessage());
        }
        return count;
    }
    public static void getCategory
            (String[] category, int[] quantity, int[] weight, String fileName){
        String str;
        int i = 0;
        try {
            Scanner data = new Scanner(new FileReader(fileName));
            while (data.hasNextLine()) {
                str = data.nextLine();
                String[] lineInformation = str.split(" ");
                category[i] = lineInformation[0];
                quantity[i] = Integer.parseInt(lineInformation[1]);
                weight[i] = Integer.parseInt(lineInformation[2]);
                i++;
            }
        }
        catch (Exception e){
            System.err.println("ERROR : " + e.getMessage());
        }
    }
    public static void writeGrades
            (String[] student,double[] grade,String baseFileName){
        FileWriter fileWriter;
        BufferedWriter writer;
        String[] str = new String[student.length];
        try {
            fileWriter = new FileWriter(baseFileName);
            writer = new BufferedWriter(fileWriter);
            if (student[1].equals("invalid")) logWriteStudent(student[0]);
            else {
                for (int i = 0; i <student.length ; i++) {
                    if (student[i] !=null) {
                        str[i] = student[i] + " " + averageMessage(grade[i]);
                        writer.write(str[i]);
                        writer.newLine();
                    }
                }
            }
            writer.close();
        }
        catch (Exception e){
            System.err.println("ERROR : " + e.getMessage());
        }
    }
    public static void logWriteStudent(String name) {
        FileWriter fileWriter;
        BufferedWriter writer;
        try{
            fileWriter = new FileWriter("CSE101_log.txt");
            writer = new BufferedWriter(fileWriter);
            writer.write("ERROR : Student " + name +
                    " - cannot calculate due to invalid grade entered.");
            writer.close();
        }
        catch (Exception e){
            System.err.println("ERROR : " + e.getMessage());
        }
    }
    public static void logWriteWeight(){
        FileWriter fileWriter;
        BufferedWriter writer;
        try{
            fileWriter = new FileWriter("CSE101_log.txt");
            writer = new BufferedWriter(fileWriter);
            writer.write("ERROR : Course details -" +
                    " invalid weight - does not sum to 100");
            writer.close();
        }
        catch (Exception e){
            System.err.println("ERROR : " + e.getMessage());
        }
        System.exit(1);
    }
    public static void logWriteQuantity(){
        FileWriter fileWriter;
        BufferedWriter writer;
        try{
            fileWriter = new FileWriter("CSE101_log.txt");
            writer = new BufferedWriter(fileWriter);
            writer.write("ERROR : Course details - invalid quantity");
            writer.close();
        }
        catch (Exception e){
            System.err.println("ERROR : " + e.getMessage());
        }
        System.exit(1);
    }
    public static boolean validQuantity(int[] quantity) {
        boolean a = true;
        for (int j : quantity)
            if (j < 0) {
                a = false;
                break; }
        return a;
    }
    public static boolean validWeight(int[] weight, int totalWeight) {
        boolean a = false;
        for (int j : weight) {
            if ((j < 0) || ((j + totalWeight) > 100)) {
                a = true;
                break; }
            totalWeight = totalWeight + j;
        }
        if (totalWeight != 100) a = true;
        return a;
    }
    public static double averageCalculate
            (double[] grade,int[] weight, int[] quantity){
        double totalScore = 0;
        int k =0;
        for (int i = 0; i < quantity.length ; i++) {
            for (int j = 0; j < quantity[i]; j++) {
                totalScore += grade[k] * weight[i] / 100 / quantity[i];
                k++;
            }
        }
        return totalScore;
    }
    public static String averageMessage(double totalScore){
        String result = String.valueOf(totalScore);
        if      (totalScore >= 88) result += " AA 4.0 passed";
        else if (totalScore >= 81) result += " BA 3.5 passed";
        else if (totalScore >= 74) result += " BB 3.0 passed";
        else if (totalScore >= 67) result += " CB 2.5 passed";
        else if (totalScore >= 60) result += " CC 2.0 passed";
        else if (totalScore >= 53) result += " DC 1.5 conditionally passed";
        else if (totalScore >= 46) result += " DD 1.0 conditionally passed";
        else if (totalScore >= 35) result += " FD 0.5 failed";
        else if (totalScore >= 0) result += " FF 0.0 failed";
        else result = "Undefined";
        return result;
    }
}