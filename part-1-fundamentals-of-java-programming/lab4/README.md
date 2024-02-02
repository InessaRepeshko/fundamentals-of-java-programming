## Laboratory Training № 4 "Working with Generics and Collections"

## 4.1 Individual Task

Add new classes to the hierarchy of classes created by implementing of the individual task given in the [Laboratory training #2](https://github.com/InessaRepeshko/java-programming/blob/main/part-1-fundamentals-of-java-programming/lab2/README.md). You should add derived classes that represent the first of the entities of the individual task. The first class should represent data using list (```ArrayList```), the second should use set (```SortedSet```).

Use Collections class to sort the list. When working with set, you should consistently create multiple sets sorted according to different criteria.

Test both implementations. The results of the programs should match.

## 4.2 Enumeration for Representation of Months of the Year

Create enumeration that represents months of the year. It is necessary to define the constructor and store the number of days (for non-leap year). Add methods of getting previous and next month, and a function that returns a season for particular month. Create static method that prints all months. Test enumeration in ```main()``` function of some test class.

## 4.3 Creation of a Library that Provides Generic Functions for Working with Arrays

Create a class with static generic methods that implement this functionality:
* swap of two groups of items;
* swap of all neighbour items (with even and odd indices);
* inserting items of another array in the specified location;
* replacement of some group with items of another array.

Demonstrate the work of all methods using data of different types (```Integer```, ```Double```, ```String```).

## 4.4 Creation of a Library that Provides Generic Functions for Working with Lists of Numbers

Create a class that contains static generic functions for implementing such actions with a list of numbers (objects derived from ```Number```):
* finding the index of the first zero element;
* counting of the number of negative numbers;
* return the last negative element.

Test all functions on lists of numbers of different types.

## 4.5 Finding Different Words in a Sentence

Enter a sentence, create a collection (```SortedSet```) of different words in a sentence, and display all these words in alphabetical order.

## 4.6 Data about Users

Present data about users in an associative array (username / password) with the assumption that all usernames are different. Display user information with a password length of more than 6 characters.

## 4.7 Creating a Custom Container Based on an Array

Create a generic class to represent a one-dimensional array, whose index of items varies from a certain value ```from``` to value ```to``` inclusive. These values can be either positive or negative. The class must implement the ```Collection``` interface. It is advisable to use the ```AbstractList``` class as a base class.

## 4.8 Implementation of the Doubly-Linked List (Advanced Task)

Implement a generic class representing a doubly-linked list.

## 4.9 Implementation of the Element Removal Functions from the Tree (Advanced Task)

Add to the example 3.8 the function of deleting a given item from a tree.

## 4.10  Implementation of the Red-Black Tree (Advanced Task, Optional)

Independently implement associative array based on a red-black tree.

## Examples of program results

[lab4_report.docx](https://github.com/InessaRepeshko/java-programming/blob/main/part-1-fundamentals-of-java-programming/lab4/lab4_report.docx)

© Inessa Repeshko. 2023
