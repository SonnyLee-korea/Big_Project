package study.spring.myapp.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.spring.myapp.member.Member;
import study.spring.myapp.member.dao.memDAO;

@Service
public class MemberService implements ISerivce {
	
	@Autowired
	private memDAO memDao;
	
	public MemberService() {
		System.out.println("서비스를 시작합니다.");
	}
	
	@Override
	public void insert(Member member) {
		memDao.insertBoard(member);
	}

	@Override
	public void update(Member member) {
		memDao.updateBoard(member);
	}

	@Override
	public void delete(Member member) {
		memDao.deleteBoard(member);

	}

	@Override
	public Member search(Member member) {
		Member board = memDao.searchBoard(member);
		return board;
	}

	@Override
	public List<Member> list() {
		List<Member> boardList = memDao.listBoard();
		return boardList;
	}

}
