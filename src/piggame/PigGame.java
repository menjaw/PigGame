/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piggame;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author MENJA
 */
public class PigGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Welcome to the player
        String welcome = presentation();
        System.out.println(welcome);

        //Denne while kontrollere og tæller hvor mange ture man spiller
        //Gælder kun for 2 ture på nuværende tidspunkt, skal ændres
        int countTurns = 0;

        while (countTurns < 2) {
            //På nuværende tidspunkt tælles antal slag, skal ændres 
            countTurns++;

            //Så længe turen er igang tjekkes nedenstående
            //På nuværende tidspunkt udelukkende true, skal ændres
            while (true) {
                int dice1 = dice();
                int dice2 = dice();
                int sum = dice1 + dice2;
                int point = sum + sum;

                System.out.println("Dice 1: " + dice1);
                System.out.println("Dice 2: " + dice2);
                //Lægger værdien fra dice1 og dice2 sammen     
                System.out.println("sum: " + sum);

                
                String bank = "bank";
                String again = "hit again";
                //Tjekker om der er kasten en 1
                if (dice1 == 1 && dice2 == 1) {
                    System.out.println("Sorry you lost your turn and point");
                    break;
                    //Tabes point i banken 
                } else if (dice1 == 1 || dice2 == 1) {
                    //Turen tabes 
                    System.out.println("Sorry you lost your turn");
                    break;
                } else {
                    //Hvis ingen terninger er 1, kør action
                    String action = "";

                    //while-loopet fortæller hvornår den kører, imens min statement er true kører den.
                    while (!action.equals(bank) && !action.equals(again)) {

                        action = JOptionPane.showInputDialog("What would you like to do with your points? (bank or hit again)");

                        if (action.equals(bank)) {

                            System.out.println("Du har: " + sum + " point. Dine point sættes i banken");
                        } else if (action.equals(again)) {
                            System.out.println("Du har valgt at slå igen");

                        } else {
                            System.out.println("Du har ikke indtastet korrekt");
                        }

                    }
                    //På nuværende tidspunkt lægges summen sammen for hvert slag, skal ændres
                    System.out.println("Du fik ialt: " + point + " point!");
                    if (action.equals(bank)) {
                        break;
                    }
                }

            }
        }
        betting();

        System.out.println("Du brugte ialt: " + countTurns + " slag!");
    }

    //METODERNE
    public static String presentation() {
        String name = JOptionPane.showInputDialog("What is your name?");
        String welcome = ("Hi " + name + "!" + "\n" + "Welcome to the game." + "\n" + "We hope you will enjoy the time you spend here.");
        String ready = ("Are you ready to play?");
        JOptionPane.showMessageDialog(null, welcome);
        JOptionPane.showMessageDialog(null, ready);
        
        return welcome;

    }

    public static int dice() {
        Random pigGame = new Random();

        int dice;
        dice = pigGame.nextInt(6) + 1;

        return dice;
    }

    public static int bank(int point) {
        return 0;
    }

    public static int account() {
        return 0;
    }

    public static int betting() {
        String bet = JOptionPane.showInputDialog("Would you like to bet your points?" + "Yes or No");
  
        return 0;
    }
}
