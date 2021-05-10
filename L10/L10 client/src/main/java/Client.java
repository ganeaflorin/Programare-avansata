import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    private String serverAddress = "127.0.0.1";
    private int PORT = 8100;
    private Scanner scanner = new Scanner(System.in);

    public Client() {
        try (
                Socket socket = new Socket(serverAddress, PORT);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            while (true) {
                System.out.print("> ");
                String command = scanner.nextLine();
                out.println(command);
                String response = in.readLine();
                System.out.println("Message: " + response);
                if (command.equals("exit"))
                    break;
            }
        } catch (
                UnknownHostException e) {
            System.err.println("No server listening... " + e);
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}

