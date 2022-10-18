package com.example.ludosnake;

import javafx.util.Pair;

import java.util.ArrayList;

public class GameBoard {

    static int tilesize=40;
    static int height=10;
    static int width=10;

    static ArrayList<Pair<Integer,Integer>> positionCoordinates;
    static ArrayList<Integer> snakeLadderPosition;

    private static void Populate()
    {
        positionCoordinates=new ArrayList<>();
        positionCoordinates.add(new Pair<>(20,380));

        for (int i =height-1; i >=0 ; i--) {
            for (int j =width-1; j>=0 ; j--) {

                int xPos,yPos,pos;
                if(i%2!=0)
                {
                    xPos=tilesize*width-(tilesize/2 + j*tilesize);
                }
                else {
                    xPos=tilesize/2 + j*tilesize;
                }
                yPos=tilesize/2 + i*tilesize;

                positionCoordinates.add(new Pair<>(xPos,yPos));

            }

        }
        for (int i = 0; i <positionCoordinates.size() ; i++) {

            System.out.println(i+"x:-"+positionCoordinates.get(i).getKey()+"y:-"+positionCoordinates.get(i).getValue());
        }


    }
    public static void main(String[] args) {
        Populate();
    }

}


