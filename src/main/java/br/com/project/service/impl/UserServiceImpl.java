package br.com.project.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.project.exception.ApplicationException;
import br.com.project.model.User;
import br.com.project.repository.UserRepository;
import br.com.project.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User findById(Long id) {
    	return repository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public User create(User user) {
    	if(user.getNome().isEmpty() || user.getNome().equals("")) {
            throw new ApplicationException("Enter a name to continue.");
        }
    	return repository.save(user);
    }

    @Override
    public User update(User user, Long id) {        
        if(user.getId().equals(id) || findById(id) == user) {            
            if(user.getNome().isEmpty() || user.getNome().equals("")) {
                throw new ApplicationException("Enter a name to continue.");
            }
            return repository.save(user);
        }
        else {
            throw new ApplicationException("The user id does not exist.");
        }
    }

    @Override
    public void delete(User user, Long id) {
        if(user.getId().equals(id) || findById(id) == user) {            
            repository.deleteById(id);
        }
        else {
            throw new ApplicationException("The user id does not exist.");
        }
    }    
}