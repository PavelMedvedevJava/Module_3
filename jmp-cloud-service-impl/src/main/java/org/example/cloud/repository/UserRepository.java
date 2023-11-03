package org.example.cloud.repository;

import java.util.List;
import lombok.AllArgsConstructor;
import org.example.cloud.dao.mapper.UserMapper;
import org.example.model.User;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class UserRepository {

	private final UserMapper mapper;

	public List<User> getAllUsers() {
		return mapper.getAllUsers();
	}

	public User getUserById(long id) {
		return mapper.getUserById(id);
	}

	public long createUser(User user) {
		return mapper.createUser(user);
	}

	public long updateUser(User user) {
		return mapper.updateUser(user);
	}

	public void deleteUser(long id) {
		mapper.deleteUser(id);
	}

	public Boolean isExistsById(long id) {
		return mapper.isExistsById(id);
	}
}
