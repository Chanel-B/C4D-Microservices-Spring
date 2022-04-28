package com.user;

import com.user.controller.dbStoreService;
import com.user.model.Users;
import com.user.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class UsersTests {

	private dbStoreService userController;

	@Autowired
	private UserRepository userRepository;

	@Test
	void findAllUsers_test(){
		Users users = new Users();
		Assertions.assertEquals(userRepository.findAll().toString(), "[]" );
	}

	@Test
	void saveUser_test() {
		Users users = new Users();
		users.setId(1);
		users.setUserName("ScofCo");
		users.setEmail("scofield@gmail.mozems");
		users.setPassword("1254978363");
		userRepository.save(users);
		Assertions.assertEquals(userRepository.findAll().toString(), "["+users.toString()+"]" );
	}

	@Test
	void updateUser_test() {
		Users users = new Users();
		users.setId(1);
		users.setUserName("ScofCo");
		users.setEmail("scofield@gmail.mozems");
		users.setPassword("1254978363");
		userRepository.save(users);
		Assertions.assertEquals(userRepository.findAll().toString(), "["+users.toString()+"]" );

		Optional<Users> oldUser = userRepository.findById(users.getId());
		oldUser.get().setId(users.getId());
		oldUser.get().setUserName("ScofCo");
		oldUser.get().setEmail("scofield@gmail.mozems");
		oldUser.get().setPassword("kamer");

		userRepository.save(  oldUser.get() );

		Assertions.assertEquals(userRepository.findAll().toString(), "["+oldUser.get()+"]" );
	}

}
