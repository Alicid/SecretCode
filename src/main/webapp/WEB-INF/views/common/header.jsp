<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!-- Start header -->
	<header class="top-navbar">
		<nav class="navbar navbar-expand-lg navbar-light bg-light" style="height: 150px;">
			<div class="container-fluid">
				<a class="navbar-brand" href="${pageContext.request.contextPath}">
					<img src="${pageContext.request.contextPath }/resources/images/KakaoTalk_20200109_175813400.png" style=" width:500px;  height:120px;" alt="" />
				</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbars-host" aria-controls="navbars-rs-food" aria-expanded="false" aria-label="Toggle navigation">
					<span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbars-host">
					<ul class="navbar-nav ml-auto">
						<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}">Home</a></li>
						<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/notice/noticeList.no"><b>공지 사항</b></a></li>
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
                       <li class="nav navbar-nav navbar-right" style="margin-top:2.8%;">
                       <span>
                       		<a href="${pageContext.request.contextPath}/member/memberView.do?userId=${member.userId}" title="내정보보기"><strong>${member.nickName}</strong></a> 님, 안녕하세요
                       	</span>
                        </li>&nbsp;&nbsp;&nbsp;
                        <li class="nav navbar-nav navbar-right"><a class="hover-btn-new log orange" onclick="location.href='${pageContext.request.contextPath}/member/memberLogout.do'"><span>Logout</span></a>
                        </li>
                        </ul>
                    </c:if>
				</div>
			</div>
		</nav>
		<!-- Modal -->
	<div class="modal fade" id="login" data-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
		<div class="modal-content">
			<div class="modal-body customer-box">
				<!-- Nav tabs -->
				<ul class="nav nav-tabs">
					<li><a class="active" href="#Login" data-toggle="tab">Login</a></li>
					<li><a href="#Registration" data-toggle="tab">Join</a></li>
				</ul>
				<!-- Tab panes -->
				<div class="tab-content">
					<div class="tab-pane active" id="Login">
						<form role="form" class="form-horizontal" action="${pageContext.request.contextPath}/member/memberLogin.do">
							<div class="form-group">
								<div class="col-sm-12">
									<input class="form-control" id="userId" name="userId" placeholder="ID" type="text">
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-12">
									<input class="form-control" id="password" name="userPwd" placeholder="Password" type="Password">
								</div>
							</div>
							<div class="row">
								<div class="col-sm-10">
									<button type="submit" class="btn btn-primary btn-light btn-radius btn-brd grd1">
										확인
                                    </button>
                                    <button type="button" class="btn btn-secondary btn-light btn-radius btn-brd grd1" data-dismiss="modal">
										취소
                                    </button>
                                    <a class="for-pwd" href="${pageContext.request.contextPath}/member/gotoIdFind.do">아이디를 잊으셨나요?</a>
									<a class="for-pwd" href="${pageContext.request.contextPath}/member/gotoPwFind.do">비밀번호를 잊으셨나요?</a>
								</div>
							</div>
						</form>
					</div>
					<div class="tab-pane" id="Registration">
						<form role="form" class="form-horizontal" action="memberEnrollEnd.do" method="post" onsubmit="return validate();">
							<div class="form-group">
								<div class="col-sm-12">
									<input type="text" class="form-control" name="userId" id="userIdEn" placeholder="아이디를 입력하세요" required>
									<span class="guide ok">사용 가능</span>
				            		<span class="guide error">사용 불가</span>
				            		<span class="guide invalid">4글자 미만</span>
				            		<input type="hidden" name="idDuplicateCheck" id="idDuplicateCheck" value="0"/>
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-12">
									<input class="form-control" name="userPwd" id="Password" placeholder="비밀번호를 입력하세요" type="password">
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-12">
									<input class="form-control" id="Password2" placeholder="비밀번호를 재입력하세요" type="password">
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-12">
									<input class="form-control" name="nickName" id="Nickname" placeholder="닉네임을 입력하세요" type="text">
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-12">
									<input class="form-control" name="email" id="Email" placeholder="이메일을 입력하세요" type="email">
								</div>
							</div>
							<div class="row">							
								<div class="col-sm-10">
									<button type="submit" class="btn btn-light btn-radius btn-brd grd1">
										회원가입
									</button>
									<button type="button" class="btn btn-secondary btn-light btn-radius btn-brd grd1" data-dismiss="modal">
										취소
                                    </button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	  </div>
	</div>
	</header>