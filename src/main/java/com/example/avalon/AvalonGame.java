package com.example.avalon;

import com.example.avalon.model.Constants;
import com.example.avalon.model.Player;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class AvalonGame extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        VBox root = new VBox(10);
        Scene scene = new Scene(root, 800, 600);

        setupWelcomeScreen(root);

        stage.setTitle("Avalon");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    private void setupWelcomeScreen(VBox root) {
        Label welcomeLabel = new Label("Welcome to Avalon");
        welcomeLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        Label playerCountLabel = new Label("Enter number of players (5-10):");
        TextField playerCountField = new TextField();
        playerCountField.setMaxWidth(100);

        Button startButton = new Button("Start Game");
        startButton.setOnAction(e -> {
            try {
                int playerCount = Integer.parseInt(playerCountField.getText());
                if (playerCount >= 5 && playerCount <= 10) {
                    startGame(playerCount);
                } else {
                    showAlert("Invalid Input", "Please enter a number between 5 and 10.");
                }
            } catch (NumberFormatException ex) {
                showAlert("Invalid Input", "Please enter a valid number.");
            }
        });

        root.getChildren().addAll(welcomeLabel, playerCountLabel, playerCountField, startButton);
        root.setAlignment(Pos.CENTER);
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private void startGame(int playerCount) {
        for (int i = 1; i <= playerCount; i++) {
            Player player = new Player("Player " + i, Constants.RoleType.getRandomRole());
            System.out.println("Player " + i + ":");
            System.out.println("  Name: " + player.getName());
            System.out.println("  Team: " + player.getTeam());
            System.out.println("  Role: " + player.getRole());
            System.out.println();
        }
    }
}