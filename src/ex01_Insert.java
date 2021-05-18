import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ex01_Insert {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement psmt = null;
		
		// 아이디, 비밀번호, 이름, 나이를 입력받아서
		// DB에 저장시키기
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("아이디 : ");
		String id = sc.next();
		
		System.out.print("비밀번호 : ");
		String pw = sc.next();
		
		System.out.print("이름 : ");
		String name = sc.next();
		
		System.out.print("나이 : ");
		int age = sc.nextInt();
		
		// 아이디 : smhrd
		// 비밀번호 : 123
		
		// 예외처리가 되어있지 않기 때문에 에러
		try {
			// java와 DB를 연결하는 통로
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 여권 만들어주기
			// 경로, 아이디, 패스워드
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			
			String db_id = "hr";
			
			String db_pw = "hr";
			
			// 여권 만들기
			try {
				conn = DriverManager.getConnection(url, db_id, db_pw);
			
			// 어떤 비행기를 탈건지
			// 명령을 내린 sql문
			// insert를 사용
			
			String sql = "insert into member values(?,?,?,?)";
			
			// 탑승 수속
				psmt = conn.prepareStatement(sql);
				
				// db는 index번호가 1부터 시작
				// 첫번째 물음표에 id값을 집어넣겠다
				psmt.setString(1, id);
				psmt.setString(2, pw);
				psmt.setString(3, name);
				psmt.setInt(4, age);
				
				// 실행을 안시킴
				// 실행 시키면 table에 변화가 일어난다
				
				// cnt = 1
				// 늘어난 열의 개수를 출력
				int cnt = psmt.executeUpdate();
				
				// cnt == 1 > 회원가입 성공
				// cnt == 0 > 회원가입 실패
				if(cnt > 0) {
					System.out.println("회원가입 성공");
				}else {
					System.out.println("회원가입 실패");
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			// conn
			// psmt
			// 역순으로 닫아주기
			try {
				psmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		
		}
		
		
		

	}


