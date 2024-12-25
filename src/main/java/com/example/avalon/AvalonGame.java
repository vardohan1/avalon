package com.example.avalon;

import com.example.avalon.model.Constants;
import com.example.avalon.model.Player;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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

        Button startButton = new Button("Start Game");
        startButton.setOnAction(e -> startGame());

        root.getChildren().addAll(welcomeLabel, startButton);
        root.setAlignment(Pos.CENTER);
    }

    private void startGame() {
        System.out.println("Game started!");
        System.out.println("Loading game...");
        Player player1 = new Player("Player 1", Constants.RoleType.getRandomRole());
        System.out.println("name: " + player1.getName());
        System.out.println("team: " + player1.getTeam());
        System.out.println("role: " + player1.getRole());
    }
}