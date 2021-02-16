public class Language {
    final private String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};

    //printeaza un mesaj + limbajul de pe o pozitie n
    public void printLanguage(int n) {
        System.out.println("Willy-nilly, this semester i Will learn " + languages[n]);
    }
}