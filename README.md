# ✏SQL, JDBC 공부

## 🖥eclipse(2021-03)
### https://www.eclipse.org/downloads/packages/release/2021-03/r 

## 🖥Oracle Database Express Edition (XE) Release 11.2.0.2.0 (11gR2)
### https://www.oracle.com/database/technologies/xe-prior-release-downloads.html

## 🖥SQL Developer 21.4.2
### https://www.oracle.com/database/sqldeveloper/technologies/download/

## 🖥JDBC Driver(ojdbc6)
### https://repo1.maven.org/maven2/com/oracle/database/jdbc/ojdbc6/11.2.0.4/


### ✔JDBC Driver 설정
![image](https://user-images.githubusercontent.com/115568532/221416577-8fdb7e0e-cfad-488b-a8e7-dec53431eee5.png)

### ✔JDBC 기본 코드
- String url = "jdbc:oracle:thin:@localhost:1521/xe";

- 드라이버 로드(객체화)
  - Class.forName("oracle.jdbc.driver.OracleDriver");  
  
- 연결(객체 얻기)
  - Connection con = DriverManager.getConnection(url, "사용자 이름", "비밀번호" );
  
- 실행 도구 생성
  - Statement st = com.createStatement();
  
- 결과 패치 : 커서가 레코드를 가리키고 있음(순차적으로 접근해야 함.)
  - ResultSet rs = st.executeQuery(sql);
  
- 다음 결과 전달
  - rs.next();
  
- 전달받은 결과 반환
  - String title = rs.getString("title");
  
- 쿼리문에 ? 이용
  - PreparedStatement st= con.prepareStatement(sql);
  - st.setString(?의 순서 - 1부터 시작, 넣을 데이터);
  - st.executeUpdate();

### ✔GIT
- remote
  - git remote add origin https://github.com/sorrel012/jdbc-practice

- remote 확인
  - git remote -v
  
- pull  
  - git pull origin main  
  
- add
  - git add -A (작업 내용 모두 추가)
  
- commit
  - git commit -m "메시지 내용"
  
- push
  - git push origin main
