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

        int[] peakRowIndices = new int[columns];
        int[] peakColIndices = new int[rows];

        // Find maximum in each row
        for (int i = 0; i < rows; i++) {
            int maxInRow = matrix[i][0];
            int colIndex = 0;

            for (int j = 1; j < columns; j++) {
                if (matrix[i][j] > maxInRow) {
                    maxInRow = matrix[i][j];
                    colIndex = j;
                }
            }

            peakRowIndices[colIndex] = i;
        }

        // Find minimum in each column
        for (int j = 0; j < columns; j++) {
            int minInCol = matrix[0][j];
            int rowIndex = 0;

            for (int i = 1; i < rows; i++) {
                if (matrix[i][j] < minInCol) {
                    minInCol = matrix[i][j];
                    rowIndex = i;
                }
            }

            peakColIndices[rowIndex] = j;
        }

        // Check for peak-columns
        boolean foundPeakColumn = false;
        for (int j = 0; j < columns; j++) {
            int rowIndex = peakRowIndices[j];
            if (peakColIndices[rowIndex] == j) {
                int peakValue = matrix[rowIndex][j];
                System.out.println("Peak-column found at position (" + rowIndex + ", " + j + ") with value " + peakValue);
                foundPeakColumn = true;
            }
        }

        if (!foundPeakColumn) {
            System.out.println("No peak-column found in the matrix.");
        }


      
    }
}