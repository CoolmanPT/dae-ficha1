/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitites;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

/**
 *
 * @author bruno
 */
@Entity
public class Teacher extends User implements Serializable {
    
    @NotNull
    private String office;
    
    @NotNull
    @ManyToMany(mappedBy = "teachers")
    private List<Subject> subjects;

    public Teacher() {
        
        subjects = new LinkedList<Subject>();
    }

    public Teacher(String office, String username, String password, String nome, String email) {
        super(username, password, nome, email);
        this.office = office;
        subjects = new LinkedList<Subject>();
    }
    
    
}
