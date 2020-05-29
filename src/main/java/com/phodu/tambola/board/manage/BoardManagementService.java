package com.phodu.tambola.board.manage;

import java.util.List;

import com.phodu.tambola.board.FullBoardException;
import com.phodu.tambola.board.InvalidGameException;
import com.phodu.tambola.board.TambolaBoard;
import com.phodu.tambola.board.data.BoardDAO;

public class BoardManagementService {
	private static BoardDAO  boardRepository = new BoardDAO();

	/**
	 * Function to create a new Tambola Board
	 * 
	 * @return Id of the game created
	 */
	public static long createNewBoard() {
		TambolaBoard board = new TambolaBoard();
		boardRepository.create(board);
		return board.getId();
	}

	/**
	 * Function to draw the next number on the board
	 * 
	 * @param gameId Id of the game
	 * @return the drawn number
	 * @throws FullBoardException
	 * @throws InvalidGameException
	 */
	public static int drawNextNumber(long gameId) throws FullBoardException, InvalidGameException {
		TambolaBoard board = boardRepository.load(gameId);
		if (board != null) {
			int drawnNumber = board.drawNextNumber();
			board = boardRepository.update(board);
			return drawnNumber;
		} else {
			throw (new InvalidGameException());
		}

	}

	/**
	 * Function to return the list of drawn numbers on a board
	 * 
	 * @param gameId
	 * @return Drawn numbers on the board
	 * @throws InvalidGameException
	 */
	public static List<Integer> getDrawnNumbers(long gameId) throws InvalidGameException {
		TambolaBoard board = boardRepository.load(gameId);
		if (board != null) {
			return board.getDrawnNumbers();
		} else {
			throw (new InvalidGameException());
		}
	}
	
	public static TambolaBoard loadBoard(long gameId) {
		return boardRepository.load(gameId);
	}
	
	public static void addTicket() {
	}

}
