package JDBC;
import java.sql.*;
//Prepared statment
public class Jdbc_PreParedStatment {
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
            String q = "insert into firsttable(ID,NAME) value (?,?)";

            //GET PREPAREDSTATMENT OBJECT
            PreparedStatement pst = con.prepareStatement(q);

            //set the value of query
            int id = 105;
            String Nm = "Bhumika";

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
