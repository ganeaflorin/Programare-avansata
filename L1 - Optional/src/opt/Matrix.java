package opt;


import java.util.ArrayList;
import java.util.Random;

public class Matrix {
    int[][] matrix;
    int n;

    /**
     * constructor pentru initializarea matricei de n x n
     */
    Matrix(int n) {
        matrix = new int[n][n];
        this.n = n;
    }

    /**
     * afisam matricea in format n x n
     */
    void printMatrix() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }
    }

    /**
     * parcurgem matricea deasupra diagonalei principale
     * pe fiecare pozitie punem 0 sau 1 (generat aleatoriu)
     * pe pozitia simetrica corespunzatoare punem aceeasi valoare
     */
    void randomMatrix() {
        Random rand = new Random();

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                if (j > i) {
                    matrix[i][j] = rand.nextInt(2);
                    matrix[j][i] = matrix[i][j];
                }
            }
    }

    /**
     * marcam nodul initial ca vizitat
     * vizitam vecinii nevizitati ai nodului initial si continuam traversarea
     */
    void DFS(int node, boolean[] visited) {
        visited[node] = true; //mark v as visited
        for (int i = 0; i < n; i++) {
            if (matrix[node][i] == 1 && !visited[i]) {
                DFS(i, visited);
            }
        }
    }

    /**
     * functia returneaza true daca avem drum intre oricare 2 noduri, false in caz contrar
     * parcurgem toate nodurile, iar la fiecare pas reinitializam visited cu false.
     * calculam visited si il parcurgem, daca nu am ajuns la un nod inseamna ca nu e conex si returnam
     * adaugam componentele conexe sub forma de stringuri intr-un array de stringuri
     */
    ArrayList<String> connected() {
        ArrayList<String> connectedComponents = new ArrayList<>();
        StringBuilder tempComponent;
        System.out.println("\nConnected components: ");

        boolean[] visited = new boolean[n];
        for (int node = 0; node < n; node++) {
            tempComponent = new StringBuilder();
            for (int i = 0; i < n; i++)
                visited[i] = false;
            DFS(node, visited);
            for (int i = 0; i < n; i++) {
                if (visited[i])
                    tempComponent.append(i);

            }
            connectedComponents.add(tempComponent.toString());
        }
        return connectedComponents;
    }

    /**
     * parcurgem array-ul de componente conexe si cream o lista temporara pentru a scapa de duplicate
     * afisam componentele conexe
     * daca exista o componenta conexa cu n noduri, atunci graful este conex, altfel nu
     * afisam daca este sau nu conex
     */
    void printConnectedComponents(ArrayList<String> list) {
        boolean isConnected = false;
        ArrayList<String> tempList = new ArrayList<>();
        for (String i : list)
            if (!tempList.contains(i)) {
                tempList.add(i);
                if (i.length() == n)
                    isConnected = true;
            }
        for (String i : tempList)
            System.out.println(i);
        if (isConnected)
            System.out.println("The graph is connected");
        else System.out.println("The graph is not connected");
    }
}