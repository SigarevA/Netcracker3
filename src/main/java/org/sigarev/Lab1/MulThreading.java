package org.sigarev.Lab1;



public class MulThreading extends Thread {

    private int[][] m1;
    private int[][] m2;
    private int[][] resmatrix;
    private int start;
    private int iter;


    public MulThreading(String name, int[][] m1, int[][] m2, int start, int iter, int[][] resmatrix) {
        super(name);
        this.m1 = m1;
        this.m2 = m2;
        this.resmatrix = resmatrix;
        this.start = start;
        this.iter = iter;
    }

    @Override
    public void run() {
        for (int i = start; i < m1.length; i+=iter ) {
            for ( int j = 0; j < m2[0].length; j++){
                for ( int k = 0; k < m2.length; k++) {
                    this.resmatrix[i][j] += this.m1[i][k] * this.m2[k][j];
                }
            }
        }
    }
}
