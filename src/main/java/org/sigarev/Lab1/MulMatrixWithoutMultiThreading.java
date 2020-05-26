package org.sigarev.Lab1;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class MulMatrixWithoutMultiThreading extends MulMatrixAbstract {

    private static final Logger LOG = LogManager.getLogger(MulMatrixWithoutMultiThreading.class);


    public MulMatrixWithoutMultiThreading(int[][] matrix1, int[][] matrix2) {
        super(matrix1, matrix2);
    }

    public int[][] multiplication() {
        if (super.ckeckmul()) {
            return new int[0][];
        }
        int[][] resultMatrix = new int[super.getMatrix1().length][super.getMatrix2()[0].length];
        for ( int i = 0; i < super.getMatrix1().length; i++ ) {
            for ( int j = 0; j < super.getMatrix2()[0].length; j++ ) {
                for ( int k = 0; k < super.getMatrix1()[0].length; k++ ) {
                    resultMatrix[i][j] += super.getMatrix1()[i][k] * super.getMatrix2()[k][j];
                }
            }
        }
        return resultMatrix;
    }

}
