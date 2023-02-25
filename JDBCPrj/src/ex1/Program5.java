package ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Program5 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		String title = "주말 경기";
		String content = "마요르카, 도르트문트. 맨시티 경기가 거의 연달아 있습니다. 잠을 잘 수 없습니다..";
				
		
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		String sql = "DELETE NOTICE WHERE WRITER_ID = 'OKAY'";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "SORREL", "olian8982e");
		PreparedStatement st= con.prepareStatement(sql);
				
		int result = st.executeUpdate();
		
		System.out.println(result);
		
		st.close();
		con.close();
		
	} //main
	
}
