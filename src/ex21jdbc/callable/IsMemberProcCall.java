package ex21jdbc.callable;

import java.sql.SQLException;
import java.sql.Types;

import ex21jdbc.connect.IConnectImpl;

public class IsMemberProcCall extends IConnectImpl{

	public IsMemberProcCall() {
		super("education","1234");
	}
	
	@Override
	public void execute() {
		try {
			csmt = con.prepareCall("{ call MyMemberAuth(?, ?, ?)}");
			
			//In파라미터로 아이디와 패스워드를 입력받는다.
			csmt.setString(1, scanValue("회원 아이디"));
			csmt.setString(2, scanValue("회원 패스워드"));
			//Out파라미터는 로그인 상태에 따른 정수를 반환받는다.
			csmt.registerOutParameter(3, Types.NUMERIC);
			//프로시저 실행
			csmt.execute();
			
			//Out파라미터는 인덱스 3이므로 아래와 같이 얻어온다.
			int outParamResult = csmt.getInt(3);
			//회원인증 상태에 따라 메세지를 출력한다.
			switch (outParamResult) {
			case 0: 
				System.out.println("회원아이디가 없어요. 회원가입해주삼");
				break;
			case 1: 
				System.out.println("패스워드가 일치하지 않아요. 비번찾기하삼");
				break;
			case 2: 
				System.out.println("회원님 방가방가");
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			close();
		}	
	}
	public static void main(String[] args) {
		IsMemberProcCall mapc = new IsMemberProcCall();
		mapc.execute();
	}
}
