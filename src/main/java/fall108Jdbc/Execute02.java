package fall108Jdbc;
import java.sql.*;
public class Execute02 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","luzumsuz71");

        Statement st = con.createStatement();

        //1.example:Select the country names whose region id's are 1
        String sql1= "Select country_name From countries where region_id  =1";
        //If you use execute () method ,you will get just true or false but i want to see the records/
        boolean result1 = st.execute(sql1);
        System.out.println("result1=" + result1);
        //To see the records we have another method which is "executeQuery()"
        ResultSet resultSet1 = st.executeQuery(sql1);

        while(resultSet1.next()){
            System.out.println(resultSet1.getString("country_name"));
        }

        //2.example:Select the country_id and country_name whose region_id's are greater than 2
     String sql2 = "Select country_id, country_name From countries Where region_id>2";
     ResultSet resultSet2 = st.executeQuery(sql2);

     while(resultSet2.next()){
         System.out.println(resultSet2.getString("country_id")+"->" +resultSet2.getString("country_name"));

     }

    //3.example:Select the worker whose salary is the lowest from workers table
     String sql3 = "Select * From workers Where worker_salary = (Select Min(worker_salary)From workers";
     ResultSet resultSet3 =st.executeQuery(sql3);

   while(resultSet3.next()){
       System.out.println(resultSet3.getString("id") +"->" + resultSet3.getString("name"));
   }

        con.close();
        st.close();
        resultSet1.close();
    }
}

/*


        //1.Example: Select the country names whose region id's are 1
        String sql1 ="SELECT country_name FROM countries WHERE region_id = 1";
        //If you use execute() method, you will get true or false as return. But I want to see the records.
        boolean result1 = st.execute(sql1);
        System.out.println("result1 = " + result1);
        //To see the records we have another method which is "executeQuery()".
        ResultSet resultSet1 = st.executeQuery(sql1);

        while (resultSet1.next()){
            System.out.println (resultSet1.getString("country_name"));
        }

        //2.Example: Select the country_id and country_name whose region_id's are greater than 2
        String sql2 ="SELECT country_id, country_name FROM countries WHERE region_id>2";
        ResultSet resultSet2 = st.executeQuery(sql2);

        while (resultSet2.next()){

            System.out.println(resultSet2.getString("country_id")+"->"+resultSet2.getString("country_name"));

        }

        //3.Example: Select all columns whose number_of_employees is the lowest from companies table

        String sql3 = "SELECT * FROM companies WHERE number_of_employees = (SELECT MIN(number_of_employees) FROM companies)";
        ResultSet resultSet3 = st.executeQuery(sql3);

        while (resultSet3.next()){

            System.out.println(resultSet3.getInt(1)+" "+resultSet3.getString(2)+" "+resultSet3.getInt(3));

        }

    }
}




 */