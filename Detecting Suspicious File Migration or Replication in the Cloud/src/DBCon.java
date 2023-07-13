import java.sql.Connection;
import java.sql.DriverManager;


public class DBCon 
{
	static Connection con;
	public Connection getConnection()
	{
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/b22","root","root");
		
		System.out.println("Connected");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
		
	}
	
	public static void main(String[] args) {
		System.out.println(new DBCon().getConnection());
	}

}
