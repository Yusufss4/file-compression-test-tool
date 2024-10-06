package com.bu.compression.compressors;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * Simulates compression using the BZip2 algorithm.
 */
public class BZip2Compressor extends Compressor {
    /**
     * Constructs a BZip2Compressor.
     */
    public BZip2Compressor() {
        super("BZip2", "bz2");
    }

    /**
     * Compresses the input file using BZip2 compression and writes the result to
     * the output file.
     *
     * @param inputFile  the file to be compressed
     * @param outputFile the file to write the compressed data to
     */
    @Override
    public void compress(File inputFile, File outputFile) {
        // Simulate compression without implementing the actual algorithm
        try {
            Files.copy(inputFile.toPath(), outputFile.toPath());
            // Simulate processing time
            Thread.sleep(700);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
