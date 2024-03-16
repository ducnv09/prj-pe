/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.ArrayList;
import java.util.List;
import model.Instructors;
import model.Students;
import java.sql.*;
import model.Subjects;

/**
 *
 * @author Asus
 */
public class StudentDAO extends DBContext {

    private final SubjectDAO sudb = new SubjectDAO();
    
    public List<Students> getAllStudentBySubject(String suid) {
        String sql = "select * from Students ";
//                    + " inner join Subjects on Students.SubjectID = Subjects.SubjectID ";
        List<Students> list = new ArrayList<>();
        if (suid != null) {
            sql += " where SubjectID = '" + suid + "'";
        }
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Students s = new Students();
                s.setStudentID(rs.getString("StudentID"));
                s.setStudentName(rs.getString("StudentName"));
                s.setBirthDate(rs.getDate("BirthDate"));
                s.setGender(rs.getBoolean("Gender"));
                Subjects su = this.sudb.getSubjectById(rs.getString("SubjectID"));
                s.setSubject(su);
                list.add(s);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    public List<Students> getAllStudent() {
        String sql = "select * from Students ";
        List<Students> list = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Students s = new Students();
                s.setStudentID(rs.getString("StudentID"));
                s.setStudentName(rs.getString("StudentName"));
                s.setBirthDate(rs.getDate("BirthDate"));
                s.setGender(rs.getBoolean("Gender"));
                Subjects su = this.sudb.getSubjectById(rs.getString("SubjectID"));
                s.setSubject(su);
                list.add(s);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    public Students getStudentById(String id) {
        String sql = "select * from Students where StudentID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Students s = new Students();
                s.setStudentID(rs.getString("StudentID"));
                s.setGender(rs.getBoolean("Gender"));
                s.setBirthDate(rs.getDate("BirthDate"));
                s.setStudentName(rs.getString("StudentName"));
                Subjects su = this.sudb.getSubjectById(rs.getString("SubjectID"));
                s.setSubject(su);
                return s;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
}
