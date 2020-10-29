/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentprojects.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import studentprojects.model.Student;

/**
 *
 * @author 503
 */
public class MainDao extends ConnectDatabase{

    public MainDao() {
        super();
    }
    public boolean addStudent(Student stu){
        boolean isSuccess = false;
        String sql = "insert into tblStudent(_name,year_of_birth,place_of_birth,classroom) values(?,?,?,?)";
        try {
            PreparedStatement pre = super.getConnection().prepareStatement(sql);
            pre.setString(1, stu.getName());
            pre.setInt(2, stu.getYearOfBirth());
            pre.setString(3, stu.getPlaceOfBirth());
            pre.setString(4, stu.getClassroom());
            int result = pre.executeUpdate();
            if(result == 1){
                isSuccess = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isSuccess;
    }
    public ArrayList<Student> searchStudentByName(String s){
         ArrayList<Student> listStu = new ArrayList<>();
        String sql = "select * from tblstudent where _name like ?";
        try {
            
            PreparedStatement stm = super.getConnection().prepareStatement(sql);
            stm.setString(1, "%"+s+"%");
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("_name");
                int yOB = rs.getInt("year_of_birth");
                String pOB = rs.getString("place_of_birth");
                String classroom = rs.getString("classroom");
                Student stu = new Student(id, name, yOB, pOB, classroom);
                listStu.add(stu);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listStu;
    }
     public ArrayList<Student> searchStudentByYear(int yearOfBirth){
         ArrayList<Student> listStu = new ArrayList<>();
        String sql = "select * from tblstudent where year_of_birth = ?";
        try {
            
            PreparedStatement stm = super.getConnection().prepareStatement(sql);
            stm.setInt(1, yearOfBirth);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("_name");
                int yOB = rs.getInt("year_of_birth");
                String pOB = rs.getString("place_of_birth");
                String classroom = rs.getString("classroom");
                Student stu = new Student(id, name, yOB, pOB, classroom);
                listStu.add(stu);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listStu;
    }
}
