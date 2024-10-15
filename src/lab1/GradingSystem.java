package lab1;

import java.util.Arrays;

public class GradingSystem {

    // returns an array of failing grades
    public static int[] failingGrades(int[] grades){
        int count = 0;
        for (int grade : grades)
            if (grade < 40)
                count++;
        int[] failing_grades = new int[count];
        int index = 0;
        for (int grade : grades)
            if (grade < 40) {
                failing_grades[index] = grade;
                index++;
            }
        return failing_grades;
    }

    // returns the average value
    public static double averageValue(int[] grades) {
        if (grades.length == 0)
            return 0.00;
        int sum = 0;
        for (int grade : grades)
            sum += grade;
        double average_value = (double) sum / grades.length;
        average_value = (int) (average_value * 100) / 100.0;
        return average_value;
    }

    // returns an array of rounded grades
    public static int[] roundGrades(int[] grades){
        int[] rounded_grades = new int[grades.length];
        for (int i=0; i<grades.length; i++)
            if (grades[i] >= 38 && (5 - (grades[i] % 5)) < 3)
                rounded_grades[i] = grades[i] + (5 - (grades[i] % 5));
            else
                rounded_grades[i] = grades[i];
        return rounded_grades;
    }

    // returns the max rounded grade
    public static int maxRounded(int[] grades) {
        int[] rounded_grades = roundGrades(grades);
        int max = rounded_grades[0];
        for (int grade : rounded_grades)
            if (grade > max)
                max = grade;
        return max;
    }

    public static void main(String[] args) {
        // display initial grades
        int[] grades = {29, 37, 38, 41, 84, 67};
        System.out.println("All grades: " + Arrays.toString(grades));
        // display failing grades
        int[] failing_grades = GradingSystem.failingGrades(grades);
        System.out.println("Failing grades: " + Arrays.toString(failing_grades));
        // display average grade
        System.out.println("Average grade: " + GradingSystem.averageValue(grades));
        // display rounded grades
        int[] rounded_grades = GradingSystem.roundGrades(grades);
        System.out.println("Rounded grades: " + Arrays.toString(rounded_grades));
        // display max rounded grade
        int max_rounded_grade = GradingSystem.maxRounded(grades);
        System.out.println("Max rounded grade: " + max_rounded_grade);
    }

}
