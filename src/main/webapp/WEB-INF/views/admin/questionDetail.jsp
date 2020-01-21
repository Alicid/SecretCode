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
				
				<li class="comment" style="display:inline-block; width: 45%;">
					<div class="comment-container" style="margin-left: -22px;">
							<h5 class="comment-author"><a href="#">정답 부분</a></h5>
						
						<div class="comment-body">
							<p>정답 부분</p>
						</div>
					</div>
				</li>
					
				<li class="comment" style="display:inline-block; width: 45%;">
					<div class="comment-container" style="margin-left: -8px;">
							<h5 class="comment-author"><a href="#">오답 부분</a></h5>
						
						<div class="comment-body">
							<p>오답 부분</p>
						</div>
					</div>
				</li>
				
					
              <c:if test="${!empty member and (member.aNo eq 1 or member.aNo eq 2)}">
			            <c:url var="questionUpdate" value="qUpdateForm.qo">
			               <c:param name="qNo" value="${question.qNo}" />
			            </c:url>
			            <button class="btn btn-primary" id="btnli" onclick="location.href='#'">수정</button>
			   </c:if>
                            <input type="button" id="btnli" class="btn btn-primary" value="목록"
                                onclick="location.href='${pageContext.request.contextPath}/question/questionList.qo'">
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
    
</body>
</html>