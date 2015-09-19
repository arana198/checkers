package com.checkers.model;


public class KingPiece extends Piece {

	private static final long serialVersionUID = -2031911489429076920L;

	public KingPiece(PieceColour pieceColour, int posX, int posY){
		super(pieceColour, posX, posY);
	}
	
	@Override
	public String toString() {
		return "com.checkers.model.KingPiece [pieceColour=" + getPieceColour() + ", posX=" + getX()
				+ ", posY=" + getY() + "]";
	}
}
