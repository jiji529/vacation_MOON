package egovframework.let.member.service;

public interface MemberService {

	//회원ID찾기
	public MemberVO findId(MemberVO vo) throws Exception;

	//회원비밀번호찾기
	public MemberVO findPassword(MemberVO vo) throws Exception;

	//회원비밀번호업데이트
	public void passwordUpdate(MemberVO vo) throws Exception;

}
