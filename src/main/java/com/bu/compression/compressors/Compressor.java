package com.bu.compression.compressors;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Abstract base class for all compressors.
 */
public abstract class Compressor {
    protected final String name;
    protected final String extension;
    protected final String description;
    protected final boolean isLossless;
    protected final int compressionLevel;
    protected final String version;
    protected final String author;
    protected final Map<String, String> settings;

    /**
     * Constructs a Compressor with the specified name and extension.
     *
     * @param name      the name of the compression algorithm
     * @param extension the file extension for the compressed file
     */
    public Compressor(String name, String extension) {
        this(name, extension, "", true, 5, "1.0", "Unknown", new HashMap<>());
    }

    /**
     * Constructs a Compressor with the specified name, extension, and description.
     *
     * @param name        the name of the compression algorithm
     * @param extension   the file extension for the compressed file
     * @param description a brief description of the algorithm
     */
    public Compressor(String name, String extension, String description) {
        this(name, extension, description, true, 5, "1.0", "Unknown", new HashMap<>());
    }

    /**
     * Constructs a Compressor with the specified name, extension, and compression
     * level.
     *
     * @param name             the name of the compression algorithm
     * @param extension        the file extension for the compressed file
     * @param compressionLevel the level of compression (1-9)
     */
    public Compressor(String name, String extension, int compressionLevel) {
        this(name, extension, "", true, compressionLevel, "1.0", "Unknown", new HashMap<>());
    }

    /**
     * Constructs a Compressor with all attributes specified.
     *
     * @param name             the name of the compression algorithm
     * @param extension        the file extension for the compressed file
     * @param description      a brief description of the algorithm
     * @param isLossless       indicates if the algorithm is lossless
     * @param compressionLevel the level of compression (1-9)
     * @param version          the version of the algorithm
     * @param author           the author or organization
     * @param settings         additional settings for the compressor
     */
    public Compressor(String name, String extension, String description,
            boolean isLossless, int compressionLevel, String version,
            String author, Map<String, String> settings) {
        this.name = name;
        this.extension = extension;
        this.description = description;
        this.isLossless = isLossless;
        this.compressionLevel = compressionLevel;
        this.version = version;
        this.author = author;
        this.settings = settings;
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

    /**
     * Indicates whether the algorithm is lossless.
     *
     * @return true if lossless, false if lossy
     */
    public boolean isLossless() {
        return isLossless;
    }

    /**
     * Returns the compression level.
     *
     * @return the compression level
     */
    public int getCompressionLevel() {
        return compressionLevel;
    }

    /**
     * Returns the information about the algorithm.
     *
     * @return information
     */
    @Override
    public String toString() {
        return String.format(
                "Name: %s\nExtension: %s\nDescription: %s\nLossless: %b\nCompression Level: %d\nVersion: %s\nAuthor: %s\nSettings: %s",
                name, extension, description, isLossless, compressionLevel, version, author, settings);
    }
}
