package org.ayato.scene;

import org.ayato.animation.AnimationState;
import org.ayato.animation.PropertiesComponent;
import org.ayato.system.BaseBackground;
import org.ayato.system.Layer;
import org.ayato.system.ToonMaster;
import org.ayato.util.BaseScene;

import java.awt.*;
import java.util.ArrayList;
import java.util.function.Supplier;

public class Title extends BaseScene {
    public static final Supplier<AnimationState> NORMAL =()-> new AnimationState(
            Color.WHITE,
            Color.RED,
            Color.WHITE,
            new Color(0, 0, 0, 120),
            new Color(0, 0, 0, 120),
            new Color(0, 0, 0, 120)
            );
    @Override
    public void tick() {

    }

    @Override
    public void display(Graphics graphics) {

    }

    @Override
    public void createUI(ToonMaster toonMaster) {
        toonMaster.setBackground(new BaseBackground() {
            @Override
            public void setLayer(ArrayList<Layer> arrayList) {
                arrayList.add((graphics2D, i, i1) -> {graphics2D.setColor(Color.BLACK);
                    graphics2D.fillRect(0, 0, i, i1);});
            }
        });
        toonMaster.addAnimation("Random Game", PropertiesComponent.ofText(20, 50)
                .color(Color.WHITE).font("", 0, 2f).center());
        toonMaster.addAnimation("Start", PropertiesComponent.ofText(100, 100)
                .color(Color.WHITE).font("", 0, 1.5f)
                .button(0, 0, 200, 10, NORMAL.get(), action->{
                    toonMaster.changeScene(new MainGame());
                })
        );
    }
}
