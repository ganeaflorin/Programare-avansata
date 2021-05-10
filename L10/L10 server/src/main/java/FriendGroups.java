import java.util.*;

public class FriendGroups {
    private Map<Client, Client> groups = new HashMap<>();
    private List<Client> clientList = new ArrayList<>();

    public void registerUser(Client client) {
        clientList.add(client);
    }

    public boolean isRegistered(String name) {
        for (Client client : clientList)
            if (client.getName().equals(name))
                return true;
        return false;
    }

    public void addFriendship(Client client1, Client client2) {
        String firstName = client1.getName();
        String secondName = client2.getName();

        boolean alreadyFriends = false;
        for (Map.Entry<Client, Client> entry : groups.entrySet()) {
            String keyClientName = entry.getKey().getName();
            String valueClientName = entry.getValue().getName();
            if (keyClientName.equals(firstName) && valueClientName.equals(secondName) || keyClientName.equals(secondName) && valueClientName.equals(firstName)) {
                alreadyFriends = true;
                break;
            }
        }
        if (!alreadyFriends)
        groups.put(client1, client2);
    }

    public Client getClientByName(String name) {
        for (Client client : clientList)
            if (client.getName().equals(name))
                return client;
        return null;
    }

    @Override
    public String toString() {
        return "FriendGroups{" +
                "groups=" + groups +
                '}';
    }

    public String getAllMessages(Client currentClient) {
        String response = "";
        for (Map.Entry<Client, Client> entry : groups.entrySet()) {
            if (entry.getValue().equals(currentClient) && entry.getKey().getMessage() != null)
                response = entry.getKey().getName() + " said: " + entry.getKey().getMessage() + "\n";
            else if (entry.getKey().equals(currentClient) && entry.getValue().getMessage() != null)
                response = entry.getValue().getName() + " said: " + entry.getValue().getMessage() + "\n";
        }
        return response;
    }
}
