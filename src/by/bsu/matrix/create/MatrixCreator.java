package by.bsu.matrix.create;

import by.bsu.matrix.entity.Matrix;
import by.bsu.matrix.exception.MatrixException;
import by.bsu.matrix.valid.PositiveIntValid;

import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class {@code MatrixCreator} is designed for initializing matrix.
 * Created by HP on 14.02.2022.
 * @author  Antonova Milana
 * @version 1.0
 */
public class MatrixCreator {

    /**
     * Initializing elements of matrix with random values from chosen range.
     * @param m matrix to work with
     * @param start left border of the range
     * @param end right border of the range
     * */
    public static void fillRandomized(Matrix m, int start, int end) {
        int v = m.getVerticalSize();
        int h = m.getHorizontalSize();
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < h; j++) {
                try {
                    double value = Math.random() * (end - start) + start;
                    m.setElement(i, j, value);
                } catch (MatrixException e) {
                    /* в данном случае exception невозможен, поэтому обработка отсутствует,
                     но try пишем, поскольку метод setElement имеет throws MatrixException */
                }
            }
        }
    }

    /**
     * Initializing elements of matrix from input stream.
     * @param m matrix to work with
     * @param input InputStream
     * */
    public static void fillFromStream(Matrix m, InputStream input) {
        int v = m.getVerticalSize();
        int h = m.getHorizontalSize();
        for(int i = 0; i < v; i++) {
            for(int j = 0; j < h; j++) {
                try {
                    double value = oneDoubleRead(input);
                    m.setElement(i, j, value);
                } catch (MatrixException e) {
                    /* в данном случае exception невозможен, поэтому обработка отсутствует,
                     но try пишем, поскольку метод setElement имеет throws MatrixException */
                }
            }
        }
    }

    /**
     * Method that reads from input stream one double number.
     * @param input InputStream
     * @return double number
     * */
    private static double oneDoubleRead(InputStream input) {
        double number = 0;
        Scanner scan = new Scanner(input);
        boolean continueInput = true;
        do {
            try {
                System.out.print("Enter an double: ");
                number = scan.nextDouble();
                System.out.println(
                        "The number entered is " + number);
                continueInput = false;
            } catch (InputMismatchException ex) {
                System.out.println("Try again. (Incorrect input: an double is required)");
                scan.nextLine();
            }
        }
        while (continueInput);
        return number;
    }

    // public void fillFromFile(Matrix t, File f) { /* код*/ }
    // public void fillFromDataBase(Matrix t, Connection conn) { /* код*/ }
}
