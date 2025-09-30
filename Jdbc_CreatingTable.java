package JDBC;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class Jdbc_CreatingTable {
    public static void main(String[] args) {
        try {
            //STEP TWO LOAD THE DRIVER :
            Class.forName("com.mysql.cj.jdbc.Driver");

            //creating a connection
            String url ="jdbc:mysql://127.0.0.1:3306/LearningJdbc";
            String userName ="root";
            String password ="Password";
            Connection con = DriverManager.getConnection(url,userName,password);

            //CREATING QUERY

            String q = """
                 CREATE TABLE FirstTable( 
                      ID INT(200) UNIQUE AUTO_INCREMENT,
                      NAME VARCHAR(200) NOT NULL
                  );
                 """ ;
            String q2 = """
                       insert into firsttable
                       (ID,NAME)
                       value
                       (101,"Dhruv"),
                       (102,"payas"),
                       (103,"ayush"),
                       (104,"harsh");
                    """ ;
            Statement stat = con.createStatement();
            stat.executeUpdate(q);
            stat.executeUpdate(q2);
            System.out.println("Table Is Created In DataBase....");
            System.out.println("VALUES INSERTED....");


            String q3 = "SELECT * FROM firsttable;";
            Statement sel = con.createStatement();
            ResultSet set = sel.executeQuery(q3);
            while (set.next()){
                int id = set.getInt("ID");
                String name = set.getString("NAME");
                System.out.println("ID AND NAME OF PERSON IS : "+id+" AND "+name);
            }
            con.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
