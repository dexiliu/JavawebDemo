package com.zngsgw.ssh.service.button;

import java.util.List;

import com.zngsgw.ssh.entity.button.Button;

public interface ButtonServiceI {
	
	//Ôö¼ÓÀ¸Ä¿
	public void save(Button button);
	
	//É¾³ý
	public void delete(Long id);
	
	//
	public void update(Button button);
	
	//
	public Button findById(Long id);
	
	//
	public List<Button> findAllList();
	
}
