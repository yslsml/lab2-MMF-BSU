package by.bsu.matrix.operation;

import by.bsu.matrix.entity.Matrix;
import by.bsu.matrix.exception.MatrixException;

/**
 * Class {@code FindElements} is the class that finds max increasing or decreasing sequence of elements of matrix(array).
 *  Created by HP on 14.02.2022.
 *  @author  Antonova Milana
 *  @version 1.0
 */
public class FindElements {

    /**
     * Finds maximum (the longest) sequence of increasing elements of matrix.
     * @param matrix - matrix to work with
     * @return sequence of elements
     * @exception MatrixException if the method {@code transformToVector} gives error
     * */
    public static double[] findMaxIncSequence(Matrix matrix) throws MatrixException {
        int count = 0;
        int max = 0;
        int index = 0;

        double[] vector = transformToVector(matrix);

        for (int k = 0; k < vector.length - 1; k++) {
            if (vector[k] < vector[k + 1]) {
                count++;
                if (count > max) {
                    max = count;
                    index = k + 1;   // save an index of the element
                }
            } else {
                count = 0;           // break the sequence
            }
        }

        double[] sequence = new double[max + 1];

        //copy the sequence of the max elements to new array
        System.arraycopy(vector, (index - max), sequence, 0, (max + 1));

        return sequence;
    }

    /**
     * Finds maximum (the longest) sequence of decreasing elements of matrix.
     * @param matrix - matrix to work with
     * @return sequence of elements
     * @exception MatrixException if the method {@code transformToVector} gives error
     * */
    public static double[] findMaxDecSequence(Matrix matrix) throws MatrixException {
        int count = 0;
        int min = 0;
        int index = 0;

        double[] vector = transformToVector(matrix);

        for (int k = 0; k < vector.length - 1; k++) {
            if (vector[k] > vector[k + 1]) {
                count++;
                if (count > min) {
                    min = count;
                    index = k + 1;   // save an index of the element
                }
            } else {
                count = 0;           // break the sequence
            }
        }

        double[] sequence = new double[min + 1];
        System.arraycopy(vector, (index - min), sequence, 0, (min + 1));//copy the sequence of the max elements to new array

        return sequence;
    }

    /**
     * Transforms matrix into vector (array).
     * @param matrix - matrix to work with
     * @return vector
     * @exception MatrixException if there is error while working with matrix
     * */
    private static double[] transformToVector(Matrix matrix) throws MatrixException {
        double[] vector = new double[matrix.getVerticalSize() * matrix.getHorizontalSize()];
        for (int i = 0; i < matrix.getVerticalSize(); i++)
            for (int j = 0; j < matrix.getHorizontalSize(); j++)
                vector[i * matrix.getHorizontalSize() + j] = matrix.getElement(i,j);
        return vector;
    }

    /**
     * Makes string out of sequence in needed format.
     * @param sequence - sequence to work with
     * @return string
     * */
    public static String toString(double[] sequence) {
        StringBuilder s = new StringBuilder();
        for (double value : sequence) {
            //s.append(value + " ");
            s.append(String.format("%6.2f",value));
            //s.append(";");
        }
        return s.toString();
    }

}
