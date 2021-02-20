package opt;


import java.util.ArrayList;

public class Main {
    public static void main (String[] args) {
//        String input = args[0];
        String input = "3";
        ValidateInput validator = new ValidateInput();
        int n = validator.validateInput(input);
        Matrix matrix = new Matrix(n);

        long t1 = System.currentTimeMillis();
        matrix.randomMatrix();
        matrix.printMatrix();
        ArrayList<String> list = matrix.connected();
        matrix.printConnectedComponents(list);


        long t2 = System.currentTimeMillis();
        System.out.println("Execution time: "+ (t2-t1));
    }
}
