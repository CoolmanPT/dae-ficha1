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
           
           courseBean.createCourse(9119, "Engenharia Informatica-D");
           courseBean.createCourse(9115, "Engenharia Informatica-PL");
           
           studentBean.createStudent("11", "11", "aa", "aa@aa.com", 9119);
           studentBean.createStudent("22", "22", "bb", "bb@bb.com", 9119);
           studentBean.createStudent("33", "33", "cc", "cc@cc.com", 9119);
           studentBean.createStudent("44", "44", "dd", "dd@dd.com", 9119);
           studentBean.createStudent("55", "5", "ee", "ee@ee.com", 9115);
           
           
           
           
           
           
           
       } catch (EJBException e) {
           System.out.println("Error!!!" + e.getMessage());
       }
   }
    
    
}
