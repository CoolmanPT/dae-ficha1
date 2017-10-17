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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
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
public class Student extends User implements Serializable {

    public Student() {
    }

    public Student(String username, String password, String nome, String email, Course course) {
        super(username, password, nome, email);
        this.course = course;
    }

    

    @ManyToOne
    @JoinColumn(name = "COURSE_CODE")
    @NotNull
    public Course course;

    @ManyToMany(mappedBy = "students")
    public List<Subject> subjects;

    private void AddSubject(Subject subject) {
        try {
            subjects.add(subject);
        } catch (Exception e) {
        }
    }

    private void RemoveSubject(Subject subject) {
        try {
            subjects.remove(subject);
        } catch (Exception e) {
        }
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "";
    }

}
