package org.sigar.examples;

import org.sigar.model.Mosaic;
import org.sigar.model.Tile;

import java.util.function.Supplier;

public class MosaicCreator {
    public Mosaic create(Supplier<? extends Tile> tileFactory) {
        // Implementation that uses the tileFactory to create tiles and build a mosaic
        Tile tile = tileFactory.get();
        System.out.println("Creating a mosaic with a tile of color: " + tile.getColor());
        return new Mosaic(tile);
    }
}
