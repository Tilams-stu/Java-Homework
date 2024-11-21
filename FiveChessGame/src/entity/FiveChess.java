package entity;

import enums.Side;

public class FiveChess {
	public double getWidth(){
		return width;
	}
	public void setWidth(double width){
		this.width = width;
	}
	public double getHeight(){
		return height;
	}
	public void setwidth(double height){
		this.height = height;
	}
	public double getCellLen(){
		return cellLen;
	}
	public void setCellLen(double cellLen){
		this.cellLen = cellLen;
	}
	//private int n;
	private double width;
	private double height;
	private double cellLen;
	private Side currentSide = Side.BLACK;
	public char getFlag(){
		return flag;
	}
	private char flag= ' ';
	private int[][] chess;
	public int[][] getChess() {
		return chess;
	}//??????
	public void setChess(int[][] chess){
		this.chess = chess;
	}
	public Side getCurrentSide(){
		return currentSide;
	}
	public void setCurrentSide(Side currentSide){
		this.currentSide = currentSide;
	}
	public FiveChess(double width,double height,double cellLen){
		this.width=width;
		this.height=height;
		this.cellLen=cellLen;
		chess = new int[(int)height][(int)width];
		for(int i=0;i<height;i++){
			for(int j=0;j<width;j++){
				chess[i][j] = ' ';
			}
		}
	}
	public void play(int x,int y){
		if(chess[x][y] == ' '){
			chess[x][y]=currentSide.getCode();
			changeSide();
		}
	}
	public void changeSide(){
		setCurrentSide(currentSide==Side.BLACK?Side.WIHTE:Side.BLACK);
	}
	public boolean judgeGame(int row,int col,Side chessColor){
		if(rowJudge(row,col,chessColor)&&colJudge(row,col,chessColor)&&mainDiagonalJudge(row,col,chessColor)&&deputyDiagonalJudge(row,col,chessColor))
			return true;
		return false;
	}
	public boolean rowJudge(int row,int col,Side chessColor){
		int count = 0;
		for(int j= col;j<width;j++){
			if(chess[row][j]!=chessColor.getCode())
				break;
			count++;
		}
		for(int j= col-1;j>=0;j--){
			if(chess[row][j]!=chessColor.getCode())
				break;
			count++;
		}
		if(count>=5) return false;
		return true;
	}
	public boolean colJudge(int row,int col,Side chessColor){
		int count = 0;
		for(int i= row;i<height;i++){
			if(chess[i][col]!=chessColor.getCode())
				break;
			count++;
		}
		for(int i= row-1;i>=0;i--){
			if(chess[i][col]!=chessColor.getCode())
				break;
			count++;
		}
		if(count>=5) return false;
		return true;
	}
	public boolean mainDiagonalJudge(int row,int col,Side chessColor){
		int count = 0;
		for(int i=row,j= col;i<height&&j<width;i++,j++){
			if(chess[i][j]!=chessColor.getCode())
				break;
			count++;
		}
		for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--){
			if(chess[i][j]!=chessColor.getCode())
				break;
			count++;
		}
		if(count>=5) return false;
		return true;
	}
	public boolean deputyDiagonalJudge(int row,int col,Side chessColor){
		int count = 0;
		for(int i=row,j=col;i>=0&&j<width;i--,j++){
			if(chess[row][j]!=chessColor.getCode())
				break;
			count++;
		}
		for(int i=row+1,j= col-1;i<height&&j>=0;i++,j--){
			if(chess[row][j]!=chessColor.getCode())
				break;
			count++;
		}
		if(count>=5) return false;
		return true;
	}
}

