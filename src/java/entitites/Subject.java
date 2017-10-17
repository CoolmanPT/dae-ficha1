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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

/**
 *
 * @author bruno
 */
@Entity
@NamedQuery(
        name = "getAllSubjects",
        query = "SELECT e FROM Subject e ORDER BY e.course, e.scholaryear DESC, e.courseYear DESC, e.name"
)
@Table(name = "SUBJECTS",
uniqueConstraints = @UniqueConstraint(columnNames = {"NAME, COURSE_CODE,SCHOLARYEAR"}))
public class Subject implements Serializable {

    @Id
    private int code;

    @NotNull
    private String name;

    
    @ManyToOne
    @JoinColumn(name = "COURSE_CODE")
    @NotNull
    private Course course;

    
    @NotNull
    private int courseYear;

    @NotNull
    private String scholaryear;

    @NotNull
    @ManyToMany
    @JoinTable(name = "SUBJECTS_STUDENTS",
            joinColumns
            = @JoinColumn(name = "SUBJECT_CODE", referencedColumnName = "CODE"),
            inverseJoinColumns
            = @JoinColumn(name = "STUDENT_USERNAME", referencedColumnName = "USERNAME"))
    private LinkedList<Student> students;
    
    @NotNull
    @ManyToMany
    @JoinTable(name = "SUBJECTS_TEACHERS",
            joinColumns
            = @JoinColumn(name = "SUBJECT_CODE", referencedColumnName = "CODE"),
            inverseJoinColumns
            = @JoinColumn(name = "TEACHER_USERNAME", referencedColumnName = "USERNAME"))
    private LinkedList<Student> teachers;

    public LinkedList<Student> getTeachers() {
        return teachers;
    }

    public void setTeachers(LinkedList<Student> teachers) {
        this.teachers = teachers;
    }

    public Subject() {
    }

    public Subject(int code, String name, int courseYear, Course course, String scholaryear) {
        this.code = code;
        this.name = name;
        this.course = course;
        this.courseYear = courseYear;
        this.scholaryear = scholaryear;
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

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getCourseYear() {
        return courseYear;
    }

    public void setCourseYear(int courseYear) {
        this.courseYear = courseYear;
    }

    public String getScholaryear() {
        return scholaryear;
    }

    public void setScholaryear(String scholaryear) {
        this.scholaryear = scholaryear;
    }

    public LinkedList<Student> getStudents() {
        return students;
    }

    public void setStudents(LinkedList<Student> students) {
        this.students = students;
    }
    
    

    
}
