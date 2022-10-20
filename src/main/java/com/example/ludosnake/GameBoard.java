package com.example.ludosnake;

import javafx.util.Pair;

import java.util.ArrayList;

public class GameBoard {

    static int tilesize = 40;
    static int height = 10;
    static int width = 10;

    static ArrayList<Pair<Integer, Integer>> positionCoordinates;
    static ArrayList<Integer> snakeLadderPosition;

    public GameBoard() {

        Populate();
        populateSnakeLadderPosition();
    }

    public int getXvalue(int piecePosition) {
        if (piecePosition <= 100 && piecePosition >= 0) {
            return positionCoordinates.get(piecePosition).getKey();

        } else {
            return positionCoordinates.get(1).getValue();
        }
    }

    public int getYvalue(int piecePosition) {
        if (piecePosition <= 100 && piecePosition >= 0) {
            return positionCoordinates.get(piecePosition).getValue();

        } else {
            return positionCoordinates.get(1).getValue();
        }
    }

    private static void Populate() {
        positionCoordinates = new ArrayList<>();
        positionCoordinates.add(new Pair<>(20, 380));

        for (int i = height - 1; i >= 0; i--) {
            for (int j = width - 1; j >= 0; j--) {

                int xPos, yPos, pos;
                if (i % 2 != 0) {
                    xPos = tilesize * width - (tilesize / 2 + j * tilesize);
                } else {
                    xPos = tilesize / 2 + j * tilesize;
                }
                yPos = tilesize / 2 + i * tilesize;

                positionCoordinates.add(new Pair<>(xPos, yPos));

            }

        }


    }

    public int getPosition(int piecePostion) {
        if (piecePostion != snakeLadderPosition.get(piecePostion)) {
            return snakeLadderPosition.get(piecePostion);
        }
        return -1;

    }

    private void populateSnakeLadderPosition() {
        snakeLadderPosition = new ArrayList<>();
        for (int i = 0; i < 101; i++) {

            snakeLadderPosition.add(i);
        }
        snakeLadderPosition.set(4, 25);
        snakeLadderPosition.set(13, 46);
        snakeLadderPosition.set(27, 5);
        snakeLadderPosition.set(33, 49);
        snakeLadderPosition.set(40, 3);
        snakeLadderPosition.set(42, 63);
        snakeLadderPosition.set(43, 18);
        snakeLadderPosition.set(50, 69);
        snakeLadderPosition.set(54, 31);
        snakeLadderPosition.set(62, 81);
        snakeLadderPosition.set(66, 45);
        snakeLadderPosition.set(74, 92);
        snakeLadderPosition.set(76, 58);
        snakeLadderPosition.set(89, 53);
        snakeLadderPosition.set(99, 41);

    }
}



