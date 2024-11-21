package control;

import entity.FiveChess;
import enums.Side;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import view.ChessPane;

import java.io.*;

public class PlayAction implements EventHandler<MouseEvent> {
	private FiveChess fiveChess;
	private ChessPane chessPane;

	public PlayAction(FiveChess fiveChess, ChessPane chessPane) {
		this.chessPane = chessPane;
		this.fiveChess = fiveChess;
	}

	public void handle(MouseEvent event) {
		double cell = fiveChess.getCellLen();
		double x = event.getX();
		double y = event.getY();
		int i =(int)((x-100+cell/2)/cell);
		int j =(int)((y-100+cell/2)/cell);
		try (FileOutputStream out = new FileOutputStream(new File(System.getProperty("user.dir")+"/src/jilu.txt"),true)){
			out.write(new String(fiveChess.getCurrentSide().getDesc()+"("+j+","+i+"\n").getBytes());
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		fiveChess.play(i, j);
		chessPane.drawChess(cell);
		if(!fiveChess.judgeGame(i, j, fiveChess.getCurrentSide()==Side.BLACK?Side.WIHTE:Side.BLACK)) {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("FiveChessGame");
			alert.setHeaderText("提示信息");
			String msg = (fiveChess.getCurrentSide()==Side.BLACK?Side.WIHTE:Side.BLACK).getDesc()+"取得胜利！";
			alert.setContentText(msg);
			try (FileOutputStream out = new FileOutputStream(new File(System.getProperty("user.dir")+"/src/jilu.txt"),true)){
				out.write(msg.getBytes());
			}
			catch (FileNotFoundException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
			alert.showAndWait();
		}
	}
}