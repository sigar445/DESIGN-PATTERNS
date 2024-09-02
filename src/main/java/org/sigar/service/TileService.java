package org.sigar.service;

import org.sigar.model.ColoredTile;
import org.sigar.examples.MosaicCreator;
import org.sigar.model.Tile;

import java.util.function.Supplier;

public class TileService {
    public static void main(String[] args) {
        MosaicCreator creator = new MosaicCreator();

        // Using a lambda expression to create a Supplier of Tile);

        Supplier<Tile> tileSupplier = () -> new Tile("Blue");
        creator.create(tileSupplier);

        // Using the diamond operator with a subclass of Tile
        Supplier<ColoredTile> coloredTileSupplier = () -> new ColoredTile("Red");
        creator.create(coloredTileSupplier);
    }
}
