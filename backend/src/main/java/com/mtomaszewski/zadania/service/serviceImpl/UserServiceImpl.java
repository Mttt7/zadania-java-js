package com.mtomaszewski.zadania.service.serviceImpl;

import com.mtomaszewski.zadania.model.User;
import com.mtomaszewski.zadania.repository.UserRepository;
import com.mtomaszewski.zadania.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User getUserByName(String name){
        return userRepository.findByName(name).orElseGet(
                ()-> createNewUser(name)
        );
    }

    private User createNewUser(String name) {
        User user = new User();
        user.setName(name);
        return userRepository.save(user);
    }

}
