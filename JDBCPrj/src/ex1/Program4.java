package ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Program4 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		String title = "주말 경기";
		String content = "마요르카, 도르트문트. 맨시티 경기가 거의 연달아 있습니다. 잠을 잘 수 없습니다..";
				
		
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		String sql = "UPDATE NOTICE SET TITLE = ?, CONTENT = ? WHERE WRITER_ID = 'sorrel012'";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "SORREL", "olian8982e");
		PreparedStatement st= con.prepareStatement(sql);
		
		st.setString(1, title);
		st.setString(2, content);
		
		int result = st.executeUpdate();
		
		System.out.println(result);
		
		st.close();
		con.close();
		
	} //main
	
}
