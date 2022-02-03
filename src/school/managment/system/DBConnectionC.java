/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school.managment.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author wku-cslab
 */
public class DBConnectionC {

    private static final String url = "jdbc:mysql://localhost:3306/school_management";
    private static final String user = "root";
    private static final String password = "";

    public static Connection connMethod() throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = null;

        try {
            con = DriverManager.getConnection(url, user, password);
            //JOptionPane.showMessageDialog(null, "connected");

        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, "Error: " + ex);
        }
        return con;
    }
    public static void main(String[] args) throws ClassNotFoundException {
        Connection conn = connMethod();
        if (conn == null){
    System.out.println("not connected...");
}
else{
        System.out.println("connected...");

}
    }
}
