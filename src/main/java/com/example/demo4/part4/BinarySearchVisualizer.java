package com.example.demo4.part4;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Duration;

public class BinarySearchVisualizer extends Application {

    private int[] array;
    private int arraySize;
    private int searchKey;
    private Label statusLabel;
    private TextField arraySizeInput;
    private TextField searchKeyInput;
    private TextField delayInput;
    private HBox arrayBox;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Binary Search Visualizer");

        // UI Components
        arraySizeInput = new TextField();
        arraySizeInput.setPromptText("Array Size");

        searchKeyInput = new TextField();
        searchKeyInput.setPromptText("Search Value");

        delayInput = new TextField();
        delayInput.setPromptText("Delay (ms)");

        Button startButton = new Button("Start Search");
        startButton.setOnAction(e -> startSearch());

        statusLabel = new Label("Status: Waiting to start...");

        arrayBox = new HBox(5);
        arrayBox.setPrefHeight(50);
        arrayBox.setPrefWidth(600);

        // Layout
        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(arraySizeInput, searchKeyInput, delayInput, startButton, arrayBox, statusLabel);

        Scene scene = new Scene(root, 800, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void startSearch() {
        try {
            arraySize = Integer.parseInt(arraySizeInput.getText());
            searchKey = Integer.parseInt(searchKeyInput.getText());
            int delay = Integer.parseInt(delayInput.getText());

            if (arraySize <= 0 || delay < 0) {
                statusLabel.setText("Invalid input values.");
                return;
            }

            array = new int[arraySize];
            for (int i = 0; i < arraySize; i++) {
                array[i] = i + 1; // Create a sorted array
            }

            displayArray();
            binarySearchWithVisualization(array, searchKey, delay);
        } catch (NumberFormatException e) {
            statusLabel.setText("Please enter valid integers.");
        }
    }

    private void displayArray() {
        arrayBox.getChildren().clear();
        for (int value : array) {
            Label label = new Label(String.valueOf(value));
            label.setStyle("-fx-border-color: black; -fx-padding: 5px;");
            arrayBox.getChildren().add(label);
        }
    }

    private void highlightArrayPositions(int low, int mid, int high) {
        for (int i = 0; i < arrayBox.getChildren().size(); i++) {
            Label label = (Label) arrayBox.getChildren().get(i);
            if (i == mid) {
                label.setStyle("-fx-border-color: red; -fx-background-color: yellow; -fx-padding: 5px;");
            } else if (i >= low && i <= high) {
                label.setStyle("-fx-border-color: green; -fx-background-color: lightgreen; -fx-padding: 5px;");
            } else {
                label.setStyle("-fx-border-color: black; -fx-padding: 5px;");
            }
        }
    }

    private void binarySearchWithVisualization(int[] array, int key, int delay) {
        final int[] low = {0};
        final int[] high = {array.length - 1};
        final int[] iterCount = {0};
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(delay), event -> {
            int mid = (low[0] + high[0]) / 2;
            iterCount[0]++;
            statusLabel.setText("Iteration count: " + iterCount[0] + ". Range: " + low[0] + " - " + high[0] + ". Mid: " + mid);
            if (low[0] <= high[0]) {
                highlightArrayPositions(low[0], mid, high[0]);
                if (array[mid] < key) {
                    low[0] = mid + 1;
                } else if (array[mid] > key) {
                    high[0] = mid - 1;
                } else {
                    statusLabel.setText("Value found at index: " + mid + " in " + iterCount[0] + " iterations");
                    timeline.stop();
                }
            } else {
                statusLabel.setText("Value not found in " + iterCount[0] + " iterations");
                timeline.stop();
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
}
