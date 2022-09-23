package com.dxctechproject.busticketbooking.Service.ServiceImpl;

import com.dxctechproject.busticketbooking.Entity.User;
import com.dxctechproject.busticketbooking.Repository.UserRepository;
import com.dxctechproject.busticketbooking.Service.UserService;
import com.dxctechproject.busticketbooking.Util.MailSenderUtil;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
	private MailSenderUtil util;
    
    @Override
    public User save(User user) {
    	 util.sendMail(user.getEmail(), "Hi " + user.getFirst_Name() + " " +
   			  user.getLast_Name() + " Thanks for signing up",
   			  "Welcome!  We are happy to have you on board. \n\n Username: " + user.getEmail()
   			  + "\n\n Password: " + user.getPassword());
        return userRepository.save(user);
    }

    @Override
    public User findByEmailAndPassword(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }
    
    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public void upadatePassword(String password, String email) {
		userRepository.updatePassword(password, email);	
	}
}
