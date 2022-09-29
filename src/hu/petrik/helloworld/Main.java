
package hu.petrik.helloworld;
import hu.petrik.helloworld.Bejegyzesek.Bejegyzesek;
import java.util.List;
import java.io.IOException;;
public class Main {
    public static void main(String[] args) {
        Bejegyzesek bejegyzesLista = new Bejegyzesek();
        bejegyzesLista.kiir();
        bejegyzesLista.Adatbekeres();
        try {
            bejegyzesLista.fileBeolvasas("bejegyzesek.csv");
        } catch (IOException e) {
            System.err.println("Hiba történt a fájl beolvasása során.");
        }
        System.out.println("-------------------------");
        bejegyzesLista.likeOsztas();
        bejegyzesLista.kiir();
    }
}
