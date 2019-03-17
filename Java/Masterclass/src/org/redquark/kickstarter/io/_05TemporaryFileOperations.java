package org.redquark.kickstarter.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class _05TemporaryFileOperations {

    public static void main(String[] args) {

        // Create temporary file using java.io.File class
        createUsingFile();

        // Create temporary file using java.nio.Files class
        createUsingNIO();

        // Write data into temporary file using BufferedWriter
        writeUsingBufferedWriter();

        // Write data into temporary file using NIO
        writeUsingNIO();

        // Delete file using java.io.File
        deleteUsingFile();

        // Delete file using java.nio.Files
        deleteUsingNIO();
    }

    private static void createUsingFile() {

        try {

            File tempFile = File.createTempFile("tempFile", ".txt");

            System.out.println("Temp file is created at :: " + tempFile.getAbsolutePath());

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    private static void createUsingNIO() {

        try {

            // Path
            final Path filePath = Files.createTempFile("tempFile", ".txt");

            System.out.println("Temp file is created at :: " + filePath);

            // Delete file on exit
            filePath.toFile().deleteOnExit();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeUsingBufferedWriter() {

        try {

            // Data to be written in the temporary file
            String data = "Temporary data to be written in the file";

            File tempFile = File.createTempFile("tempFile", ".txt");

            // Write data to temporary file
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(tempFile));
            bufferedWriter.write(data);
            bufferedWriter.close();

            System.out.println("Data is written to the file :: " + tempFile.getAbsolutePath());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeUsingNIO() {

        try {

            // Data to be written in the temporary file
            String data = "Temporary data to be written in the file";

            final Path path = Files.createTempFile("tempFile", ".txt");

            // Writing data to the file
            byte[] buffer = data.getBytes();
            Files.write(path, buffer);

            System.out.println("Data is written to the file :: " + path);

            // Delete file on exit
            path.toFile().deleteOnExit();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void deleteUsingFile() {

        try {

            File tempFile = File.createTempFile("tempFile", ".txt");

            System.out.println("Temp file is created at :: " + tempFile.getAbsolutePath());

            // Delete immediately
            boolean hasDeleted = tempFile.delete();

            // Delete on run time exit
            tempFile.deleteOnExit();

            if (hasDeleted) {
                System.out.println("Temp file is deleted");
            } else {
                System.out.println("Temp file is not deleted");
            }

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    private static void deleteUsingNIO() {

        try {
            final Path filePath = Files.createTempFile("tempFile", ".txt");

            System.out.println("Temp file is created at :: " + filePath);

            // Delete file immediately
            Files.delete(filePath);

            // Delete file on exit
            Files.deleteIfExists(filePath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
