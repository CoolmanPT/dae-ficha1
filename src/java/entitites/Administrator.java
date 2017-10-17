/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitites;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author bruno
 */
@Entity
public class Administrator extends User implements Serializable {

    public Administrator() {
    }

    public Administrator(String username, String password, String nome, String email) {
        super(username, password, nome, email);
    }

  
    
}
