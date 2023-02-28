package com.platzi.market.persistence;

import com.platzi.market.domain.User;
import com.platzi.market.domain.repository.UserRepository;
import com.platzi.market.persistence.crud.UsuarioCrudRepository;
import com.platzi.market.persistence.entity.Usuario;
import com.platzi.market.persistence.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UsuarioRepository implements UserRepository {

    @Autowired
    private UsuarioCrudRepository usuarioCrudRepository;

    @Autowired
    private UserMapper mapper;

    @Override
    public List<User> getAll() {
        List<Usuario> usuarios = (List<Usuario>) usuarioCrudRepository.findAll();
        return mapper.toUsers(usuarios);
    }

    @Override
    public Optional<User> getUser(String userId) {
        return usuarioCrudRepository.findById(userId).map(usuario -> mapper.toUser((usuario)));
    }

    @Override
    public Optional<User> getUserLogin(String email, String password) {
        return usuarioCrudRepository.findByEmailAndPassword(email, password).map(usuario -> mapper.toUser(usuario));
    }

    @Override
    public User save(User user) {
        Usuario usuario = mapper.toUsuario(user);
        return mapper.toUser(usuarioCrudRepository.save(usuario));
    }

    @Override
    public void delete(String userId) {
    usuarioCrudRepository.deleteById(userId);
    }
}
