package com.bu.compression.compressors;

import java.io.*;

/**
 * Implements compression using the Run-Length Encoding (RLE) algorithm.
 */
public class RunLengthEncodingCompressor extends Compressor {
    /**
     * Constructs a RunLengthEncodingCompressor.
     */
    public RunLengthEncodingCompressor() {
        super("Run-Length Encoding", "rle"); // This is the constructor of the superclass Compressor
    }

    /**
     * Compresses the input file using RLE compression and writes the result to the
     * output file.
     *
     * @param inputFile  the file to be compressed
     * @param outputFile the file to write the compressed data to
     */
    @Override
    public void compress(File inputFile, File outputFile) {
        try (
                FileInputStream fis = new FileInputStream(inputFile);
                BufferedInputStream bis = new BufferedInputStream(fis);
                FileOutputStream fos = new FileOutputStream(outputFile);
                BufferedOutputStream bos = new BufferedOutputStream(fos)) {
            int currentByte, previousByte = -1, count = 0;

            while ((currentByte = bis.read()) != -1) {
                if (currentByte == previousByte) {
                    count++;
                    if (count == 255) {
                        bos.write(count);
                        bos.write(currentByte);
                        count = 0;
                        previousByte = -1;
                    }
                } else {
                    if (previousByte != -1) {
                        bos.write(count);
                        bos.write(previousByte);
                    }
                    count = 1;
                    previousByte = currentByte;
                }
            }

            // Write the last sequence
            if (count > 0 && previousByte != -1) {
                bos.write(count);
                bos.write(previousByte);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
