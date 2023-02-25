package ex1;

import java.sql.SQLException;

import com.sorrel012.app.console.NoticeConsole;

public class Program6 {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		NoticeConsole console = new NoticeConsole();

		EXIT:
		while(true) {
			console.printNoticeList(); //공지사항 목록 출력
			int menu = console.inputNoticeMenu(); //메뉴 입력 받기

			switch(menu) {
			case 1: //이전
				console.movePrevList();
				break;
			case 2: //다음
				console.moveNextList();
				break;
			case 3: //검색
				console.inputSearchWord();
				break;
			case 4: //종료
				break EXIT;
			default:
				System.out.println("1~4 사이의 숫자를 입력해 주세요.\n");
			}
		}

		System.out.println("프로그램을 종료합니다.");

	} //main

}
