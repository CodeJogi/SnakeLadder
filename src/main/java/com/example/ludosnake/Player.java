package com.example.ludosnake;

import javafx.animation.TranslateTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class Player {
    Circle gamepiece;
    int xPosition;
    int yPosition;
    int currentPiecePosition;

    static GameBoard game;

    Player(Color peiceColor, int peicesize)
    {
        game=new GameBoard();
        this.currentPiecePosition=1;
        this.xPosition=game.getXvalue(this.currentPiecePosition);
        this.yPosition=game.getYvalue(this.currentPiecePosition);

        gamepiece=new Circle(peicesize/2);
        gamepiece.setFill(peiceColor);
        gamepiece.setTranslateX(this.xPosition);
        gamepiece.setTranslateY(this.yPosition);
    }

    public void movePlayer(int dicevalue)
    {
        if( this.currentPiecePosition+dicevalue <=100) {
            this.currentPiecePosition += dicevalue;
        }
        translatePlayer();

    }

    public void playerAtSnakeOrLadder()
    {
        int newPosition=game.getPosition(this.currentPiecePosition);

        if (newPosition !=-1)
        {
            this.currentPiecePosition=newPosition;
        }
        translatePlayer();

    }

    public boolean winningStatus()
    {
        if(this.currentPiecePosition==100) {
            return true;
        }
        return false;
    }


    private void  translatePlayer()
    {

        this.xPosition=game.getXvalue(this.currentPiecePosition);
        this.yPosition=game.getYvalue(this.currentPiecePosition);

        TranslateTransition animate=new TranslateTransition(Duration.millis(1000), this.gamepiece);
        animate.setToX(this.xPosition);
        animate.setToY(this.yPosition);
        animate.setAutoReverse(false);
        animate.play();

    }
    public Circle getGamepiece()
    {
        return this.gamepiece;

    }
}
