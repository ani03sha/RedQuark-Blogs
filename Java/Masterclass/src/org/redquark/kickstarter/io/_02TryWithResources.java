package org.redquark.kickstarter.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class _02TryWithResources {

    // Path of the file to be read
    private static final String filePath = "src//org//redquark//kickstarter//data//sample.txt";

    public static void main(String[] args) {

        // Read file using the conventional way
        System.out.println("Reading file using conventional way: ");
        oldWay();

        // Separator
        System.out.println("----------------------------------------------------------------------------");

        // Read file using new way - using try-with-resources
        System.out.println("Reading file using new way: ");
        newWay();
    }

    private static void oldWay() {

        // This string variable will hold one line of the file one by one
        String line;

        // Buffered instance to get buffer
        BufferedReader bufferedReader = null;

        try {
            // Creating an instance of FileReader to read the file by providing the path
            FileReader fileReader = new FileReader(filePath);

            // Creating the instance of BufferedReader to read text file
            bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {

                // Printing the line
                System.out.println(line);
            }

        } catch (IOException e) {

            e.printStackTrace();

        } finally {
            // Close the BufferedReader to avoid memory leaks
            try {

                if (bufferedReader != null) {
                    bufferedReader.close();
                }

            } catch (IOException e) {

                e.printStackTrace();
            }
        }
    }

    private static void newWay() {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {

            // Variable that holds the current line in the file
            String line;

            while ((line = bufferedReader.readLine()) != null) {

                // Printing the current line
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
