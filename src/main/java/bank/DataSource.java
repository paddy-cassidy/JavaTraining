package bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.derby.iapi.sql.PreparedStatement;

public class DataSource {

  public static Connection connect() {

    String db_file = "jdbc:sqlite:resources/bank.db";
    Connection connection = null;

    try {
      DriverManager.getConnection(db_file);
      System.out.println("We are connected");
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return connection;

  }

  public static getCustomer(String username){

      String sql = "select * from customers where username =  ?";
      try(Connection connection = connect();
        PreparedStatement statement = connection.PreparedStatement(sql)){

          statement.setString(parameterIndex: 1,username);


      }catch(SQLException e){
        e.printStackTrace();
      }

    }

  public static void main(String[] args) {
    connect();
  }
}
