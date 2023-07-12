<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Language" content="ko" >
<meta http-equiv="X-UA_Compatible" content="IE=edge" >
<meta name="viewpoint" content="width=device-width, initial-scale=1.0, minimum-scale=1.0,user-scalable=no"/>
<title>아이디 찾기</title>
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<link rel="stylesheet" href="/asset/member/css/login.css">
</head>
<body>

<h2 class="icon1">아이디 찾기</h2>
<p class="mB20">회원가입 시 등록한 정보를 입력해주세요.</p>

<div class="bg-area change_box">
	<form id="frm" name="frm" action="/member/findIdComplete.do" method="post" onsubmit="return checkForm(this)">
		<fieldset>
			<legend>아이디찾기 폼</legend>
			<div class="change_inp">
				<div>
					<label for="userNm">회원명</label>
					<input type="text" name="userNm" class="inp" id="userNm"/>
				</div>
				<div>
					<label for="emailAdres">이메일</label>
					<input type="text" name="emailAdres" class="inp" id="emailAdres"/>
				</div>
				<div>
					<label for="passwordHint">힌트</label>
					<select id="passwordHint" name="passwordHint" required>
						<option value="1">취미생활은?</option>
						<option value="2">애완견 이름은?</option>
						<option value="3">취직하고 싶은 곳은?</option>
						<option value="4">여행가고 싶은 곳은?</option>
					</select>
				</div>
				<div>
					<label for="passwordCnsr">정답</label>
					<input type="text" name="passwordCnsr" class="inp" id="passwordCnsr"/>
				</div>
			</div>
			<div class="btn-cont">
				<button type="submit" class="btn spot">확인</button>
				<button type="reset" class="btn">취소</button>
			</div>
		</fieldset>
	</form>
</div>

<script>
<c:if test="${not empty message}">
	alert("${message}");
</c:if>

function checkForm() {
	if(!$("#userNm").val()) {
		alert("회원명을 입력해주세요");
		return false;
	} else if(!$("#emailAdres").val()) {
		alert("이메일을 입력해주세요.");
		return false;
	} else if(!$("#passwordCnsr").val()) {
		alert("비밀번호 정답을 입력해주세요");
		return false;
	} 
}

</script>


</body>
</html>