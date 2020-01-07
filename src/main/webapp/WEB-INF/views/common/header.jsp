<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<!-- Start header -->
	<header class="top-navbar">
		<nav class="navbar navbar-expand-lg navbar-light bg-light" style="height: 150px;">
			<div class="container-fluid">
				<a class="navbar-brand" href="${pageContext.request.contextPath}">
					<img src="${pageContext.request.contextPath }/resources/images/KakaoTalk_20191226_120151349.png" width="300px" alt="" />
				</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbars-host" aria-controls="navbars-rs-food" aria-expanded="false" aria-label="Toggle navigation">
					<span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbars-host">
					<ul class="navbar-nav ml-auto">
						<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}">Home</a></li>
						<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/notice/nInsertForm.no"><b>공지 사항</b></a></li>
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
									<input class="form-control" id="userPwd" name="userPwd" placeholder="Password" type="Password">
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
                                    <a class="for-pwd" href="javascript:;">아이디를 잊으셨나요?</a>
									<a class="for-pwd" href="javascript:;">비밀번호를 잊으셨나요?</a>
								</div>
							</div>
						</form>
					</div>
					<div class="tab-pane" id="Registration">
						<form role="form" class="form-horizontal">
							<div class="form-group">
								<div class="col-sm-12">
									<input class="form-control" placeholder="ID" type="text">
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-12">
									<input class="form-control" id="Password" placeholder="Password" type="password">
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-12">
									<input class="form-control" id="Nickname" placeholder="Nickname" type="text">
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-12">
									<input class="form-control" id="Email" placeholder="Email" type="email">
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