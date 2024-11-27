package org.ayato.ui;

import org.ayato.animation.PropertiesComponent;
import org.ayato.animation.text.properties.CheckBox;
import org.ayato.entities.Player;
import org.ayato.scene.Title;
import org.ayato.system.ToonMaster;
import org.ayato.util.Setup;

import java.awt.*;

public class Latch implements Setup {
    private final Player player;
    public Latch(Player p){

        player = p;
    }
    @Override
    public void createUI(ToonMaster toonMaster) {
        toonMaster.addAnimation("1", PropertiesComponent.ofText(10, 190)
                .font("", 0, 1.5f).color(Color.WHITE)
                .chooseBox(aBoolean -> {
                    if(aBoolean)
                        player.latch = 1;
                }, Title.NORMAL.get(), Color.WHITE, CheckBox.Duration.LEFT)).setGroup("latch");
        toonMaster.addAnimation("2", PropertiesComponent.ofText(40, 190)
                .font("", 0, 1.5f).color(Color.WHITE)
                .chooseBox(aBoolean -> {
                    if(aBoolean)
                        player.latch = 2;
                }, Title.NORMAL.get(), Color.WHITE, CheckBox.Duration.LEFT)).setGroup("latch");
        toonMaster.addAnimation("4", PropertiesComponent.ofText(70, 190)
                .font("", 0, 1.5f).color(Color.WHITE)
                .chooseBox(aBoolean -> {
                    if(aBoolean)
                        player.latch = 4;
                }, Title.NORMAL.get(), Color.WHITE, CheckBox.Duration.LEFT)).setGroup("latch");
        toonMaster.addAnimation("8", PropertiesComponent.ofText(100, 190)
                .font("", 0, 1.5f).color(Color.WHITE)
                .chooseBox(aBoolean -> {
                    if(aBoolean)
                        player.latch = 8;
                }, Title.NORMAL.get(), Color.WHITE, CheckBox.Duration.LEFT)).setGroup("latch");
        toonMaster.addAnimation("50", PropertiesComponent.ofText(130, 190)
                .font("", 0, 1.5f).color(Color.WHITE)
                .chooseBox(aBoolean -> {
                    if(aBoolean)
                        player.latch = 50;
                }, Title.NORMAL.get(), Color.WHITE, CheckBox.Duration.LEFT)).setGroup("latch");
        toonMaster.addAnimation("100", PropertiesComponent.ofText(160, 190)
                .font("", 0, 1.5f).color(Color.WHITE)
                .chooseBox(aBoolean -> {
                    if(aBoolean)
                        player.latch = 100;
                }, Title.NORMAL.get(), Color.WHITE, CheckBox.Duration.LEFT)).setGroup("latch");
    }
}
