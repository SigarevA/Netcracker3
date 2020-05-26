package org.sigarev.Lab1;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MulMatrixWithMultiThreading extends MulMatrixAbstract {

    private static final Logger LOG = LogManager.getLogger(MulMatrixWithoutMultiThreading.class);
    private Thread[] threads;


    public MulMatrixWithMultiThreading(int[][] matrix1, int[][] matrix2, int count) {
        super(matrix1, matrix2);
        threads = new Thread[count];
    }


    @Override
    public int[][] multiplication() throws InterruptedException {
        if (super.ckeckmul() )
            return new int[0][];

        int[][] resmatrix = new int[super.getMatrix1().length][super.getMatrix2()[0].length];
        int iter = threads.length;
        for ( int i = 0; i < threads.length; i++ ) {
            this.threads[i] = new MulThreading("Thread " + i, super.getMatrix1(), super.getMatrix2(), i, iter, resmatrix);
            this.threads[i].start();
        }
        for ( Thread thread : this.threads) {
            thread.join();
        }

        return resmatrix;
    }
}
