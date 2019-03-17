package org.redquark.kickstarter.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class _01ReadTextFile {

    private static final String filePath = "src//org//redquark//kickstarter//data//sample.txt";

    public static void main(String[] args) {

        // Read file using the normal IO APIs
        System.out.println("Contents of the file using normal IO APIs are:\n");
        readFileUsingIO();

        // Separator
        System.out.println("----------------------------------------------------------------------------");

        // Read file using the NIO APIs
        System.out.println("\n\nContents of the file using NIO APIs are:\n");
        readFileUsingNIO();
    }

    private static void readFileUsingIO() {

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

    private static void readFileUsingNIO() {

        try {

            // Create an instance of RandomAccessFile to read to file
            RandomAccessFile randomAccessFile = new RandomAccessFile(filePath, "r");

            // Getting the instance of channel
            FileChannel fileChannel = randomAccessFile.getChannel();

            // ByteBuffer with capacity of 1024 bytes
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

            // Read from the ByteBuffer
            while (fileChannel.read(byteBuffer) > 0) {

                byteBuffer.flip();

                for (int i = 0; i < byteBuffer.limit(); i++) {

                    // Read character by character
                    System.out.print((char) byteBuffer.get());
                }
                byteBuffer.clear();
            }

            // Closing channel and file instance to avoid memory leaks
            fileChannel.close();
            randomAccessFile.close();

        } catch (IOException e) {

            e.printStackTrace();

        }
    }
}
