package ru.milkparts.web.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.milkparts.web.exceptions.UserAlreadyExistException;
import ru.milkparts.web.models.DTOs.UserRegistrationDTO;
import ru.milkparts.web.models.User;
import ru.milkparts.web.repositories.UserRepository;
import ru.milkparts.web.services.UserService;
import ru.milkparts.web.utils.UserMapper;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    /**
     * Locates the user based on the username. In the actual implementation, the search
     * may possibly be case sensitive, or case insensitive depending on how the
     * implementation instance is configured. In this case, the <code>UserDetails</code>
     * object that comes back may have a username that is of a different case than what
     * was actually requested..
     *
     * @param username the username identifying the user whose data is required.
     * @return a fully populated user record (never <code>null</code>)
     * @throws UsernameNotFoundException if the user could not be found or the user has no
     *                                   GrantedAuthority
     */

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User ‘" + username + "’ not found");
        }

        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .disabled(!user.getVerified())
                .accountExpired(false)
                .accountLocked(false)
                .roles(user.getUserRole())
                .build();
    }

    @Transactional
    public User verifyUser(String username) {
        User user = repository.findByUsername(username);
        user.setVerified(true);
        return save(user);
    }

    @Override
    @Transactional
    public User registerNewUserAccount(UserRegistrationDTO userDto) throws UserAlreadyExistException {
        if (emailExists(userDto.getEmail())) {
            throw new UserAlreadyExistException("There is an account with that email address: "
                    + userDto.getEmail());
        }

        if (usernameExists(userDto.getUsername())) {
            throw new UserAlreadyExistException("There is an account with that username: "
                    + userDto.getUsername());
        }

        final User user = UserMapper.toUser(userDto, passwordEncoder);
        return save(user);
    }

    private User save(User user) {
        return repository.save(user);
    }

    private boolean emailExists(String email) {
        return repository.findByEmail(email) != null;
    }

    private boolean usernameExists(String username) {
        return repository.findByUsername(username) != null;
    }
}
