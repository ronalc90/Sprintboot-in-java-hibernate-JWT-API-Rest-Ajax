package com.parcialAvanzada.avanzada.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Comment;

import javax.persistence.*;

@Entity  //Maven lombok para Getter y setters.
@Table(name = "usuarios")
@ToString @EqualsAndHashCode
public class Usuario {


    @Getter @Setter @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Getter @Setter @Column(name = "nombre")
    private String nombre;
    @Getter @Setter@Column(name = "apellido")
    private String apellido;
    @Getter @Setter@Column(name = "email")
    private String email;
    @Getter @Setter@Column(name = "telefono")
    private String telefono;
    @Getter @Setter@Column(name = "password")
    private String Password;


}