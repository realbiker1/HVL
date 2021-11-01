package opg3;

import java.util.Random;

public class Kokk extends Thread {

    private HamburgerBrett brett;
    private String navn;

    public Kokk(HamburgerBrett brett, String navn) {
        this.brett = brett;
        this.navn = navn;
    }

    @Override
    public void run() {

        while (true) {
            try {
                int random = new Random().nextInt(6000 - 2000 + 1) + 2000;
                Thread.sleep(random);

                if (brett.getAntBurgere() >= brett.getKapasitet()) {
                    System.out.println(navn + " (Kokk) prøver å legge en burger på brettet, men brettet er fullt!");
                }
                if (brett.getAntBurgere() < brett.getKapasitet()) {
                    System.out.println(navn + " (Kokk) legger på hamburger " + brett.addBurger() + ".     " + brett.toString());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
