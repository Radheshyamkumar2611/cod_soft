import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Student Grade Calculator");

       
        System.out.print("Enter the number of subjects: ");
        int numSubjects = sc.nextInt();

        double totalMarks = 0.0;

        for (int i = 1; i <= numSubjects; i++) {
            System.out.print("Enter marks obtained in subject " + i + " (out of 100): ");
            double marks = sc.nextDouble();

            
            if (marks < 0 || marks > 100) {
                System.out.println("Marks should be in the range 0-100. Please enter valid marks.");
                i--;
                continue;
            }

            totalMarks += marks;
        }

        
        double averagePercentage = (totalMarks / (numSubjects * 100)) * 100;

       
        String grade = calculateGrade(averagePercentage);

       
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);

        scanner.close();
    }

    public static String calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return "A+";
        } else if (averagePercentage >= 80) {
            return "A";
        } else if (averagePercentage >= 70) {
            return "B";
        } else if (averagePercentage >= 60) {
            return "C";
        } else if (averagePercentage >= 50) {
            return "D";
        } else {
            return "F";
        }
    }
}
