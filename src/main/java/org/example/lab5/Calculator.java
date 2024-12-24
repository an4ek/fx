package org.example.lab5;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Calculator extends Application {
    private double currentResult = 0;
    private String operator = "";
    private boolean start = true;

    @Override
    public void start(Stage stage) {
        GridPane gridPane = new GridPane();

        TextField tField = new TextField();
        tField.setPrefHeight(70);
        gridPane.add(tField, 0, 5, 4, 1);
        tField.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        // Создание кнопок
        Button[] numberButtons = new Button[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new Button(String.valueOf(i));
            numberButtons[i].setPrefSize(70, 70);
            final int num = i; // Для использования в лямбда-выражении
            numberButtons[i].setOnAction(e -> handleNumberButton(tField, num));
        }

        Button bSum = createOperatorButton("+", tField);
        Button bMin = createOperatorButton("-", tField);
        Button bMult = createOperatorButton("*", tField);
        Button bDiv = createOperatorButton("/", tField);

        Button bRes = new Button("=");
        bRes.setPrefSize(70, 70);
        bRes.setStyle("-fx-background-color: #4F658C; -fx-text-fill: white;");
        bRes.setOnAction(e -> calculate(tField));

        // Расположение кнопок
        gridPane.add(numberButtons[1], 0, 2);
        gridPane.add(numberButtons[2], 1, 2);
        gridPane.add(numberButtons[3], 2, 2);
        gridPane.add(bSum, 3, 2);

        gridPane.add(numberButtons[4], 0, 1);
        gridPane.add(numberButtons[5], 1, 1);
        gridPane.add(numberButtons[6], 2, 1);
        gridPane.add(bMin, 3, 1);

        gridPane.add(numberButtons[7], 0, 0);
        gridPane.add(numberButtons[8], 1, 0);
        gridPane.add(numberButtons[9], 2, 0);
        gridPane.add(bMult, 3, 0);

        gridPane.add(numberButtons[0], 0, 3);
        gridPane.add(bDiv, 2, 3);
        gridPane.add(bRes, 3, 3);

        Scene scene = new Scene(gridPane);
        stage.setScene(scene);
        stage.setTitle("Калькулятор");
        stage.setWidth(300);
        stage.setHeight(400);
        stage.show();
    }

    private void handleNumberButton(TextField tField, int num) {  //Этот метод очищает текстовое поле при первом нажатии и добавляет выбранное число к тексту.
        if (start) {
            tField.clear();
            start = false;
        }
        tField.appendText(String.valueOf(num));
    }

    private Button createOperatorButton(String op, TextField tField) {
        Button button = new Button(op);
        button.setPrefSize(70, 70);
        button.setOnAction(e -> handleOperator(tField.getText(), op));
        return button;
    }

    private void handleOperator(String text, String op) {
        if (!text.isEmpty()) {
            currentResult = Double.parseDouble(text);
            operator = op;
            start = true; // Сбросить для следующего ввода
        }
    }

    private void calculate(TextField tField) {
        if (operator.isEmpty() || tField.getText().isEmpty()) return;

        double secondNumber = Double.parseDouble(tField.getText());

        switch (operator) {
            case "+" -> currentResult += secondNumber;
            case "-" -> currentResult -= secondNumber;
            case "*" -> currentResult *= secondNumber;
            case "/" -> {
                if (secondNumber == 0) {
                    tField.setText("Ошибка: Деление на ноль!");
                    return;
                }
                currentResult /= secondNumber;
            }
            default -> {}
        }
        tField.setText(String.valueOf(currentResult)); // Обновляем текстовое поле с результатом
    }

    public static void main(String[] args) {
        launch();
    }
}
