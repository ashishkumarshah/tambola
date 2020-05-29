package com.phodu.tambola.ticket.manage;

import org.junit.Test;

import com.phodu.tambola.board.FullBoardException;
import com.phodu.tambola.board.InvalidGameException;
import com.phodu.tambola.board.TambolaBoard;
import com.phodu.tambola.board.manage.BoardManagementService;
import com.phodu.tambola.profile.Profile;
import com.phodu.tambola.profile.manage.ProfileManagementService;
import com.phodu.tambola.ticket.TambolaTicket;

public class TicketManagementTest {

	@Test
	public void test() {
		long gameId = BoardManagementService.createNewBoard();

		TambolaBoard board = BoardManagementService.loadBoard(gameId);

		ProfileManagementService profileManagementService = new ProfileManagementService();
		long profileId = profileManagementService.createProfile();
		Profile profile = profileManagementService.loadProfile(profileId);
		long ticketId = TicketManagementService.createTicket(board, profile);
		TambolaTicket ticket = TicketManagementService.loadTicket(ticketId);

		for (int i = 0; i < 100; i++) {
			int drawnNumber = 0;
			try {
				drawnNumber = BoardManagementService.drawNextNumber(gameId);
			} catch (FullBoardException | InvalidGameException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (ticket.claimNumber(drawnNumber)) {
				System.out.println(drawnNumber);
			}
				
		}

	}

}
