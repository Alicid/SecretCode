<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <title>비밀번호 찾기</title> 

    <c:import url="../common/commonUtil.jsp" />
	<style>
		.form-control {
			width: 400px !important;
			margin: 0 auto !important;
		}
		
		div.row-button {
			margin: 0 auto !important;
		}
		
		
		
	</style>
</head>
<body class="host_version"> 

<c:import url="../common/header.jsp" />

<!---------------------- 본문 시작 ------------------------->	
	
	
	
<div class="pwFind-content">
	<div class="modal-body customer-box">
		<!-- Tab panes -->
		<div class="tab-content">
			<div class="tab-pane active" id="idFind">
				<form role="form" class="form-horizontal" action="${pageContext.request.contextPath}/member/pwFind.do">
					<div class="form-group">
						<div class="col-sm-12">
							<input class="form-control" id="pwFind1" name="pwFind1" placeholder="아이디 입력" type="text">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-12">
							<input class="form-control" id="pwFind2" name="pwFind2" placeholder="이메일 입력" type="text">
						</div>
					</div>
					<div class="row-button">
						<div class="col-sm-10">
							<button type="submit" class="btn btn-primary btn-light btn-radius btn-brd grd1">
								확인
                            </button>
                            <button type="button" class="btn btn-secondary btn-light btn-radius btn-brd grd1">
								취소
                            </button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
	


<!---------------------- 본문 끝 ------------------------->	

<c:import url="../common/footer.jsp" />


</body>
</html>