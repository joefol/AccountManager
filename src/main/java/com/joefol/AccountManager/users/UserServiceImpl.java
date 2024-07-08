package com.joefol.AccountManager.users;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public User save(UserDto userDto) {

        User user = new User(userDto.getFirstName(), userDto.getLastName(), userDto.getEmail(), userDto.getPassword(), userDto.getRole());
        return userRepository.save(user);
    }
}
