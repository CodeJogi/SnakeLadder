package com.example.ludosnake;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tile extends Rectangle {
    Tile (int x,int y)
    {
        setWidth(x);
        setHeight(y);
        setFill(Color.BLUE);
        setStroke(Color.BLACK);
    }
}
