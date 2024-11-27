package org.ayato.ui;

import org.ayato.animation.PropertiesComponent;
import org.ayato.system.ToonMaster;
import org.ayato.util.Setup;

import java.util.function.IntSupplier;
import java.util.function.Supplier;

public class Hold implements Setup {
    private final IntSupplier holdCount;
    private final int maxHold;
    public Hold(IntSupplier holdCount, int maxHold){
        this.holdCount = holdCount;
        this.maxHold = maxHold;
    }
    @Override
    public void createUI(ToonMaster toonMaster) {
        for(int i = 0; i < maxHold; i ++){
            final int finalI = i + 1;
            toonMaster.addAnimation((Supplier<String>) ()->holdCount.getAsInt() >= finalI ? "O" : "-",
                    PropertiesComponent.ofText(120, 50 + i * 20).font("", 0, 3));
        }
    }
}
