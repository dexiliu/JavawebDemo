package com.zngsgw.ssh.service.button;

import java.util.List;

import com.zngsgw.ssh.entity.button.Button;

public interface ButtonServiceI {
	
	//������Ŀ
	public void save(Button button);
	
	//ɾ��
	public void delete(Long id);
	
	//
	public void update(Button button);
	
	//
	public Button findById(Long id);
	
	//
	public List<Button> findAllList();
	
}
