package com.company;

import java.util.Random;

public class Main {
    public static int bossHealth = 700;
    public static int[] heroesHealth = {250, 250, 250, 500};
    public static int bossAttack = 50;
    public static int[] heroesAttack = {20, 20, 20};
    public static int medicSave = 20;
    public static String bossDefenceType = "";
    public static String[] heroesAttackType = {"Physical", "Magical", "Kinetic", "Medic"};

    public static void main(String[] args) {
        int roundNumber = 1;
        prinStatistics(0);
        while (!isFinished()) {
            changeBossDefence();
            round(roundNumber);
            roundNumber++;
        }
    }

    public static void changeBossDefence() {
        Random r = new Random();
        int randomIndex = r.nextInt(3);
        bossDefenceType = heroesAttackType[randomIndex];
        System.out.println("boss defence " + bossDefenceType);
    }

    public static void round(int number) {
        bossHit();
        heroesHit();
        medicTreat();
        prinStatistics(number);
    }

    public static boolean isFinished() {
        if (bossHealth <= 0) {
            System.out.println("Heroes won!");
            return true;
        }
        if (heroesHealth[0] <= 0 && heroesHealth[1] <= 0 && heroesHealth[2] <= 0) {
            System.out.println("Boss won!");

            return true;
        }

        return false;
    }

    public static void bossHit() {

        for (int i = 0; i < heroesHealth.length; i++) {
            heroesHealth[i] = heroesHealth[i] - bossAttack;
        }
    }

    public static void medicTreat() {
        for (int i = 0; i < 1; i++) {

        }
        if ((heroesHealth[0] > 0 || heroesHealth[1] > 0 || heroesHealth[2] > 0 || heroesHealth[3] > 0) &&
                (heroesHealth[0] < 250 || heroesHealth[1] < 250 || heroesHealth[2] < 250)) ;
        Random r = new Random();
        int randomNumber = r.nextInt(3);
        switch (randomNumber) {
            case 0:
                heroesHealth[0] = heroesHealth[0] + medicSave;
                System.out.println("Medic helped " + heroesAttackType[0]);
                break;
            case 1:
                heroesHealth[1] = heroesHealth[1] + medicSave;
                System.out.println("Medic helped " + heroesAttackType[1]);
                break;
            case 2:
                heroesHealth[2] = heroesHealth[2] + medicSave;
                System.out.println("Medic helped " + heroesAttackType[2]);
                break;
        }
    }

    public static void heroesHit() {
        for (int i = 0; i < heroesAttack.length; i++) {
            if (bossHealth > 0 && heroesHealth[i] > 0) {
                if (bossDefenceType.equals(heroesAttackType[i])) {
                    Random r = new Random();
                    int randomNumber = r.nextInt(9) + 2;
                    bossHealth = bossHealth - heroesAttack[i] * randomNumber;
                    System.out.println("Critical Damage " + (heroesAttack[i] * randomNumber));
                } else {

                    bossHealth = bossHealth - heroesAttack[i];
                }
            }

        }

    }

    public static void prinStatistics(int round) {
        System.out.println("_________________________________________");
        System.out.println("round" + round);
        System.out.println("Boss health" + bossHealth);
        System.out.println("Physical health" + heroesHealth[0]);
        System.out.println("Magical health" + heroesHealth[1]);
        System.out.println("Kinetic health" + heroesHealth[2]);
        System.out.println("Medic health " + heroesHealth[3]);
        System.out.println("_________________________________________");

    }

}
