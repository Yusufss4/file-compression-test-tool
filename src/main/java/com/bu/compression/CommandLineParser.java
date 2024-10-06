package com.bu.compression;

import com.bu.compression.compressors.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Parses command-line arguments and configures the tool accordingly.
 */
public class CommandLineParser {
    private String[] args;
    private boolean verbose = false;
    private File inputFile;
    private List<Compressor> compressors = new ArrayList<>();

    /**
     * Constructs a CommandLineParser with the specified arguments.
     *
     * @param args Command-line arguments
     */
    public CommandLineParser(String[] args) {
        this.args = args;
        parseArgs();
    }

    /**
     * Parses the command-line arguments and initializes the tool's configuration.
     */
    private void parseArgs() {
        if (args.length == 0) {
            printHelp();
            System.exit(0);
        }

        for (String arg : args) {
            switch (arg) {
                case "--help":
                    printHelp();
                    System.exit(0);
                    break;
                case "--verbose":
                    verbose = true;
                    break;
                case "--gzip":
                    // TODO: Add support getting compression level from command line.
                    compressors.add(new GZipCompressor(5));
                    break;
                case "--bzip2":
                    compressors.add(new BZip2Compressor());
                    break;
                case "--lz4":
                    compressors.add(new LZ4Compressor());
                    break;
                case "--rle":
                    compressors.add(new RunLengthEncodingCompressor());
                    break;
                default:
                    if (arg.startsWith("--")) {
                        System.err.println("Unknown option: " + arg);
                        System.exit(1);
                    } else {
                        // Assume it's the input file
                        inputFile = new File(arg);
                        if (!inputFile.exists()) {
                            System.err.println("Input file does not exist: " + arg);
                            System.exit(1);
                        }
                    }
                    break;
            }
        }

        if (compressors.isEmpty()) {
            System.out.println("No algorithms specified.");
            System.exit(1);
        }

        if (inputFile == null) {
            System.out.println("No input file specified.");
            System.exit(1);
        }
    }

    /**
     * Prints the help message to the console.
     */
    private void printHelp() {
        System.out.println("Usage: java -jar FileCompressionTestTool.jar [options] <inputfile>");
        System.out.println("Options:");
        System.out.println("  --help           Show this help message");
        System.out.println("  --verbose        Enable verbose output");
        System.out.println("  --gzip           Use GZip compression algorithm");
        System.out.println("  --bzip2          Use BZip2 compression algorithm");
        System.out.println("  --lz4            Use LZ4 compression algorithm");
        System.out.println("  --rle            Use Run-Length Encoding compression algorithm");
    }

    /**
     * Returns whether verbose output is enabled.
     *
     * @return true if verbose output is enabled; false otherwise
     */
    public boolean isVerbose() {
        return verbose;
    }

    /**
     * Returns the input file to be compressed.
     *
     * @return the input file
     */
    public File getInputFile() {
        return inputFile;
    }

    /**
     * Returns the list of compressors to be used.
     *
     * @return the list of compressors
     */
    public List<Compressor> getCompressors() {
        return compressors;
    }
}
