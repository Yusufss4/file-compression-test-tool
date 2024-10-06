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
    private boolean help = false;
    private File inputFile;
    private List<Compressor> compressors = new ArrayList<>();

    public CommandLineParser(String[] args) {
        this.args = args;
        parseArgs();
    }

    private void parseArgs() {
        if (args.length == 0) {
            printHelp();
            System.exit(0);
        }

        for (String arg : args) {
            switch (arg) {
                case "--help":
                    help = true;
                    printHelp();
                    System.exit(0);
                    break;
                case "--verbose":
                    verbose = true;
                    break;
                case "--gzip":
                    compressors.add(new GZipCompressor());
                    break;
                case "--bzip2":
                    compressors.add(new BZip2Compressor());
                    break;
                case "--lz4":
                    compressors.add(new LZ4Compressor());
                    break;
                default:
                    if (arg.startsWith("--")) {
                        System.out.println("Unknown option: " + arg);
                        System.exit(1);
                    } else {
                        // Assume it's the input file
                        inputFile = new File(arg);
                        if (!inputFile.exists()) {
                            System.out.println("Input file does not exist: " + arg);
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

    private void printHelp() {
        System.out.println("Usage: java -jar FileCompressionTestTool.jar [options] <inputfile>");
        System.out.println("Options:");
        System.out.println("  --help           Show this help message");
        System.out.println("  --verbose        Enable verbose output");
        System.out.println("  --gzip           Use GZip compression algorithm");
        System.out.println("  --bzip2          Use BZip2 compression algorithm");
        System.out.println("  --lz4            Use LZ4 compression algorithm");
    }

    public boolean isVerbose() {
        return verbose;
    }

    public File getInputFile() {
        return inputFile;
    }

    public List<Compressor> getCompressors() {
        return compressors;
    }
}
