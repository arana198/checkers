package com.checkers.model;


public class NormalPiece extends Piece {

	private static final long serialVersionUID = 3133442014213094909L;

	public enum PieceMovement {
		POSITIVE, NEGATIVE;
	}
	
	private PieceMovement pieceMovement;
	
	public NormalPiece(PieceMovement pieceMovement, PieceColour pieceColour, int posX, int posY){
		super(pieceColour, posX, posY);
		this.pieceMovement = pieceMovement;
	}	

	public PieceMovement getPieceMovement() {
		return pieceMovement;
	}

	public void setPieceMovement(PieceMovement pieceMovement) {
		this.pieceMovement = pieceMovement;
	}
	
	@Override
	public String toString() {
		return "com.checkers.model.NormalPiece [pieceColour=" + getPieceColour() + ", posX=" + getX()
				+ ", posY=" + getY() + "]";
	}
}
