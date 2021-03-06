package com.github.adam6806.gcj.storecredit;

import com.github.adam6806.gcj.Helper;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by Adam on 4/21/2015.
 */
public class StoreCredit {
    private static final String FILE_NAME = "A-large-practice.in";
    private static final URL FILE_PATH = StoreCredit.class.getResource(FILE_NAME);
    private static final File INPUT_FILE = new File(FILE_PATH.getPath());
    private static final File OUTPUT_FILE = new File(FILE_PATH.getPath() + ".out");

    public static String getResult(int numCases, Scanner scanner) {
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println("Input file: " + FILE_NAME);
        for (int i = 1; i <= numCases; i++) {
            String result = "Case #" + i + ": " + doAlgorithm(scanner) + "\n";
            System.out.print(result);
            stringBuilder.append(result);
        }
        return stringBuilder.toString();
    }

    public static String doAlgorithm(Scanner scanner) {
        int credit = Integer.parseInt(scanner.nextLine());
        int numItems = Integer.parseInt(scanner.nextLine());
        String[] strPrices = scanner.nextLine().split(" ");
        int[] prices = Helper.convertToIntArray(strPrices);
        int answer1 = 0;
        int answer2 = 0;
        for (int i = 0; i < numItems; i++) {
            for (int j = 0; j < numItems; j++) {
                if (i != j && credit == prices[i] + prices[j]) {
                    if (i < j) {
                        answer1 = i;
                        answer2 = j;
                    } else {
                        answer1 = j;
                        answer2 = i;
                    }
                    break;
                }
            }
        }
        String answer = (answer1 + 1) + " " + (answer2 + 1);
        return answer;
    }

    public static File getInputFile() {
        return INPUT_FILE;
    }

    public static File getOutputFile() {
        return OUTPUT_FILE;
    }

    public static void main(String[] args) {

        try {
            Scanner scanner = new Scanner(new FileReader(getInputFile()));
            PrintWriter printWriter = new PrintWriter(new FileWriter(getOutputFile()));
            int numOfCases = Integer.parseInt(scanner.nextLine());
            String answer = getResult(numOfCases, scanner);
            printWriter.write(answer);
            scanner.close();
            printWriter.flush();
            printWriter.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}
