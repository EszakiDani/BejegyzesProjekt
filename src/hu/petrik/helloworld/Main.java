
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
        bejegyzesLista.TartalomModsitas();
        System.out.println("\nA végleges lista:\n");
        bejegyzesLista.kiir();
        System.out.printf("\nA legnépszerűbb: %d",bejegyzesLista.likeMax());
        System.out.printf("\n%s nagyobb mint 64 like.\n",(bejegyzesLista.nagyobb() ? "Van" : "Nincs"));
        System.out.printf("\nEnnyi kisebb van mint 15 like: %d \n",bejegyzesLista.kisebb());
        System.out.println("\nRendezett lista:\n");
        bejegyzesLista.Rendezes();
    }
}
