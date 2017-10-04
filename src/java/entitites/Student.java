/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitites;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 *
 * @author bruno
 */
@Entity
@NamedQuery(
        name = "getAllStudents",
        query = "SELECT e FROM Student e ORDER BY e.username"
)
@Table(name = "STUDENTS")
public class Student implements Serializable {

    @Id
    private String username;
    @NotNull
    private String password;
    @NotNull
    private String nome;
    @NotNull
    @Pattern(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\."
            + "[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@"
            + "(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
            message = "{invalid.email}")
    private String email;
    
    @ManyToOne
    @JoinColumn(name = "CODE")
    @NotNull
    public Course course_id;

    

    //EMPTY
    protected Student() {
    }



    //FILLED
    public Student(String username, String password, String nome, String email, int course_id) {
        this.username = username;
        this.password = password;
        this.nome = nome;
        this.email = email;
        this.course_id.setCode(course_id);
    }
    
    public Course getCourse() {
        return course_id;
    }

    public void setCourse(int course_id) {
        this.course_id.setCode(course_id);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" + "username=" + username + ", password=" + password + ", nome=" + nome + ", email=" + email + '}';
    }

}
