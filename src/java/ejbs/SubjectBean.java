/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import entitites.Course;
import entitites.Subject;
import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Bruno
 */
@Stateless
public class SubjectBean {

    @PersistenceContext
    private EntityManager em;

    public void createSubject(int code, String name, int courseCode, int courseYear, String scholarYear) {
        try {
            Course c = em.find(Course.class, courseCode);
            if (c != null) {
                Subject subject = new Subject(code, name, courseYear,c, scholarYear);
                em.persist(subject);
            }
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }

    }

    public List<Subject> getAll() {
        try {
            List<Subject> subject = em.createNamedQuery("getAllSubjects").getResultList();
            return subject;
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }
}
