package org.example.cloud.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.model.User;
@Mapper
public interface UserMapper {
	List<User> getAllUsers();

	User getUserById(@Param("id") long id);

	long createUser(User user);

	long updateUser(User user);

	void deleteUser(@Param("id") long id);

	Boolean isExistsById(@Param("id") long id);
}
