package com.bu.compression.compressors;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * Simulates compression using the LZ4 algorithm.
 */
public class LZ4Compressor extends Compressor {
    public LZ4Compressor() {
        super("LZ4", "lz4");
    }

    @Override
    public void compress(File inputFile, File outputFile) {
        // Simulate compression without implementing the actual algorithm
        try {
            Files.copy(inputFile.toPath(), outputFile.toPath());
            // Simulate processing time
            Thread.sleep(300);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
