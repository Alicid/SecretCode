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
 <style>
 	.resultTable{
 		column-count: 2;
 	}
 </style>
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
            <div id="main-title"><h1>${tInfo.category}</h1><h6>${tInfo.range}</h6>><input type="hidden" id="categoryNum" value="${categoryNum}"/></div>
            <div id="main-title-paper" style="position: absolute;top: 72px;left: 15px;"><p><b>Paper 1 (Non-Calculator)</b></p></div>
            <div id="foundation"><p><b>${tInfo.mode}</b></p></div>
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

      <div class="resultTable" style="display: table-cell;">
      <table class="result">
      <c:forEach var="result" items="${result}" varStatus="status">
			<tr> 
				<td>
					<c:if test="${status.count < 11}">
					<c:if test="${result.value ne 0}">
					<img src="${pageContext.request.contextPath}/resources/images/redcircle no1.png" style="position: absolute;height: 26px;left: 57px;">
					</c:if>
					<c:if test="${result.value eq 0}">
					<img src="${pageContext.request.contextPath}/resources/images/wrongSign.png" style="position: absolute;height: 26px;left: 57px;">
					</c:if>
					</c:if>
					<c:if test="${status.count > 10}">
						<c:if test="${result.value ne 0}">
							<img src="${pageContext.request.contextPath}/resources/images/redcircle no1.png" style="position: absolute;height: 26px;left: 169px;">
						</c:if>
						<c:if test="${result.value eq 0}">
							<img src="${pageContext.request.contextPath}/resources/images/wrongSign.png" style="position: absolute;height: 26px;left: 169px;">
						</c:if>
					</c:if>
					${status.count}.
				</td> 
				<td>
					<button type="button" class="btn btn-primary btn-xs" data-toggle="modal" data-target="#basicExampleModal${status.count}" style="font-size: 1px;">
					  문제보기
					</button>
				</td>
			</tr>
      </c:forEach>
      </table>
      </div>
     <!-- <div class="resultTable" style="display: table-cell;position: relative;right: -123px;">
      <table class="result">
      <c:forEach var="result" items="${result}" varStatus="status"  begin="10">
      <c:set var="num" value="${status.count+10}"/>
			<tr><td><c:if test="${result.value ne 0}"><img src="${pageContext.request.contextPath}/resources/images/redcircle no1.png" style="position: absolute;height: 26px;left: 0px;"></c:if><c:if test="${result.value eq 0}"><img src="${pageContext.request.contextPath}/resources/images/wrongSign.png" style="position: absolute;height: 26px;left: 0px;"></c:if>${num}.</td> <td><c:if test="${result.value eq 0}"> X </c:if><c:if test="${result.value ne 0}">O</c:if> </td></tr>
      </c:forEach>
      </table>
     </div> --> 
     
      <br />
      
 																		
 			<div id="score"> 
     			${tInfo.score}&nbsp;&nbsp; / &nbsp;&nbsp;${tInfo.total}
    		</div> 
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
    <c:forEach var="question" items="${qlist}" varStatus="status">
    	<div class="modal fade" id="basicExampleModal${status.count}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  			<div class="modal-dialog" role="document">
    			<div class="modal-content">
      				<div class="modal-header">
        				<h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
        					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
          						<span aria-hidden="true">&times;</span>
        					</button>
      				</div>
	      			<div class="modal-body">
	       				 <div id="oneQuiz" style="padding-left: 10px;padding-top: 10px;padding-right: 10px;height: auto;overflow: auto;">
	       				 	${question.qContent}
	       				 	 <div class="answerList">
	       				 		<c:forEach var="answer" items="${question.answer}" varStatus="status2">
	       				 			<p>${status2.count}. ${answer.qancontent}<input type="hidden" class="answerVal" value="${answer.qstatus}"></p>
	       				 		</c:forEach>
	       				 	</div>
	       				 </div>
	       				
	       				 
	      			</div>
			      	<div class="modal-footer">
			      	  <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			      	  <button type="button" class="btn btn-primary" onclick="printAnswer(this);">정답보기</button>
			     	 </div>
    			</div>
  			</div>
		</div>
    </c:forEach>

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
		
		
		  $('.result tr').hover(function() {
			  console.log("확인");
			    var modalId = $(this).data('target');
			    $(modalId).modal('show');

			  });
});

	function printAnswer(element){
		console.log(element);
		var $answerbutton = $(element);
		var $answerList = $answerbutton.parent().parent().find('.answerList').children();
		
		$answerList.each(function(){
			if($(this).find('.answerVal').val()=='Y'){
				$(this).css({
							'color':'red',
							'text-decoration':'underline'
							});
				console.log($(this));
			};
			
		});
		
		console.log($answerbutton.parent().parent().find('.answerList').children());
		
	};
</script>
</body>
</html>