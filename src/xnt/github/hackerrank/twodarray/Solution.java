package xnt.github.hackerrank.twodarray;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    private static int calculateHourglass(int[][] arr, int x, int y) {
        int sum = arr[x][y];
        for(int i = -1; i < 2; i++) {
            sum += arr[x-1][y+i] + arr[x+1][y+i];
        }
        return sum;
    }

    // Complete the hourglassSum function below.
    private static int hourglassSum(int[][] arr) {
        int highest = Integer.MIN_VALUE;
        
        for(int i = 1; i < (arr.length - 1); i++) {
            for(int j = 1; j < (arr.length -1); j++) {
                int hourglass = calculateHourglass(arr, i, j);
                if(calculateHourglass(arr, i, j) > highest) {
                    highest = hourglass;
                }
            }
        }

        return highest;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}