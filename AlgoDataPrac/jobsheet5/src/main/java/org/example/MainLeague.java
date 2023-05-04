package org.example;

import java.util.Scanner;

public class MainLeague {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        PremiereLeagueService data = new PremiereLeagueService();
        System.out.print("Input data length: ");
        data.setArray(sc.nextInt());
        for (int i = 0; i < data.leagues.length; i++){
            System.out.print("Input team name: ");
            sc.nextLine();
            String team = sc.nextLine();
            System.out.print("Input number of plays: ");
            int play = sc.nextInt();
            System.out.print("Input number of goals: ");
            int goal = sc.nextInt();
            System.out.print("Input total points: ");
            int points = sc.nextInt();
            System.out.println("+++++++++++++++++++++++++++++++++++");

            PremierLeague inputLeagues = new PremierLeague(team, play,  goal, points);
            data.add(inputLeagues);
        }

        System.out.println("Here is the output in ascending order from biggest to smallest: ");
        data.insertionSort();
        data.displayAll();
    }
}
