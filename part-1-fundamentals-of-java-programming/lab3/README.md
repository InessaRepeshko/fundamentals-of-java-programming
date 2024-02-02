## Laboratory Training № 3 "Use of Inheritance and Polymorphism in Java"

## 3.1 Individual Assignment

Create a hierarchy of classes that represent entities according to individual assignment. Particular function is given in the individual task according to your own index in the group students list (index of variant).

Each class should be separately tested. The ```main()``` function of the first class should contain creation of necessary object and invocation of methods implementing an individual assignment. Results should be shown on console window.

| # Variant | First Entity   | Obligatory Fields of First Entity | Second Entity | Obligatory Fields of Second Entity | Main Assignment: Find and show the following data:                                                                  |
| :-------: | :------------- | :-------------------------------- | :------------ | :--------------------------------- | :------------------------------------------------------------------------------------------------------------------ |
| 24        | Subway station | Name, year of opening	           | Hour          | Count of passengers, comments	    | Total count of passengers, hours with the minimum count of passengers, hours the maximum count of words in comments |

The class that represents the second entity of an individual task should contain data and access methods, overridden ```toString()```, ```equals()```, and ```hashCode()``` functions, as well as the implementation of the functions defined in the previous assignments (if necessary). This class also should implement the ```Comparable``` interface for the natural comparison of objects when sorting by one of the criteria.

The base abstract class that represents the first entity of individual tasks (conventionally ```AbstractFirstEntity```) should contain:
* access functions (getters and setters);
* abstract methods for access to a sequence of elements of the second abstract class;
* overridden ```toString()``` method for output object data;
* overridden ```equals()``` method for checking equality of objects;
* overridden ```hashCode()``` method for getting hash codes;
* implementation of search methods according to specific criteria;
* implementation of the function of sorting items of the sequence on the first criterion of an individual task by the Bubble method;
* implementation of the function of sorting items of the sequence on the second criterion of the individual task by the Insertion method;
* implementation of testing the classes' functionality.

Sorting criteria are determined by the student's number in the group list. Search functions should return arrays of objects (or ```null```, if no search results). Individual tasks are listed in the following table:

| # Variant | First Criterion of Sorting                   | Second Criterion of Sorting                 |
| :-------: | :------------------------------------------- | :------------------------------------------ |
| 24        | By count of passengers (in decreasing order) | By length of comments (in decreasing order) |

Derived class from the created abstract classes (for convenience ```FirstEntityWithArray```) should contain fields of appropriate types, in particular, the sequence of elements of the second entity should be represented as an array.

Create another class (conventionally ```FirstEntityWithSorting```) derived from the previously created ```FirstEntityWithArray``` class. This class should override sorting methods by use the standard ```Arrays.sort()``` function instead of bubble sorting and insertion sorting. The first sorting should be provided by the implementation of the ```Comparable``` interface for the entity whose objects are stored in an array. The second sorting is provided by creating a separate class that implements the ```Comparator``` interface. Use of lambda expression is recommended.

Testing of the program should include the previously implemented task, as well as sorting according to specific criteria.

Note: you should create classes with meaningful names that reflect the physical nature of the individual task, not ```FirstEntity```, ```SecondEntity```, etc.

Javadoc comments should be added to the source code.

## 3.2 Class Hierarchy

Implement classes "Human," "Citizen", "Student", "Employee". Each class should implement ```toString()``` method. Create an array of references to different objects of the class hierarchy. Create a cycle and display data that represents objects of different types.

Note: it is necessary to create classes with meaningful names.

## 3.3 Minimum of a Function

Implement a program that finds minimum of some function by setting value of step and traversal of a given interval. Implement five versions:
* using abstract class and derived classes;
* through the definition of the interface, the creation of a class that uses this interface as a parameter type of the minimum finding function, the creation of separate classes that implement this interface;
* using previously described interface and anonymous classes;
* using lambda expressions;
* using references to methods.

Test the program for two different functions.

## 3.4 Implementation of an Array of Points through a Two-Dimensional Array

Implement the ```AbstractArrayOfPoints```, abstract class functionality given in Example 3.2, in two ways:
* using a two-dimensional array of real numbers; each row of the array must correspond to the point;
* use of a one-dimensional array of real numbers; each pair of numbers in the array should correspond to the point.

Test classes.

Note: you should not make changes to the ```AbstractArrayOfPoints``` class code (except the package name and implementation of the ```sortByY()``` method).

## 3.5 The Implementation of the Comparable Interface

Create a ```Circle``` class that implements the ```Comparable``` interface. A circle with a larger radius is considered to be larger. Sort the array of ```Circle``` objects.

## 3.6 The Implementation of the Comparator Interface

Create a ```Triangle``` class. The triangle is defined by the lengths of the sides. The area of the triangle in this case can be calculated by Heron's formula:

```math
S_ \triangle = \frac{1}{4} \sqrt{(a + b + c)(b + c - a)(a + c - b)(a + b - c)} 
```

where $`a`$, $`b`$ and $`c`$ are the lengths of the sides of the triangle. Sort the array of triangles by descending the area. To determine the sort criteria, use an object that implements the ```Comparator``` interface.

## 3.7 Calculation of the Definite Integral (Additional Task)

Create an ```Integrable``` interface that contains a description of an abstract function that takes an argument of type ```double``` and returns the result of the same type. This interface should contain the ```integral()``` method with the default implementation (with the ```default``` modifier) of calculating the specified integral. The method should receive start, end of the interval, and the accuracy of the calculations as arguments. The default implementation of computing the integral should use the method of rectangles.

Create a class that redefines the ```integral()``` method by implementing a trapezoid method for calculating integral.

Calculate a definite integral by using both algorithms for different functions of the ```java.lang.Math``` class (see example 3.3). Compare results for different algorithms and different values of computing accuracy.

## Examples of program results

![lab3_report.docx](https://github.com/InessaRepeshko/java-programming/blob/main/part-1-fundamentals-of-java-programming/lab3/lab3_report.docx)

© Inessa Repeshko. 2023
