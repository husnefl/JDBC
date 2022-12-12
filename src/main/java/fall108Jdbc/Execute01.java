package fall108Jdbc;
import java.sql.*; //1.step:Do import ,it is like having phone machine
public class Execute01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //2.step:Registration to the driver, it is like registering to communication company like At&t
        Class.forName("org.postgresql.Driver");

        //3.step:create a connection with database, it is like calling your friend
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","luzumsuz71");

        //4.step:Create statement, it is like talking with your friend
        Statement st = con.createStatement();

        //5.step: Execute the query, it is like sending your message to your friend
        /*
         execute() method can be used in DDL(Table creation, drop table, alter table) and DQL(Select)
         1)If you use execute() method in DDL you will get false everytime.
         2)If you use execute() method in DQL you will get false or true
         When you use execute() method in DQL, if you get ResultSet Object as return you will get true
         otherwise you will get false.
         */
        String sql1 =  "Create Table workers (worker_id Char(3),worker_name Varchar(50),worker_salary Numeric(7,2))";
        boolean result1  =st.execute(sql1);
        System.out.println("result1 =" +result1);//I got false from here , it means no record returned.

        //2.example ; Alter table by adding worker_address column into the workers table
        String sql2 = "Alter table workers Add workers_address Varchar(50) ";
        boolean result2= st.execute(sql2);
        System.out.println("result2=" + result2);

//        //3.example;
//        String sql3 ="Drop Table workers";
//        boolean result3 =st.execute(sql3);
//        System.out.println("result3 ="+ result3);

       // 7.step:Close the connection, and st
        con.close();
        st.close();
    }
}
/*

      //4. Step: Execute the query
       /*
         execute() method can be used in DDL(Table creation, drop table, alter table) and DQL(Select)
         1)If you use execute() method in DDL you will get false everytime.
         2)If you use execute() method in DQL you will get false or true
         When you use execute() method in DQL, if you get ResultSet Object as return you will get true
         otherwise you will get false.


    // 1.Example: Create a workers table with the columns worker_id,worker_name, worker_salary
    String sql1 ="create table workers(worker_id varchar(50),worker_name varchar(20),worker_salary Int)";
        st.execute(sql1);
                boolean sqlResult =st.execute(sql1);
                System.out.println(sqlResult);

                //2.Example:2.Example: Alter table by adding worker_address column into the workers table
                String sql2 = "alter table workers add worker_address varchar(80)";

                //3.Example= Drop Table
                String sql3= "drop table workers";
                st.execute(sql3);

                //

                //5. Step: Close the connection and statement
                con.close();
                st.close();
                }


                }

 */


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
        con.close();
        st.close();
    }
}



 */