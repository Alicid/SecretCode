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
    	padding : 10px;
    	border-left : 5px solid #aaf0d1;
	}
	.content{
		height : 500px;
		overflow : auto;
	}
	
</style>
</head>
<body class="host_version">
<c:import url="../common/header.jsp" />

<div class="all-title-box" style="background-image:url('${pageContext.request.contextPath }/images/blog_single.jpg');">
      <div class="container text-center">
         <h1>자유 게시판<span class="m_1">In giving advice, seek to help, not to please, your friend.</span></h1>
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
							<h1>[${board.bCategory}]&nbsp;&nbsp;${board.bTitle}&nbsp;(${clist.size()})</h1>
						</div>
					
		
						<div class="post-content">
							
							<div class="meta-info-blog">
								<span><i class="fa fa-calendar fa-lg" name="bDate">${board.bDate}</i> </span>
								<span><i class="fa fa-comments fa-lg" >12 Comments</i> </span>
								<span><i class="fa fa-pencil fa-lg" aria-hidden="true" name="writer">${board.writer}</i></span>
								<span><i class="fa fa-eye fa-lg" aria-hidden="true" name="bCount">${board.bCount}</i></span>
								 <input type="hidden" class="bno" name="bno" value="${board.bno}"/>
							</div>
							
							<div class="blog-desc">
								
								<blockquote class="default content">
									${board.bContent} 
								</blockquote>
								
							</div>							
						</div>
					</div>
				<div class="blog-button">
					<a class="hover-btn-new orange" href="${pageContext.request.contextPath}/board/boardSelectList.do"><span>목록<span></a>
				</div>
				<c:if test="${member.uNo == board.uno} ">
				<c:url var="boardUpdate" value="bUpdateForm.do">
					<c:param name="bno" value="${board.bno}"/>
				</c:url>
				
				<div class="blog-button">
					<a class="hover-btn-new orange" href="${boardUpdate}"><span>수정</span></a>
				</div>
				</c:if>
				<c:if test="${member.uNo eq board.uno or member.aNo eq 1 or member.aNo eq 2} ">
				<c:url var="boardDelete" value="boardDelete.do">
					<c:param name="bno" value="${board.bno}"/>
				</c:url>
				
				<div class="blog-button">
					<a class="hover-btn-new orange" href="${boardDelete}"><span>삭제<span></a>
				</div>
				</c:if>
				</div>
				
				
					<div class="blog-comments">
					<h4>Comments (${clist.size()})</h4>
						<c:forEach var="cmt" items="${clist}">
							
							<div id="comment-blog">
								<ul class="comment-list">
									<li class="comment" style="margin-left : ${(cmt.cLevel-1) *50}px;">
							
										<div class="comment-container">
											<h5 class="comment-author">${cmt.writer}</h5>
											<div class="comment-meta">
												<a href="#" class="comment-date link-style1">${cmt.cDate}</a>
												<a class="comment-reply-link link-style3" href="#respond">Reply »</a> <br>
												<c:if test="${member.uNo eq cmt.uno}"><a class="comment-reply-link link-style3" href="#" onClick="updateReply(this);return false;" style="margin-top: 20px;">Edit »</a></c:if>
												<c:if test="${member.uNo eq cmt.uno}"><a class="comment-reply-link link-style3" href="#" onClick="deleteReply(this);return false;" style="margin-top: 40px;">Delete »</a></c:if>
											</div>
											<div class="comment-body">
												${cmt.cContent}
											</div>
										</div>
									</li>
							
								</ul>
							</div>
						</c:forEach>
						
						
					</div>
				
					
					
					<c:if test="${!empty member }">
					<div class="comments-form">
						<h4>댓글 작성</h4>
						<div class="comment-form-main">
							<form action="${pageContext.request.contextPath}/comment/insertComment.do">
								<div class="row">
										<input type="hidden" name="uno" value="${ member.uNo}"/>
										<input type="hidden" name="bno" value="${board.bno}" />
										<input type="hidden" name="cRef" value="0" />
										<input type="hidden" name="cLevel" value="1" />
									<div class="col-md-12">
										<div class="form-group">
											<textarea class="form-control" name="cContent" placeholder="댓글을 입력해 주세요" id="commenter-message" cols="30" rows="2"></textarea>
										</div>
									</div>
									<div class="col-md-12 post-btn">
										<button class="hover-btn-new orange"><span>댓글 작성</span></button>
									</div>
								</div>
							</form>
						</div>
					</div>
					</c:if>
					<c:if test="${empty member }">
						<strong><center><div class="text-center">댓글은 로그인 후 이용 가능합니다.</div></center></strong>
					</c:if>
                </div><!-- end col -->
			
            </div><!-- end row -->
        </div><!-- end container -->
    </div><!-- end section -->
    <c:import url="../common/footer.jsp" />
    <script>
	// 게시글 번호를 전달할 전역 변수 생성
	var bno = ${board.bno};
	
	// 댓글 수정 함수
	function updateReply(obj){
		// 현재 위치와 가장 가까운 textarea 가져오기
		console.log(obj);
		//$(obj).parent().parent().next().find('textarea')
	//	.removeAttr('readonly');
		
		// 수정 완료 버튼 보여주기
	//	$(obj).siblings('.updateConfirm').css('display', 'inline');
		
		// 수정 하기는 숨기기
	//	$(obj).css('display', 'none');
	
	}
	
	// 수정 완료 기능 구현 함수
	function updateConfirm(obj) {
		// 댓글 내용 가져오기
		
		var content 
		    = $(obj).parent().parent()
		      .next().find('textarea').val();
		
		// 댓글 번호 가져오기
		var cno = $(obj).siblings('input').val();
		
		location.href="/myWeb/update.co?cno="+cno+"&bno="+bno
				     +"&ccontent=" + content;
	}
	
	function deleteReply(obj){
		
		var cno = $(obj).siblings('input').val();
		
		location.href="/myWeb/delete.co?cno="+cno+"&bno="+bno;
	}
	
	// 대댓글 기능 구현 함수
	function reComment(obj){
		
		// 추가 완료 기능 버튼 보이게 하기
		$(obj).siblings('.insertConfirm').css('display','inline');
		
		// 현재 버튼은 숨기기
		$(obj).css('display','none');
		
		// 내용 입력 공간 만들기
		//$(obj).parent('table').append(htmlCode);
		var htmlCode = 
			'<tr class="comment"> <td></td>'
			+ '<td colspan="3" style="background:transparent;">'
			+'<textarea class="reply-content" style="background:palegreen;"'
			+' cols="100" rows="3"> </textarea>'
			+'</td></tr>'
			
			$(obj).parents('table').append(htmlCode);
	}
    
    function reConfirm(obj){
		// 참조한 댓글의 정보 가져오기
		var refcno = $(obj).siblings('input[name=refcno]').val();
		// 참조한 댓글의 번호
		var clevel = Number($(obj).siblings('input[name=clevel]').val()) + 1;
		
		//console.log(refcno + " : " + clevel);
		var parent = $(obj).parent();
		var grandParent = parent.parent();
		var siblingsTR = grandParent.siblings().last();
		
		var content = siblingsTR.find("textarea").val();
		
		location.href='/myWeb/insert.co?'
					+ 'writer=${member.userId}'
					+ '&replyContent=' + content
					+ '&bno=' + bno
					+ '&refcno='+ refcno
					+ '&clevel=' + clevel;
	}
    $(function(){
    	var memberAno = '${member.aNo}';
    	var muno = '${member.uNo}';
    	var buno = '${board.uno}';
    	
    	console.log(memberAno);
    	console.log(muno);
    	console.log(buno);
    	
    })
    </script>
</body>
</html>