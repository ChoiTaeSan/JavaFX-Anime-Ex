package com.example.anime_practice;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Stack;

public class SubController implements Initializable {
    @FXML
    private AnchorPane sub_layout;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sub_layout.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                StackPane stackPane = (StackPane) sub_layout.getScene().getRoot();
                Parent sub = (Parent) stackPane.getChildren().get(1);

                Timeline timeline = new Timeline();
                KeyValue keyValue = new KeyValue(sub.translateXProperty(), 400);
                KeyFrame keyFrame = new KeyFrame(Duration.millis(300), new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        stackPane.getChildren().remove(1);
                    }
                }, keyValue);
                timeline.getKeyFrames().add(keyFrame);
                timeline.play();


            }
        });
    }
}
