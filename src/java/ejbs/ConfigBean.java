/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import entitites.Course;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 *
 * @author bruno
 */
@Startup
@Singleton
public class ConfigBean {
    @EJB
    private StudentBean studentBean;
    @EJB
    private CourseBean courseBean;
    
    

   @PostConstruct
   public void populateDB() {
       try {
           studentBean.createStudent("11", "11", "aa", "aa@aa.com", new Course(9119, "EI-D"));
           studentBean.createStudent("22", "22", "bb", "bb@bb.com",new Course(9119, "EI-D"));
           studentBean.createStudent("33", "33", "cc", "cc@cc.com",new Course(9119, "EI-D"));
           studentBean.createStudent("44", "44", "dd", "dd@dd.com",new Course(9119, "EI-D"));
           studentBean.createStudent("55", "5", "ee", "ee@ee.com",new Course(9119, "EI-D"));
           
           courseBean.createCourse(9119, "Engenharia Informatica-D");
           courseBean.createCourse(9115, "Engenharia Informatica-PL");
           
           
           
           
           
       } catch (EJBException e) {
           System.out.println("Error" + e.getMessage());
       }
   }
    
    
}
