package org.redquark.kickstarter.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Objects;

public class _03DirectoryOperations {

    public static void main(String[] args) {

        String sourceFolderPath = "<path to source folder>";

        String destinationFolderPath = "<path to destination folder>";

        // Copying one directory to another directory
        copyDirectory(sourceFolderPath, destinationFolderPath);

        // Delete the specified directory from the given path
        deleteDirectory("<path of folder to be deleted>");
    }

    private static void copyDirectory(String sourceFolderPath, String destinationFolderPath) {

        System.out.println("Copying process starts...");

        try {
            // Getting file reference for source and destination folders
            File sourceFolder = new File(sourceFolderPath);
            File destinationFolder = new File(destinationFolderPath);

            // Check if the sourceFolder is a directory or file
            if (sourceFolder.isDirectory()) {

                // Check if destinationFolder is present. If not, then create it
                if (!destinationFolder.exists()) {

                    // Create destination folder
                    boolean isCreated = destinationFolder.mkdir();
                    System.out.println("New directory is created");

                    if (isCreated) {
                        System.out.println("Destination directory is created at:: " + destinationFolder);
                    } else {
                        System.out.println("Some error occurred while creating destination directory");
                    }

                    // Get all the files from the sourceFolder
                    String[] files = sourceFolder.list();

                    // Iterate through all the files list and copy them one by one
                    for (String file : Objects.requireNonNull(files)) {

                        // Getting the source file
                        File sourceFile = new File(sourceFolder, file);

                        // Getting the destination file
                        File destinationFile = new File(destinationFolder, file);

                        // Recursive call so get all the sub directories
                        copyDirectory(sourceFile.getPath(), destinationFile.getPath());
                    }
                }
            } else {

                // Copy the files from one folder to another
                Files.copy(sourceFolder.toPath(), destinationFolder.toPath(), StandardCopyOption.REPLACE_EXISTING);

                System.out.println("File copied :: " + destinationFolder);
            }

            System.out.println("Copying process ends...");
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    private static void deleteDirectory(String path) {

        System.out.println("Recursive deletion starts...");

        try {

            // Getting the paths
            Path directory = Paths.get(path);

            Files.walkFileTree(directory, new SimpleFileVisitor<>() {

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes basicFileAttributes) throws IOException {

                    System.out.println("Deleting file :: " + file);

                    Files.delete(file);

                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path directory, IOException e) throws IOException {

                    System.out.println("Deleting directory :: " + directory);

                    if (e == null) {

                        Files.delete(directory);

                        return FileVisitResult.CONTINUE;
                    } else {
                        throw e;
                    }
                }
            });

            System.out.println("Recursive deletion ends...");

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}
