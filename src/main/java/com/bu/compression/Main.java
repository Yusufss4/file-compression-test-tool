package com.bu.compression;

/**
 * The entry point of the File Compression Test Tool.
 */
public class Main {
    /**
     * Main method to start the application.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        CompressionTestTool tool = new CompressionTestTool(args);
        tool.run();
    }
}
