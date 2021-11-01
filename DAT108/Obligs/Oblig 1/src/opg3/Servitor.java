package opg3;

import java.util.Random;

public class Servitor extends Thread {

    private HamburgerBrett brett;
    private String navn;

    public Servitor(HamburgerBrett brett, String navn) {
        this.brett = brett;
        this.navn = navn;
    }

    @Override
    public void run() {

        while (true) {
            try {
                int random = new Random().nextInt(6000 - 2000 + 1) + 2000;
                Thread.sleep(random);

                if (brett.erTom()) {
                    System.out.println(navn + " (Servitør) ønsker å ta av hamburger, men brettet er tomt. Venter!");
                }
                if (!brett.erTom()) {
                    System.out.println(navn + " (Servitør) tar av hamburger " + brett.removeBurger() + ".     " + brett.toString());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
