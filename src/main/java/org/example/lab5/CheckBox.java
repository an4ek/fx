package org.example.lab5;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.io.IOException;

public class CheckBox extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Label w1= new Label("+");
        Label w2= new Label("!");
        Label w3= new Label("{");

        javafx.scene.control.CheckBox ch1= new javafx.scene.control.CheckBox();
        ch1.setSelected(true);
        javafx.scene.control.CheckBox ch2= new javafx.scene.control.CheckBox();
        ch2.setSelected(true);
        javafx.scene.control.CheckBox ch3= new javafx.scene.control.CheckBox();
        ch3.setSelected(true);

        stage.setTitle("CheckBoxes");
        stage.setWidth(300);
        stage.setHeight(70);
        stage.show();

        HBox hbox1 = new HBox(10); // 10 - отступ между элементами
        hbox1.getChildren().addAll(w1,ch1,w2,ch2,w3,ch3);

        ch1.setOnAction(e -> w1.setVisible(ch1.isSelected()));
        ch2.setOnAction(e -> w2.setVisible(ch2.isSelected()));
        ch3.setOnAction(e -> w3.setVisible(ch3.isSelected()));

        Scene scene = new Scene(hbox1);
        stage.setScene(scene);

    }

    public static void main(String[] args) {
        launch();
    }
}

