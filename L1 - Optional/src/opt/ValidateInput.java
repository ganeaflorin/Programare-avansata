package opt;

public class ValidateInput {
    /**
     *  convertim inputul intr-o valoare de tip integer daca este posibil
     */
     int validateInput(String input) {


        int n = Integer.parseInt(input);
        System.out.println("Input valid.");
        return n;


    }
}

