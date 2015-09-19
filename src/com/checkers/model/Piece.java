package com.checkers.model;

import java.io.Serializable;

public abstract class Piece implements Serializable {

	private static final long serialVersionUID = 6985015106349703166L;

	public enum PieceColour {
		RED, BLACK;
	}
		
	public static final int WIDTH = 48;
	public static final int HEIGHT = 48;
	
	/** The Color of this Piece */
	protected PieceColour pieceColour;
	
	/** The current x postion on the game board */
	protected int x;
	
	/** The current y postion on the game board */
	protected int y;
	
	/**Initialize a new Piece with the given color and at the given position
	 * 
	 * @param pieceColour	The color of the new Piece
	 * @param x				The x position of the game board this piece lives on
	 * @param y				The y position of the game board this piece lives on
	 */
	public Piece(PieceColour pieceColour, int x, int y){
		this.pieceColour = pieceColour;
		this.x = x;
		this.y = y;
	}
	
	/** Get the color of this piece
	 * 
	 * @return 	The color of this piece
	 */
	public PieceColour getPieceColour() {
		return pieceColour;
	}
	
	/** Get the x position on the game board that this Piece resides on
	 * 
	 * @return		The x position of the game board this Piece resides on
	 */
	public int getX() {
		return x;
	}

	/** Get the y position on the game board that this Piece resides on
	 * 
	 * @return	The y position of the game board that this Piece resides on
	 */
	public int getY() {
		return y;
	}
	
	/** Give this Piece a new position to live on in the game board
	 * 
	 * @param row		The new row for this piece to live on
	 * @param col		The new column for this piece to live on
	 */
	public void setPosition(int row, int col) {
		this.x = row;
		this.y = col;
	}
			
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Piece other = (Piece) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "com.checkers.model.Piece [pieceColour=" + pieceColour + ", posX=" + x
				+ ", posY=" + y + "]";
	}
}
