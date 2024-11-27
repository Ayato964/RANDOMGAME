package org.ayato.entities;

public class Player {
    public int maxHold = 4;
    private int gold;
    private int hold = 0;
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

    public void removeGold(int g){
        gold -= g;
    }

    public int getHold() {
        return hold;
    }
    public void addHold(int h){
        if(hold < maxHold) {
            hold += h;
        }
    }
    public void decHold(){
        hold --;
    }
}
