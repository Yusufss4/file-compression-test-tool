package com.bu.compression.compressors;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

/**
 * Simulates compression using the LZ4 algorithm.
 */
public class LZ4Compressor extends Compressor {
    /**
     * Constructs an LZ4Compressor.
     */
    public LZ4Compressor() {
        super("LZ4", "lz4"); // This is the constructor of the superclass Compressor
    }

    /**
     * Compresses the input file using LZ4 compression and writes the result to the
     * output file.
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
            Thread.sleep(300);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
