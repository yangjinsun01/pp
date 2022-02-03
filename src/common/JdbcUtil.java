package common;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class JdbcUtil {
   private static JdbcUtil instance = new JdbcUtil();
   
   private static DataSource ds;
   static {
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         System.out.println("Driver.load.Success");
         
         InitialContext ctx = new InitialContext();
         
         ds = (DataSource)ctx.lookup("java:comp/env/jdbc/yrOracle");
         System.out.println("DB POOL Success");
         
      }catch(ClassNotFoundException e) {
         e.printStackTrace();
      }catch(NamingException e) {
         e.printStackTrace();
      }
   }
   
   private JdbcUtil() {};
   
   public static JdbcUtil getInstance() {
      return instance;
   }

   public Connection getConnection() throws SQLException{
      return ds.getConnection();
   }
}