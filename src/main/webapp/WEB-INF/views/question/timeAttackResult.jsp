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
            <div id="main-title"><h1 id="main-title2">${result.category}</h1><h6 id="main-title3">${result.range}</h6><input type="hidden" id="categoryNum" value="${result.categoryNum}"/></div>
            <div id="main-title-paper"><p><b>Paper 1 (Non-Calculator)</b></p><input type="hidden" id="unitNum" value="${result.unitNum}"/></div>
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
   
   			<div id="score2"> 
   			     <p id="myScore">획득점수</p> <p id="totalScore">총점</p>
     			${result.score}&nbsp;&nbsp; / &nbsp;&nbsp;${result.totalScore}
    		</div> 
      <br />
      <br />
 																	
     	
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