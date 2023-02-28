package com.platzi.market.persistence.crud;

import com.platzi.market.persistence.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioCrudRepository extends CrudRepository<Usuario,String> {
    Optional<Usuario> findByEmailAndPassword(String email, String Password);
}
