package hoon;

import java.util.ArrayList;
import java.util.Scanner;

import sun.security.jca.GetInstance;

public class HoonEx implements RentalInterface {

	private ArrayList<Member> member;
	Scanner sc;
	
	private ArrayList<Book> books;
	private ArrayList<DVD> dvd;
	private ArrayList<Game> game;
	
	private HoonEx() {
		this.member = new ArrayList<Member>();
		this.books = new ArrayList<Book>();
		this.dvd = new ArrayList<DVD>();
		this.game = new ArrayList<Game>();
		sc = new Scanner(System.in);
	}
	
	private static HoonEx manager = new HoonEx();
	
	public static HoonEx getInstance() {
		return manager;
	}
	

	
	public ArrayList<Member> getMember() {
		return member;
	}

	public ArrayList<Book> getBooks() {
		return books;
	}


	public ArrayList<DVD> getDvd() {
		return dvd;
	}

	public ArrayList<Game> getGame() {
		return game;
	}
	

	//회원정보 보기
	@Override
	public void showInfo() {
		for(int i=0; i<member.size();i++) {
			member.get(i).showAllInfo();
			System.out.println("---------------------");
		}
		
	}

	@Override
	public void addInfo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editInfo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteInfo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void login() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void adminLogin() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showBookInfo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editBookInfo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBookInfo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int searchBookInfo(String title) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void showDvdInfo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editDvdInfo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteDvdInfo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int searchDvdInfo(String title) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void showGameInfo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editGameInfo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteGameInfo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int searchGameInfo(String title) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Book createBookInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DVD createDvdInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Game CreateGameInfo() {
		// TODO Auto-generated method stub
		return null;
	}

}
