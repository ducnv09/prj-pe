/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Customer;

/**
 *
 * @author Asus
 */
public class DAO extends DBContext {

    public List<Customer> getAll() {
        String sql = "select * from Customers";
        List<Customer> list = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Customer c = new Customer();
                c.setCustomerID(rs.getString(1));
                c.setCustomerName(rs.getString(2));
                c.setBirthDate(rs.getDate(3));
                c.setGender(rs.getBoolean(4));
                c.setAddress(rs.getString(5));
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    public List<Customer> getAllByName(String name) {
        String sql = "select * from Customers ";
        List<Customer> list = new ArrayList<>();
        
        if (!name.isEmpty()) {
            sql += " where CustomerName like '%" + name +"%'";
        }
        
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Customer c = new Customer();
                c.setCustomerID(rs.getString(1));
                c.setCustomerName(rs.getString(2));
                c.setBirthDate(rs.getDate(3));
                c.setGender(rs.getBoolean(4));
                c.setAddress(rs.getString(5));
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    public List<Customer> getAllByYear(int year) {
        String sql = "select * from Customers where Year(BirthDate) = ?";
        List<Customer> list = new ArrayList<>();
        
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, year);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Customer c = new Customer();
                c.setCustomerID(rs.getString(1));
                c.setCustomerName(rs.getString(2));
                c.setBirthDate(rs.getDate(3));
                c.setGender(rs.getBoolean(4));
                c.setAddress(rs.getString(5));
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    public void delete(String id) {
        String sql = "delete from Customers where CustomerID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
