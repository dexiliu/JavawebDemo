package com.zngsgw.ssh.service.demo;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zngsgw.ssh.entity.demo.Users;
import com.zngsgw.ssh.repository.demo.UsersRepository;

@Service("usersService")
@Transactional
public class UsersService implements UsersServiceI {

	@Resource
	private UsersRepository usersRepository;
	
//	private PasswordHelper passwordHelper;
//	private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
//	public void setRandomNumberGenerator(RandomNumberGenerator randomNumberGenerator) {
//        this.randomNumberGenerator = randomNumberGenerator;
//    }
	


    public void save(Users users) {  
//    	passwordHelper.encryptPassword(user);
//    	user.setSalt(randomNumberGenerator.nextBytes().toHex());
//
//        String newPassword = new SimpleHash(
//        		"md5",
//                user.getPassword(),
//                ByteSource.Util.bytes(user.getCredentialsSalt()),
//                2).toHex();
//
//
//        user.setPassword(newPassword);
		usersRepository.save(users); 
    }

    public void update(Users users) {
		Users users2=this.findById(users.getId());
		BeanUtils.copyProperties(users, users2);
		usersRepository.save(users2);
	}

    @Transactional(readOnly = true)
	public List<Users> findAllList() {
		 return (List<Users>) usersRepository.findAll();
	}

	public Users findById(Long id) {
		Users users=usersRepository.findOne(id);
		return users;
	}

	public void delete(Long id) {
		usersRepository.delete(id);
	}

	public Users findByUsername(String username) {
		return usersRepository.findByUsername(username);
	}
}
