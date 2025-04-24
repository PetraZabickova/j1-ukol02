package cz.czechitas.turtle;

import dev.czechitas.java1.turtle.engine.Turtle;

public class HlavniProgram {
    private final Turtle zofka = new Turtle();

    public static void main(String[] args) {
        new HlavniProgram().start();
    }

    public void start() {
        //TODO Tady bude kód pro kreslení želví grafiky.
        nakresliSnehulaka();
    }


    public void nakresliSnehulaka() {
        int pocetStran = 30;

        double prumerHlava = 30;
        double prumerTelo = 60;
        double prumerNohy = 80;
        double prumerRuce = 20;

        // 1. Nohy
        nakresliKruhZPrumeru(prumerNohy, pocetStran);

        // 2. Tělo
        posunNahoru((prumerNohy + prumerTelo) / 2);
        nakresliKruhZPrumeru(prumerTelo, pocetStran);

        // 3. Hlava
        posunNahoru((prumerTelo + prumerHlava) / 2);
        nakresliKruhZPrumeru(prumerHlava, pocetStran);

        // 4. Levá ruka
        zofka.turnLeft(180);
        posunDoprava((prumerTelo + prumerRuce) / 2);
        zofka.turnLeft(90);
        posunDolu(prumerTelo / 4);
        nakresliKruhZPrumeru(prumerRuce, pocetStran);

        // 5. Pravá ruka
        zofka.turnRight(90);
        posunNahoru(prumerTelo / 4);
        zofka.turnLeft(98);
        posunDoprava(prumerTelo + prumerRuce);
        nakresliKruhZPrumeru(prumerRuce, pocetStran);
    }

    public void nakresliKruhZPrumeru(double prumer, double pocetStran) {
        double obvod = Math.PI * prumer;
        double delkaStrany = obvod / pocetStran;
        double uhel = 360 / pocetStran;

        for (int i = 0; i < pocetStran; i++) {
            zofka.move(delkaStrany);
            zofka.turnRight(uhel);
        }
    }

    public void posunNahoru(double vzdalenost) {
        zofka.penUp();
        zofka.move(vzdalenost);
        zofka.penDown();
    }

    public void posunDolu(double vzdalenost) {
        posunNahoru(-vzdalenost);
    }

    public void posunDoprava(double vzdalenost) {
        zofka.penUp();
        zofka.move(vzdalenost);
        zofka.penDown();
    }

}






