## Laboratory Training № 1 "Java Architecture and Syntax"

## 1.1 Individual Task

Create a console Java application that calculates values of a function on a given range. The necessary source data (interval boundaries and step of argument increasing) should be read from keyboard.

Program should contain reading data from keyboard and main loop, in which the following activities are performed:
* calculating the function choosing one of branches, depending on the value of the argument;
* output to the console argument and result at each step;
* increase value of the argument by the size of the step and go to the next calculation, if necessary.

Program should contain the single class with two static functions:
* a separate static function to calculate the value of $`y`$ depending on the value of the argument $`x`$;
* the ```main()``` method, which contains the reading the source data, as well as the cycle of calculating the function and output the values of $`x`$ and $`y`$.

Particular function is given in the individual task according to your own index in the group students list (index of variant). Define the constant $`n`$ with the ```final``` modifier. Use the ```printf()``` function for formatted output.

* Variant# 4
* $`n`$ = 11
* Function:
```math
y = \begin{cases}
3x + \sum_{k=1}^{n} sin^k(x - 7) , x < 7
\\ 23 - 2e^{7-x} , x \geq 7
\end{cases} 
```

![task1_1](https://github.com/InessaRepeshko/java-programming/blob/main/part-1-fundamentals-of-java-programming/lab1/screens/task1_1.png)

## 1.2 Powers of 8

Read integer value of $`n`$ (from 1 to 10) and display powers of 8 from 1 to $`n`$. Implement two approaches: using arithmetic and bitwise operations.

## 1.3 Use break and continue with a Label

Enter the values of $`x`$ and $`n`$, calculate and display the result of the expression:

```math
y =  \prod_{i=1}^{n-1} \sum_{j=0}^n \frac{i}{j + x} 
```

![task1_3](https://github.com/InessaRepeshko/java-programming/blob/main/part-1-fundamentals-of-java-programming/lab1/screens/task1_3.png)

If $`i`$ is equal to $`j + x`$, go to the next step of the external cycle without multiplying by the intermediate result. To proceed to the next step, use ```continue``` with a label.

If the denominator at any iteration is 0, exit both loops with an error message. To exit, use ```break``` with a label.

## 1.4 Type Conversion Function Library

Create a class with static functions to convert an argument of type ```boolean``` to an integer value (0 or 1) and vice versa (zero is ```false```, non-zero value is ```true```). Demonstrate the invocation of functions by calling them from another class created in another package. Apply normal and static import.

## Examples of program results

![lab1_report.docx](https://github.com/InessaRepeshko/java-programming/blob/main/part-1-fundamentals-of-java-programming/lab1/lab1_report.docx)

© Inessa Repeshko. 2023
