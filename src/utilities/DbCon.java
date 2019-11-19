package utilities;


import java.sql.Connection;
import java.sql.DriverManager;

public class DbCon {
static Connection con = null;
	
	public static Connection getConnection() {
		if (con == null) {
			try {

				String url = "jdbc:oracle:thin:@10.101.121.96:1521:xe";
				String user = "batch112019";
				String password = "batch112019";
				Class.forName("oracle.jdbc.driver.OracleDriver"); 
				con = DriverManager.getConnection(url, user, password);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return con;
	}
	
	public static void closeConnection()
	{
		try
		{
			if(con != null && !con.isClosed())
			{
				con.close();
			}
			con = null;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}