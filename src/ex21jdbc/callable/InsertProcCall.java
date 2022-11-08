package ex21jdbc.callable;

import java.sql.SQLException;
import java.sql.Types;

import ex21jdbc.connect.IConnectImpl;

/*
Java에서 프로시저 호출하기

프로시저를 실행하기 위한 CallableStatement 객체 생성
- 프로시저 호출시에는 { call 프로시저명(?, ?, ... N) }
- 파라미터는 in, out 순서없이 작성할 수 있다. 즉 프로시저 정의에 따라
	달라진다.
 */
public class InsertProcCall extends IConnectImpl{

	public InsertProcCall() {
		super("education", "1234");
	}
	
	@Override
	public void execute() {
		try {
			/*
			프로시저는 return값이 없으므로 함수처럼 (좌측항)?= 로 시작하지 않는다.
			out파라미터를 통해 값을 반환한다.
			 */
			csmt = con.prepareCall("{call MyMEmberInsert(?,?,?,?)}");
			//인파라미터 설정 : 사용자로부터 받은 입력값을 세팅한다.
			csmt.setString(1, scanValue("아이디"));
			csmt.setString(2, scanValue("패스워드"));
			csmt.setString(3, scanValue("이름"));
			//아웃파라미터 설정 : 반환값의 자료형을 설정한다.
			csmt.registerOutParameter(4, Types.NUMERIC);
			//프로시저 실행
			csmt.execute();
			//아웃파라미터를 읽어오기 위해 4번 인덱스로 설정
			//out파라미터에 할당된 값을 읽어 결과를 출력한다.
			int affected = csmt.getInt(4);
			if(affected == 0) 
				System.out.println("오류발생 : 입력실패");
			else
				System.out.println(affected + "행 입력 성공");
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}
	public static void main(String[] args) {
		new InsertProcCall().execute();
	}
}
