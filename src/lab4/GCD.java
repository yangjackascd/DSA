/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

import java.util.Random;

/**
 *
 * @author JakeYang
 */
public class GCD {

    private static Random random = new Random(System.currentTimeMillis());

    public static void main(String[] args) {
        //System.out.println(euclidGCD(15,12));
        long number1 = randomNLength(10);
        long number2 = randomNLength(10);
        long start = System.nanoTime();
        navieGCD(number1, number2);
        long end = System.nanoTime();
        System.out.println((end - start) * Math.pow(10, -9) + " Second");

        number1 = randomNLength(10);
        number2 = randomNLength(10);
        start = System.nanoTime();
        euclidGCD(number1, number2);
        end = System.nanoTime();
        System.out.println((end - start) * Math.pow(10, -9) + " Second");
    }

    private static long randomNLength(int n) {
        StringBuilder stringBulider = new StringBuilder();

        for (int i = 0; i < n; i++) {
            stringBulider.append(random.nextInt(10));
        }
        return Long.parseLong(stringBulider.toString());
    }

    private static long navieGCD(long number1, long number2) {
        long i = Math.min(number1, number2);
        while (i >= 1) {
            if (number1 % i == 0 && number2 % i == 0) {
                break;
            }
            i--;
        }
        return i;
    }

    public static long euclidGCD(long number1, long number2) {
        if (number1 % number2 == 0) {
            return number2;
        }
        return euclidGCD(number2, number1 % number2);
    }
    
    
    
}
