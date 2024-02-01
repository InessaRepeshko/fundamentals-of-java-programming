package task4;

import task4.helpers.TypeCaster;

import static task4.helpers.TypeCaster.*;

public class Application {
    public static void main(String[] args) {
        int intVariable = 1;
        System.out.printf("Integer to boolean:\t%d\t->\t%b\n", intVariable, TypeCaster.cast(intVariable));

        intVariable = 0;
        System.out.printf("Integer to boolean:\t%d\t->\t%b\n", intVariable, cast(intVariable));

        intVariable = -5;
        System.out.printf("Integer to boolean:\t%d\t->\t%b\n", intVariable, TypeCaster.cast(intVariable));

        intVariable = 1000;
        System.out.printf("Integer to boolean:\t%d\t->\t%b\n", intVariable, cast(intVariable));

        boolean boolVariable = true;
        System.out.printf("Boolean to integer:\t%b\t->\t%d\n", boolVariable, TypeCaster.cast(boolVariable));

        boolVariable = false;
        System.out.printf("Boolean to integer:\t%b\t->\t%d\n", boolVariable, cast(boolVariable));

    }
}

