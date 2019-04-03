package sieve;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        for (int i = 1000000; i <= 1000000; i *= 10) {
            double start = (double) System.nanoTime();
            Sieve sieve = new Sieve(i);
            System.out.println(sieve.getNumbers().size());
            System.out.println(sieve.getNumbers());
            double end = (double) System.nanoTime();
            System.out.println((end - start) / 1000000 + "ms for " + i + " with " + sieve.getNumbers().size() + " natural nums");
        }
    }
}

class Sieve {

    private ArrayList<Integer> numbers;
    private Integer num;

    public Sieve(Integer n) {
        this.num = n;
        this.numbers = new ArrayList<>(this.num + 1);
        this.getNaturalNumbers();
    }

    public ArrayList<Integer> getNumbers() {
        return numbers;
    }

    private void getNaturalNumbers() {
        boolean[] map = new boolean[this.num + 1];
        for (int i = 2; i * i <= this.num; i++) {
            if (!map[i]) {
                for (int j = i; i * j <= this.num; j++) {
                    map[i * j] = true;
                }
            }
        }
        for (int i = 2; i <= this.num; i++) {
            if (!map[i]) {
                this.numbers.add(i);
            }
        }
    }
}

/*
    1. Получаем число X
    2. Создаем массив от 2 до числа X
    3. Удаляем из массива число делящееся на число без остатка


 */