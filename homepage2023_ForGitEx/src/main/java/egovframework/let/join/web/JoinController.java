package egovframework.let.join.web;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import egovframework.com.cmm.EgovMessageSource;
import egovframework.com.cmm.LoginVO;
import egovframework.com.cmm.service.EgovFileMngService;
import egovframework.com.cmm.service.FileVO;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.let.board.service.BoardService;
import egovframework.let.board.service.BoardVO;
import egovframework.let.join.service.JoinService;
import egovframework.let.join.service.JoinVO;
import egovframework.let.utl.fcc.service.EgovStringUtil;
import egovframework.let.utl.fcc.service.FileMngUtil;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.psl.dataaccess.util.EgovMap;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import net.sf.json.JSONObject;

@Controller
public class JoinController {
	
	@Resource(name = "joinService")
	JoinService joinService;
	
	@Resource(name = "egovMessageSource")
	EgovMessageSource egovMessageSource;
	
	//약관동의
	@RequestMapping(value = "/join/siteUseAgree.do")
    public String siteUseAgree(@ModelAttribute("searchVO") JoinVO vo, HttpServletRequest request, ModelMap model, HttpSession session) throws Exception{
	
		return "join/SiteUseAgree";
	}
	
	//회원구분
		@RequestMapping(value = "/join/memberType.do")
	    public String memberType(@ModelAttribute("searchVO") JoinVO vo, HttpServletRequest request, ModelMap model, HttpSession session) throws Exception{
		
			return "join/MemberType";
		}
		
	//회원등록 폼
		@RequestMapping(value = "/join/memberRegist.do")
	    public String memberRegist(@ModelAttribute("searchVO") JoinVO vo, HttpServletRequest request, ModelMap model) throws Exception{
		
			return "join/MemberRegist";
		}
		
	// 아이디 중복체크
		@RequestMapping(value = "/join/duplicateCheck.do")
	    public void duplicateCheck(@ModelAttribute("searchVO") JoinVO vo, HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception{
		//디폴트 값.
		String successYn = "Y";
		String message = "성공";
		
		JSONObject jo = new  JSONObject();
		response.setContentType("application/json; charset=utf-8");
		
		int duplicateCnt = joinService.duplicateCheck(vo);
		//ID중복된 경우
		if(duplicateCnt > 0) {
			successYn = "N";
			message = egovMessageSource.getMessage("fail.duplicate.member"); //이미 사용중인 ID입니다.;
		}
		
		jo.put("successYn", successYn);
		jo.put("message", message);
		
		//제이슨 오브젝트에 담은 것을 브라우저에 자바가 알아서 출력하도록 만드는 방법.
		PrintWriter printwriter = response.getWriter();
		printwriter.println(jo.toString());
		printwriter.flush();
		printwriter.close();
		
		}
	
	//회원가입
	@RequestMapping(value = "/join/insertMember.do")
    public String insertMember(@ModelAttribute("searchVO") JoinVO vo, HttpServletRequest request, ModelMap model) throws Exception{
		//jsp의 자바스크립트 부분에서  #idCheckAt= "N"으로만 회원가입 가능 여부를 판단하면 해킹 위험 있기 때문에 추가한 내용.
		if(joinService.duplicateCheck(vo) > 0) {
			model.addAttribute("message", egovMessageSource.getMessage("fail.duplicate.member")); //이미 사용중인 ID입니다.
			return "forward:/join/memberType.do";
		}else {
			joinService.insertJoin(vo);
			model.addAttribute("message", egovMessageSource.getMessage("join.request.msg")); //회원 신청이 정상적으로 완료되었습니다. \n로그인 후 이용해주세요.
		}
		
		return "join/MemberComplete";
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(1);
		a.add(2);
		a.add(3);
		
		
		System.out.print(a.get(0) + ", " + a.get(1) + ", "+ a.get(2));
		System.out.println(a.contains(1));
		System.out.println(a.indexOf(3));
		System.out.println(a.get(a.indexOf(8) ));
		
	}
	
}

		
