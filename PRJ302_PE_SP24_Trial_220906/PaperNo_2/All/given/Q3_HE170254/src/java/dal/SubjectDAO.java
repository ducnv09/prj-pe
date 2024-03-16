/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.List;
import model.Subjects;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author Asus
 */
public class SubjectDAO extends DBContext{
    public List<Subjects> getAllSubject() {
        String sql = "select * from Subjects";
        List<Subjects> list = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {                
                Subjects s = new Subjects();
                s.setSubjectID(rs.getString(1));
                s.setSubjectName(rs.getString(2));
                list.add(s);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    public Subjects getSubjectById(String id) {
        String sql = "select * from Subjects where SubjectID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Subjects s = new Subjects();
                s.setSubjectID(rs.getString("SubjectID"));
                s.setSubjectName(rs.getString("SubjectName"));
                return s;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
}
