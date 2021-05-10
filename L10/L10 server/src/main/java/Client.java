
public class Client {
    private String message;
    private String name;


    public Client(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }


    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                '}';
    }

    public boolean equals(Client client) {
        return this.getName().equals(client.getName());
    }
}
