package opt;


import java.util.ArrayList;

public class Main {
    public static void main (String[] args) {
        String input = args[0];
//        String input = "10000";
        ValidateInput validator = new ValidateInput();
        int n = validator.validateInput(input);
        Matrix matrix = new Matrix(n);

        long t1 = System.nanoTime();
        matrix.randomMatrix();
        matrix.printMatrix();
        ArrayList<String> list = matrix.connected();
        matrix.printConnectedComponents(list);
        matrix.partialTree(0);
        matrix.printTreeMatrix();


        long t2 = System.nanoTime();
        System.out.println("Execution time: "+ (t2-t1) +" nanoseconds.");
    }
}
