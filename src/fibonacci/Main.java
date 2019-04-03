package fibonacci;

import org.jetbrains.annotations.NotNull;

public class Main {


}

class Fibonacci {
    private int[][] q = {{1, 0}, {0, 1}};

    /**
     * @param m1
     * @param m2
     * @return int[][]
     */
    private int[][] multiplyMatrices(@NotNull int[][] m1, @NotNull int[][] m2) {

        int a11 = m1[0][0] * m2[0][0] + m1[1][0] * m2[1][0];
        int a12 = m1[0][0] * m2[0][1] + m1[0][1] * m2[1][1];
        int a21 = m1[1][0] * m2[0][0] + m1[1][1] * m2[1][0];
        int a22 = m1[1][0] * m2[0][1] + m1[1][1] * m2[1][1];
        int[][] m = new int[2][2];
        m[0][0] = a11;
        m[0][1] = a12;
        m[1][0] = a21;
        m[1][1] = a22;

        return m;
    }

    private void matrixPower(int p){
//        if(p == 1){
//            return 1;
//        }


    }

}