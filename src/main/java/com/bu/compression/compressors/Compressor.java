package com.bu.compression.compressors;

import java.io.File;

/**
 * Abstract base class for all compressors.
 */
public abstract class Compressor {
    protected String name;
    protected String extension;

    /**
     * Constructs a Compressor with the specified name and extension.
     *
     * @param name      the name of the compression algorithm
     * @param extension the file extension for the compressed file
     */
    public Compressor(String name, String extension) {
        this.name = name;
        this.extension = extension;
    }

    /**
     * Compresses the input file and writes the compressed data to the output file.
     *
     * @param inputFile  the file to be compressed
     * @param outputFile the file to write the compressed data to
     */
    public abstract void compress(File inputFile, File outputFile);

    /**
     * Returns the name of the compression algorithm.
     *
     * @return the algorithm name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the file extension for the compressed file.
     *
     * @return the file extension
     */
    public String getExtension() {
        return extension;
    }
}
