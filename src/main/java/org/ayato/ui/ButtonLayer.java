package org.ayato.ui;

import org.ayato.animation.PropertiesComponent;
import org.ayato.scene.Title;
import org.ayato.system.ToonMaster;
import org.ayato.util.Setup;

import java.awt.*;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ButtonLayer implements Setup {
    private final Consumer<Integer> ifClickedButton;
    public int chooseNumber = 0;
    public ButtonLayer(Consumer<Integer> ifClickedButton){
        this.ifClickedButton = ifClickedButton;
    }
    @Override
    public void createUI(ToonMaster toonMaster) {
        for(int i = 1; i < 10; i ++) {
            int finalI = i;

            toonMaster.addAnimation((Supplier<String>) ()->chooseNumber == finalI ? "O" : "", PropertiesComponent
                    .ofText(120 + i * 22, 165).font("", 0, 1.5f).color(Color.WHITE));

            toonMaster.addAnimation(String.valueOf(i), PropertiesComponent
                    .ofText(120 + i * 22, 180).font("", 0, 1.5f).color(Color.WHITE)
                    .button(0, 0, 20, 10, Title.NORMAL.get(), a -> {
                        ifClickedButton.accept(finalI);
                    }));
        }
    }
}
