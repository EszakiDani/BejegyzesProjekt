
package hu.petrik.helloworld;
import hu.petrik.helloworld.Bejegyzesek.Bejegyzesek;

import java.time.LocalDateTime;
public class Main {
    public static void main(String[] args) {
        Bejegyzesek bejegyzesLista = new Bejegyzesek();
        // 2db alap bejegyés
        Bejegyzes b1 = new Bejegyzes("Kovács István","A kiskutyusok olyan jók.");
        Bejegyzes b2 = new Bejegyzes("Svájci Arnold","Jó edzeni.");
        bejegyzesLista.addBejegyzes(b1);
        bejegyzesLista.addBejegyzes(b2);
        bejegyzesLista.kiir();

    }
}
