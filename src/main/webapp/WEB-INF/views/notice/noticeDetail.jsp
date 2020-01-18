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

<div class="all-title-box" style="background-image:url('${pageContext.request.contextPath }/images/banner.jpg');">
      <div class="container text-center">
         <h1>공지 사항<span class="m_1">Asking costs nothing.</span></h1>
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
							<h1>${notice.nTitle}</h1>
						</div>
						<div class="post-content">
							<div class="meta-info-blog">
								<span><i class="fa fa-calendar fa-lg">${notice.nEnrolldate}</i> </span>
								<span><i class="fa fa-pencil fa-lg" aria-hidden="true">${notice.writer}</i></span>
								<span><i class="fa fa-eye fa-lg" aria-hidden="true">${notice.nCount}</i></span>
								 <input type="hidden" class="nNo" name="nNo" value="${notice.nNo}"/>
							</div>
							<div class="blog-desc">
								<blockquote class="default content">
									${notice.nContent} 
								</blockquote>
							</div>							
						</div>
					</div>
					<div align="center">
              <c:if test="${!empty member and member.uNo eq notice.uNo}">
			            <c:url var="noticeUpdate" value="nUpdateForm.no">
			               <c:param name="nNo" value="${notice.nNo}" />
			            </c:url>
			            <button class="btn btn-primary" id="btnli" onclick="location.href='${noticeUpdate}'">수정</button>
			         	</c:if>
                            <input type="button" id="btnli" class="btn btn-primary" value="목록"
                                onclick="location.href='${pageContext.request.contextPath}/notice/noticeList.no'">
					</div>
				</div>	
              </div><!-- end col -->
            </div><!-- end row -->
        </div><!-- end container -->
    </div><!-- end section -->
    <c:import url="../common/footer.jsp" />
    
</body>
</html>