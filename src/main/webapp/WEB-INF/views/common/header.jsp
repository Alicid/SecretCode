<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Start header -->
	<header class="top-navbar">
		<nav class="navbar navbar-expand-lg navbar-light bg-light" style="height: 150px;">
			<div class="container-fluid">
				<a class="navbar-brand" href="index.html">
					<img src="${pageContext.request.contextPath }/resources/images/KakaoTalk_20191226_120151349.png" width="300px" alt="" />
				</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbars-host" aria-controls="navbars-rs-food" aria-expanded="false" aria-label="Toggle navigation">
					<span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbars-host">
					<ul class="navbar-nav ml-auto">
						<li class="nav-item"><a class="nav-link" href="index.html">Home</a></li>
						<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/notice/noticeSelectList.do"><b>공지 사항</b></a></li>
						<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/board/boardSelectList.do"><b>자유 게시판</b></a></li>
						<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/question/questionSelectList.do"><b>문제 풀이</b></a></li>
					</ul>
                    <c:if test="${empty member}">
                    <div class="modal-header tit-up">
                        <ul class="nav navbar-nav navbar-right">
                            <li><a class="hover-btn-new log orange" href="#" data-toggle="modal" data-target="#login"><span>Login / Join</span></a></li>
                        </ul>
                    </div>
                    </c:if>
                    <c:if test="${!empty member}">
                        <ul class="nav navbar-nav navbar-right">
                        <li class="nav-item"><span><a href="${pageContext.request.contextPath}/member/memberView.do?userId=${member.userId}" title="내정보보기"><strong>${member.userName}</strong></a> 님, 안녕하세요</span>
                        </li>&nbsp;
                        <li class="nav-item"><a class="hover-btn-new log orange" onclick="location.href='${pageContext.request.contextPath}/member/memberLogout.do'"><span>Logout</span></a>
                        </li>
                        </ul>
                    </c:if>
				</div>
			</div>
		</nav>
	</header>