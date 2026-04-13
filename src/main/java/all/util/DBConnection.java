package all.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
		private static final String URL="jdbc:mysql://localhost:3306/rest";
		private static final String USER="root";
		private static final String PASSWORD="ankit25";
		public static Connection getConnection() throws SQLException, ClassNotFoundException
		{
			Connection con=null;
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(URL,USER,PASSWORD);
//			System.out.println("Connected Successfully");
			return con;
		}
}
