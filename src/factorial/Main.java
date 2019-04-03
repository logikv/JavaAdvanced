package factorial;

public class Main {

    public static void main(String[] args) {

        long factorial = Factorial.getFactorial(25);
        System.out.println(factorial);

    }
}

class Factorial {

    static long getFactorial(int i) {
        long mem = 1;
        if(i == 0) return 1;
        for (int j = 1; j <= i; j++) {
            mem*=j;
        }
        return mem;
    }
}