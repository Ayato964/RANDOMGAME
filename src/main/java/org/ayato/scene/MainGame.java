package org.ayato.scene;

import org.ayato.animation.PropertiesComponent;
import org.ayato.ui.ButtonLayer;
import org.ayato.ui.Hold;
import org.ayato.ui.Latch;
import org.ayato.ui.Roulette;
import org.ayato.entities.Player;
import org.ayato.system.Tick;
import org.ayato.system.ToonMaster;
import org.ayato.util.BaseScene;
import org.ayato.util.Display;
import org.ayato.util.Setup;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.function.Supplier;

public class MainGame extends BaseScene {
    private Player player = new Player(1000);
    private final Random rand = new Random();
    private final ButtonLayer layer = new ButtonLayer(this::lottery);
    private final Roulette roulette = new Roulette();
    private final Hold hold = new Hold(player::getHold, player.maxHold);
    @Override
    public void tick() {
        rouletteFunction();
    }

    private void rouletteFunction() {
        if(player.getHold() != 0){
            if(!roulette.isBusy){
                player.decHold();
                roulette.start();
            }
        }
    }

    @Override
    public void display(Graphics graphics) {

    }

    @Override
    public void createUI(ToonMaster toonMaster) {
        toonMaster.addAnimation((Supplier<String>) ()->player.getGold() + "G", PropertiesComponent.ofText(10, 10)
                .font("", 0, 2f));

    }
    @Override
    public void setupUIClass(ArrayList<Setup> setups) {
        setups.add(layer);
        setups.add(roulette);
        setups.add(hold);
        setups.add(new Latch(player));
    }

    private void lottery(int number){
        int lo = rand.nextInt(9) + 1;
        if(lo == number) {
            player.addGold(4);
            player.addHold(1);
        }

        layer.chooseNumber = lo;
        player.removeGold(1);
    }

    @Override
    public void displayClass(ArrayList<Display> display) {
        display.add(roulette);
    }

    @Override
    public void tickClass(ArrayList<Tick> ticks) {
        ticks.add(roulette);
    }
}
