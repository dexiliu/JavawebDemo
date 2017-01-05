package com.zngsgw.ssh.entity.button;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="t_button")
public class Button implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String buttonName;
	private String description;
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	@Column(length=32)
	public String getButtonName() {
		return buttonName;
	}
	@Column(length=1000)
	public String getDescription() {
		return description;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public void setButtonName(String buttonName) {
		this.buttonName = buttonName;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
