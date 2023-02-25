package com.sorrel012.app.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sorrel012.app.entity.Notice;

public class NoticeService {

	private String url = "jdbc:oracle:thin:@localhost:1521/xe";
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String userId = "SORREL";
	private String userPwd = "olian8982e";
	
	public List<Notice> getList() throws SQLException, ClassNotFoundException {
		
		String sql = "SELECT * FROM NOTICE WHERE HIT >= 10";

		Class.forName(this.driver);
		Connection con = DriverManager.getConnection(this.url, this.userId, this.userPwd);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		List<Notice> list = new ArrayList<Notice>();
		
		while(rs.next()) {
			int id = rs.getInt("ID");
			String title = rs.getString("TITLE");
			String writerId = rs.getString("WRITER_ID");
			Date regDate = rs.getDate("REGDATE");
			String content = rs.getString("CONTENT");
			int hit = rs.getInt("hit");
			
			Notice notice = new Notice(id, title, writerId, regDate, content, hit);
			
			list.add(notice);
		}
		
		rs.close();
		st.close();
		con.close();
		
		return list;
	}

	public int insert(Notice notice) throws ClassNotFoundException, SQLException {

		String title = notice.getTitle();
		String writerId = notice.getWriterId();
		String content = notice.getContent();
				
		String sql = "INSERT INTO NOTICE (TITLE, WRITER_ID, CONTENT, FILES) "
									+ "VALUES (?, ?, ?)";
		
		Class.forName(this.driver);
		Connection con = DriverManager.getConnection(this.url, this.userId, this.userPwd);
		PreparedStatement st= con.prepareStatement(sql);
		
		st.setString(1, title);
		st.setString(2, writerId);
		st.setString(3, content);
		
		int result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}
	
	public int update(Notice notice) throws SQLException, ClassNotFoundException {
		
		String title = notice.getTitle();
		String content = notice.getContent();
				
		
		String sql = "UPDATE NOTICE SET TITLE = ?, CONTENT = ? WHERE WRITER_ID = 'sorrel012'";

		Class.forName(this.driver);
		Connection con = DriverManager.getConnection(this.url, this.userId, this.userPwd);
		PreparedStatement st= con.prepareStatement(sql);
		
		st.setString(1, title);
		st.setString(2, content);
		
		int result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}
	
	public int delete(int id) throws SQLException, ClassNotFoundException {
		
		String sql = "DELETE NOTICE WHERE ID = ?";

		Class.forName(this.driver);
		Connection con = DriverManager.getConnection(this.url, this.userId, this.userPwd);
		PreparedStatement st= con.prepareStatement(sql);
		
		st.setInt(1, id);
		
		int result = st.executeUpdate();
		
		System.out.println(result);
		
		st.close();
		con.close();
		
		return result;
	}
}
