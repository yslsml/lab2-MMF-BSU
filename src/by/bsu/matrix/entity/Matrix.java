package by.bsu.matrix.entity;

import by.bsu.matrix.exception.InRangeException;
import by.bsu.matrix.exception.MatrixException;
import by.bsu.matrix.valid.PositiveIntValid;

import java.util.Arrays;

/**
 * Class {@code Matrix} is designed to storage data about matrix.
 * Created by HP on 14.02.2022.
 * @author  Antonova Milana
 * @version 1.0
 */
public class Matrix {

    /** Field matrix*/
    private double[ ][ ] matr;

    /**
     * Constructor of class
     * @param matr matrix
     * @see Matrix#Matrix(int, int)
     * */
    public Matrix(double[][] matr) {
        this.matr = Arrays.copyOf(matr,matr.length);
    }

    /**
     * Constructor of class
     * @param n vertical size
     * @param m horizontal size
     * @see Matrix#Matrix(double[][])
     * @throws MatrixException if n or m (size of matrix) is negative.  //trows or exception??
     * */
    public Matrix(int n, int m) throws MatrixException {
        // проверка на отрицательные значения размерности матрицы
        if (PositiveIntValid.isValidSize(n) && PositiveIntValid.isValidSize(m))  {
            matr = new double[n][m];
        }
        else {
            throw new MatrixException();
        }
    }

    /**
     * Gets Matrix that is
     * Returns value of field {@link Matrix#matr}
     * @return field value {@link Matrix#matr}
     */
    public double[][] getMatrix() {
        return matr;
    }

    /**
     * Returns vertical size of matrix
     * @return vertical size
     */
    public int getVerticalSize() {
        return matr.length;
    }

    /**
     * Returns horizontal size of matrix
     * @return horizontal size
     */
    public int getHorizontalSize() {
        return matr[0].length;
    }

    /**
     * Returns horizontal line of matrix
     * @param i number of line
     * @return horizontal line
     * @exception InRangeException if number of line is bad
     */
    public double[] getHorizontalLine(int i)throws InRangeException {
        if((i<0)||(i>=matr[0].length)){
            throw new InRangeException();
        }
        return matr[i];
    }

    /**
     * Returns element of matrix
     * @param i number of line
     * @param j number of element in chosen line
     * @return element of matrix
     * @exception MatrixException if coordinates of element are bad
     */
    public double getElement(int i, int j) throws MatrixException {
        if (checkRange(i, j)) { // проверка i и j
            return matr[i][j];
        }
        throw new MatrixException();
    }

    /**
     * Defines element of matrix
     * @param i number of line
     * @param j number of element in chosen line
     * @param value value of element
     * @exception MatrixException if coordinates of element are bad
     */
    public void setElement(int i, int j, double value) throws MatrixException {
        if (checkRange(i, j)) { // проверка i и j
            matr[i][j] = value;
        }
        else {
            throw new MatrixException();
        }
    }

    /**
     * Prints matrix in needed format.
     * @return string
     * */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("\nMatrix : " + matr.length + "x" + matr[0].length + "\n");
        for (double [ ] row : matr) {
            for (double value : row) {
                //s.append(value + " ");
                s.append(String.format("%6.2f",value));
            }
            s.append("\n");
        }
        return s.toString();
    }

    /**
     * Method for checking whether coordinates are valid.
     * @param i number of line
     * @param j number of element in chosen line
     * @return {@code true} if coordinates are valid
     *        and {@code false} otherwise
     */
    // проверка возможности выхода за пределы матрицы
    private boolean checkRange(int i, int j) {
        if ( i >= 0 && i < matr.length && j >= 0 && j < matr[0].length ) {
            return true;
        } else {
            return false;
        }
    }
}

