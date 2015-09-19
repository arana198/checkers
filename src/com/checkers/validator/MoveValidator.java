package com.checkers.validator;

import com.checkers.exception.IllegalMoveException;
import com.checkers.model.Piece;

public interface MoveValidator {

	public boolean validate(final Piece piece, int posX, int posY) throws IllegalMoveException;
}
