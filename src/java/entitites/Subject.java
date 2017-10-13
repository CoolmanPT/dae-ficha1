/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitites;

import java.io.Serializable;
import java.util.LinkedList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 *
 * @author bruno
 */
@Entity
public class Subject implements Serializable {

    @Id
    private Long id;
    
    @NotNull
    private String name;
    
    @NotNull
    private Course course;
    
    @NotNull
    private int courseYear;
    
    @NotNull
    private String scholaryear;
    
    @NotNull
    private LinkedList<Student> students;

    
}
