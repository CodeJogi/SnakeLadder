package com.example.ludosnake;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    int yLine=440;

    public static final int tilesize=40;
    int height=10;
    int width=10;
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

        Button player1=new Button("Player1");
        player1.setTranslateX(40);
        player1.setTranslateY(yLine);

        Button start=new Button("Start Game");
        start.setTranslateX(160);
        start.setTranslateY(yLine);

        Button player2=new Button("Player2");
        player2.setTranslateX(320);
        player2.setTranslateY(yLine);

        Image img=new Image("C:\\Users\\jogi\\IdeaProjects\\LudoSnake\\src\\ludo.jpg");
        ImageView boardImg=new ImageView(img);
        boardImg.setFitHeight(tilesize*height);
        boardImg.setFitWidth(tilesize*width);

        tilesGroup.getChildren().addAll(boardImg,player2,player1,start);
                return root;

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