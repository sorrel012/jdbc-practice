package com.sorrel012.app.console;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.sorrel012.app.entity.Notice;
import com.sorrel012.app.service.NoticeService;

public class NoticeConsole {

	private NoticeService service;
	private int page;
	private int lastPage;
	private String searchWord;
	private String searchField;
	
	public NoticeConsole() {
		this.service = new NoticeService();
		this.page = 1;
		this.searchWord = "";
		this.searchField = "TITLE"; //에러 발생 방지
	}
	
	public void printNoticeList() throws ClassNotFoundException, SQLException {
		
		List<Notice> list = service.getList(this.page, this.searchField, this.searchWord);
		int count = service.getCount();
		this.lastPage = (count % 3 == 0) ? count/3 : count/3 + 1;
		
		System.out.println("\n────────────────────────────────────────────────────────");
		System.out.printf("<공지사항> 총 %d개의 게시글\n", count);
		System.out.println("────────────────────────────────────────────────────────");
		
		for(Notice n : list) {
			System.out.printf("%d. %s / %s / %s\n"
									, n.getId()
									, n.getTitle()
									, n.getWriterId()
									, n.getRegDate());
		}
		
		System.out.println("────────────────────────────────────────────────────────");
		System.out.printf("%d/%d pages\n", this.page, lastPage);
		System.out.println("────────────────────────────────────────────────────────\n");
		
	}

	public int inputNoticeMenu() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("1.이전 /2.다음 /3.검색 /4.종료 : " );
		
		return Integer.parseInt(scan.nextLine());
		
	}
	
	private boolean checkMenu(String menu_) {
		
		int menu = Integer.parseInt(menu_);
		
		if(menu >= 1 && menu <= 4) {
			return true;
		} else {
			return false;
		}
		
	}

	public void movePrevList() {
		if(this.page > 1) {
			this.page--;
		} else {
			System.out.println("이전 페이지가 없습니다.");
		}
	}

	public void moveNextList() {
		if(this.page < this.lastPage) {
			this.page++;
		} else {
			System.out.println("다음 페이지가 없습니다.");
		}
	}

	public void inputSearchWord() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("\n검색 범주(title/content/writerid) 중 하나를 입력하세요. : ");
		this.searchField = scan.nextLine();
		
		System.out.print("검색어를 입력하세요. : ");
		this.searchWord = scan.nextLine();
		
	}

}
