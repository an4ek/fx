package org.example.lab5;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

import java.io.IOException;


public class WordShifter extends Application {
    private boolean isFirstToSecond = true; // Флаг для отслеживания направления
    @Override
    public void start(Stage stage) throws IOException {
        TextField textField1 = new TextField();
        textField1.setPrefColumnCount(10);

        TextField textField2 = new TextField();
        textField2.setPrefColumnCount(10);
        textField2.setEditable(false);

        Button swapButton = new Button();
        updateButtonArrow(swapButton);

        // Обработчик нажатия кнопки
        swapButton.setOnAction(event -> {
            if (isFirstToSecond) {
                textField2.setText(textField1.getText());
                textField1.clear();
            } else {
                textField1.setText(textField2.getText());
                textField2.clear();
            }
            isFirstToSecond = !isFirstToSecond; // Меняем направление
            updateButtonArrow(swapButton);
        });

        stage.setTitle("Перекидыватель слов");
        stage.setWidth(330);
        stage.setHeight(70);
        stage.show();
        FlowPane root = new FlowPane(textField1, swapButton,textField2);
        Scene scene = new Scene(root);
        stage.setScene(scene);

    }
    private void updateButtonArrow(Button button) {
        if (isFirstToSecond) {
            button.setText("---->");
        } else {
            button.setText("<----");
        }
    }


    public static void main(String[] args) {
        launch();
    }
}