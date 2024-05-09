package ru.gb.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.gb.model.MyUser;
import ru.gb.model.MyUserDetails;
import ru.gb.repository.UserRepository;


import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    /**
     * Загрузка пользователя из репозитория
     *
     * @param username имя пользователя
     * @return userDetails
     */
    @Override
    public MyUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<MyUser> user = repository.findByName(username);
        MyUserDetails myUserDetails;
        myUserDetails = user.map(MyUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException(username+"not found"));
        return myUserDetails;
    }
}