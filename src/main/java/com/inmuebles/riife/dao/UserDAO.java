/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inmuebles.riife.dao;

import com.inmuebles.riife.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Edward Reyes
 */
public interface UserDAO extends JpaRepository<User, Integer>{
    
}
