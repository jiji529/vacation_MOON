package egovframework.let.join.service;

import java.util.List;

import egovframework.rte.psl.dataaccess.util.EgovMap;

public interface JoinService {
	
	//아이디 중복 체크 
	public int duplicateCheck(JoinVO vo) throws Exception;

	//회원 가입
	public String insertJoin(JoinVO vo) throws Exception;
	
//		//게시물 목록 가져오기
//		public List<EgovMap> selectBoardList(JoinVO vo) throws Exception;
//			
//		//게시물 목록 수 
//		public int selectBoardListCnt(JoinVO vo) throws Exception;
//	
//		//게시물 등록하기
//		public String insertBoard(JoinVO vo) throws Exception;
//		
//		//게시물 상세정보
//		public JoinVO selectBoard(JoinVO vo) throws Exception;
//		
//		//게시물 수정하기
//		public void updateBoard(JoinVO vo) throws Exception;
//		
//		//게시물 삭제하기
//		public void deleteBoard(JoinVO vo) throws Exception;
//	
}
