/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import entitites.Course;
import entitites.Student;
import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author bruno
 */
@Stateless
public class StudentBean {

    @PersistenceContext
    private EntityManager entityManager;

    public void createStudent(String username, String password, String nome, String email, int course_id) {
        try {
            Course c = entityManager.find(Course.class, course_id);
            if (c != null) {
                Student student = new Student(username, password, nome, email, entityManager.find(Course.class, course_id));
            entityManager.persist(student);
            }
            
            
        } catch (EJBException e) {
            throw new EJBException(e.getMessage());
        }

    }

    public void removeStudent(String username) {
        try {
            Student student = entityManager.find(Student.class, username);
            entityManager.remove(student);
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }
    
    
    
    public List<Student> getAll() {
        try {
            List<Student> students = entityManager.createNamedQuery("getAllStudents").getResultList();
            return students;
        } catch (Exception e) {
            return null;
        }
    }
    
    public void update(Student s) {
        try {
            Student student = entityManager.find(Student.class, s.getUsername());
            student.setPassword(s.getPassword());
            student.setNome(s.getNome());
            student.setEmail(s.getEmail());
            student.setCourse(entityManager.find(Course.class, s.getCourse().getCode()));
            entityManager.merge(student);
            
        } catch (EJBException e) {
            throw new EJBException(e.getMessage());
        }
    }

}
