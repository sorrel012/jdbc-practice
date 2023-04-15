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
	private String userId = "sorrel";
	private String userPwd = "1234";
	
	public List<Notice> getList(int page, String field, String query) throws SQLException, ClassNotFoundException {
		
		int start = 1 + (page-1) * 3;
		int end = 3 * page;
		
		String sql = "SELECT * FROM NOTICE_VIEW WHERE " + field + " LIKE ? AND NUM BETWEEN ? AND ?";

		Class.forName(this.driver);
		Connection con = DriverManager.getConnection(this.url, this.userId, this.userPwd);
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, "%"+query+"%");
		st.setInt(2, start);
		st.setInt(3, end);
		
		ResultSet rs = st.executeQuery();
		
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

	//Scalar
	public int getCount() throws ClassNotFoundException, SQLException {
		
		int count = 0;
		
		String sql = "SELECT COUNT(ID) COUNT FROM NOTICE_VIEW";

		Class.forName(this.driver);
		Connection con = DriverManager.getConnection(this.url, this.userId, this.userPwd);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		List<Notice> list = new ArrayList<Notice>();
		
		if(rs.next()) {
			count = rs.getInt("COUNT");
		}

		rs.close();
		st.close();
		con.close();
		
		return count;
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
