import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConn 
{
	Connection cn=null;
	
	public Connection getConn() throws SQLException, ClassNotFoundException
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+"To_Do_list","root","admin");
			return cn;
		}
		catch(Exception e)
		{
			return null;
		}

		
	}

}

