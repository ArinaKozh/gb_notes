package ru.gb.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
/*import ru.gb.exceptions.UserAlreadyExistsException;*/
import ru.gb.model.MyUser;
import ru.gb.repository.UserRepository;


@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Сохранение пользователя в репозиторий
     *
     * @param user данные пользователя
     * @throws RuntimeException
     */
public void addUser(MyUser user) {

       if (repository.existsByName(user.getName())) {
        throw new RuntimeException("Пользователь с таким именем уже существует");
    }
    repository.save(user);
}


}
