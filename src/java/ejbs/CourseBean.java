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
public class CourseBean {

   @PersistenceContext
    private EntityManager entityManager;
   
       public List<Course> getAll() {
        try {
            List<Course> courses = entityManager.createNamedQuery("getAllCourses").getResultList();
            return courses;
        } catch (Exception e) {
            return null;
        }
    }
       
           public void createCourse(int code, String name) {
        try {
            Course course = new Course(code, name);
            entityManager.persist(course);
        } catch (EJBException e) {
            throw new EJBException(e.getMessage());
        }

    }
}
