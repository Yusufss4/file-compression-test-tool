package com.bu.compression.compressors;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * Simulates compression using the GZip algorithm.
 */
public class GZipCompressor extends Compressor {
    /**
     * Constructs a GZipCompressor.
     */
    public GZipCompressor() {
        super("GZip", "gz");
    }

    /**
     * Compresses the input file using GZip compression and writes the result to the
     * output file.
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
            Thread.sleep(500);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
