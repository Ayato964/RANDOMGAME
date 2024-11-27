package org.ayato.entities;

public class Player {
    private int gold;
    public Player(int g){
        gold = g;
    }

    public void addGold(int g){
        gold += g;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getGold() {
        return gold;
    }

    public int removeGold(int g){
        gold -= g;
        return gold;
    }

}
