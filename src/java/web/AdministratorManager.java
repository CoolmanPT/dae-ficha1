/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import ejbs.StudentBean;
import entitites.Student;
import javax.faces.event.ActionEvent;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIParameter;
import org.jboss.logging.Logger;

/**
 *
 * @author bruno
 */

@ManagedBean
@SessionScoped
public class AdministratorManager {
    
    @EJB
    private StudentBean studentBean;
    
    private static final Logger logger = Logger.getLogger("web.StudentManager");
    private String newStudentUsername;
    private String newStudentPassword;
    private String newStudentName;
    private String newStudentEmail;
    private int newStudentCourse;
    
    private Student currentStudent;

    public StudentBean getStudentBean() {
        return studentBean;
    }

    public void setStudentBean(StudentBean studentBean) {
        this.studentBean = studentBean;
    }

    public Student getCurrentStudent() {
        return currentStudent;
    }

    public void setCurrentStudent(Student currentStudent) {
        this.currentStudent = currentStudent;
    }

    /**
     * Creates a new instance of AdministratorManager
     */
    public AdministratorManager() {
    }

    public String CreateStudent() {
        try {
            studentBean.createStudent(newStudentUsername, newStudentPassword, newStudentName, newStudentEmail, newStudentCourse);
            ClearNewStudent();
            getAllStudents();
            return "index?faces-redirect=true";
        } catch (Exception e) {
            return "Error";
        }
    }
    
    public String UpdateStudent() {
        try {
            studentBean.update(currentStudent);
            return "index?faces-redirect=true";
        } catch (Exception e) {
            return e.getMessage();
        }
        
    }
    
    public void RemoveStudent(ActionEvent event) {
        try {
            UIParameter param = (UIParameter) event.getComponent().findComponent("deleteStudentId");
        String id = param.getValue().toString();
        
        studentBean.removeStudent(id);
        } catch (Exception e) {
        }
        
    }
    
    private void ClearNewStudent() {
        newStudentUsername = null;
        newStudentPassword = null;
        newStudentName = null;
        newStudentEmail = null;
    }
    
    public List<Student> getAllStudents() {
        return studentBean.getAll();
    }
    
    /**
     * @return the newStudentUsername
     */
    public String getNewStudentUsername() {
        return newStudentUsername;
    }

    /**
     * @param newStudentUsername the newStudentUsername to set
     */
    public void setNewStudentUsername(String newStudentUsername) {
        this.newStudentUsername = newStudentUsername;
    }

    /**
     * @return the newStudentPassword
     */
    public String getNewStudentPassword() {
        return newStudentPassword;
    }

    /**
     * @param newStudentPassword the newStudentPassword to set
     */
    public void setNewStudentPassword(String newStudentPassword) {
        this.newStudentPassword = newStudentPassword;
    }

    /**
     * @return the newStudentName
     */
    public String getNewStudentName() {
        return newStudentName;
    }

    /**
     * @param newStudentName the newStudentName to set
     */
    public void setNewStudentName(String newStudentName) {
        this.newStudentName = newStudentName;
    }

    /**
     * @return the newStudentEmail
     */
    public String getNewStudentEmail() {
        return newStudentEmail;
    }

    /**
     * @param newStudentEmail the newStudentEmail to set
     */
    public void setNewStudentEmail(String newStudentEmail) {
        this.newStudentEmail = newStudentEmail;
    }
    
}
