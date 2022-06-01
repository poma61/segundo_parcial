
package com.codefix.jc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conection {
      static String driver="com.mysql.jdbc.Driver";
     static String url="jdbc:mysql://localhost:3306/bd_seminarios";
     static String usuario="root";
     static String password="";
    protected Connection conn=null;
    
  public Conection(){
      try {
          Class.forName(driver);
      conn=DriverManager.getConnection(url,usuario,password);    
      
      }catch(Exception ex){
       JOptionPane.showMessageDialog(null,"Error del driver "+ex.getMessage());   
      }
      
  }  
    
   public Connection conectar(){
       return conn;
   } 
    
    public void desconn()
    {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
