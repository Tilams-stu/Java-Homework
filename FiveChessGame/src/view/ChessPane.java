package view;

import entity.FiveChess;
import enums.Side;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;


public class ChessPane extends Pane{
	public Canvas canvas;
	public GraphicsContext gc;
	public FiveChess fiveChess;
	public Canvas getCanvas(){
		return canvas;
	}
	public GraphicsContext getGc(){
		return gc;
	}
	public FiveChess getFiveChess(){
		return fiveChess;
	}
	public void setFiveChess(FiveChess fiveChess){
		this.fiveChess = fiveChess;
	}
	public ChessPane(FiveChess fiveChess){
		this.fiveChess = fiveChess;
		double cell = fiveChess.getCellLen();
		drawPane(cell);
		drawChess(cell);
		getChildren().add(canvas);
	}
	public void drawPane(double cell){
		canvas = new Canvas(800,700);
		gc = canvas.getGraphicsContext2D();
		gc.clearRect(0,0,canvas.getWidth(),canvas.getHeight());
		gc.setStroke(Color.BLACK);
		
		for(int i=0;i<fiveChess.getWidth();i++)
			for(int j=0;j<fiveChess.getHeight();j++){
				gc.strokeRect(100+i*cell,100+cell*j,cell,cell);
			}
		
	}
	public void drawChess(double cell){
		int[][] chess = fiveChess.getChess();
		
		for(int i=0;i<fiveChess.getHeight();i++) {
			for(int j=0;j < fiveChess.getWidth();j++) {
				if(chess[i][j]== Side.BLACK.getCode()) {
					gc.setFill(Color.BLACK);
					gc.fillOval(100+i*cell-cell/2,100+j*cell-cell/2,cell,cell);
				}
				else if(chess[i][j]==Side.WIHTE.getCode()) {
					gc.setFill(Color.WHITE);
					gc.fillOval(100+i*cell-cell/2,100+j*cell-cell/2,cell,cell);
					gc.strokeOval(100+i*cell-cell/2,100+j*cell-cell/2,cell,cell);
				}
			}
		}
	}
}
