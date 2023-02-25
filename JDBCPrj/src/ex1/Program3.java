package ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Program3 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		String title = "드디어";
		String writerId = "sorrel012";
		String content = "주말이 왔다!";
		String files = "";
				
		
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		String sql = "INSERT INTO NOTICE (TITLE, WRITER_ID, CONTENT, FILES) "
									+ "VALUES (?, ?, ?, ?)";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "SORREL", "olian8982e");
		PreparedStatement st= con.prepareStatement(sql);
		
		st.setString(1, title);
		st.setString(2, writerId);
		st.setString(3, content);
		st.setString(4, files);
		
		int result = st.executeUpdate();
		
		System.out.println(result);
		
		st.close();
		con.close();
		
	} //main
	
}
