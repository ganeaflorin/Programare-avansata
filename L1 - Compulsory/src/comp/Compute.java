package comp;

public class Compute {
    //generam un numar aleatoriu
    //il inmultim cu 3, convertim 10101 din binar si FF din hex si le adaugam numarului
    //il inmultim cu 6
    //facem suma cifrelor numarului, daca aceasta este >10 repetam
    public int computeNumber() {
        int n = (int) (Math.random() * 1_000_000);
        n *= 3;

        n += Integer.parseInt("10101", 2);
        n += Integer.parseInt("FF", 16);
        n *= 6;
        System.out.println(n);

        int result = 0;
        while (n >= 10) {
            while (n != 0) {
                result += n % 10;
                n /= 10;
            }
            n = result;
            result = 0;
        }

        return n;
    }
}