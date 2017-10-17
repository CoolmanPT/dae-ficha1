/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import ejbs.CourseBean;
import ejbs.StudentBean;
import ejbs.SubjectBean;
import entitites.Course;
import entitites.Student;
import entitites.Subject;
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
    
    @EJB
    private CourseBean courseBean;
    
    @EJB
    private SubjectBean subjectBean;

    public SubjectBean getSubjectBean() {
        return subjectBean;
    }

    public void setSubjectBean(SubjectBean subjectBean) {
        this.subjectBean = subjectBean;
    }

    public CourseBean getCourseBean() {
        return courseBean;
    }

    public void setCourseBean(CourseBean courseBean) {
        this.courseBean = courseBean;
    }

    private static final Logger logger = Logger.getLogger("web.StudentManager");
    private String newStudentUsername;
    private String newStudentPassword;
    private String newStudentName;
    private String newStudentEmail;
    private int newStudentCourse;

    public void setNewStudentCourse(int newStudentCourse) {
        this.newStudentCourse = newStudentCourse;
    }
    private int course_id;

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

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
        newStudentCourse = 0;
    }

    public List<Student> getAllStudents() {
        return studentBean.getAll();
    }
    
    public List<Course> getAllCourses() {
        return courseBean.getAll();
    }
    
    public List<Subject> getAllSubjects(){
        return subjectBean.getAll();
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

    /**
     * @return the newStudentCourse
     */
    public int getNewStudentCourse() {
        return newStudentCourse;
    }

    /**
     * @param newStudentCourse the newStudentCourse to set
     */


}
