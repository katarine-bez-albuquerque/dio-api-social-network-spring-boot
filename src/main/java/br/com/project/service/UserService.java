package br.com.project.service;

import java.util.List;

import br.com.project.model.User;

public interface UserService {
	List<User> findAll();
    User findById(Long id);
    User create(User user);
    User update(User user, Long id);
    void delete(User user, Long id);
}