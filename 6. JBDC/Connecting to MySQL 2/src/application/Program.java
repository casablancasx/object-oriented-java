package application;

import db.DB;
import db.DbException;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Program {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try{
            connection = DB.getConnection();
            preparedStatement = connection.prepareStatement(
                    "INSERT INTO seller "
                    + "(Name, Email, Birthdate, Basesalary, DepartmentId)"
                    + "VALUES "
                    + "(?,?,?,?,?)"
            );

            preparedStatement.setString(1,"Jhonny");
            preparedStatement.setString(2,"jhonny@gmail.com");
            preparedStatement.setDate(3,new java.sql.Date(sdf.parse("22/04/1985").getTime()));
            preparedStatement.setDouble(4,1200.00);
            preparedStatement.setInt(5,2);

            int rowsAffected = preparedStatement.executeUpdate();

            System.out.println("DONE, ROWS AFFECTED: " + rowsAffected);


        } catch (SQLException e){
            throw new DbException(e.getMessage());
        } catch (ParseException e){
            e.printStackTrace();
        } finally {
            DB.closeStatement(preparedStatement);
            DB.closeConnection();
        }

    }
}
