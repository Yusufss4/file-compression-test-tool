package com.bu.compression;

/**
 * Represents a benchmark result for a compression algorithm.
 */
public class BenchmarkResult {
    private String algorithmName;
    private long timeTaken; // in milliseconds
    private long originalSize; // in bytes
    private long compressedSize; // in bytes

    public BenchmarkResult(String algorithmName, long timeTaken, long originalSize, long compressedSize) {
        this.algorithmName = algorithmName;
        this.timeTaken = timeTaken;
        this.originalSize = originalSize;
        this.compressedSize = compressedSize;
    }

    public String getAlgorithmName() {
        return algorithmName;
    }

    public long getTimeTaken() {
        return timeTaken;
    }

    public long getOriginalSize() {
        return originalSize;
    }

    public long getCompressedSize() {
        return compressedSize;
    }

    public double getCompressionRatio() {
        if (originalSize == 0) return 0;
        return (double) compressedSize / originalSize;
    }

    @Override
    public String toString() {
        return String.format(
            "Algorithm: %s\nTime taken: %d ms\nOriginal Size: %d bytes\nCompressed Size: %d bytes\nCompression Ratio: %.2f%%\n",
            algorithmName,
            timeTaken,
            originalSize,
            compressedSize,
            getCompressionRatio() * 100
        );
    }
}
