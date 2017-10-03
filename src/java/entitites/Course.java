/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitites;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author bruno
 */
@Entity
@Table(name = "COURSES",
uniqueConstraints =
@UniqueConstraint(columnNames = {"NAME"}))

@NamedQuery(
        name = "getAllCourses",
        query = "SELECT e FROM Course e ORDER BY e.name"
)

public class Course implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private int code;

    private String name;
    
    @OneToMany(mappedBy = "course", cascade = CascadeType.REMOVE) 
    private LinkedList<Student> students;

    private void AddStudent(Student student) {
        try {
            students.add(student);

        } catch (Exception e) {
        }
    }

    private void RemoveStudent(Student student) {
        try {
            students.remove(student);
        } catch (Exception e) {
        }
    }

    public Course() {
        this.students = new LinkedList<Student>();
    }

    public Course(int code, String nome) {
        this.students = new LinkedList<Student>();
        this.code = code;
        this.name = nome;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(LinkedList<Student> students) {
        this.students = students;
    }

}
