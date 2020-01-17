<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
    <title>문제풀이</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/questionView.css">
    <c:import url="../common/commonUtil.jsp"/>
	<script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
</head>
<body>
<c:import url="../common/header.jsp" />
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
            <div id="main-title"><h1>${category.cn}</h1><h6>${category.un}</h6><input type="hidden" id="categoryNum" value="${categoryNum}"/></div>
            <div id="main-title-paper"><p><b>Paper 1 (Non-Calculator)</b></p><input type="hidden" id="unitNum" value="${category.unum}"/></div>
            <div id="foundation"><p><b>${mode}</b></p></div>
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
      <div id="instructions">
        <h4>Instructions</h4>
        <ul>
          <li>마우스를 이용해 정답을 선택해 주세요</li>
          <li>모든 질문에 답하십시오.</li>
          <li><b>한번 제출한 문제는 답안을 수정할 수 없습니다.</b></li>
          <li><b>계산기를 사용해서는 안됩니다.</b></li>
        </ul>
      </div>
      <div id="information">
        <h4>Information</h4>
        <ul>
          <li>각 질문에 대한 표시는 괄호 안에 표시됩니다.<br>
            <i>-각 질문에 소요되는 시간에 대한 지침으로 이것을 사용하십시오.</i></li>
            <li>본 시험 문제들의 저작권은 전부 <b>유정훈</b> 강사님께 있으며<br>
                 강사님의 허락 없이 문제를 불법 도용할 경우 법적 처벌을 받습니다.</li>
        </ul>
      </div>
      <div id="advice">
        <h4>Advice</h4>
        <ul>
          <li>답변을 시작하기 전에 각 질문을주의 깊게 읽으십시오.</li>
          <li>시간을 주시하십시오.</li>
          <li>모든 질문에 답하십시오.</li>
        </ul>
      </div>
    </div>
      <div class="button exam_btn" id="start_btn" >
        <p>Start</p>
      </div>
      <div class="button exam_btn" id="next_btn" >
        <p>Next</p>
      </div>
      <div class="button exam_btn" id="fin_btn" >
        <p>Finish</p>
      </div>
     
     
     
      <img id="pearson" src="${pageContext.request.contextPath}/resources/images/Secret_Code logo.png">
      <p id="code">P65493A</p>
    <p id="code-bottom">&copy 2020 Secret Code Ltd.<br>6/5/5/</p>
    </div>
    <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br />
   
    	<c:import url="../common/footer.jsp"/>
    	
    <script>
    var num = 1;
    var answer;
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
      $('#start_btn').click(function(){
    	  $(this).hide();
    	  $('#next_btn').show();
        $('#quiz_area').html('<div id="realQuiz" style="text-align: center;margin: auto;margin-top: 148px;font-size: 75px;">시작합니다!</div>');
        
        //$('#instructions');

        //location.href="https://www.naver.com";
      });
      
      $('#next_btn').click(function(){
    	  $('#quiz_area').html('');
    	  var $categoryNum = $('#categoryNum').val();
    	  var $unitNum = $('#unitNum').val();
    	  console.log($categoryNum);
    	  console.log('다음문제');
    	  $.ajax({
	            url  : "${pageContext.request.contextPath}/question/selectOneQuestion.do",
	            data : {categoryNum:$categoryNum,unitNum:$unitNum},
	            dataType: "json",
	            success : function(data){
	                console.log(data);
	            	//console.log(data.question);
	            	//console.log(data.question.qContent);
	            	//console.log(data.question.answer);
	            	//console.log(data.question.answer[0]);
	            	//console.log(data.question.answer[0].qancontent);
	            	  $('#quiz_area').html('<div id="oneQuiz" style="padding-left: 60px;padding-top: 48px;padding-right: 60px;">'+num +'. '+data.question.qContent +'</div>');
	            	  $('#oneQuiz').append('<br><br>');
	            	  for(var i=0;i<4;i++){
	                	  
	            	  $('#oneQuiz').append('<input type="checkbox" class="answer" name="answer" value="'+data.question.answer[i].qstatus+'"> '+(i+1)+') '+data.question.answer[i].qancontent + '<br>');	
	                  }
	            	  
	                
	            	  $('.answer').click(function(){
	              		
	          	        //클릭 이벤트 발생한 요소가 체크 상태인 경우
	          	        if ($(this).prop('checked')) {
	          	        
	          	            //체크박스 그룹의 요소 전체를 체크 해제후 클릭한 요소 체크 상태지정
	          	            $('input[type="checkbox"]').prop('checked', false);
	          	            $(this).prop('checked', true);
	          	          answer = $(this).val();
	          	      	console.log(answer);
	          	        }
	          	    });
	            	  var isAnswer = "Q"+(num-1);
	            	  //var 
	            	  var a;
	            	  var curScore=0;
	            	  
	            	  if(num==2){
	            		  sessionStorage.setItem("correct",0);
	            	  }
	            	  
	            	  
	            	  if(answer=='N'|| answer==null){
	            		   a = 0;
	            		   sessionStorage.setItem(isAnswer,a);
	            		   //$('#answerList').append('<input type="hidden" name="" id="Q'+num+'" value="'+a+'">');
	            	  }else if(answer=='Y'){
	            		  a = data.question.qScore;
	            		  sessionStorage.setItem(isAnswer,a);
	            		 // $('#answerList').append('<input type="hidden" name="" id="Q'+num+'" value="'+a+'">');
	            		 
	            		  curScore = parseInt(sessionStorage.getItem("correct"));
	            		  console.log(typeof(sessionStorage.getItem("correct")));
	            		  console.log(typeof(parseInt(sessionStorage.getItem("correct"))));
	            		  curScore += a;
	            		  sessionStorage.setItem("correct",curScore);
	            		  
	            	  }
	            	  
	            	  console.log(data.question.qScore);
	            	  //console.log(typeof(data.question.qScore));
	            	 
	            	 if(num==1){
	            		 sessionStorage.setItem("totalScore",0);
	            	 }else{
	            		 var score = parseInt(sessionStorage.getItem("totalScore"));
	            		 score+=data.question.qScore;
	            		 sessionStorage.setItem("totalScore",score);
	            		  
	            	 }
	            	  console.log( sessionStorage.getItem("totalScore"));
	            	  if(num==20){
	            		  $('#next_btn').html("Finish");
	            	  }
	            	 // if($("input[type='checkbox']").filter(':checked').size()==0)
	            	  
	            	  
	            	  if(num==21){
	            		  alert('문제풀이 종료!');
	            		  
	            		 var category = $('#main-title').text();
	            		 var mode = $('#foundation').text();
	            		 
	            		
	            		  sessionStorage.setItem('category',category);
	            		  sessionStorage.setItem('mode',mode);
	            		  
	            		 
	            		  console.log('채점결과');
	            		  
	            		  $.ajax({
	            				   url  : "${pageContext.request.contextPath}/question/questionResult.do",
	            				   type: 'POST',
	            				   data : JSON.stringify(sessionStorage),
	            				   dataType: "json",
	            				   contentType: 'application/json',
	            				   success : function(data){
	            					   console.log('아작스 성공!');
	            					   location.href = "${pageContext.request.contextPath}/question/printResult.do";
	            					   
	            				   },error : function(jqxhr, textStatus, errorThrown){
	            				      	     console.log("ajax 처리 실패");
	            				    	     //에러로그
	            				    	     console.log(jqxhr);
	            				    	     console.log(textStatus);
	            				    	     console.log(errorThrown);
	            				   }
	            		});//ajax 끝
	            	  }
	           		
	            	  answer=null;
	            	  num++;
	            	  
	            }, error : function(jqxhr, textStatus, errorThrown){
	                console.log("ajax 처리 실패");
	                //에러로그
	                console.log(jqxhr);
	                console.log(textStatus);
	                console.log(errorThrown);
	            }
      	});
      });
      
      
   
     
    </script>
    
  </body>
</html>