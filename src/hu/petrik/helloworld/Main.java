
package hu.petrik.helloworld;
import hu.petrik.helloworld.Bejegyzesek.Bejegyzesek;
import java.util.List;

import java.time.LocalDateTime;
public class Main {
    public static void main(String[] args) {
        Bejegyzesek bejegyzesLista = new Bejegyzesek();
        Bejegyzes b1 = new Bejegyzes("Próba István","A régi szép idől!.");
        bejegyzesLista.addBejegyzes(b1);
        bejegyzesLista.kiir();
        bejegyzesLista.AdatBekeres();
        bejegyzesLista.kiir();
    }
}
