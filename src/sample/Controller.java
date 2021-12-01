package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.Console;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;

public class Controller {

    @FXML
    public Button genNumBtn;

    @FXML
    public Label currentNum;

    @FXML
    public Label numList;

    String output = "";
    int newNum = 0;
    Timer t;
    int cycle = 0;
    long delay = 400;

    public void genNewNum(ActionEvent actionEvent) {
        newNum = ThreadLocalRandom.current().nextInt(0, 101);

        cycle = 0;
        t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> gen());
            }
        }, 0, 300);

    }

    private void gen() {

        currentNum.setText(String.format("%d", ThreadLocalRandom.current().nextInt(0, 101)));

        t.cancel();
    }

}

