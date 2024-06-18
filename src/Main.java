import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int rows = 0;
        int columns = 0;
        boolean validInput = false;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        while(!validInput){
            if(scanner.hasNextInt()){
                rows = scanner.nextInt();
                validInput = true;
            }else{
                System.out.print("Number of rows must be an integer, re-enter number of rows: ");
                scanner.next();
            }
        }

        validInput = false;  // Reset validInput for next validation

        System.out.print("Enter the number of columns: ");
        while(!validInput){
            if(scanner.hasNextInt()){
                columns = scanner.nextInt();
                validInput = true;
            }else{
                System.out.print("Number of columns must be an integer, re-enter number of columns: ");
                scanner.next();
            }
        }

        int[][] matrix = new int[rows][columns];

        validInput = false;

        System.out.println("Enter the matrix: ");
        for (int i = 0; i < rows; i++){
            for(int j= 0; j < columns; j++){
                while(!validInput){
                    if(scanner.hasNextInt()){
                        matrix[i][j] = scanner.nextInt();
                        validInput = true;
                    }else {
                        System.out.println("All elements of the matrix must be integers, re-enter the element: ");
                         scanner.next();
                    }
                }
                validInput = false;
            }
        }

        // Find peak-columns
        boolean foundPeakColumn = false;

        // Find maximum in each row
        int[] maxInRow = new int[rows];
        for (int i = 0; i < rows; i++) {
            int max = matrix[i][0];
            for (int j = 1; j < columns; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }
            }
            maxInRow[i] = max;
        }

        // Find minimum in each column
        int[] minInCol = new int[columns];
        for (int j = 0; j < columns; j++) {
            int min = matrix[0][j];
            for (int i = 1; i < rows; i++) {
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                }
            }
            minInCol[j] = min;
        }

        // Check for peak-columns
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == maxInRow[i] && matrix[i][j] == minInCol[j]) {
                    System.out.println();
                    System.out.println("(" + (i + 1) + ", " + (j + 1 )+ ") = " + matrix[i][j]);
                    foundPeakColumn = true;
                }
            }
        }

        if (!foundPeakColumn) {
            System.out.println("No peak-column found in the matrix.");
        }
      
    }
}