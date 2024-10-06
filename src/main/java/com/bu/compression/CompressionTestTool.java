package com.bu.compression;

import com.bu.compression.compressors.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * The main tool that orchestrates the compression tests.
 */
public class CompressionTestTool {
    private CommandLineParser parser;
    private boolean verbose;
    private File inputFile;
    private List<Compressor> compressors;
    private List<BenchmarkResult> results = new ArrayList<>();

    public CompressionTestTool(String[] args) {
        this.parser = new CommandLineParser(args);
        this.verbose = parser.isVerbose();
        this.inputFile = parser.getInputFile();
        this.compressors = parser.getCompressors();
    }

    public void run() {
        for (Compressor compressor : compressors) {
            if (verbose) {
                System.out.println("Running compressor: " + compressor.getName());
            }

            long startTime = System.currentTimeMillis();
            compressor.compress(inputFile, new File(inputFile.getName() + "." + compressor.getExtension()));
            long endTime = System.currentTimeMillis();

            BenchmarkResult result = new BenchmarkResult(
                compressor.getName(),
                endTime - startTime,
                inputFile.length(),
                new File(inputFile.getName() + "." + compressor.getExtension()).length()
            );
            results.add(result);

            System.out.println(result);
        }
    }
}
