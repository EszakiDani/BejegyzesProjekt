package hu.petrik.helloworld.Bejegyzesek;
import hu.petrik.helloworld.Bejegyzes;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.Scanner;public class Bejegyzesek {
    private List<Bejegyzes> bejegyzesek;

    public Bejegyzesek() {
        this.bejegyzesek = new ArrayList<>();
    }

    public void addBejegyzes(Bejegyzes b) {
        this.bejegyzesek.add(b);
    }

    public void kiir() {
        for (int i = 0; i < this.bejegyzesek.size(); i++) {
            System.out.println(this.bejegyzesek.get(i) + "\n");
        }
    }

    private static boolean isDigit(String szoveg) {
        if (szoveg == null) {
            return false;
        }
        try {
            int num = Integer.parseInt(szoveg);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public void Adatbekeres() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bejegyzések száma:");
        String megadott_ertek = sc.nextLine();
        if (isDigit(megadott_ertek) && 0 <= Integer.parseInt(megadott_ertek)) {
            int darabSzam = Integer.parseInt(megadott_ertek);
            String szerzo;
            String tartalom;
            for (int i = 0; i < darabSzam; i++) {
                System.out.println("\nSzerző neve:");
                szerzo = sc.nextLine();
                System.out.println("\nTartalma a bejegyzésednek:");
                tartalom = sc.nextLine();
                Bejegyzes b = new Bejegyzes(szerzo, tartalom);
                this.bejegyzesek.add(b);
            }
        } else {
            throw new RuntimeException("A beírt karakter nem természetes szám");
        }
    }

    public void fileBeolvasas(String filenev) throws IOException {
        FileReader fr = new FileReader(filenev);
        BufferedReader br = new BufferedReader(fr);
        String sor = br.readLine();
        while (sor != null && !sor.equals("")){
            String[] adatok = sor.split(";");
            Bejegyzes b = new Bejegyzes(adatok[0],adatok[1]);
            this.bejegyzesek.add(b);
            sor = br.readLine();
        }
        fr.close();
        br.close();
    }

    public void likeOsztas(){
        int NumOfLike = this.bejegyzesek.size()*20;
        Random r = new Random();
        int kezdoertek = 1;
        int vegsoertek = NumOfLike;
        int like = 0;
        int index=0;
        while (NumOfLike > 0){
            if ((vegsoertek-kezdoertek) > 0) {
                like = r.nextInt(vegsoertek - kezdoertek) + kezdoertek;
            } else {
                like = 1;
            }
            NumOfLike = NumOfLike-like;
            vegsoertek = NumOfLike;
            index = r.nextInt((this.bejegyzesek.size()));
            for (int i = 0; i < like; i++) {
                this.bejegyzesek.get(index).like();
            }
        }
    }
    public void TartalomModsitas() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nKérlek add meg a tartalmat:");
        String tartalom = sc.nextLine();
        this.bejegyzesek.get(1).setTartalom(tartalom);
    }

    public int likeMax(){
        int max = 0;
        for (int i = 0; i < this.bejegyzesek.size(); i++) {
            if (this.bejegyzesek.get(i).getLikeok()>this.bejegyzesek.get(max).getLikeok()){
                max = i;
            }
        }
        return this.bejegyzesek.get(max).getLikeok();
    }
    public boolean nagyobb(){
        boolean van = false;
        for (Bejegyzes b :this.bejegyzesek) {
            if (b.getLikeok()>35){
                van = true;
            }
        }
        return van;
    }
    public int kisebb(){
        int count =0;
        for (Bejegyzes b :this.bejegyzesek) {
            if (b.getLikeok()<15){
                count++;
            }
        }
        return count;
    }
    static class Hasonlito implements Comparator<Bejegyzes> {
        @Override
        public int compare(Bejegyzes b1, Bejegyzes b2) {
            return b2.getLikeok() - b1.getLikeok();
        }
    }
    public void Rendezes() {
        List<Bejegyzes> rendezett = this.bejegyzesek.stream().sorted(new Hasonlito()).collect(Collectors.toList());
        for (int i = 0; i < rendezett.size(); i++) {
            System.out.println(rendezett.get(i) + "\n");
        }
    }
}

