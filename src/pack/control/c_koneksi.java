/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.control;

import com.sun.istack.internal.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import javax.swing.JOptionPane;

/**
 *
 * @author yobelchris
 */
public class c_koneksi {
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    String sql = null;
    public c_koneksi(){
        try{
           con = DriverManager.getConnection("jdbc:mysql://localhost:3306/toko","root","");
           st = con.createStatement();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Koneksi Database gagal "+ex);
        }
    }
    public static Object getConnection(){
        return null;
    }
    public static Connection setKoneksi(){
        String konString = "jdbc:mysql://localhost:3306/toko";
        Connection koneksi = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            koneksi = (Connection) DriverManager.getConnection(konString,"root","");
            System.out.println("koneksi berhasil");
        }catch(ClassNotFoundException ex){
            Logger.getLogger(c_koneksi.class).log(Level.SEVERE,null,ex);
            System.out.println("koneksi gagal");
        }catch(SQLException ex){
            Logger.getLogger(c_koneksi.class).log(Level.SEVERE,null,ex);
            System.out.println("koneksi gagal");
        }
        return koneksi;
    }
    
    public static ResultSet executeQuery(String SQL){
        ResultSet rs = null;
        Connection koneksi = setKoneksi();
        try{
            Statement st = koneksi.createStatement();
            rs = st.executeQuery(SQL);
        }catch(SQLException ex){
            Logger.getLogger(c_koneksi.class).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public static int execute(String SQL){
        int status = 0;
        Connection koneksi = setKoneksi();
        try{
            Statement st = koneksi.createStatement();
            status = st.executeUpdate(SQL);
        }catch(SQLException ex){
            Logger.getLogger(c_koneksi.class).log(Level.SEVERE,null,ex);
        }
        return status;
    }
}
