## Laboratory Training № 5 "Working with Exceptions and Files in Java"

## 5.1 Individual Task

Create and implement classes that represent entities given in an individual assignment of the [Laboratory training #4](https://github.com/InessaRepeshko/java-programming/blob/main/lab4). The decision should be based on the hierarchy of classes.

You need to create two derived classes from the class that represents the main entity. The first derived class should be supplemented by the ability to read data from the appropriately prepared text file and write this data to another file after sorting. The second derived class should implement support reading data from a pre-generated XML document, storing data in structures that are automatically created using data binding technology, and writing data to another XML document after sorting. To avoid duplication of data in the program, you must also redefine the class representing the second entity. Derived classes should implement a common interface, which declare the functions of reading from a file and writing to a file.

An additional console output should be provided.

## 5.2 Sorting Integers

Implement a program that reads positive integer values from the text file (the numbers are separated by spaces, it should be read to the end of the file), places these numbers into an array, sorts them in descending order and increasing the sum of digits and stores both results in two new text files. The above actions should be implemented in separate static functions. To define the sort order, create two classes that implement the ```Comparator``` interface.

## 5.3 Working with ZIP Archive (Additional Task)

Create classes ```Student``` and ```Academic Group``` (with an array of students as a field). Create objects, store data about the students of the academic group in the archive. Read data from the archive in another program.

## Examples of program results

[lab5_report.docx](https://github.com/InessaRepeshko/java-programming/blob/main/lab5/lab5_report.docx)

© Inessa Repeshko. 2023
