package egovframework.let.join.service.impl;

import java.util.List;

import egovframework.let.board.service.BoardVO;
import egovframework.let.join.service.JoinVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Mapper("joinMapper")
public interface JoinMapper {
	
	//ID 중복체크
	int duplicateCheck(JoinVO vo) throws Exception;

	//회원등록
	void insertJoin(JoinVO vo) throws Exception;
	
//	//게시물 목록 가져오기
//	List<EgovMap> selectBoardList(BoardVO vo) throws Exception;
//	
//	//게시물 목록 수
//	int selectBoardListCnt(BoardVO vo) throws Exception;
//	
//	//게시물 등록
//	void insertBoard(BoardVO vo) throws Exception;
//	
//	//게시물 상세정보
//	BoardVO selectBoard(BoardVO vo) throws Exception;
//	
//	//조회수 업
//	void updateViewCnt(BoardVO vo) throws Exception;
//		
//	//게시물 수정하기
//	void updateBoard(BoardVO vo) throws Exception;
//	
//	//게시물 삭제하기
//	void deleteBoard(BoardVO vo) throws Exception;

}
