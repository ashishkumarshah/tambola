package com.phodu.tambola.ticket.manage;

import com.phodu.tambola.board.TambolaBoard;
import com.phodu.tambola.profile.Profile;
import com.phodu.tambola.ticket.TambolaTicket;
import com.phodu.tambola.ticket.data.TicketDAO;

public class TicketManagementService {
	private static TicketDAO  ticketRepository = new TicketDAO();
	
	public static long createTicket(TambolaBoard tambolaBoard, Profile profile) {
		int[][] ticket = TicketGeneratorService.generate();
		TambolaTicket tambolaTicket = new TambolaTicket(tambolaBoard, profile, ticket[0], ticket[1], ticket[2]);
		ticketRepository.create(tambolaTicket);
		return tambolaTicket.getId();
	}

	public static TambolaTicket loadTicket(long ticketId) {
		return ticketRepository.load(ticketId);
	}
}
