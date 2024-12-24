package org.example.lab5;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Flag extends Application {
    @Override
    public void start(Stage stage) {

        Label color1 = new Label("Выберете первый цвет:");
        RadioButton white = new RadioButton("Белый");
        RadioButton blue = new RadioButton("Синий");
        RadioButton red = new RadioButton("Красный");
        RadioButton pink = new RadioButton("Розовый");
        RadioButton purple = new RadioButton("Фиолетовый");

        ToggleGroup group1 = new ToggleGroup();
        // установка группы
        white.setToggleGroup(group1);
        blue.setToggleGroup(group1);
        red.setToggleGroup(group1);
        pink.setToggleGroup(group1);
        purple.setToggleGroup(group1);

        Label color2 = new Label("Выберете второй цвет:");
        RadioButton white2 = new RadioButton("Белый");
        RadioButton blue2 = new RadioButton("Синий");
        RadioButton red2 = new RadioButton("Красный");
        RadioButton pink2 = new RadioButton("Розовый");
        RadioButton purple2 = new RadioButton("Фиолетовый");
        ToggleGroup group2 = new ToggleGroup();

        // установка группы
        white2.setToggleGroup(group2);
        blue2.setToggleGroup(group2);
        red2.setToggleGroup(group2);
        pink2.setToggleGroup(group2);
        purple2.setToggleGroup(group2);

        Label color3 = new Label("Выберете второй цвет:");
        RadioButton white3 = new RadioButton("Белый");
        RadioButton blue3 = new RadioButton("Синий");
        RadioButton red3 = new RadioButton("Красный");
        RadioButton pink3 = new RadioButton("Розовый");
        RadioButton purple3 = new RadioButton("Фиолетовый");

        ToggleGroup group3 = new ToggleGroup();
        // установка группы
        white3.setToggleGroup(group3);
        blue3.setToggleGroup(group3);
        red3.setToggleGroup(group3);
        pink3.setToggleGroup(group3);
        purple3.setToggleGroup(group3);


        Label resultLabel= new Label();
        Button drawButton = new Button("Нарисовать");
        drawButton.setOnAction(e -> {

            String resColor1 = ((RadioButton) group1.getSelectedToggle()).getText();
            String resColor2 = ((RadioButton) group2.getSelectedToggle()).getText();
            String resColor3 = ((RadioButton) group3.getSelectedToggle()).getText();
            resultLabel.setText("Выбранные цвета: " + resColor1 + ", " + resColor2 + ", " + resColor3 );
        });
        FlowPane root = new FlowPane(Orientation.VERTICAL, 10, 10);
        root.getChildren().addAll(color1, white, blue, red, pink, purple, color2, white2, blue2, red2, pink2, purple2, color3, white3, blue3, red3, pink3, purple3 ,drawButton, resultLabel);

        Scene scene = new Scene(root, 700, 180);

        stage.setScene(scene);
        stage.setTitle("Текстовый флаг");
        stage.setResizable(false);
        stage.show();

    }
    public static void main(String[] args) {
        launch();
    }


}
