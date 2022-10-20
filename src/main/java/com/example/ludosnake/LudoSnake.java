package com.example.ludosnake;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class LudoSnake extends Application {

    int yLine=450;

    public static final int tilesize=40;
    int height=10;
    int width=10;
    int diceValue=1;

    boolean gameStart=false,player1turn=true,player2turn=false;
    Button start;
    Label dice;

    Player playerOne, playerTwo;
    Group tilesGroup=new Group();
    private Pane createContent()
    {
        Pane root=new Pane();
        root.setPrefSize(400,500);
        root.getChildren().addAll(tilesGroup);

        for (int i = 0; i < height; i++) {
            for (int j = 0; j <width ; j++) {

                Tile t=new Tile(tilesize,tilesize);
                t.setTranslateX(j*tilesize);
                t.setTranslateY(i*tilesize);

                tilesGroup.getChildren().addAll(t);
            }

        }


        playerOne=new Player(Color.BLACK,tilesize);
        playerTwo=new Player(Color.WHITE,tilesize-10);

        dice=new Label("Player1 will start the game!!");
        dice.setTranslateX(170);
        dice.setTranslateY(420);

        Button player1=new Button("Player1");
        player1.setTranslateX(40);
        player1.setTranslateY(yLine);
        player1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                if(player1turn==true && gameStart==true)
                {
                    diceValue=getDiceValue();
                    dice.setText("PlayerOne:-"+String.valueOf(diceValue));

                    playerOne.movePlayer(diceValue);
                    if(Integer.valueOf(diceValue)==6)
                    {
                        player1turn=true;
                        player2turn=false;
                    }
                    player1turn=false;
                    player2turn=true;
                    playerOne.playerAtSnakeOrLadder();
                    gameOver();
                }
            }
        });

        start=new Button("Start the Game");
        start.setTranslateX(160);
        start.setTranslateY(yLine);
        start.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                start.setText("Playing Game...!!!");
                gameStart=true;
            }
        });

        Button player2=new Button("Player2");
        player2.setTranslateX(320);
        player2.setTranslateY(yLine);
        player2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                if(player2turn==true && gameStart==true)
                {
                    diceValue=getDiceValue();
                    dice.setText("PlayerTwo:-"+String.valueOf(diceValue));

                    playerTwo.movePlayer(diceValue);
                    if(Integer.valueOf(diceValue)==6)
                    {
                        player1turn=false;
                        player2turn=true;
                    }
                    player1turn=true;
                    player2turn=false;
                    playerTwo.playerAtSnakeOrLadder();
                    gameOver();
                }
            }
        });

        Image img=new Image("C:\\Users\\jogi\\IdeaProjects\\LudoSnake\\src\\ludo.jpg");
        ImageView boardImg=new ImageView(img);
        boardImg.setFitHeight(tilesize*height);
        boardImg.setFitWidth(tilesize*width);

        tilesGroup.getChildren().addAll(boardImg,dice,playerOne.getGamepiece(),playerTwo.getGamepiece(),player2,player1,start);
                return root;

    }

    public void gameOver()
    {
        if(playerOne.winningStatus()==true)
        {
            dice.setText("Congrats Player1 Won!!");
            start.setText("Start again");
            gameStart=false;
        }
        else if(playerTwo.winningStatus()==true)
    {
        dice.setText("Congrats Player2 Won!!");
        start.setText("Start again");
        gameStart=false;
    }
    }

    private int getDiceValue()
    {
        diceValue=(int)(Math.random()*6+1);
        return diceValue;
    }

    @Override
    public void start(Stage stage) throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(createContent());
        stage.setTitle("Lets Play Snake&Ladder!!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}