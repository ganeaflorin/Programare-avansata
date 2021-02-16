public class Main {


    public static void main(String[] args) {
        HelloWorld hello = new HelloWorld();
        hello.printHelloWorld();
        Language lang = new Language();
        Compute number = new Compute();
        int n = number.computeNumber();

        lang.printLanguage(n);
    }
}