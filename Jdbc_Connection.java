package JDBC;
//STEP ONE IMPORT JAVA.SQL.*

import java.sql.*;
public class Jdbc_Connection{
    public static void main(String[] args) {
        try {
            //STEP TWO LOAD THE DRIVER :
            Class.forName("com.mysql.cj.jdbc.Driver");

            //creating a connection
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/company","root","password");

            if (con.isClosed()) {
                System.out.println("connection is closed");
            }
            else{
                System.out.println("connection created");
            }
        }
        catch (Exception e){
            System.out.println(e);;
        }
    }
}
