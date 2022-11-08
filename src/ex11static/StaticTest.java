package ex11static;


class A{
	int aVar;
	public static int bVar;
	
}
class InstCnt{
	
	static int instNum = 0;
	
	public InstCnt() {
		instNum++;
		System.out.println(instNum);
	}
}
public class StaticTest {

	public static void main(String[] args) {
		A a = new A();
		a.aVar = 200;
		
		a.bVar = 300;
		
		System.out.printf("%d\n",a.aVar);
		System.out.println(a.bVar);
		
		InstCnt cnt1 = new InstCnt();
		
		
		
		
	}

}
