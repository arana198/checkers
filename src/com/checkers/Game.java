package com.checkers;

import java.io.Serializable;

import com.checkers.exception.IllegalMoveException;
import com.checkers.model.Board;
import com.checkers.model.NormalPiece;
import com.checkers.model.NormalPiece.PieceMovement;
import com.checkers.model.Piece;
import com.checkers.model.Piece.PieceColour;
import com.checkers.model.Square;
import com.checkers.model.Square.BackgroundColour;
import com.checkers.validator.MoveValidator;
import com.checkers.validator.MoveValidatorImpl;

public class Game implements Serializable {

	private static final long serialVersionUID = 5135181223671226662L;
	
	private Board board;
	private MoveValidator moveValidator;
	
	public Game(){
		board = new Board();
		moveValidator = new MoveValidatorImpl(board);
		setupGame();
	}
	
	private void setupGame(){
		Square[][] square = board.getSquares();
		
		//Setup BLACK piece
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < square[i].length; j++){
				if(square[i][j].getBackgroundColour() == BackgroundColour.LIGHT){
					NormalPiece normalPiece = new NormalPiece(PieceMovement.POSITIVE, PieceColour.BLACK, i, j);
					square[i][j].setPiece(normalPiece);
				}
			}
		}
		
		//Setup RED piece
		for(int i = square.length - 1; i > square.length - 4; i--){
			for(int j = 1; j < square[i].length; j++){
				if(square[i][j].getBackgroundColour() == BackgroundColour.LIGHT){
					NormalPiece normalPiece = new NormalPiece(PieceMovement.NEGATIVE, PieceColour.RED, i, j);
					square[i][j].setPiece(normalPiece);
				}
			}
		}
	}
	
	public void move(final Piece piece, final int posX, final int posY) throws IllegalMoveException{		
		if(moveValidator.validate(piece, posX, posY)){
			board.getSquares()[piece.getX()][piece.getY()].setPiece(null);
			board.getSquares()[posX][posY].setPiece(piece);
			//check game is finished
		}
		
		throw new IllegalMoveException("Move from posX: " + piece.getX() + " posY: " + piece.getY() 
				+ " to newPosX: " + posX + " newPosY: " + posY + " is not valid");
	}
	
	/*
	public static void main(String[] args){
		Game board = new Game();
		
		JFrame window = new JFrame(); 
		//window.setContentPane(board);
		window.pack();
		window.setSize(600,  600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setVisible(true);    
	}
	
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Color color = this.pieceColour == PieceColour.BLACK ? Color.BLACK : Color.RED;
		g.setColor(color);
		
		int posX = this.x * 64 + 8;
		int posY = this.y * 64 + 8;
		
		g.fillOval(posX, posY, WIDTH, HEIGHT);

		//Draw inner oval of piece
		Color lineColor = this.pieceColour == PieceColour.BLACK ? Color.WHITE : Color.PINK;
		g.setColor(lineColor);
		g.drawOval(posX, posY, WIDTH, HEIGHT);
		g.drawOval(posX + Math.round((WIDTH - WIDTH * 0.75f)/2), posY + Math.round((HEIGHT - HEIGHT * 0.75f)/2), Math.round(WIDTH * 0.75f), Math.round(HEIGHT * 0.75f));
		g.drawOval(posX + Math.round((WIDTH - WIDTH * 0.5f)/2), posY + Math.round((HEIGHT - HEIGHT * 0.5f)/2), Math.round(WIDTH * 0.5f), Math.round(HEIGHT * 0.5f));
		g.drawOval(posX + Math.round((WIDTH - WIDTH * 0.25f)/2), posY + Math.round((HEIGHT - HEIGHT * 0.25f)/2), Math.round(WIDTH * 0.25f), Math.round(HEIGHT * 0.25f));
	}
	 */
}
