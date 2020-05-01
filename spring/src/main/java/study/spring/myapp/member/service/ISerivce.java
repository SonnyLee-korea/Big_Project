package study.spring.myapp.member.service;

import java.util.List;

import study.spring.myapp.member.Member;

public interface ISerivce {
	public void insert(Member member);
	public void update(Member member);
	public void delete(Member member);
	public Member search(Member member);
	public List<Member> list();
}
