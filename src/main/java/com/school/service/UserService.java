package com.school.service;

import com.school.security.User;

public interface UserService {
	void save(User user);

    User findByUsername(String username);
}
