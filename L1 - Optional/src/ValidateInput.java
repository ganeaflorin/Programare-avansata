import java.util.Scanner;

public class ValidateInput {
    static void validateInput() {

        Scanner scanner = new Scanner(System.in);
        jmp:
        while (true) {
            System.out.println("Input: ");
            String input = scanner.nextLine();
            for (int i = 0; i < input.length(); i++)
                if ((input.charAt(i) > '9' || input.charAt(i) < '0') && input.charAt(i) != '-') {
                    System.out.println("Input is not an integer.");
                    continue jmp;
                }
            int number = Integer.parseInt(input);
            if (number % 2 == 0) {
                System.out.println("Input is not an odd integer.");
                
            } else break;
        }
    }
}
