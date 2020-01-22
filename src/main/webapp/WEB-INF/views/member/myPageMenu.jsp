<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
  <nav id="sidebar" class="sidebar-wrapper">
    <div class="sidebar-content">
      <div class="sidebar-brand">
        <a href="#">My page</a>
        
      </div>
      <div class="sidebar-header">
        <div class="user-info">
          <span class="user-name" >${member.nickName}
            <strong>님 안녕하세요.</strong>
          </span>
          
          
        </div>
      </div>
      <div class="sidebar-menu">
        <ul>
          <li class="header-menu">
            <span>내 정보</span>
          </li>
          <li class="sidebar-dropdown">
            <a href="${pageContext.request.contextPath}/member/mypage.do">
              <i class="fa fa-book"></i>
              <span>내 정보 수정</span>
              <span class="badge badge-pill badge-warning"></span>
            </a>
          </li>
          <li class="sidebar-dropdown">
            <a href="${pageContext.request.contextPath}/member/mypageDeleteView.do">
              <i class="fa fa-shopping-cart"></i>
              <span>회원 탈퇴</span>
              <span class="badge badge-pill badge-danger"></span>
            </a>
          </li>
          <li class="sidebar-dropdown">
            <a href="#">
              <i class="fa fa-chart-line"></i>
              <span>내 통계</span>
            </a>
          </li>
         
          <c:if test="${!empty member && member.aNo == 1 }">
          <li class="sidebar-dropdown">
            <a href="${pageContext.request.contextPath}/question/questionList.qo">
              <i class="fa fa-folder"></i>
              <span>시험문제 관리</span>
            </a>
          </li>
          
          <li class="sidebar-dropdown">
            <a href="${pageContext.request.contextPath}/admin/adminMemberList.qo">
              <i class="far fa-gem"></i>
              <span>회원 관리</span>
            </a>
          </c:if>
          
        </ul>
      </div>
     </div>
  </nav>