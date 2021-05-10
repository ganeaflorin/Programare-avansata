import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static final int PORT = 8100;
    private boolean running = true;
    private static volatile FriendGroups groups = new FriendGroups();

    public Server() throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            getCommands(serverSocket);
        } catch (IOException e) {
            System.err.println("ERROR: " + e);
        } finally {
            serverSocket.close();
        }
    }

    public void stopServer() {
        running = false;
    }

    public void getCommands(ServerSocket serverSocket) throws IOException {
        while (running) {
            System.out.println("Waiting for a client ...");
            Socket socket = serverSocket.accept();
            Runnable client = new ClientThread(socket, groups, this);
            Thread clientThread = new Thread(client);
            clientThread.start();
        }
    }


}

