package org.ayato.ui;

import org.ayato.animation.PropertiesComponent;
import org.ayato.system.Tick;
import org.ayato.system.ToonMaster;
import org.ayato.util.Display;
import org.ayato.util.Setup;

import java.awt.*;
import java.util.HashMap;
import java.util.Random;
import java.util.function.Supplier;

public class Roulette implements Setup, Display, Tick {
    public boolean isBusy = false;

    private int busyTime = 0;
    private final HashMap<Integer, String> rate = new HashMap<>();
    private String[][] roulette = new String[3][3];
    private final Random seed = new Random();
    private int length;
    private boolean isStartRoulette = false;
    private int rCount = 0;
    private int time = 0;
    public Roulette(){
        int c = 1;
        int r = 0;
        boolean isEnd = false;
        while (!isEnd){
            if(r % 2 == 1) {
                rate.put(r, String.valueOf(c));
                c ++;
            }else{
                rate.put(r, "*");
            }
            if(c != 10) {
                r++;
            }else {
                isEnd = true;
                length = r;
            }
        }
        turning(-1);
    }

    private void turning(int al) {
        for(int i = 0; i < 3; i ++){
            int r = al == -1 ? seed.nextInt(length) : al;
            roulette[1][i] = rate.get(r);
            roulette[0][i] = rate.get(r - 1 < 0 ? length : r - 1);
            roulette[2][i] = rate.get(r + 1 > length ? 0 : r + 1);
        }
    }

    @Override
    public void createUI(ToonMaster toonMaster) {
        for(int i= 0; i < 3; i ++){
            for(int c = 0; c < 3; c ++){
                int finalI = i;
                int finalC = c;
                toonMaster.addAnimation((Supplier<String>) ()->roulette[finalI][finalC], PropertiesComponent.ofText(200 + c * 30, 40 + i * 30)
                        .color(Color.WHITE).font("", 0, 4f));
            }
        }
    }

    @Override
    public void display(Graphics graphics) {
        graphics.setColor(Color.WHITE);
        graphics.drawLine(650, 150, 650, 700);
        graphics.drawLine(1250, 150, 1250, 700);
        graphics.drawLine(650, 150, 1250, 150);
        graphics.drawLine(650, 700, 1250, 700);
    }
    public void start(){
        isStartRoulette = true;
        busyTime = 0;
    }
    @Override
    public void tick() {
        if(isStartRoulette){
            isBusy = true;
            turning(rCount);
            rCount ++;
            time ++;
            if(rCount > length){
                rCount = 0;
            }
            if(time >= 3000){
                time = 0;
                isStartRoulette = false;
                turning(-1);
            }
        }else{
            busyTime ++;
            isBusy = busyTime < 2000;
        }
    }

    @Override
    public long getSerialID() {
        return 999;
    }
}
