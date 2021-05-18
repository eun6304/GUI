import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ex01_Insert {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement psmt = null;
		
		// ���̵�, ��й�ȣ, �̸�, ���̸� �Է¹޾Ƽ�
		// DB�� �����Ű��
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���̵� : ");
		String id = sc.next();
		
		System.out.print("��й�ȣ : ");
		String pw = sc.next();
		
		System.out.print("�̸� : ");
		String name = sc.next();
		
		System.out.print("���� : ");
		int age = sc.nextInt();
		
		// ���̵� : smhrd
		// ��й�ȣ : 123
		
		// ����ó���� �Ǿ����� �ʱ� ������ ����
		try {
			// java�� DB�� �����ϴ� ���
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// ���� ������ֱ�
			// ���, ���̵�, �н�����
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			
			String db_id = "hr";
			
			String db_pw = "hr";
			
			// ���� �����
			try {
				conn = DriverManager.getConnection(url, db_id, db_pw);
			
			// � ����⸦ Ż����
			// ����� ���� sql��
			// insert�� ���
			
			String sql = "insert into member values(?,?,?,?)";
			
			// ž�� ����
				psmt = conn.prepareStatement(sql);
				
				// db�� index��ȣ�� 1���� ����
				// ù��° ����ǥ�� id���� ����ְڴ�
				psmt.setString(1, id);
				psmt.setString(2, pw);
				psmt.setString(3, name);
				psmt.setInt(4, age);
				
				// ������ �Ƚ�Ŵ
				// ���� ��Ű�� table�� ��ȭ�� �Ͼ��
				
				// cnt = 1
				// �þ ���� ������ ���
				int cnt = psmt.executeUpdate();
				
				// cnt == 1 > ȸ������ ����
				// cnt == 0 > ȸ������ ����
				if(cnt > 0) {
					System.out.println("ȸ������ ����");
				}else {
					System.out.println("ȸ������ ����");
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			// conn
			// psmt
			// �������� �ݾ��ֱ�
			try {
				psmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		
		}
		
		
		

	}


