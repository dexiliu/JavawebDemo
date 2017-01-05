package com.zngsgw.ssh.service.button;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zngsgw.ssh.entity.button.Button;
import com.zngsgw.ssh.repository.button.ButtonRepository;

@Service("buttonService")
@Transactional
public class ButtonService implements ButtonServiceI {

	@Resource
	private ButtonRepository buttonRepository;
	
	public void save(Button button) {
		List<Button> listBut=this.findAllList();
		for(Button butt:listBut){
			if(button.getButtonName()==butt.getButtonName()){
				
			}
		}
	}

	public void delete(Long id) {
		buttonRepository.delete(id);
	}

	public void update(Button button) {
		Button button2=this.findById(button.getId());
		BeanUtils.copyProperties(button, button2);
		buttonRepository.save(button2);
	}

	public Button findById(Long id) {
		Button button=new Button();
		if(id!=null||id!=0){
			button=buttonRepository.findOne(id);
			return button;
		}else{
			return null;
		}
	}

	public List<Button> findAllList() {
		return (List<Button>) buttonRepository.findAll();
	}

}
