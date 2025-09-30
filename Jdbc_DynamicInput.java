package JDBC;
import java.io.*;
import java.sql.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Jdbc_DynamicInput {
    public static void main(String[] args) {
        //insert into table value(?,?);
        try {
            //STEP TWO LOAD THE DRIVER :
            Class.forName("com.mysql.cj.jdbc.Driver");

            //creating a connection
            String url ="jdbc:mysql://127.0.0.1:3306/LearningJdbc";
            String userName ="root";
            String password ="password";
            Connection con = DriverManager.getConnection(url,userName,password);

            //CREATING QUERY
            String q = "insert into firsttable (ID,NAME) value (?,?)";

            //GET PREPAREDSTATMENT OBJECT
            PreparedStatement pst = con.prepareStatement(q);

            //set the value of query by taking it from user
            Scanner br = new Scanner(System.in);

            System.out.println("Enter id :");
            int id = br.nextInt();
            System.out.println("Enter name :");
            String Nm = br.next();

            pst.setInt(1,id);
            pst.setString(2,Nm);

            pst.executeUpdate();

            System.out.println("INSERTED "+Nm+" USING PREPARED STATEMENT");
            con.close();

        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
