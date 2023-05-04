package org.example;

public class PremiereLeagueService {
    int length, idx;
    PremierLeague[] leagues;

    void setArray(int arrayLength){
        leagues = new PremierLeague[arrayLength];
    }
    void add(PremierLeague p){
        if(idx<leagues.length){
            leagues[idx] = p;
            idx++;
        } else {
            System.out.println("The premier league list is full");
        }
    }
    void displayAll(){
        for (PremierLeague out : leagues){
            out.print();
            System.out.println("=================================");
        }
    }
    void insertionSort() {
        for (int i = 0; i < leagues.length; i++) {
            PremierLeague temp = leagues[i];
            int j = i;
            while (j > 0 && leagues[j - 1].points > temp.points){
                leagues[j] = leagues[j - 1];
                j--;
            }
            leagues[j] = temp;
        }
    }
}
