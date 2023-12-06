package com.example.anime_practice;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.security.Key;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private BorderPane main;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        main.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    Parent sub = FXMLLoader.load(getClass().getResource("sub.fxml"));
                    StackPane root = (StackPane) main.getScene().getRoot();
                    root.getChildren().add(sub);

                    sub.setTranslateX(400);

                    Timeline timeline = new Timeline();
                    KeyValue keyValue = new KeyValue(sub.translateXProperty(),0);
                    KeyFrame keyFrame = new KeyFrame(Duration.millis(300), keyValue);
                    timeline.getKeyFrames().add(keyFrame);
                    timeline.play();

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}