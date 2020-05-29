package com.phodu.tambola.profile;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.phodu.tambola.ticket.TambolaTicket;

@Entity
public class Profile {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	/**
	 * Profile Id
	 */
	private long id;
	
	private String name = "Ashish";
	
	@OneToMany
	private List<TambolaTicket> tickets;
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	

}
