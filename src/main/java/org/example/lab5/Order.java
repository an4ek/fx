package org.example.lab5;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;


public class Order extends Application{


    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        GridPane gridPane= new GridPane();

        String[] menuItems = {"Паста", "Пицца", "Салат", "Десерт", "Суп", "Стейк","Паста", "Пицца", "Салат", "Десерт", "Суп", "Стейк"};
        double[] prices = {150, 200, 100, 80, 120, 300,150, 200, 100, 80, 120, 300};
        List<CheckBox> checkBoxes = new ArrayList<>();
        List<TextField> quantityFields = new ArrayList<>();
        for(int i = 0; i < menuItems.length; i++){
            CheckBox checkBox= new CheckBox(menuItems[i]+" - " + prices[i] + " руб.");
            checkBoxes.add(checkBox);
            gridPane.add(checkBox, 0, i);

            TextField quantityField = new TextField("0");
            quantityField.setPrefWidth(50);
            quantityField.setDisable(true);
            gridPane.add(quantityField,1,i);
            quantityFields.add(quantityField);

            Text t=new Text(" порций");
            gridPane.add(t,2,i);

            checkBox.setOnAction(event -> {
                if (checkBox.isSelected()) {
                    quantityField.setText("1");
                    quantityField.setDisable(false);
                } else {
                    quantityField.setText("0");
                    quantityField.setDisable(true);
                }
            });

        }
        Button toOrder = new Button("Заказать");
        gridPane.add(toOrder,3, menuItems.length);
        toOrder.setOnAction(event -> showOrderSummary(menuItems, prices, checkBoxes, quantityFields));

        ScrollPane scrollPane=new ScrollPane();
        scrollPane.setContent(gridPane);
        scrollPane.setFitToWidth(true);

        Scene scene = new Scene(scrollPane, 300, 300);

        stage.setScene(scene);
        stage.setTitle("Заказ");
        stage.show();

    }
    private void showOrderSummary(String[] menuItems, double[] prices,
                                  List<CheckBox> checkBoxes, List<TextField> quantityFields) {
        StringBuilder summary = new StringBuilder();
        double totalCost = 0;

        for (int i = 0; i < menuItems.length; i++) {
            if (checkBoxes.get(i).isSelected()) {
                int quantity = Integer.parseInt(quantityFields.get(i).getText());
                double itemCost = prices[i] * quantity;
                totalCost += itemCost;
                summary.append(menuItems[i])
                        .append(" - ")
                        .append(quantity)
                        .append(" порций - ")
                        .append(itemCost)
                        .append(" руб.\n");
            }
        }

        summary.append("Общая стоимость: ").append(totalCost).append(" руб.");


        Stage summaryStage = new Stage();
        VBox vbox = new VBox();
        TextArea textArea = new TextArea(summary.toString());
        textArea.setEditable(false);
        vbox.getChildren().add(textArea);

        Scene summaryScene = new Scene(vbox, 300, 200);
        summaryStage.setScene(summaryScene);
        summaryStage.setTitle("Чек");
        summaryStage.show();
    }
}
