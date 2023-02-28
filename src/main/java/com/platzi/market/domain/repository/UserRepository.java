package com.platzi.market.domain.repository;

import com.platzi.market.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    List<User> getAll();
    Optional<User> getUser (String userId);

    Optional<User> getUserLogin (String email, String password);

    User save(User user);

    void delete(String userId);
}
