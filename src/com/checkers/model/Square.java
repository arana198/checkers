package com.checkers.model;

import java.io.Serializable;


public class Square implements Serializable {

	private static final long serialVersionUID = 1244220179660498108L;

	public static final int WIDTH = 64;
	public static final int HEIGHT = 64;

	/** The background color that a square should be */
	public enum BackgroundColour {
		LIGHT, DARK;
	}

	/** The Piece that occupies this Square, may be NULL */
	private Piece piece;

	/** The background color of this Square */
	private BackgroundColour backgroundColour;

	/** x position of the rectangle measured from top left corner */
	private int x;

	/** The column of the game board that this square represents */
	private int y;

	@SuppressWarnings("unused")
	private Square() {
	}

	/**
	 * Make a new Square at the given position with the specified
	 * BackgroundColor
	 *
	 * @param backgroundColour - The background color of this Square
	 * @param posX - The x position of this Square
	 * @param posY - The y position of this Square
	 */
	public Square(BackgroundColour backgroundColour, int posX, int posY) {
		this.backgroundColour = backgroundColour;
		this.x = posX;
		this.y = posY;
	}

	/**
	 * Get the piece that occupies this Square
	 * 
	 * @return The piece that occupies this Square, if any
	 */
	public Piece getPiece() {
		return piece;
	}

	/**
	 * Set the occupant of this Square
	 *
	 * @param visitor
	 *            The Piece that should now reside here
	 */
	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	/**
	 * Return whether or not this Square is occupied
	 * 
	 * @return Whether or not this Square is selected
	 */
	public boolean isOccupied() {
		return this.piece != null;
	}

	/** Get the background color of this Square */
	public BackgroundColour getBackgroundColour() {
		return backgroundColour;
	}

	/**
	 * Get the x position of the square measured from top left corner
	 * 
	 * @return The x position on the game board represented by this Square
	 */
	public int getX() {
		return x;
	}

	/**
	 * Get the y position of the square measured from top left corner
	 * 
	 * @return The y position on the game board represented by this Square
	 */
	public int getY() {
		return y;
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
		Square other = (Square) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "com.checkers.model.Square [tileColour=" + backgroundColour + ", posX=" + x + ", posY=" + y + "]";
	}
}
