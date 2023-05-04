package org.example;

public class PremierLeague {
    String team;
    int play, points, goal;

    PremierLeague(){}
    PremierLeague(String t, int p, int g, int pt){
        team = t;
        play = p;
        goal = g;
        points = pt;
    }

    public void print(){
        System.out.println(
                "Team\t:" + team +
                "\nPlay\t:" + play +
                "\nGoal\t:" + goal +
                "\nPoints\t:" + points
        );
    }

}
