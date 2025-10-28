package it.saimao;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Random;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main extends Application {
    static void main() {
        launch(Main.class);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Font font = new Font("A J Kunheing 09 Regular", 18);

        Label lbName = new Label("Student Name");
        lbName.setFont(font);
        Button btPick = new Button("Pick");
        btPick.setFont(font);

        HBox hbRadio = new HBox();
        hbRadio.setAlignment(Pos.CENTER);
        hbRadio.setSpacing(15);

        ToggleGroup tg = new ToggleGroup();
        RadioButton rbMorning = new RadioButton("Morning class");
        rbMorning.setSelected(true);
        rbMorning.setFont(font);

        RadioButton rbAfternoon = new RadioButton("Afternoon class");
        rbAfternoon.setFont(font);
        hbRadio.getChildren().add(rbMorning);
        hbRadio.getChildren().add(rbAfternoon);

        tg.getToggles().addAll(rbMorning, rbAfternoon);

        VBox root = new VBox();
        root.setSpacing(20);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(lbName, btPick, hbRadio);
        root.setBackground(Background.fill(Paint.valueOf("#FBE592")));

        Scene scene = new Scene(root, 450, 450);
        primaryStage.setScene(scene);

        primaryStage.show();

        // Actions

        String[] afternoonClass = {"Lao Lao", "La Han", "Phoung Num", "Kham Hleng", "Seng Aom", "Mo Noung", "Jao Khao", "Jarm Hom Lao"};
        String[] morningClass = {"A", "B", "C", "D", "E", "F", "G"};
        String[] shanNumbers = {"ၼိုင်ႈ", "သွင်", "သၢမ်"};

        btPick.setOnAction(event -> {

            Thread th = new Thread(() -> {
                for (int i = 0; i < 3; i++) {
                    int finalI = i;
                    Platform.runLater(() -> {
                        lbName.setText(shanNumbers[finalI]);
                    });
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                String name;
                if (rbMorning.isSelected()) {
                    name = morningClass[new Random().nextInt(morningClass.length)];
                } else {
                    name = afternoonClass[new Random().nextInt(afternoonClass.length)];
                }
                Platform.runLater(() -> {
                    lbName.setText(name);
                });
            });
            th.start();
        });


    }
}
