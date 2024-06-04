package com.mtomaszewski.zadania;

import com.mtomaszewski.zadania.repository.UserRepository;
import com.mtomaszewski.zadania.model.User;
import static org.mockito.Mockito.*;

import com.mtomaszewski.zadania.service.serviceImpl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

@SpringBootTest
public class UserServiceTest {
    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        when(userRepository.findByName("existingUser")).thenReturn(Optional.of(new User()));
        when(userRepository.findByName("newUser")).thenReturn(Optional.empty());
        when(userRepository.save(any(User.class))).thenAnswer(invocation -> {
            User user = invocation.getArgument(0);
            user.setId(1L);
            return user;
        });
    }

    @Test
    public void getUserByName_existingUser() {
        User user = userService.getUserByName("existingUser");
        assertNotNull(user);
        verify(userRepository, times(1)).findByName("existingUser");
    }

    @Test
    public void getUserByName_newUser() {
        User user = userService.getUserByName("newUser");
        assertNotNull(user);
        verify(userRepository, times(1)).findByName("newUser");
        verify(userRepository, times(1)).save(any(User.class));
    }
}
