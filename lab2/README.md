## Laboratory Training № 2 "Working with Reference Types"

## 2.1 Individual Task

Fill in a two-dimensional array of integers by random positive values according to the rule given in the table. Fill in a one-dimensional array of strings by repeating of a certain character by the number of times specified in the table. Sort the array of strings according to the rule specified in the table.

| # Variant | Size of a two-dimensional array | The rule of filling a two-dimensional array | Number of items in array of strings       | The length of a single string in the array | Criterion of sorting array of strings |
| :-------: | :------------------------------ | :------------------------------------------ | :---------------------------------------- | :----------------------------------------- | :------------------------------------ |
| 24        | 5 × 3                           | random odd number between 3 and 31          | the number of rows of an array of numbers | minimum row item                           | by reverse alphabetical order         |

Display the resulting array of strings.

For example, suppose a two-dimensional array of integers that contains the following numbers:

| First column | Second column  |
| :----------: | :------------: |
| 3            | 7              |
| 18           | 4              |
| 19           | 2              |

If, suppose, the number of items of the array of strings corresponds to the number of rows of the array of numbers, and the minimum elements of the array are the number of repetitions of a certain character, and the character to be repeated is $`N`$, we will get such an array of strings:

| Rows |
| :--- |
| NNN  |
| NNNN |
| NN   |

To implement two approaches: traditional, built on cycles and working with individual items and through the functions of the ```Arrays``` class (without cycles). Do not use streams and ```Arrays.stream()``` method.

## 2.2 Sieve of Eratosthenes

Fill an array of 300 elements with consecutive positive integer numbers. Replace all non-prime numbers with some negative value. To do this, consistently exclude all numbers that are divisors of other numbers. Print all remaining positive values (prime numbers).

Do not use division and getting the remainder of the division in the program.

## 2.3 Finding Fibonacci Numbers

Implement a function for computing of Fibonacci numbers (up to the 92nd integer) using an auxiliary array (static field). The function parameter should be Fibonacci number's index. The search for Fibonacci numbers is carried out according to the following rule:

```math
F(1) = F(2) = 1;   F(n) = F(n - 2) + F(n - 1)
```

At the first call, the array is filled until the required number. At subsequent calls, the number either returns from the array, or is calculated using the last two numbers stored in an array. Use the ```long``` type to represent numbers.

Perform function testing for different values of numbers entered in an arbitrary order.

## 2.4 Alignment of a String

Read string from command line and then add spaces until string length will be equal to a given value. Spaces must be even added at the beginning and at the end of string. The spaces should be added evenly between words (if possible).

## Examples of program results

[lab2_report.docx](https://github.com/InessaRepeshko/java-programming/blob/main/part-1-fundamentals-of-java-programming/lab2/lab2_report.docx)

© Inessa Repeshko. 2023
