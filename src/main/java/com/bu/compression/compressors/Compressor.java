package com.bu.compression.compressors;

import java.io.File;

/**
 * Abstract base class for all compressors.
 */
public abstract class Compressor {
    protected String name;
    protected String extension;

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

    public String getName() {
        return name;
    }

    public String getExtension() {
        return extension;
    }
}
