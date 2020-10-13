import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection
	{

		public static void main(String[] args) throws SQLException
			{
				// TODO Auto-generated method stub
				String host = "localhost";
				String port = "3306";
				Connection con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/student", "root",
						"root");
				System.out.println("*****Connection Established*****");
				Statement st = con.createStatement();
				//ResultSet set1=st.executeQuery("insert into stud values(1,'KKK','KOP')");
				//System.out.println("Data Inserted");
				ResultSet set = st.executeQuery("select * from stud where name='srushti'");
				System.out.println("Select Query Fired");
				
				while(set.next())
					{
				System.out.println(set.getInt("id"));
				System.out.println(set.getString("name"));
				System.out.println(set.getString("location"));
					}

			}

	}
