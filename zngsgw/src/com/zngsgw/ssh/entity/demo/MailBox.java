package com.zngsgw.ssh.entity.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_mailbox")
public class MailBox {

	private int id;
	private String mailBox;
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public String getMailBox() {
		return mailBox;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setMailBox(String mailBox) {
		this.mailBox = mailBox;
	}
	
	
}
