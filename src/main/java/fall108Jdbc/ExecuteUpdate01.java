package fall108Jdbc;
import java.sql.*;
public class ExecuteUpdate01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "luzumsuz71");
        Statement st = con.createStatement();

        //1.example :Update The number of employees to 16000 if the number of employees is less than the average number of employees
        String sql1 ="Update companies\n" +
                "Set number_of_employees =16000\n" +
                "where number_of_employees < (Select avg(number_of_employees )From companies)";
        int numOfRecUpdated1= st.executeUpdate(sql1);

        System.out.println("numOfRecUpdate1 =" + numOfRecUpdated1);
        String sql2 = "Select * from companies";
        ResultSet result1 = st.executeQuery(sql2);
         while(result1.next()){
             System.out.println(result1.getInt(1)+"--" + result1.getString(2)+"--"+result1.getInt(3));
         }






   con.close();
   st.close();
    }
}
