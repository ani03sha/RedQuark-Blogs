package org.redquark.kickstarter.io;

import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author Anirudh Sharma
 * <p>
 * This class shows commonly used file operatons using different ways
 */
public class _04FileOperations {

    public static void main(String[] args) {

        // Path of the file
        String path = "src\\org\\redquark\\kickstarter\\data\\";

        // Create file using java.io.File class
        createFileUsingFile(path);

        // Create file using java.io.FileOutputStream class
        createFileUsingFileOutputStream(path);

        // Create file using NIO API
        createFileUsingNIO(path);

        //  Reading file using BufferedReader
        System.out.println("\n----------< Reading file using BufferedReader >----------");
        readFileUsingBufferedReader(path);

        //  Reading file using try-with-resources
        System.out.println("\n----------< Reading file using Try-With-Resources >----------");
        readFileUsingTryWithResources(path);

        //  Reading file using LineNumberReader
        System.out.println("\n----------< Reading file using LineNumberReader >----------");
        readFileUsingLineNumberReader(path);

        // Checking file behavior
        System.out.println("----------< File behavior is as follows: >----------");
        checkFileBehavior(path);

        // Check if the word is present in the file
        System.out.println("\n----------< The line which contains the word is: >----------");
        checkIfWordPresent(path);

        // Set file read only
        makeFileReadOnly(path);

        // Copy file using FileStreams
        copyUsingFileStreams(path);

        // Copy file using NIO channel
        copyUsingNIOChannel(path);

        // Copy file using NIO Files class
        copyUsingNIOFiles(path);

        // List all the files with a certain extension
        System.out.println("\n----------< Files with .log extension are: >----------");
        filterFilesUsingFilenameFiler(path);

        // List all the files with a certain extension using FileFilter
        System.out.println("\n----------< Files with .json extension are: >----------");
        filterFilesUsingFileFilter(path);
    }

    private static void createFileUsingFile(String path) {

        try {

            // Creating a new file at the given path with the name "file1.txt"
            File file = new File(path + "file1.txt");

            // The condition in if block returns true if the file is created
            if (file.createNewFile()) {
                System.out.println("New file is created!");
            } else {
                System.out.println("File already exists or some error occurred");
            }

            // Writing some content in the file
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write("Test data in " + file.getName());
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createFileUsingFileOutputStream(String path) {

        try {
            // FileOutputStream instance
            FileOutputStream fileOutputStream = new FileOutputStream(path + "file2.txt");

            // Data to be written in the file
            String data = "Test data in file2.txt";

            // Writing data in the file after converting it into bytes
            fileOutputStream.write(data.getBytes());

            // Closing the instance
            fileOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createFileUsingNIO(String path) {

        // Data to be written in the file
        String data = "Test data in file3.txt";

        // Writing the data in the file after creating it
        try {
            Files.write(Paths.get(path + "file3.txt"), data.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readFileUsingBufferedReader(String path) {

        // Instance of BufferedReader
        BufferedReader bufferedReader = null;

        try {

            // Getting the instance of BufferedReader from the path of the file
            bufferedReader = new BufferedReader(new FileReader(path + "sample.txt"));

            // Variable that will read the file line by line
            String line;

            // Loop that will iterate the file line by line
            while ((line = bufferedReader.readLine()) != null) {

                // Reading the file and printing it
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void readFileUsingTryWithResources(String path) {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path + "sample.txt"))) {

            // Variable to read file line by line
            String line;

            // Loop which will read the file line by line
            while ((line = bufferedReader.readLine()) != null) {

                // Printing the line on the console
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readFileUsingLineNumberReader(String path) {

        LineNumberReader lineNumberReader = null;

        try {

            // Getting the LineNumberReader instance
            lineNumberReader = new LineNumberReader(new FileReader(path + "sample.txt"));

            // Print the initial line number
            System.out.println("Initial Line Number :: " + lineNumberReader.getLineNumber());

            // Setting the initial line number
            lineNumberReader.setLineNumber(4);
            System.out.println("New Initial Line Number :: " + lineNumberReader.getLineNumber());

            // Read all the lines wit their respective line numbers
            String line;

            while ((line = lineNumberReader.readLine()) != null) {
                System.out.println("Line-" + lineNumberReader.getLineNumber() + " :: " + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if (lineNumberReader != null) {
                    lineNumberReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void checkFileBehavior(String path) {

        String completePath = path + "sample.txt";

        // Check if file exists or not
        try {

            // Getting reference of file using path
            File file = new File(completePath);

            // Check if file exists
            if (file.exists()) {
                System.out.println("\nFile :: " + file.getName() + " exists");
            } else {
                System.out.println("\nFile :: " + file.getName() + " does not exist");
            }

            // Getting the "Path" object
            Path filePath = Paths.get(completePath);

            // Check if the file is readable
            if (Files.isReadable(filePath)) {
                System.out.println("\nFile :: " + file.getName() + " is readable");
            } else {
                System.out.println("\nFile :: " + file.getName() + " is not readable");
            }

            // Check if the file is writable
            if (Files.isWritable(filePath)) {
                System.out.println("\nFile :: " + file.getName() + " is writable");
            } else {
                System.out.println("\nFile :: " + file.getName() + " is not writable");
            }

            // Check if the file is executable
            if (Files.isExecutable(filePath)) {
                System.out.println("\nFile :: " + file.getName() + " is executable");
            } else {
                System.out.println("\nFile :: " + file.getName() + " is not executable");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void checkIfWordPresent(String path) {

        // Reading file using Streams
        try (Stream<String> filteredLines = Files
                .lines(Paths.get(path, "sample.txt"))
                .onClose(() -> System.out.println("File is closed"))
                .filter(s -> s.contains("fermentum"))) {

            // Find first occurrence of "fermentum"
            Optional<String> hasWord = filteredLines.findFirst();

            // Print if the line which contains the word, if present
            hasWord.ifPresent(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void makeFileReadOnly(String path) {

        try {

            // Getting File instance
            File file = new File(path + "sample.txt");

            // Make file read only
            if (file.exists() && file.setReadOnly()) {
                System.out.println("\nFile :: " + file.getName() + " is set read only");
            } else {
                System.out.println("\nFile :: " + file.getName() + " cannot be set read only or some error occured");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void copyUsingFileStreams(String path) {

        try {

            // Getting source and destination file reference using path
            File sourceFile = new File(path + "file1.txt");
            File destinationFile = new File(path + "file4.txt");

            // FileInputStream which will read the source file
            FileInputStream fileInputStream = new FileInputStream(sourceFile);

            if (destinationFile.createNewFile()) {

                // FileOutputStream for the destination file
                FileOutputStream fileOutputStream = new FileOutputStream(destinationFile);

                // Buffer of size 1024 bytes
                byte[] buffer = new byte[1024];
                int readBytes;

                // Reading file content and write in the destination file
                while ((readBytes = fileInputStream.read(buffer)) > 0) {

                    fileOutputStream.write(buffer, 0, readBytes);
                }

                fileOutputStream.close();
            }

            fileInputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void copyUsingNIOChannel(String path) {

        try {

            // Source file
            File sourceFile = new File(path + "file2.txt");
            FileInputStream fileInputStream = new FileInputStream(sourceFile);
            FileChannel sourceChannel = fileInputStream.getChannel();

            // Destination file
            File destinationFile = new File(path + "file5.txt");

            if (destinationFile.createNewFile()) {

                FileOutputStream fileOutputStream = new FileOutputStream(destinationFile);
                FileChannel destinationChannel = fileOutputStream.getChannel();

                sourceChannel.transferTo(0, sourceFile.length(), destinationChannel);

                fileOutputStream.close();
            }

            fileInputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void copyUsingNIOFiles(String path) {

        Path source = Paths.get(path + "file3.txt");
        Path destination = Paths.get(path + "file6.txt");

        try {

            Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void filterFilesUsingFilenameFiler(String path) {

        try {
            // Target directory
            File targetDirectory = new File(path);

            // Create few files with extension .log
            for (int i = 0; i < 5; i++) {
                File newFile = new File(path + "test" + i + ".log");
                if (newFile.createNewFile()) {
                    System.out.println("New file :: " + newFile.getName() + " is created");
                }
            }

            // Filter out all the files with .log extension
            String[] logFiles = targetDirectory.list((dir, name) -> name.endsWith(".log"));

            // List files
            Arrays.stream(Objects.requireNonNull(logFiles)).forEachOrdered(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void filterFilesUsingFileFilter(String path) {

        try {
            // Target directory
            File targetDirectory = new File(path);

            // Create few files with extension .log
            for (int i = 0; i < 5; i++) {
                File newFile = new File(path + "test" + i + ".json");
                if (newFile.createNewFile()) {
                    System.out.println("New file :: " + newFile.getName() + " is created");
                }
            }

            // List files using FileFilter
            FileFilter fileFilter = file -> file.getName().endsWith(".json");

            // List all the files
            File[] files = targetDirectory.listFiles(fileFilter);

            // List files
            for (File file : Objects.requireNonNull(files)) {
                System.out.println(file.getName());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
