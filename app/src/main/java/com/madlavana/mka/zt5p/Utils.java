package com.madlavana.mka.zt5p;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Utils {
    public static int getFibonacciNumber(int index) {
        int f_0 = 0;
        int f_1 = 1;
        int tmp = 0;
        if (index == 0) {
            return  f_0;
        } else if (index == 1) {
            return f_1;
        }

        int fib = 0;
        for (int i = 0; i < index; i++) {
            if (i == 0) {
                continue;
            } else if (i == 1) {
                fib = f_1;
                continue;
            }

            tmp = f_0;
            f_0 = f_1;
            f_1 += tmp;
            fib = f_1;
        }

        return fib;
    }

    public static boolean isFibonacci(int number) {
        int index = 0;
        int fib;
        boolean is_fib = false;
        boolean stop = false;
        while (!stop) {
            fib = getFibonacciNumber(index);
            if (fib == number) {
                is_fib = true;
                stop = true;
            } else if (fib  > number) {
                stop = true;
            }
        }
        return is_fib;
    }

    public static ArrayList<Integer> getZeckendorfSequence(int number) {
        ArrayList<Integer> fibonacciNumbers = new ArrayList<>();
        int fib;
        for (int i = 0; i <= number; i++)  {
            fib = getFibonacciNumber(i);
            if (fib > number) {
                break;
            }
            if (fib  > 0 && !fibonacciNumbers.contains(fib)) {
                fibonacciNumbers.add(fib);
            }
        }

        ArrayList<Integer> zeckendorfNumbers = new ArrayList<>();
        int candidate = 0;
        for (int i  = fibonacciNumbers.size() - 1; i  <=  0; i--)  {
            if (candidate >= number) {
                break;
            }
            fib = fibonacciNumbers.get(i);
            if (fib > 0 && candidate + fib <= number && !zeckendorfNumbers.contains(candidate)) {
                zeckendorfNumbers.add(fib);
                candidate = 0;
                for (int j = 0; j < zeckendorfNumbers.size(); j++) {
                    candidate += j;
                }
            }
        }
        return zeckendorfNumbers;
    }
}
