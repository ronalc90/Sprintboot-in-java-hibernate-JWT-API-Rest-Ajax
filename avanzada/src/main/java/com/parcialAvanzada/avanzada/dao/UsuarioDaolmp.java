package com.parcialAvanzada.avanzada.dao;

import com.parcialAvanzada.avanzada.models.Usuario;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository //Anotacion que hace referencia a la base de datos
@Transactional //poder armar las consultas SQL a la base de datos
public class UsuarioDaolmp implements UsuarioDao{
    @PersistenceContext //referencia a contexto en la BD

    EntityManager entityManager;
    @Override
    public List<Usuario> getUsuarios() {
        String query = "FROM Usuario"; //Consulta sobre hibernate
        return entityManager.createQuery(query).getResultList();

    }

    @Override
    public void eliminar(Long id) {
        Usuario usuario = entityManager.find(Usuario.class,id);
        entityManager.remove(usuario);
    }

    @Override
    public void registrar(Usuario usuario) {
        entityManager.merge(usuario);
    }

    @Override
    public Usuario obtenerUsuarioPorCredenciales(Usuario usuario) {
        String query = "FROM Usuario WHERE email = :email"; //Clase usuarios la representacion de la tabla usuarios
        List<Usuario> lista= entityManager.createQuery(query)
                .setParameter("email",usuario.getEmail())
                .getResultList();

        if (lista.isEmpty()){
            return null; //si la lista que busco en la bd esta vacia devuelve null
        }


        String passwordhash = lista.get(0).getPassword();
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        if (argon2.verify(passwordhash, usuario.getPassword())){
            return lista.get(0);
        }
        return null;


    }
    }



