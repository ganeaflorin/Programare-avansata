import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread implements Runnable {
    private final Socket socket;
    private boolean running = true;
    private FriendGroups groups;
    private Client currentClient;
    private boolean isLogged = false;
    private Server server;

    public ClientThread(Socket socket, FriendGroups groups, Server server) {
        this.socket = socket;
        this.groups = groups;
        this.server = server;
    }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            while (running) {
                String command = in.readLine();
                System.out.println(command);
                String response = handleCommand(command);
                out.println(response);
            }
            in.close();
            out.close();
        } catch (IOException e) {
            System.err.println("Communication error... " + e);
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String handleCommand(String command) {
        String response = "Server stopped.";
        String[] splitCommand = command.split(" ", 2);
        String chosenCommand = splitCommand[0].toLowerCase();
        final String EXIT_COMMAND = "exit";
        final String LOGIN = "login";
        final String REGISTER = "register";
        final String FRIEND_REQUEST = "friend";
        final String SEND_MESSAGE = "send";
        final String READ_MESSAGE = "read";
        final String STOP_SERVER = "stop";
        if (command.equals(EXIT_COMMAND)) {
            running = false;
            return response;
        } else if (chosenCommand.equals(REGISTER)) {
            currentClient = new Client(splitCommand[1]);
            groups.registerUser(currentClient);
            isLogged = true;
            response = "You are now registered.";
        } else if (chosenCommand.equals(LOGIN)) {
            isLogged = groups.isRegistered(splitCommand[1]);
            response = (isLogged) ? "You logged in." : "Login failed. Username was not found.";
        } else if (chosenCommand.equals(FRIEND_REQUEST)) {
            String[] splitFriends = splitCommand[1].replaceAll(" ", "").split(",");
            response = "You have new friends!";
            if (!isLogged)
                response = "You have to be logged it";
            else
                for (String friend : splitFriends) {
                    groups.addFriendship(currentClient, groups.getClientByName(friend));
                }
        } else if (chosenCommand.equals(SEND_MESSAGE)) {
            if (!isLogged)
                response = "You have to be logged in to use the \"send\" command.";
            else {
                currentClient.setMessage(splitCommand[1]);
                response = "Message sent.";
                System.out.println(response);
            }
        } else if (chosenCommand.equals(READ_MESSAGE)) {
            response = groups.getAllMessages(currentClient);
            if (response.equals(""))
                response = "You have no messages";
        } else if (chosenCommand.equals(STOP_SERVER))
            server.stopServer();
        else response = "Unknown command. Try again.";

        return response;
    }

}


