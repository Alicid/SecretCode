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
<c:import url="../common/commonUtil.jsp"/>
<style> 
	.title{
		border-color: #aaf0d1;
    	color: #666;
    	background: #ffffff;
    	font-size: inherit;
    	padding : 5px;
    	border-left : 5px solid #aaf0d1;
    	margin:10px;
	}
	.content{
		height : 500px;
		overflow : auto;
		margin:10px;
	}
	
	i{
		margin-left:15px;
	}
	
</style>
</head>
<body class="host_version">
<c:import url="../common/header.jsp" />

<div class="all-title-box">
      <div class="container text-center">
         <h1 style="color:#02876C">시험 문제</h1>
      </div>
</div>

<div id="overviews" class="section wb">
        <div class="container">
            <div class="row"> 
					<br />
                <div class="col-lg-12 blog-post-single">
                    <div class="blog-item">
                    <div class="blog-desc">
						<div class="title display-5">
							<h1>${question.qTitle}</h1>
						</div>
						<div class="post-content">
							<div class="meta-info-blog">
								<span><i class="fa fa-calendar fa-lg">난이도 : </i>${question.qLevel}</span>
								<span><i class="fa fa-pencil fa-lg" aria-hidden="true">점수 : </i>${question.qScore}점</span>
								<span><i class="fa fa-eye fa-lg" aria-hidden="true">${question.qWriter}</i></span>
								 <input type="hidden" class="qNo" name="qNo" value="${question.qNo}"/>
							</div>
							<div class="blog-desc">
								<blockquote class="default content">
									${question.qContent} 
								</blockquote>
							</div>							
						</div>
					</div>
    
    <div class="blog-comments"></div>
		<h4 align="center">정답  / 오답</h4>
			<div id="comment-blog">
				<ul class="comment-list" align="center">
				
				<li class="comment" style="display:inline-table; width: 45%;">
					<div class="comment-container" style="margin-left: -22px;">
							<h5 class="comment-author" style="margin-bottom: 20px;"><a href="#">정답 부분</a></h5>
							<div style="display:inline-table;position: relative;left: 0px;border-bottom:2px solid #aaf0d1;width: 70%;"">내용</div><div style="display:inline-table;position: relative;right: -30px;border-bottom: 2px solid #aaf0d1;width: 30%;">작성자</div>
						<c:forEach var="cAnswer" items="${cAnswer}">
						<div class="comment-body">
							<div style="position: relative;display: inline-table;width: 70%;">${cAnswer.qancontent}</div><div style="position: relative;display: inline-table;width: 30%;right: -30px;"">${cAnswer.uName}</div>
						</div>
						</c:forEach>
					</div>
				</li>
					
				<li class="comment" style="display:inline-table; width: 45%;">
					<div class="comment-container" style="margin-left: -8px;">
							<h5 class="comment-author" style="margin-bottom: 20px;"><a href="#">오답 부분</a></h5>
							<div style="display:inline-table;position: relative;left: 0px;border-bottom:2px solid #aaf0d1;width: 70%;"">내용</div><div style="display:inline-table;position: relative;right: -30px;border-bottom: 2px solid #aaf0d1;width: 30%;">작성자</div>
						<c:forEach var="wAnswer" items="${wAnswer}">
						<div class="comment-body">
							<div style="position: relative;display: inline-table;width: 70%;">${wAnswer.qancontent}</div><div style="position: relative;display: inline-table;width: 30%;right: -30px;"">${wAnswer.uName}</div>
						</div>
						</c:forEach>
					</div>
				</li>
				
					<br />
              <c:if test="${!empty member and (member.aNo eq 1 or member.aNo eq 2)}">
			            <c:url var="questionUpdate" value="/admin/updateQuestionView.qo">
			               <c:param name="qNo" value="${question.qNo}" />
			            </c:url>
			            <button class="btn btn-primary" id="btnli" onclick="location.href='${questionUpdate}'">수정</button>
			   </c:if>
                            <input type="button" id="btnli" class="btn btn-primary" value="목록"onclick="location.href='${pageContext.request.contextPath}/question/questionList.qo'">
			</ul>
		</div>
	</div>
    
					</div>
				</div>	
              </div><!-- end col -->
            </div><!-- end row -->
        </div><!-- end container -->
    </div><!-- end section -->
    <c:import url="../common/footer.jsp" />
    <script>
    $(document).ready(function(){
    	
		$('#summernote').summernote({
		    placeholder: '내용을 입력하세요.',
		    tabsize: 2,
		    height: 500,
		    width: 900,
		    focus: true,
		    callbacks: {
		       onImageUpload: function(files, editor, welEditable) {
		             for (var i = files.length - 1; i >= 0; i--) {
		                sendFile(files[i], this);
		             }
		         }
		    }
		 });
		});
			
		  $('.dropdown-toggle').dropdown()
 
 function sendFile(file, el) {
    
 var form_data = new FormData();
  form_data.append('file', file);
  // console.log(form_data.file);

  
  $.ajax({
       data: form_data,
       type: "post",
       url: '${pageContext.request.contextPath}/insert.tn',
    cache : false,
    contentType : false,
       enctype: 'multipart/form-data',
    processData : false,
       success: function(url) {
          console.log('----------------------------');
          console.log(url);
          console.log('----------------------------');
          url.replace("\/","/");
         $(el).summernote('editor.insertImage', url);
       }, error: function(){
          console.log("실패실패");
       }
  });
}
    </script>
</body>
</html>