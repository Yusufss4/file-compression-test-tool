# File Compression Test Tool

A Java-based command-line application that benchmarks various file compression algorithms. The tool allows you to compress files using different algorithms, measure their performance, and compare results such as compression ratio and time taken. 

This project is written for the Boğazici University Master of Science in Software Engineering SWE 510.01 Data Structures and Algorithms course.

---

## Table of Contents

- [File Compression Test Tool](#file-compression-test-tool)
  - [Table of Contents](#table-of-contents)
  - [Features](#features)
  - [Supported Compression Algorithms](#supported-compression-algorithms)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
  - [Building the Project](#building-the-project)
  - [Running the Tool](#running-the-tool)
  - [Usage Examples](#usage-examples)
    - [Example 1: Compress a File with GZip at Level 5](#example-1-compress-a-file-with-gzip-at-level-5)
    - [Example 2: Compress a File with Multiple Algorithms](#example-2-compress-a-file-with-multiple-algorithms)
    - [Example 3: Display Help Message](#example-3-display-help-message)
  - [Sample Output](#sample-output)
  - [Project Structure](#project-structure)
  - [Additional Details](#additional-details)
    - [UML Diagram](#uml-diagram)
    - [Design Choices and Implementation Details](#design-choices-and-implementation-details)
    - [Polymorphism and Inheritance Usage](#polymorphism-and-inheritance-usage)
    - [Extensibility](#extensibility)
    - [Java Code](#java-code)
  - [Further Developments and Improvements](#further-developments-and-improvements)
  - [Contact](#contact)

---

## Features

- **Benchmark Multiple Algorithms**: Compress files using GZip, BZip2, LZ4, and Run-Length Encoding (RLE).
- **Extensible Design**: Easily add new compression algorithms and options.
- **Detailed Output**: Displays algorithm name, time taken, original size, compressed size, and compression ratio.
- **Verbose Mode**: Enable verbose output to see detailed processing information.

---

## Supported Compression Algorithms

- **GZip** : Currently not implemented. Only added as a mock up.
- **BZip2** : Currently not implemented. Only added as a mock up.
- **LZ4** : Currently not implemented. Only added as a mock up.
- **Run-Length Encoding (RLE)** : Implemented fully.

---

## Prerequisites

- **Java Development Kit (JDK) 8 or higher**: [Download JDK](https://www.oracle.com/java/technologies/javase-downloads.html)

---

## Installation

1. **Clone the Repository**

   ```bash
   git clone https://github.com/yourusername/FileCompressionTestTool.git
   cd FileCompressionTestTool
   ```

2. **Install Dependencies**

   The project uses Maven for dependency management. All dependencies will be downloaded during the build process.

---

## Building the Project

Use Maven to build the project and create an executable JAR file.

```bash
mvn clean package
```

After building, the JAR file will be located at:

```
target/FileCompressionTestTool-1.0-SNAPSHOT-jar-with-dependencies.jar
```

---

## Running the Tool

Execute the JAR file using the `java -jar` command, followed by the options and input file.

**Basic Syntax**

```bash
java -jar target/FileCompressionTestTool-1.0-SNAPSHOT-jar-with-dependencies.jar [options] <inputfile>
```

**Options**

- `--help`: Show the help message.
- `--verbose`: Enable verbose output.
- `--gzip [level]`: Use GZip compression algorithm with optional compression level (1-9).
- `--bzip2`: Use BZip2 compression algorithm.
- `--lz4`: Use LZ4 compression algorithm.
- `--rle`: Use Run-Length Encoding compression algorithm.

---

## Usage Examples

### Example 1: Compress a File with GZip at Level 5

```bash
java -jar target/FileCompressionTestTool-1.0-SNAPSHOT-jar-with-dependencies.jar --gzip 5 sample.txt
```

### Example 2: Compress a File with Multiple Algorithms

```bash
java -jar target/FileCompressionTestTool-1.0-SNAPSHOT-jar-with-dependencies.jar --verbose --gzip 7 --bzip2 --lz4 sample.txt
```

### Example 3: Display Help Message

```bash
java -jar target/FileCompressionTestTool-1.0-SNAPSHOT-jar-with-dependencies.jar --help
```

---

## Sample Output

```
Running compressor: GZip
Algorithm: GZip
Lossless: true
Compression Level: 7
Time taken: 120 ms
Original Size: 204800 bytes
Compressed Size: 102400 bytes
Compression Ratio: 50.00%

Running compressor: BZip2
Algorithm: BZip2
Lossless: true
Compression Level: 5
Time taken: 300 ms
Original Size: 204800 bytes
Compressed Size: 81920 bytes
Compression Ratio: 40.00%

Running compressor: LZ4
Algorithm: LZ4
Lossless: true
Compression Level: 5
Time taken: 80 ms
Original Size: 204800 bytes
Compressed Size: 153600 bytes
Compression Ratio: 75.00%
```

---

## Project Structure

```
FileCompressionTestTool/
├── pom.xml // Currently it is not implemented. Only added for future Maven support.
├── README.md
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── bu/
│   │   │           └── compression/
│   │   │               ├── AlgorithmOptionParser.java
│   │   │               ├── BenchmarkResult.java
│   │   │               ├── CommandLineParser.java
│   │   │               ├── CompressionTestTool.java
│   │   │               ├── Main.java
│   │   │               ├── compressors/
│   │   │               │   ├── Compressor.java
│   │   │               │   ├── GZipCompressor.java
│   │   │               │   ├── BZip2Compressor.java
│   │   │               │   ├── LZ4Compressor.java
│   │   │               │   └── RunLengthEncodingCompressor.java
│   │   │               └── parsers/
│   │   │                   ├── GZipParser.java
│   │   │                   ├── BZip2Parser.java
│   │   │                   ├── LZ4Parser.java
│   │   │                   └── RLEParser.java
│   └── test/
│       └── java/
│           └── com/
│               └── bu/
│                   └── compression/
│                       └── (Unit test classes will go here)
```

---

## Additional Details

### UML Diagram

![UML Diagram](uml-diagram.png)

### Design Choices and Implementation Details

### Polymorphism and Inheritance Usage

### Extensibility

To add a new compression algorithm:

1. **Create a New Compressor Class**

   - Extend the `Compressor` abstract class.
   - Implement the `compress` method.

2. **Create a New Parser Class**

   - Implement the `AlgorithmOptionParser` interface.
   - Parse algorithm-specific options.

3. **Register the Parser**

   - Add the new parser to the `algorithmParsers` map in `CommandLineParser`.
  
### Java Code

---

## Further Developments and Improvements

- **Implement Compression Algorithms**: Implement the GZip, BZip2, and LZ4 compression algorithms.

## Contact

For any questions or issues, please open an issue on the GitHub repository or contact [your.email@example.com](mailto:your.email@example.com).

---

**Thank you for using the File Compression Test Tool!**
