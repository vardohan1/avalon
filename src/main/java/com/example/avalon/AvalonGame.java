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
import java.util.ArrayList;
import java.util.List;

import java.io.IOException;

public class AvalonGame extends Application {
    private VBox root;

    @Override
    public void start(Stage stage) throws IOException {
        root = new VBox(10);
        Scene scene = new Scene(root, 800, 600);

        setupWelcomeScreen();

        stage.setTitle("Avalon");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    private void setupWelcomeScreen() {
        root.getChildren().clear();

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


    private List<Player> players;
    private int currentPlayerIndex;
    private void startGame(int playerCount) {
        players = new ArrayList<>();
        currentPlayerIndex = 0;
        askPlayerName(playerCount);
    }

    private void askPlayerName(int remainingPlayers) {
        root.getChildren().clear();

        Label nameLabel = new Label("Enter player " + (players.size() + 1) + "'s name:");
        TextField nameField = new TextField();
        nameField.setMaxWidth(200);

        Button submitButton = new Button("Submit");
        submitButton.setOnAction(e -> {
            String name = nameField.getText().trim();
            if (!name.isEmpty()) {
                players.add(new Player(name, Constants.RoleType.getRandomRole()));
                if (players.size() < remainingPlayers) {
                    askPlayerName(remainingPlayers);
                } else {
                    showPlayerInfo(); // Call showPlayerInfo() here after all players are added
                }
            } else {
                showAlert("Invalid Input", "Please enter a name.");
            }
        });

        root.getChildren().addAll(nameLabel, nameField, submitButton);
        root.setAlignment(Pos.CENTER);
    }

    private void showPlayerInfo() {
        root.getChildren().clear();

        Player currentPlayer = players.get(currentPlayerIndex);

        Label playerInfoLabel = new Label();
        updatePlayerInfoLabel(playerInfoLabel, currentPlayer);

        Button nextPlayerButton = new Button("Next Player");
        nextPlayerButton.setOnAction(e -> onNextPlayer());

        root.getChildren().addAll(playerInfoLabel, nextPlayerButton);
        root.setAlignment(Pos.CENTER);
    }

    private void updatePlayerInfoLabel(Label label, Player player) {
        String info = String.format("Player: %s\nTeam: %s\nRole: %s",
                player.getName(), player.getTeam(), player.getRole());
        label.setText(info);
    }

    private void onNextPlayer() {
        currentPlayerIndex++;
        if (currentPlayerIndex < players.size()) {
            showPlayerInfo();
        } else {
            showGameStartScreen();
        }
    }

    private void showGameStartScreen() {
        root.getChildren().clear();

        Label gameStartLabel = new Label("All players have seen their roles. The game can now begin!");
        gameStartLabel.setStyle("-fx-font-size: 18px; -fx-text-alignment: center;");

        root.getChildren().add(gameStartLabel);
        root.setAlignment(Pos.CENTER);
    }
}