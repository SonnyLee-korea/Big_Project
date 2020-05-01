package study.spring.myapp.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import study.spring.myapp.member.Member;
import study.spring.myapp.member.jdbcutil.JDBCUtil;

@Repository
public class memDAO {
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private final String BOARD_INSERT = "insert into myboard(seq,id,pw,mail,phone) values((select nvl(max(seq),0)+1 from myboard),?,?,?,?)";
	private final String BOARD_UPDATE = "update myboard set pw=?,mail=? where seq=?";
	private final String BOARD_DELETE = "delete myboard where seq=?";
	private final String BOARD_GET = "select * from myboard where seq=?";
	private final String BOARD_LIST = "select * from myboard order by seq desc";
	
	
	public void insertBoard(Member member) {
		System.out.println("JDBC로 insert기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_INSERT);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPw());
			pstmt.setString(3, member.getMail());
			pstmt.setString(4, member.getPhone());
			pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(pstmt, conn);
		}
	}
	
	public void updateBoard(Member member) {
		System.out.println("JDBC로 update기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_UPDATE);
			pstmt.setString(1, member.getPw());
			pstmt.setString(2, member.getMail());
			pstmt.setInt(3, member.getSeq());
			pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(pstmt, conn);
		}
	}
	
	public void deleteBoard(Member member) {
		System.out.println("JDBC로 delete기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_DELETE);
			pstmt.setInt(1, member.getSeq());
			pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(pstmt, conn);
		}
	}
	
	public Member searchBoard(Member member) {
		System.out.println("JDBC로 search기능 처리");
		Member board = null;
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_GET);
			pstmt.setInt(1, member.getSeq());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				board = new Member();
				board.setSeq(rs.getInt("seq"));
				board.setId(rs.getString("id"));
				board.setPw(rs.getString("pw"));
				board.setMail(rs.getString("mail"));
				board.setPhone(rs.getString("phone"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		return board;
	}
	
	public List<Member> listBoard(){
		System.out.println("JDBC로 search기능 처리");
		List<Member> boardList = new ArrayList<Member>();
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_LIST);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Member member = new Member();
				member.setSeq(rs.getInt("seq"));
				member.setId(rs.getString("id"));
				member.setPw(rs.getString("pw"));
				member.setMail(rs.getString("mail"));
				member.setPhone(rs.getString("phone"));
				boardList.add(member);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		return boardList;
	}
	
	
	
	
}
