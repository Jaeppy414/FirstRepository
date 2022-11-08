package ex20io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
/*
연습문제1] 친구정보를 파일로 직렬화하기 위한 메서드를 정의하시오. 
	현재 친구의 정보를 List컬렉션에 저장되고 있다. 프로그램을 종료할때
	저장된 모든 친구의 정보를 파일로 저장할 수 있는 메서드를 정의하시오
	파일명 : myfriend_info.obj
	메서드명 : saveFriendInfo()
	※ 해당 메서드는 FriendInfoHandler 클래스에 추가하면 된다. 

연습문제2] 프로그램을 다시 시작하면 문제1에서 직렬화 했던 파일을 역직렬화해서
	복원하시오. 만약 3명의 정보가 저장되었다면 다시 시작한 직후 정보출력을 하면
	3명의 정보가 출력되어야 한다. 
	메서드명 : readFriendInfo()
	※ 해당 메서드는 FriendInfoHandler 클래스에 추가하면 된다.
 */

abstract class Friend implements Serializable {
	String name;
	String phone;
	String addr;
	
	public Friend(String name, String phone, String addr) {
		this.name = name;
		this.phone = phone;
		this.addr = addr;
	}
	public void showAllData() {
		System.out.println("이름: "+ name);
		System.out.println("전화번호: "+ phone);
		System.out.println("주소: "+ addr);
	}
	abstract public void showBasicInfo();
}
class HighFriend extends Friend{
	String nickname;
	public HighFriend(String name, String phone, String addr, String nickname) {
		super(name, phone, addr);
		this.nickname = nickname;
	}
	@Override
	public void showAllData() {
		System.out.println("==고딩친구(전체정보)==");
		super.showAllData();
		
		System.out.println("별명: "+ nickname);
	}
	@Override
	public void showBasicInfo() {
		System.out.println("==고딩친구==");
		System.out.println("별명:"+ nickname);
		System.out.println("전번: "+ phone);
	}
}
class UnivFriend extends Friend{
	String major;
	public UnivFriend(String name, String phone, String addr, String major) {
		super(name, phone, addr);
		this.major = major;
	}
	@Override
	public void showAllData() {
		System.out.println("==대딩친구(전체정보)==");
		super.showAllData();
		System.out.println("전공: "+ major);
	}
	@Override
	public void showBasicInfo() {
		System.out.println("==대딩친구==");
		System.out.println("이름: "+ name);
		System.out.println("전번: "+ phone);
	}
}
class FriendInfoHandler {
	private ArrayList<Friend> myFriends;
	
	public FriendInfoHandler() {
		myFriends = new ArrayList<Friend>();
	}
	public void addFriend(int choice) {
		Scanner scan = new Scanner(System.in);
		
		String iName, iPhone, iAddr, iNickname, iMajor;
		
		System.out.print("이름: "); iName = scan.nextLine();
		System.out.print("전화번호: ");iPhone = scan.nextLine();
		System.out.print("주소: "); iAddr = scan.nextLine();

		if(choice==1) {
			System.out.print("별명: "); iNickname = scan.nextLine();
			HighFriend high = new HighFriend(iName, iPhone, iAddr, iNickname);
			myFriends.add(high);
		}
		else if(choice==2) {
			System.out.print("전공: "); iMajor = scan.nextLine();
			myFriends.add(new UnivFriend(iName, iPhone, iAddr, iMajor));
			
		} 
		System.out.println("친구정보 입력이 완료되었습니다.");
	}////end of addFriend
	
	public void showAllData() {
		for(int i=0 ; i<myFriends.size() ; i++) {
			myFriends.get(i).showAllData();
		}
		System.out.println("==전체정보가 출력되었습니다==");
	}
	public void showSimpleData() {
		for(Friend fr : myFriends) {
			fr.showBasicInfo();
		}
		System.out.println("==간략정보가 출력되었습니다==");
	}

	public void searchInfo() {
		boolean isFind = false;
		Scanner scan = new Scanner(System.in);
		System.out.println("검색할 이름을 입력하세요.");
		String searchName = scan.nextLine();
		
		Iterator<Friend> itr = myFriends.iterator();
		while(itr.hasNext()) {
			Friend fr = itr.next();
			if(searchName.equals(fr.name)){
				fr.showAllData();
				System.out.println("***귀하가 요청한 정보를 찾았습니다.***");
				isFind = true;
			}
		}
		if(isFind==false)
			System.out.println("***찾는 정보가 없습니다.***");
	}	
	public void deleteInfo() {
		Scanner scan = new Scanner(System.in);
		System.out.print("삭제할 이름을 입력하세요:");
		String deleteName = scan.nextLine();
		boolean isDelete = false;
		
		for(Friend fr : myFriends) {
			if(deleteName.compareTo(fr.name)==0) {	
				myFriends.remove(fr);
				System.out.println("# 정보가 삭제되었습니다. #");
				isDelete = true;
				break;
			}
		}
		if(isDelete == false) {
			System.out.println("==삭제된 데이터가 없습니다.");
		}
		else {
		}
	}///end of deleteInfo
	
	//프로그램 종료시 친구의 정보를 직렬화한다.
	public void saveFriendInfo() {
		try {
			//친구 정보를 파일에 저장하기 위한 출력스트림을 생성한다.
			ObjectOutputStream out =
				new ObjectOutputStream(
					new FileOutputStream("src/ex20io/friend_info.obj")
				);
			//List<E> 컬렉션에 저장된 친구정보의 갯수만큼 반복하여
			for(Friend fr : myFriends) {
				//파일에 저장한다. 즉 직렬화한다.
				out.writeObject(fr);
			}
		} 
		catch (Exception e) {
			System.out.println("친구정보 직렬화 중 예외발생");
		}
	}
	
	//프로그램이 시작되면 저장된 파일을 통해 복원한 후 컬렉션에 추가한다.
	public void readFriendInfo() {
		try {
			//파일을 복원(역직렬화)하기 위해 스트림을 생성한다.
			ObjectInputStream in =
				new ObjectInputStream(
					new FileInputStream("src/ex20io/friend_info.obj")
				);
			//파일에 친구의 정보가 몇개 저장되었는지 확인할 수 없으므로
			//무한루프로 구성한다.
			while(true) {
				//직렬화될 때 Object기반으로 저장되므로 역직렬화할 때는
				//반드시 다운캐스팅 해야 한다.
				Friend fr = (Friend)in.readObject();
				//List<E> 컬렉션에 추가한다.
				myFriends.add(fr);
				//만약 더이상 복원할 객체가 없다면 예외가 발생한다.
			}
		}
		catch (Exception e) {
			//예외가 발생하면 catch절로 예외객체가 던져지므로 while루프를 탈출할 수 있다.
			System.out.println("더 이상 복원할 객체가 없습니다.");
		}
		System.out.println("친구의 정보가 복원되었습니다.");
	}
}
public class E12MyFriendSerializable {

	public static void menuShow() {
		System.out.println();
		System.out.println(" ####### 메뉴를 입력하세요 #######");
		System.out.print("1. 고딩친구입력 ");
		System.out.println("2. 대딩친구입력");
		System.out.print("3. 전체정보출력 ");
		System.out.println("4. 간략정보출력");
		System.out.print("5. 검색 ");
		System.out.print("6. 삭제 ");
		System.out.println("7. 프로그램종료");
		System.out.print("메뉴선택>>> ");
	}
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
	
		FriendInfoHandler handler = new FriendInfoHandler();
		
		//프로그램 시작시 직렬화된 파일이 있다면 즉시 복원하여 컬렉션에 저장한다.
		handler.readFriendInfo();
		
		while(true) {
			menuShow();
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:	case 2:
				handler.addFriend(choice);
				break;
			case 3:
				handler.showAllData();
				break;
			case 4:
				handler.showSimpleData();
				break;
			case 5:
				handler.searchInfo();
				break;
			case 6:
				handler.deleteInfo();
				break;
			case 7:
				System.out.println("\n<<프로그램 종료>>");
				/*
				프로그램이 종료되는 시점에 컬렉션에 저장된 객체를
				파일의 형태로 저장 즉, 직렬화해야한다.
				핸들러 클래스에 정의된 메서드를 호출한다.
				 */
				handler.saveFriendInfo();
				return;
			}////switch 끝
		}////while 끝
	}////main 끝
}////class 끝
