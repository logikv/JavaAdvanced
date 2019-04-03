package perfectNumbers;

public class PerfectNumbers {

    public static void main(String[] args) {
        //http://www.cyberforum.ru/post1296781.html
/*        int[] nat = {2, 3, 5, 7, 13, 17, 19, 31};
        long absent;
        long max = (long) (Math.pow(10, 31));

        for (int i1 : nat) {
            absent = (long) (Math.pow(2, i1 - 1) * (Math.pow(2, i1) - 1));
            if (absent <= max) {
                System.out.println(absent);
            } else {
                break;
            }
        }*/



        /*
        for (int i = 2; i < max; i++) {
            int s = 0;
            for (int j = 1; j <= i/2; j++)
                if(i%j == 0){ s+=j; }
            }

            if(s == i){
                System.out.println(i);
            }
        }
        */
        long max = (long) (Math.pow(10, 31));
        int sum;
        byte k;

        for (int i = 2; i <= max; i++) {
            sum = 0;
            for (int j = 1; j <= i * i; j++) {
                if (i % j == 0) {
                    sum += 1;
                    System.out.println(i);
                }
            }
            if (1 == sum) {

                for (k = 2; k <= 128; k++)
                    if (i == (Math.pow(2, k) - 1)) {
                        System.out.println("Простое: " + i + " Совершенное:%" + i * (Math.pow(2, k - 1)));
                    }
            }

        }
/*long i, j, sum;
   short int k;
   //Цикл нахождения ПРОСТОГО числа
   for (i = 2; i <= x; i++)
   {
      sum = 0;
      for (j = 1; j <= sqrt(i); j++)
         if ((i%j == 0) && (i%i == 0))
            sum += 1;
    //Если ПРОСТОЕ число найдено...
      if (sum == 1)
      {
      ...сравним его с числами 2^k - 1. Если числа равны, умножим число на i.
      Результатом будет совершенное число
        for (k = 2; k <= 128; k++)
            if (i == (pow(2, k) - 1))
                printf("Простое: %ld\tСовершенное:%.0f\n", i, i*(pow(2, k-1)));
    }
}*/
    }
}

