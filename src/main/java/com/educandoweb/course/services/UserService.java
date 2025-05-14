package com.educandoweb.course.services;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
import com.educandoweb.course.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        List<User> list = repository.findAll();
        return list;
    }

    public User findById(Long id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User user) {
        return repository.save(user);
    }

    public void delete(Long id) {
        User obj = repository.findById(id).get();
        if (obj != null) {
            repository.delete(obj);
        }
        else {
            throw new IllegalArgumentException("User with ID " + id + " doesn't exist");
        }
    }

    public User update(Long id, User user) {
        User obj = repository.getReferenceById(id);
        updateData(user, obj);
        return repository.save(obj);
    }

    private void updateData(User source, User destination) {
        destination.setName(source.getName());
        destination.setEmail(source.getEmail());
        destination.setPhone(source.getPhone());
        destination.setPassword(source.getPassword());
    }

}
