package fall108Jdbc;
import java.sql.*;
public class ExecuteQuery01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","luzumsuz71");
        Statement st = con.createStatement();

        //Find the name and salary of the worker whose salary is the second highest from the workers table
        // 1.way:
        String sql1 ="select worker_name , worker_salary from workers order by worker_salary desc offset 1 row fetch next 1 row only;";
        ResultSet result1 = st.executeQuery(sql1);

        while(result1.next()){
            System.out.println(result1.getString(1) + "->"+ result1.getInt(2));
        }
       //2.example   1)Find all values less than max
       //              2)Find the maximum among the values less than maximum
        /*Worker_salary
        21000
        18000------>Values less than the maximum
        12000
        10000
        */

   String sql2 ="select company, number_of_employees from companies where number_of_employees = (select max (number_of_employees) from companies where  number_of_employees < (select max (number_of_employees) from companies))";

   ResultSet result2 = st.executeQuery(sql2);

   while(result2.next()){
       System.out.println(result2.getString(1)+"->"+result2.getInt(2));
   }

   // 3.example : Find the company names and number of employees whose number of employees is less than the average  number of employees

        String sql3 ="select company, number_of_employees\n" +
                " from companies where number_of_employees < (Select Avg(number_of_employees) from companies)";

       ResultSet result3 =st.executeQuery(sql3);
        while(result3.next()){
            System.out.println(result3.getString(1)+"--"+ result3.getInt(2));

        }
     con.close();
     st.close();
    result1.close();
    result2.close();
    result3.close();
    }
}
