package com.zngsgw.ssh.service.demo;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zngsgw.ssh.entity.demo.User;
import com.zngsgw.ssh.repository.demo.UserRepository;

@Service("userService")
@Transactional
public class UserService implements UserServiceI {

	@Resource
	private UserRepository userRepository;
	
//	private PasswordHelper passwordHelper;
//	private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
//	public void setRandomNumberGenerator(RandomNumberGenerator randomNumberGenerator) {
//        this.randomNumberGenerator = randomNumberGenerator;
//    }
	


    public void save(User user) {  
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
		userRepository.save(user); 
    }

    public void update(User user) {
		User user2=this.findById(user.getId());
		BeanUtils.copyProperties(user, user2);
		userRepository.save(user2);
	}

    @Transactional(readOnly = true)
	public List<User> findAllList() {
		 return (List<User>) userRepository.findAll();
	}

	public User findById(Long id) {
		User user=userRepository.findOne(id);
		return user;
	}

	public void delete(Long id) {
		userRepository.delete(id);
	}

	public User findByUserName(String userName) {
		return userRepository.findByUserName(userName);
	}
}
