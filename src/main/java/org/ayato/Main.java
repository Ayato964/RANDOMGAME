package org.ayato;

import org.ayato.scene.Title;
import org.ayato.system.ToonMaster;

public class Main {
    private static final ToonMaster INSTANCE = ToonMaster.create("Random Game", true);
    public static void main(String[] args) {
        INSTANCE.changeScene(new Title());
        INSTANCE.setVisible(true);
    }
}