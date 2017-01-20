package createTable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.TestNG;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Test_createTables extends TestNG {
	
	private Connection con = null;
    private Statement stmt = null;
    int result = 0;
    
    
    @BeforeClass
    public void connectDBBeforeTests() throws ClassNotFoundException, SQLException{
    	Class.forName("org.hsqldb.jdbc.JDBCDriver");
        con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb", "SA", "");
        stmt = con.createStatement();
    }
	
	@Test
	public void createTable_t_sys_users(){
	      try {
	         //Class.forName("org.hsqldb.jdbc.JDBCDriver");
	         //con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb", "SA", "");
	         //stmt = con.createStatement();
	         
	         result = stmt.executeUpdate("CREATE TABLE t_sys_users ("
	         		+ "id INT NOT NULL, "
	         		+ "login VARCHAR(255) NOT NULL, "
	         		+ "password VARCHAR(255) NOT NULL, "
	         		+ "PRIMARY KEY (id));"
	        		);
	         System.out.println("Table t_sys_users created successfully");
	      }  catch (SQLException e) {
	         e.printStackTrace(System.out);
	      }
	      
	}
	
	@Test
	public void createTable_t_sys_permissions(){
	      try {
	         //Class.forName("org.hsqldb.jdbc.JDBCDriver");
	         //con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb", "SA", "");
	         
	         
	         result = stmt.executeUpdate("CREATE TABLE t_sys_permissions ("
	         		+ "permissionId INT NOT NULL, "
	         		+ "roleId INT NOT NULL, "
	         		+ "PRIMARY KEY (permissionId));"
	        		);
	         System.out.println("Table t_sys_permissions created successfully");
	      }  catch (SQLException e) {
	         e.printStackTrace(System.out);
	      }
	      
	}
	
	@Test
	public void createTable_t_sys_roles(){
	      try {
	         //Class.forName("org.hsqldb.jdbc.JDBCDriver");
	         //con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb", "SA", "");
	         //stmt = con.createStatement();
	         
	         result = stmt.executeUpdate("CREATE TABLE t_sys_roles ("
	         		+ "userId INT NOT NULL, "
	         		+ "roleId INT NOT NULL, "
	         		+ "PRIMARY KEY (roleId));"
	        		);
	         System.out.println("Table t_sys_roles created successfully");	
	      }  catch (SQLException e) {
	         e.printStackTrace(System.out);
	      }
	      
	}
	
	@Test
	public void createTable_t_sys_enums(){
	      try {
	         //Class.forName("org.hsqldb.jdbc.JDBCDriver");
	         //con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb", "SA", "");
	         //stmt = con.createStatement();
	         
	         result = stmt.executeUpdate("CREATE TABLE t_sys_enums ("
	         		+ "userId INT NOT NULL, "
	         		+ "roleId INT NOT NULL, "
	         		+ "PRIMARY KEY (roleId));"
	        		);
	      System.out.println("Table t_sys_enums created successfully");	
	      }  catch (SQLException e) {
	         e.printStackTrace(System.out);
	      }
	      
	}

}
