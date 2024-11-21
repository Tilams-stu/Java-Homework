package text;

import control.PlayAction;
import entity.FiveChess;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.ChessPane;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        FiveChess fiveChess = new FiveChess(20, 20, 28.0);
        ChessPane chessPane = new ChessPane(fiveChess);

        File logFile = new File(System.getProperty("user.dir") + "/src/jilu.txt");
        try (FileOutputStream out = new FileOutputStream(logFile, true)) {
            out.write(new String("棋局开始，黑子先行\n").getBytes());
        } catch (IOException e) {
            e.printStackTrace(); 
        }

        chessPane.setOnMouseClicked(new PlayAction(fiveChess, chessPane));

        Scene scene = new Scene(chessPane, 800, 700);
        primaryStage.setScene(scene);
        primaryStage.setTitle("五子棋游戏");
        primaryStage.show();
    }
}