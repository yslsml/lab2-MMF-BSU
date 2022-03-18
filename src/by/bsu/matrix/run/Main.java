package by.bsu.matrix.run;

import by.bsu.matrix.create.MatrixCreator;
import by.bsu.matrix.entity.Matrix;
import by.bsu.matrix.entity.User;
import by.bsu.matrix.exception.InRangeException;
import by.bsu.matrix.exception.MatrixException;
import by.bsu.matrix.exception.BadDateException;
import by.bsu.matrix.operation.FindElements;
import by.bsu.matrix.valid.PositiveIntValid;

import java.text.SimpleDateFormat;
import java.util.Scanner;

/*
Ввести с консоли n-размерность матрицы a [n] [n]. Задать значения элементов
матрицы в интервале значений от -n до n с помощью датчика случайных чисел.
3.Найти и вывести наибольшее число возрастающих (убывающих) элементов матрицы, идущих подряд.
*/

public class Main {

    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        try {

            System.out.println("Enter size of matrix: ");
            int size = scan.nextInt();

            Matrix m1 = new Matrix(size, size);
            MatrixCreator.fillRandomized(m1, -size, size);
            System.out.println("Matrix first is: " + m1);

            double[] incSequence = FindElements.findMaxIncSequence(m1);
            double[] decSequence = FindElements.findMaxDecSequence(m1);
            System.out.println("\nMax sequence of increasing elements: " + FindElements.toString(incSequence));
            System.out.println("Max sequence of decreasing elements: " + FindElements.toString(decSequence));


            User user = new User("Antonova", 2022, 2, 18, 12, 00);
            System.out.println("\nAuthor: " + user.getName());
            System.out.print("The time of getting task: ");
            long getTaskTime = user.timeGettingTask();
            String taskStringDate = new SimpleDateFormat("d MMMMM yyyy HH:mm").format(getTaskTime);
            System.out.println(taskStringDate);

            System.out.print("The time of end of task: ");
            long currTime = user.timeFinishTask();
            String currStingTime = new SimpleDateFormat("d MMMMM yyyy HH:mm").format(currTime);
            System.out.println(currStingTime);

        } catch (MatrixException ex) {
            System.err.println("Error of creating matrix or number of line or column" + ex);
        } catch (BadDateException e) {
            System.out.println(e.getMessage());
        }

    }
}
