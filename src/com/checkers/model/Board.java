package com.checkers.model;

import java.io.Serializable;
import java.util.Arrays;

import com.checkers.model.Square.BackgroundColour;

public class Board implements Serializable {

	private static final long serialVersionUID = -3619396439702763423L;
	
	private static final int rows = 8;
	private static final int cols = 8;
	
	private Square [][] squares = new Square [rows][cols];
	
	public Board(){
		boolean isLight = true;
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < cols; j++){			
				BackgroundColour colour = isLight ? BackgroundColour.DARK : BackgroundColour.LIGHT;				
				squares[i][j] = new Square(colour, Square.WIDTH * i, Square.HEIGHT * j);
				isLight = !isLight;
			}
						
			isLight = !isLight;
		}
	}

	public Square[][] getSquares() {
		return squares;
	}
	
	public int getRows() {
		return rows;
	}

	public int getCols() {
		return cols;
	}

	@Override
	public String toString() {
		return "com.checkers.model.Board [board=" + Arrays.toString(squares) + "]";
	}
}
