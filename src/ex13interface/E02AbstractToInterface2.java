package ex13interface;
/*
추상클래스를 인터페이스로 변경하기
	abstract class => interface
	메서드인 경우 public abstract 제거
	멤버변수인 경우 public static final 제거
 */
interface IPersonalNumberStorage {
	
	//정보를 저장하는 기능
	void addPersonalInfo(String juminNum, String name);
	//정보를 검색하는 기능
	String searchPersonalInfo(String juminNum);
}
/*
VO(Value Object) : 값만 저장할 수 있는 객체라는 뜻으로 데이터 저장용
	클래스를 만들 때 사용한다.
 */
class PersonalInfoVO{
	//이름과 주민번호를 멤버변수로 정의
	private String name;
	private String juminNum;
	//생성자
	public PersonalInfoVO(String name, String juminNum) {
		super();
		this.name = name;
		this.juminNum = juminNum;
	}
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public String getJuminNum() { return juminNum; }
	public void setJuminNum(String juminNum) { this.juminNum = juminNum; }
	
}
/*
클래스가 클래스를 상속할 때 => extends
클래스가 인터페이스를 상속할 때 => implements
매우 드물지만 인터페이스가 인터페이스를 상속할 때 => extends

또한 extends는 "상속"이라 하고, implements는 "구현"이라 표현한다.
 */
class PersonalNumberStorageImpl implements IPersonalNumberStorage{
	
	//정보저장용 객체배열과 인덱스 카운트를 위한 멤버변수 생성
	PersonalInfoVO[] personalArr;
	int numOfPerInfo;
	
	//생성자에서 객체배열 생성 및 인덱스 변수 초기화
	public PersonalNumberStorageImpl(int arrSize) {
		personalArr = new PersonalInfoVO[arrSize];
		numOfPerInfo = 0;
	}
	@Override
	public void addPersonalInfo(String juminNum, String name) {
		//객체를 생성한 후 객체배열에 저장한다.
		personalArr[numOfPerInfo] = new PersonalInfoVO(name, juminNum);
		//인덱스로 사용할 변수를 1 증가시킨다.
		numOfPerInfo++;
	}
	
	@Override
	public String searchPersonalInfo(String juminNum) {
		//저장된 객체의 갯수만큼 반복한다.
		for(int i=0 ; i<numOfPerInfo ; i++) {
			//주민번호와 일치하는지 확인한다.
			if(juminNum.compareTo(personalArr[i].getJuminNum())==0) {
				//일치하는 경우 이름을 반환한다.
				return personalArr[i].getName();
			}
		}
		//결과가 없다면 null을 반환한다.
		return null;
	}
}

public class E02AbstractToInterface2 {

	public static void main(String[] args) {
		//정보저장용 객체 생성
		PersonalNumberStorageImpl storage = new PersonalNumberStorageImpl(10);
		
		//2개의 정보를 추가
		storage.addPersonalInfo("901234-2222222", "김태희");
		storage.addPersonalInfo("901234-1111111", "정지훈");
		
		//정보를 검색
		System.out.println(storage.searchPersonalInfo("901234-2222222"));
		System.out.println(storage.searchPersonalInfo("901234-1111111"));
		System.out.println(storage.searchPersonalInfo("9001024-1090333"));
	}
}
