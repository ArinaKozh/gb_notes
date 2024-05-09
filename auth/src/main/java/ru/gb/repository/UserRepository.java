package ru.gb.repository;

import ru.gb.model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<MyUser, Long> {

    /**
     * Поиск пользователя по имени
     *
     * @param username имя пользователя
     * @return Optional<MyUser>
     */
    Optional<MyUser> findByName(String username);


    /**
     * Проверка, существует ли пользователь по id
     *
     * @param id id пользователя
     * @return boolean
     */
    boolean existsById(Long id);

    /**
     * Проверка, существует ли пользователь по имени
     *
     * @param name имя пользователя
     * @return boolean
     */
    boolean existsByName(String name);
}
