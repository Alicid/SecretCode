<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/questionView.css">
 <c:import url="../common/commonUtil.jsp"/>
</head>
<body>
<c:import url="../common/header.jsp"/>

    <div id="a-three">
      <div id="header-container">
        <div>
          <p id="write-name">Write your name here</p>
          <div id="surname">
            <p class="float-top-left">Surname</p>
          </div>
          <div id="other-names">
            <p class="float-top-left" style="margin-left: -65px;">Other names</p>
            <p style="margin-top: 6px;font-style: italic;">${member.nickName}</p>
          </div>
          <div id="id-numbers">
            <div id="edexcel"><h2>Serial Number</h2></div>
            <div id="id-1"></div>
            <div id="id-2"></div>
            <div id="id-3"></div>
            <div id="id-4"></div>
            
            <div id="id-5"></div>
            <div id="id-6"></div>
            <div id="id-7"></div>
            <div id="id-8"></div>
            <div id="id-9"></div>
          </div>
          <div id="main-header">
            <div id="main-title"><h1>${result.category}</h1><input type="hidden" id="categoryNum" value="${categoryNum}"/></div>
            <div id="main-title-paper"><p><b>Paper 1 (Non-Calculator)</b></p></div>
            <div id="foundation"><p><b>${result.mode}</b></p></div>
          </div>
          <div id="date">
            <p id="date-time"><br></p>
            <p id="date-now" style="margin-left: 7px;"><b>Time: 1 hour 45 minutes</b></p>
          </div>
          <div id="reference">
            <p id="p-ref">Paper Reference</p>
            <p id="n-ref">1MA0/1F</p>
          </div>
          <div id="must-have">
            <p id="must-p"><b>You must have:</b> Ruler graduated in centimetres and millimetres,<br> protractor, pair of compasses, pen, HB pencil, eraser. Tracing<br> paper may be used.</p>
          </div>
          <div id="marks">
            <p id="marks-p">Total Marks</p>
          </div>
        </div>
      </div>
      <div class="test-border" id="quiz_area">
      <div id="oneQuiz" style="padding-left: 60px;padding-top: 48px;padding-right: 60px;">
      <h2>시험 결과</h2>
      <br />
      1. <c:if test="${result.Q1 eq 0}"> X </c:if> <c:if test="${result.Q1 ne 0}"> O </c:if>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 11. <c:if test="${result.Q11 eq 0}"> X </c:if> <c:if test="${result.Q11 ne 0}"> O </c:if><br />
      2. <c:if test="${result.Q2 eq 0}"> X </c:if> <c:if test="${result.Q2 ne 0}"> O </c:if>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 12. <c:if test="${result.Q12 eq 0}"> X </c:if> <c:if test="${result.Q12 ne 0}"> O </c:if><br />
      3. <c:if test="${result.Q3 eq 0}"> X </c:if> <c:if test="${result.Q3 ne 0}"> O </c:if>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 13. <c:if test="${result.Q13 eq 0}"> X </c:if> <c:if test="${result.Q13 ne 0}"> O </c:if><br />
      4. <c:if test="${result.Q4 eq 0}"> X </c:if> <c:if test="${result.Q4 ne 0}"> O </c:if>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 14. <c:if test="${result.Q14 eq 0}"> X </c:if> <c:if test="${result.Q14 ne 0}"> O </c:if><br />
      5. <c:if test="${result.Q5 eq 0}"> X </c:if> <c:if test="${result.Q5 ne 0}"> O </c:if>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 15. <c:if test="${result.Q15 eq 0}"> X </c:if> <c:if test="${result.Q15 ne 0}"> O </c:if><br />
      6. <c:if test="${result.Q6 eq 0}"> X </c:if> <c:if test="${result.Q6 ne 0}"> O </c:if>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 16. <c:if test="${result.Q16 eq 0}"> X </c:if> <c:if test="${result.Q16 ne 0}"> O </c:if><br />
      7. <c:if test="${result.Q7 eq 0}"> X </c:if> <c:if test="${result.Q7 ne 0}"> O </c:if>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 17. <c:if test="${result.Q17 eq 0}"> X </c:if> <c:if test="${result.Q17 ne 0}"> O </c:if><br />
      8. <c:if test="${result.Q8 eq 0}"> X </c:if> <c:if test="${result.Q8 ne 0}"> O </c:if>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 18. <c:if test="${result.Q18 eq 0}"> X </c:if> <c:if test="${result.Q18 ne 0}"> O </c:if><br />
      9. <c:if test="${result.Q9 eq 0}"> X </c:if> <c:if test="${result.Q9 ne 0}"> O </c:if>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 19. <c:if test="${result.Q19 eq 0}"> X </c:if> <c:if test="${result.Q19 ne 0}"> O </c:if><br />
      10. <c:if test="${result.Q10 eq 0}"> X </c:if> <c:if test="${result.Q10 ne 0}"> O </c:if>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 20. <c:if test="${result.Q20 eq 0}"> X </c:if> <c:if test="${result.Q20 ne 0}"> O </c:if><br />
      <br />
      <br />
 																		<br> 
     	${result.correct}&nbsp;&nbsp; / &nbsp;&nbsp;${result.totalScore} <br> 
      </div>
    </div>
      <div class="button exam_btn" id="start_btn" >
        <p>Start</p>
      </div>
      <div class="button exam_btn" id="next_btn" >
        <p>Next</p>
      </div>
     
     
     
      <img id="pearson" src="${pageContext.request.contextPath}/resources/images/Secret_Code logo.png">
      <p id="code">P65493A</p>
    <p id="code-bottom">&copy 2020 Secret Code Ltd.<br>6/5/5/</p>
    </div>
    <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br />
    <form action="" id="answerList">
    	
    </form>

<c:import url="../common/footer.jsp"/>
<script>
$(function(){
	sessionStorage.clear();
	
	
	  $('#next_btn').hide();
	  
	 	var today=new Date();
	 	var year = today.getFullYear();
	 	var month = today.getMonth()+1;
	 	var date = today.getDate();
	 	var day = today.getDay();
	 	var week = new Array('일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일');
		var todayLabel = week[day];
	 		
	  	var todayDate = todayLabel +'    '+year+' / '+month+' / '+date;
		$('#date-time').text(todayDate);
})
</script>
</body>
</html>