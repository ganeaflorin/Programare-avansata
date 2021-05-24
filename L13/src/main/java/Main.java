import commands.Commands;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        Commands commands = new Commands();
        commands.loadClass("commands.Commands");
    }
}
