package egovframework.let.join.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import egovframework.let.join.service.JoinService;
import egovframework.let.join.service.JoinVO;
import egovframework.let.utl.fcc.service.EgovStringUtil;
import egovframework.let.utl.sim.service.EgovFileScrty;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;

@Service("joinService")
public class JoinServiceImpl extends EgovAbstractServiceImpl implements JoinService {
	
	@Resource(name = "joinMapper")
	private JoinMapper joinMapper;
	
	@Resource(name = "joinIdGnrService")
	private EgovIdGnrService idgenService;
	
	//ID 중복체크
	public int duplicateCheck(JoinVO vo) throws Exception {
		return joinMapper.duplicateCheck(vo);
	}
	
	//회원등록
	public String insertJoin(JoinVO vo) throws Exception {
		//회원고유 ID -> vo객체에 담기.
		String esntlId = idgenService.getNextStringId();
		vo.setEsntlId(esntlId);

		//입력한 비밀번호를 암호화한다.
		String enpassword = EgovFileScrty.encryptPassword(vo.getPassword(), vo.getEmplyrId());
		vo.setPassword(enpassword);

		//이메일 import EgovStringUtil = egovframework.let.utl.service.EgovStirngUtil
		if(!EgovStringUtil.isEmpty(vo.getEmailId()) && !EgovStringUtil.isEmpty(vo.getEmailDomain())) {
			vo.setEmailAdres(vo.getEmailId() + "@" + vo.getEmailDomain());
		}
		
		joinMapper.insertJoin(vo);
		return esntlId;
	}
	
//	@Resource(name = "egovBoardIdGnrService")
//	private EgovIdGnrService idgenService;
//	
//	//게시물 목록 가져오기
//	public List<EgovMap> selectBoardList(BoardVO vo) throws Exception{
//		return boardMapper.selectBoardList(vo);
//	}
//	
//	//게시물 목록 수 
//	public int selectBoardListCnt(BoardVO vo) throws Exception{
//		return boardMapper.selectBoardListCnt(vo);
//	}
//	
//	//게시물 등록
//	public String insertBoard(BoardVO vo) throws Exception{
//		String id = idgenService.getNextStringId();
//		vo.setBoardId(id);
//		boardMapper.insertBoard(vo);
//		
//		return id;
//	}
//	
//	//게시물 상세정보
//	public BoardVO selectBoard(BoardVO vo) throws Exception{
//		//조회수 업
//		boardMapper.updateViewCnt(vo);
//		return boardMapper.selectBoard(vo);
//	}
//	
//	//게시물 수정하기
//	public void updateBoard(BoardVO vo) throws Exception{
//		boardMapper.updateBoard(vo);
//	}
//	
//	//게시물 삭제하기
//	public void deleteBoard(BoardVO vo) throws Exception{
//		boardMapper.deleteBoard(vo);
//	}	
}

