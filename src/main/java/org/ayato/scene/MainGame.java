package org.ayato.scene;

import org.ayato.animation.PropertiesComponent;
import org.ayato.buttons.ButtonLayer;
import org.ayato.entities.Player;
import org.ayato.system.ToonMaster;
import org.ayato.util.BaseScene;
import org.ayato.util.Setup;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.function.Supplier;

public class MainGame extends BaseScene {
    private Player player = new Player(1000);
    private final Random rand = new Random();
    private final ButtonLayer layer = new ButtonLayer(this::lottery);


    @Override
    public void tick() {
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
    }

    private void lottery(int number){
        int lo = rand.nextInt(9) + 1;
        if(lo == number)
            player.addGold(5);

        layer.chooseNumber = lo;
        player.removeGold(1);
    }
}
