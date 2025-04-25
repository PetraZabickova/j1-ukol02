package cz.czechitas.turtle;

import dev.czechitas.java1.turtle.engine.Turtle;

public class HlavniProgram {
    private final Turtle zofka = new Turtle();

    public static void main(String[] args) {
        new HlavniProgram().start();
    }

    public void start() {

        zofka.turnRight(90);
        posunDoprava(300);
        zofka.turnLeft(90);
        nakresliSnehulaka();

        posunDoleva(400);
        nakresliMasinku();

        zofka.turnRight(120);
        posunDoleva(200);

        zofka.turnLeft(60);
        nakresliZmrzlinu();
    }


    public void nakresliMasinku() {
        // Rozměry
        double sirkaSpodnihoDilu = 230;
        double vyskaSpodnihoDilu = 70;

        double sirkaHornihoDilu = 70;
        double vyskaHornihoDilu = 150;

        double prumerKoleckoMale = 40;
        double prumerKoleckoVelke = 70;

        // 1. Spodní obdélník (spodek mašinky)
        nakresliObdelnik(sirkaSpodnihoDilu, vyskaSpodnihoDilu);

        // 2. Horní obdélník (kabina)
        nakresliObdelnik(sirkaHornihoDilu, vyskaHornihoDilu);

        // 3. Kolečka
        zofka.turnRight(90);
        posunDoleva(70);
        nakresliKruhZPrumeru(prumerKoleckoVelke, 30);

        // První malé kolečko
        posunDoleva(80);
        nakresliKruhZPrumeru(prumerKoleckoMale, 30);

        // Druhé malé kolečko
        posunDoleva(prumerKoleckoMale + 40);
        nakresliKruhZPrumeru(prumerKoleckoMale, 30);

        // 4. Nárazník – trojúhelník
        zofka.turnLeft(60);
        nakresliRovnostrannyTrojuhelnik(70);
    }


    public void nakresliZmrzlinu() {
        int pocetStran = 30;
        double prumerKopecek = 90;
        double delkaKornoutu = 90;

        zofka.turnRight(90);
        nakresliRovnostrannyTrojuhelnik(delkaKornoutu);
        zofka.turnLeft(90);
        nakresliKruhZPrumeru(prumerKopecek, pocetStran);
    }

    public void nakresliRovnostrannyTrojuhelnik(double delkaStrany) {
        for (int i = 0; i < 3; i++) {
            zofka.move(delkaStrany);
            zofka.turnRight(120);
        }
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
        zofka.turnLeft(172);
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

    public void nakresliObdelnik(double sirka, double vyska) {
        for (int i = 0; i < 2; i++) {
            zofka.move(sirka);
            zofka.turnRight(90);
            zofka.move(vyska);
            zofka.turnRight(90);
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

    public void posunDoleva(double vzdalenost) {
        zofka.penUp();
        zofka.turnLeft(90);
        zofka.move(vzdalenost);
        zofka.penDown();
        zofka.turnRight(90);
    }
}






