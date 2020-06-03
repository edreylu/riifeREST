/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inmuebles.riife.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Edward Reyes
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User implements Serializable {
    @Id
    @Column(name = "NO_USUARIO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users")
    @SequenceGenerator(name="users", sequenceName="USERS_SEQ", allocationSize = 1)
    private int noUsuario;
    @Column(name = "CLAVE", nullable = false, length = 50)
    private String clave;
    @Column(name = "PASAPORTE", nullable = false, length = 30)
    private String pasaporte;
    @Column(name = "NOMBRE", nullable = false, length = 40)
    private String nombre;
    @Column(name = "APELLIDO_PATERNO", nullable = false, length = 30)
    private String apellidoPaterno;
    @Column(name = "APELLIDO_MATERNO", nullable = true, length = 30)
    private String apellidoMaterno;
    @Column(name = "CORREO", nullable = true, length = 50)
    private String correo;
    @Column(name = "TELEFONO", nullable = true, length = 15)
    private String telefono;
    @Column(name = "IDESTATUS", nullable = false)
    private int idEstatus;
    
}