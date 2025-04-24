package cz.czechitas.turtle;

import dev.czechitas.java1.turtle.engine.Turtle;

public class HlavniProgram {
    private final Turtle zofka = new Turtle();

    public static void main(String[] args) {
        new HlavniProgram().start();
    }

    public void start() {
        //TODO Tady bude kód pro kreslení želví grafiky.

        nakresliCtverec(100);
        nakresliTrojuhelnik(100);
        nakresliKruh(10, 20);
        nakresliObdelnik(200, 100);
    }

    public void nakresliCtverec(double delkaStrany) {
        for (int i = 0; i < 4; i++) {
            zofka.move(delkaStrany);
            zofka.turnRight(90);
        }
    }

    public void nakresliTrojuhelnik(double delkaStrany) {
        for (int i = 0; i < 3; i++) {
            zofka.move(delkaStrany);
            zofka.turnLeft(120);
        }
    }

    public void nakresliObdelnik(double delsiStrana, double kratsiStrana) {
        for (int i = 0; i < 2; i++) {
            zofka.move(delsiStrana);
            zofka.turnRight(90);
            zofka.move(kratsiStrana);
            zofka.turnRight(90);
        }
    }


    public void nakresliKruh(double pocetStran, double delkaStrany) {
        double uhel = 360 / pocetStran;

        for (int i = 0; i < pocetStran; i++) {
            zofka.move(delkaStrany);
            zofka.turnRight(uhel);
        }
    }
}



