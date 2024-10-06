package com.bu.compression.compressors;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

/**
 * Simulates compression using the BZip2 algorithm.
 */
public class BZip2Compressor extends Compressor {
    /**
     * Constructs a BZip2Compressor.
     */
    public BZip2Compressor() {
        super("BZip2", "bz2"); // This is the constructor of the superclass Compressor
    }

    /**
     * Compresses the input file using BZip2 compression and writes the result to
     * the output file.
     *
     * @param inputFile  the file to be compressed
     * @param outputFile the file to write the compressed data to
     * @warning This method is not implemented yet. Just a simulation.
     */
    @Override
    public void compress(File inputFile, File outputFile) {
        // Simulate compression without implementing the actual algorithm
        try {
            Files.copy(inputFile.toPath(), outputFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            // Simulate processing time
            Thread.sleep(700);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
