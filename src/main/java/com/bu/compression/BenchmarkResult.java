package com.bu.compression;

/**
 * Represents a benchmark result for a compression algorithm.
 */
public class BenchmarkResult {
    private String algorithmName;
    private long timeTaken; // in milliseconds
    private long originalSize; // in bytes
    private long compressedSize; // in bytes
    private boolean isLossless;
    private int compressionLevel;

    /**
     * Constructs a BenchmarkResult with the specified parameters.
     *
     * @param algorithmName  the name of the compression algorithm
     * @param timeTaken      the time taken to compress in milliseconds
     * @param originalSize   the size of the original file in bytes
     * @param compressedSize the size of the compressed file in bytes
     */
    public BenchmarkResult(String algorithmName, long timeTaken, long originalSize, long compressedSize,
            boolean isLossless, int compressionLevel) {
        this.algorithmName = algorithmName;
        this.timeTaken = timeTaken;
        this.originalSize = originalSize;
        this.compressedSize = compressedSize;
        this.isLossless = isLossless;
        this.compressionLevel = compressionLevel;
    }

    /**
     * Returns the name of the compression algorithm.
     *
     * @return the algorithm name
     */
    public String getAlgorithmName() {
        return algorithmName;
    }

    /**
     * Returns the time taken to compress in milliseconds.
     *
     * @return the time taken
     */
    public long getTimeTaken() {
        return timeTaken;
    }

    /**
     * Returns the size of the original file in bytes.
     *
     * @return the original size
     */
    public long getOriginalSize() {
        return originalSize;
    }

    /**
     * Returns the size of the compressed file in bytes.
     *
     * @return the compressed size
     */
    public long getCompressedSize() {
        return compressedSize;
    }

    /**
     * Calculates and returns the compression ratio as a percentage.
     *
     * @return the compression ratio
     */
    public double getCompressionRatio() {
        if (originalSize == 0) return 0;
        return (double) compressedSize / originalSize * 100;
    }

    @Override
    public String toString() {
        return String.format(
                "Algorithm: %s\nLossless: %b\nCompression Level: %d\nTime taken: %d ms\nOriginal Size: %d bytes\nCompressed Size: %d bytes\nCompression Ratio: %.2f%%\n",
            algorithmName,
                isLossless,
                compressionLevel,
            timeTaken,
            originalSize,
            compressedSize,
                getCompressionRatio()
        );
    }
}
