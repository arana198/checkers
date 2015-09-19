package com.checkers.validator;

import com.checkers.exception.IllegalMoveException;
import com.checkers.model.Board;
import com.checkers.model.NormalPiece;
import com.checkers.model.NormalPiece.PieceMovement;
import com.checkers.model.Piece;
import com.checkers.model.Square;

public class MoveValidatorImpl implements MoveValidator {
	
	private Board board;
	
	public MoveValidatorImpl(final Board board){
		this.board = board;
	}
	
	@Override
	public boolean validate(final Piece piece, int posX, int posY) throws IllegalMoveException{
		if(piece == null){
			throw new IllegalArgumentException("Piece object cannot be null");
		}
		
		if(posX < 0 || posX > board.getRows() - 1 || posY < 0 || posY > board.getCols()){
			return false;
		}
		
		if(validateXAndYMovement(piece, posX, posY) && validateXMovement(piece, posY) 
				&& validateYMovement(piece, posY) 
				&& checkNewPositionIsEmpty(posX, posY) 
				&& validateNewPosition(piece, posX, posY)){
			return true;
		}
		
		return false;
		
	}
	
	/**
	 * Validate the movement is diagonal 
	 * @param piece - Piece being moved
	 * @param posX - The new X position
	 * @param posY - The new Y position
	 * @return
	 */
	private boolean validateXAndYMovement(final Piece piece, final int posX, final int posY){
		final int currentXPos = piece.getX();
		final int currentYPos = piece.getY();
		
		if(Math.abs(currentXPos - posX) == 1 && Math.abs(currentYPos - posY) == 1){
			return true;
		} else if(Math.abs(currentXPos - posX) == 2 && Math.abs(currentYPos - posY) == 2){
			return true;
		}	
		
		return false;
	}
	
	/**
	 * Validate the X-axis movement is greater than 0
	 * @param piece - Piece being moved
	 * @param posX - The new X position
	 * @return
	 */
	private boolean validateXMovement(final Piece piece, final int posX){
		if(posX > piece.getX() || posX < piece.getX()){
			return true;
		} 		
		
		return false;
	}
	
	/**
	 * Validate the Y-axis movement is greater than 0
	 * @param piece - Piece being moved
	 * @param posY - The new Y position
	 * @return
	 */
	private boolean validateYMovement(final Piece piece, final int posY){
		if(piece instanceof NormalPiece){
			final PieceMovement movement = ((NormalPiece) piece).getPieceMovement();
			
			if(movement == PieceMovement.POSITIVE && posY > piece.getY()){
				return true;
			} else if(movement == PieceMovement.NEGATIVE && posY < piece.getY()){
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Check the new position is empty
	 * @param posY - The new X position
	 * @param posY - The new Y position
	 * @return
	 */
	private boolean checkNewPositionIsEmpty(final int posX, final int posY){
		final Square tile = board.getSquares()[posX][posY];
		if(tile.getPiece() == null){
			return true;
		}	
		
		return false;
	}
	
	/**
	 * If movement is 2 squares then check there is an opponent piece being eaten.
	 * If movement is 1 square then return true
	 * otherwise return false 
	 * @param piece - Piece being moved
	 * @param posY - The new X position
	 * @param posY - The new Y position
	 * @return
	 */
	private boolean validateNewPosition(final Piece piece, final int posX, final int posY){
		final int currentXPos = piece.getX();
		final int currentYPos = piece.getY();
		
		if(Math.abs(currentXPos - posX) == 2 && Math.abs(currentYPos - posY) == 2){
			int posXToCheck = currentXPos > posX ? currentXPos - 1 : currentXPos + 1;
			int posYToCheck = currentYPos > posY ? currentYPos - 1 : currentYPos + 1;
			
			Square tile = board.getSquares()[posXToCheck][posYToCheck];
			if(tile.getPiece() != null && tile.getPiece().getPieceColour() != piece.getPieceColour()){
				return true;
			}
		} else if(Math.abs(currentXPos - posX) == 1 && Math.abs(currentYPos - posY) == 1){
			return true;
		}
		
		return false;
	}
}
