package org.sigarev.Lab1;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public abstract class MulMatrixAbstract {

    private int[][] matrix1;
    private int[][] matrix2;

    MulMatrixAbstract(int[][] matrix1, int[][] matrix2) {
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
    }

    public int[][] getMatrix1() {
        return matrix1;
    }

    public void setMatrix1(int[][] matrix1) {
        this.matrix1 = matrix1;
    }

    public int[][] getMatrix2() {
        return matrix2;
    }

    public void setMatrix2(int[][] matrix2) {
        this.matrix2 = matrix2;
    }

    public boolean ckeckmul() {
        if (this.matrix1.length == 0 || this.matrix2.length == 0 ) {
            return true;
        }
        if (this.matrix1[0].length != this.matrix2.length) {
            new IOException("Неверный ввод");
        }
        return false;
    }

    public abstract int[][] multiplication() throws InterruptedException;
}
