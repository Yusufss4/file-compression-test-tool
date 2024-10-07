# File Compression Test Tool

A Java-based command-line application that benchmarks various file compression algorithms. The tool allows you to compress files using different algorithms, measure their performance, and compare results such as compression ratio and time taken. 

This project is written for the Boğaziçi University Master of Science in Software Engineering SWE 510.01 Data Structures and Algorithms course to showcase the usage of multiple classes, inheritance, different access permissions, polymorphism, arrays, strings, and multiple constructors using Java.

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
  - [Key Classes and Interfaces](#key-classes-and-interfaces)
  - [Polymorphism and Inheritance Usage](#polymorphism-and-inheritance-usage)
      - [1. `Compressor` Abstract Class](#1-compressor-abstract-class)
      - [2. Concrete Compressor Classes](#2-concrete-compressor-classes)
    - [Polymorphism](#polymorphism)
      - [Usage in the Program](#usage-in-the-program)
      - [Benefits of Polymorphism](#benefits-of-polymorphism)
    - [Example of Polymorphic Behavior](#example-of-polymorphic-behavior)
  - [Design Choices and Implementation Details](#design-choices-and-implementation-details)
    - [1. Package Usage and JavaDoc Comments](#1-package-usage-and-javadoc-comments)
    - [2. Encapsulation and Information Hiding](#2-encapsulation-and-information-hiding)
    - [3. Overloaded Constructors for Compression Algorithms](#3-overloaded-constructors-for-compression-algorithms)
  - [Extensibility](#extensibility)
    - [Java Code](#java-code)
  - [Further Developments and Improvements](#further-developments-and-improvements)

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

**Clone the Repository**
   ```bash
   git clone https://github.com/Yusufss4/file-compression-test-tool
   cd file-compression-test-tool
   ```
---

## Building the Project

Use Java compiler to build the project. The following command compiles all Java files in the project:

```bash
javac src/main/java/com/bu/compression/*.java src/main/java/com/bu/compression compressors/*.java
```
---

## Running the Tool

Execute the JAR file using the `java -jar` command, followed by the options and input file.

**Basic Syntax**

Move to the project directory before running the tool.
```bash
cd file-compression-test-tool/src/main/java
```
Run the tool with the following command:
```bash
java com.bu.compression.Main [options] <inputfile>
```

**Options**

- `--help`: Show the help message.
- `--verbose`: Enable verbose output.
- `--gzip`: Use GZip compression algorithm.
- `--bzip2`: Use BZip2 compression algorithm.
- `--lz4`: Use LZ4 compression algorithm.
- `--rle`: Use Run-Length Encoding compression algorithm.

---

## Usage Examples

### Example 1: Compress a File with GZip at Level 5

```bash
java com.bu.compression.Main --gzip sample.txt
```

### Example 2: Compress a File with Multiple Algorithms

```bash
java com.bu.compression.Main --verbose --gzip --bzip2 --lz4 --rle sample.txt
```

### Example 3: Display Help Message

```bash
java com.bu.compression.Main --help
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

## Key Classes and Interfaces

1. **`Compressor` (Abstract Class)**
2. **Concrete Compressor Classes**:
   - `GZipCompressor`
   - `BZip2Compressor`
   - `LZ4Compressor`
   - `RunLengthEncodingCompressor`
3. **`CommandLineParser` (Class)**
4. **`CompressionTestTool` (Class)**
4. **`BenchmarkResult` (Class)**

## Polymorphism and Inheritance Usage

**Inheritance** allows us to define a base class (`Compressor`) and have multiple subclasses inherit from it. This enables code reuse and establishes a common interface for all compression algorithms.

#### 1. `Compressor` Abstract Class

- **Definition**: An abstract class that defines the common interface and shared properties for all compression algorithms.
- **Key Methods and Properties**:
  - `compress(File inputFile, File outputFile)`: Abstract method to be implemented by subclasses. Every compressor must have a `compress` method.
  - Common properties like `name`, `extension`, `description`, `isLossless`, etc.

#### 2. Concrete Compressor Classes

Each concrete compressor class extends the `Compressor` class and provides a specific implementation of the `compress` method.

- **`GZipCompressor`**
  - Extends `Compressor`.
  - Implements the `compress` method using mocked GZip compression.
  - May have additional properties like `compressionLevel` via overloaded constructors.

- **`BZip2Compressor`**
  - Extends `Compressor`.
  - Implements the `compress` method using mocked BZip2 compression.

- **`LZ4Compressor`**
  - Extends `Compressor`.
  - Implements the `compress` method using mocked LZ4 compression.

- **`RunLengthEncodingCompressor`**
  - Extends `Compressor`.
  - Implements the `compress` method using Run-Length Encoding.

### Polymorphism

**Polymorphism** allows us to treat objects of different classes that share a common superclass as objects of the superclass type. This enables writing code that works with superclass types but operates on subclass objects. It really simplifies the code and makes it more maintainable.

#### Usage in the Program

- **List of Compressors**: In the `CommandLineParser` and `CompressionTestTool` classes, we use a `List<Compressor>` to hold instances of various compressor subclasses.

```java
// In CommandLineParser
private List<Compressor> compressors = new ArrayList<>();

// In CompressionTestTool
for (final Compressor compressor : compressors) {
    compressor.compress(inputFile, outputFile);
}
```

- **Dynamic Method Dispatch**: When we call `compressor.compress(inputFile, outputFile);`, the JVM determines at runtime which `compress` method to invoke based on the actual object type (e.g., `GZipCompressor`, `BZip2Compressor`, etc.).

#### Benefits of Polymorphism

- **Extensibility**: New compressor types can be added without modifying the code that uses the `Compressor` interface.
- **Maintainability**: Code that operates on `Compressor` objects doesn't need to know about the specifics of each subclass.

### Example of Polymorphic Behavior

```java
// compressors list contains various Compressor objects
List<Compressor> compressors = Arrays.asList(
    new GZipCompressor(),
    new BZip2Compressor(),
    new LZ4Compressor()
);

for (Compressor compressor : compressors) {
    compressor.compress(inputFile, outputFile);
    // The correct compress method is called based on the object's actual type
}
```

## Design Choices and Implementation Details

- **Package Organization**: Classes are organized into packages (`compressors`, `parsers`, etc.) to group related functionality.
- **Interfaces and Abstract Classes**: Use of interfaces and abstract classes to define contracts and common behavior.
- **Encapsulation**: Implementation details are hidden, exposing only necessary interfaces.

### 1. Package Usage and JavaDoc Comments

- **Package Structure**: Classes are organized into packages based on functionality (e.g., `compressors`, `parsers`). Also the folder structure is organized in a way to support Maven project structure.
- **JavaDoc Comments**: JavaDoc comments are used to document classes, methods, and fields. This could help in generating documentation and understanding the code.

### 2. Encapsulation and Information Hiding

In the `Compressor` class, properties are encapsulated and accessed through getter methods. This ensures that the internal state of the class is protected and can only be modified through subclasses. That is why the properties are declared as `protected` and accessed through getter methods.

```java
public abstract class Compressor {
    protected final String name;
    protected final String extension;
    protected final String description;
    protected final boolean isLossless;
    protected final int compressionLevel;
    protected final String version;
    protected final String author;
    protected final Map<String, String> settings;
```

But for example in the `BenchmarkResult` class, the properties are declared as `private` and only can be accessed through getter methods. This ensures that the internal state of the class can be only be set via the constructor. Otherwise the user could accidentally change the values of the properties and mix the algorithms results.

```java
public class BenchmarkResult {
    private String algorithmName;
    private long timeTaken; // in milliseconds
    private long originalSize; // in bytes
    private long compressedSize; // in bytes
    private boolean isLossless;
    private int compressionLevel;
```

In our program we did not use the 'public' access modifier for the properties. We used 'protected' and 'private' access modifiers to hide the implementation details and to prevent the user from changing the values of the properties.

### 3. Overloaded Constructors for Compression Algorithms

**Design Choice**:

The 'Compressor' abstract class has overloaded constructors to allow different compression algorithms to be created with different settings. For example, the 'GZipCompressor' class has a constructor that takes a compression level as an argument. This allows to add new algorithms with specific settings without modifying the existing abstract class.

```java
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
    this(name, extension, "", true, compressionLevel, "1.0"

```

## Extensibility

To add a new compression algorithm:

1. **Create a New Compressor Class**

   - Extend the `Compressor` abstract class.
   - Implement the `compress` method.

2. **Register the Parser**

   - Add the new parser to the `algorithmParsers` map in `CommandLineParser`.
  
### Java Code

---

## Further Developments and Improvements

- **Implement Compression Algorithms**: Implement the GZip, BZip2, and LZ4 compression algorithms. Currently they are only added as mock up to showcase the extensibility of the program.
- **Add Support Algorithm Options**: Add support for specifying algorithm-specific options like compression level in the command line parser. Currently they are supported class-wise but not in the command line.
- **Unit Tests**: Write unit tests to ensure the correctness of the compression algorithms and benchmarking logic.
- **Maven Support**: Add Maven support to manage dependencies and build the project.
- **More Compression Algorithms**: Add more compression algorithms to compare and benchmark.

---

**Thank you for using the File Compression Test Tool!**
