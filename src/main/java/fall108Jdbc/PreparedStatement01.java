package fall108Jdbc;

import java.sql.*;


public class PreparedStatement01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","luzumsuz71");
        Statement st = con.createStatement();

        //1.example:Update the number of employees to 9999 if the company name is IBM  by using prepared statement.
        //1.step:Create prepared statement query
        String sql1 ="Update companies Set number_of_employees = ? Where company= ?";
       //2.step:Create  PreparedStatement Object
       PreparedStatement pst1 = con.prepareStatement(sql1);
       //3.step: Set the values for ? marks
       pst1.setInt(1,9999); //bu iki pst1 soru isarelerinin oldugu yer iicn 1->? soru isaretinin 1.si allataki 2 ->?
       pst1.setString(2,"IBM");
       //4.step:Execute the query
       int numOfUpdateRecs = pst1.executeUpdate();
        System.out.println("numOfUpdateRecs =" + numOfUpdateRecs );

        String sql2="Select * From companies";
        ResultSet result1= st.executeQuery(sql2);
         while(result1.next()){
             System.out.println(result1.getInt(1)+"->"+result1.getString(2)+ "-"+ result1.getInt(3));
         }

        pst1.setInt(1,5555);
        pst1.setString(2,"GOOGLE");

        int numOfRecordsUpdated2 = pst1.executeUpdate();
        System.out.println("numOfRecordsUpdated2 = " + numOfRecordsUpdated2);

        ResultSet resultSet2 = st.executeQuery(sql2);
        while (resultSet2.next()) {
            System.out.println(resultSet2.getInt("company_id") + "--" + resultSet2.getString("company") + "--" + resultSet2.getInt("number_of_employees"));
        }






        con.close();
        st.close();
    }
}
