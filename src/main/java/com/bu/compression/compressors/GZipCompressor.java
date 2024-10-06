package com.bu.compression.compressors;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;

/**
 * Simulates compression using the GZip algorithm.
 */
public class GZipCompressor extends Compressor {
    /**
     * Constructs a GZipCompressor with default settings.
     */
    public GZipCompressor() {
        super("GZip", "gz", "GZip compression using DEFLATE algorithm", true, 5, "1.0",
                "Jean-loup Gailly and Mark Adler", new HashMap<>());
    }

    /**
     * Constructs a GZipCompressor with specified compression level.
     *
     * @param compressionLevel the compression level (1-9)
     */
    public GZipCompressor(int compressionLevel) {
        super("GZip", "gz", "GZip compression using DEFLATE algorithm", true, compressionLevel, "1.0",
                "Jean-loup Gailly and Mark Adler", new HashMap<>());
    }

    /**
     * Compresses the input file using GZip compression and writes the result to the
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
            Thread.sleep(500);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
