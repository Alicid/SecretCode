<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <title>Secret Code</title> 
    <c:import url="views/common/commonUtil.jsp" />
	<style>
		/* 중복체크관련 스타일 */
		div#userId-container{position:relative; padding:0px;}
		div#userId-container span.guide {display:none;font-size: 12px;position:absolute; top:12px; right:10px;}
		div#userId-container span.ok{color:green;}
		div#userId-container span.error, span.invalid{color:red;}
		
	nav > .nav.nav-tabs{

  	border: none;
    color:#fff;
    background:#02876C;
    border-radius:0;

}
nav > div a.nav-item.nav-link,
nav > div a.nav-item.nav-link.active
{
  	border: none;
    padding: 18px 25px;
    color:#fff;
    background:#02876C;
    border-radius:0;
}

.tab-content{
  	background: #fdfdfd;
    line-height: 30px;
    border: 1px solid #ddd;
}

nav > div a.nav-item.nav-link:hover,
nav > div a.nav-item.nav-link:focus
{
  	border: none;
    background: orange;
    color:#fff;
    border-radius:0;
    transition:background 0.20s linear;
    
}

.table table-sm public th,tr,td{
	text-align:center;
}
.public th{
	background-color:#E7ECF2;
}
	</style>
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script src="${pageContext.request.contextPath }/js/Chart.bundle.js" integrity="sha256-8zyeSXm+yTvzUN1VgAOinFgaVFEFTyYzWShOy9w7WoQ=" crossorigin="anonymous"></script>
    <script src="${pageContext.request.contextPath }/js/Chart.bundle.min.js"  integrity="sha256-TQq84xX6vkwR0Qs1qH5ADkP+MvH0W+9E7TdHJsoIQiM=" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/Chart.css" integrity="sha256-IvM9nJf/b5l2RoebiFno92E5ONttVyaEEsdemDC6iQA=" crossorigin="anonymous" />
    <script src="${pageContext.request.contextPath }/js/Chart.js"  integrity="sha256-nZaxPHA2uAaquixjSDX19TmIlbRNCOrf5HO1oHl5p70=" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/Chart.min.css" integrity="sha256-aa0xaJgmK/X74WM224KMQeNQC2xYKwlAt08oZqjeF0E=" crossorigin="anonymous" />
    <script src="${pageContext.request.contextPath }/js/Chart.min.js"integrity="sha256-R4pqcOYV8lt7snxMQO/HSbVCFRPMdrhAFMH+vr9giYI=" crossorigin="anonymous"></script>
    
</head>
<body class="host_version"> 

<c:import url="views/common/header.jsp" />
            

    <!-- LOADER -->
	<div id="preloader">
		<div class="loader-container">
			<div class="progress-br float shadow">
				<div class="progress__item"></div>
			</div>
		</div>
	</div>
	<!-- END LOADER -->	
	
	
	
	<div id="carouselExampleControls" class="carousel slide bs-slider box-slider" data-ride="carousel" data-pause="hover" data-interval="false" >
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#carouselExampleControls" data-slide-to="0" class="active"></li>
			<li data-target="#carouselExampleControls" data-slide-to="1"></li>
			<li data-target="#carouselExampleControls" data-slide-to="2"></li>
		</ol>
		<div class="carousel-inner" role="listbox">
			<div class="carousel-item active">
				<div id="home" class="first-section" style="background-image:url('${pageContext.request.contextPath }/images/KakaoTalk_20200115_192243213.jpg');">
					<div class="dtab">
						<div class="container">
							<div class="row">
								<div class="col-md-12 col-sm-12 text-right">
									<div class="big-tagline">
										<h2><strong>The beginning</strong> is half of the whole.</h2>
										<p class="lead" style="font-size:17px;">- 시작이 반이다. - </p>
										<p class="lead">자격증 공부를 위한 실력 향상 프로젝트 Web Site </p>
											
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										
									</div>
								</div>
							</div><!-- end row -->            
						</div><!-- end container -->
					</div>
				</div><!-- end section -->
			</div>
			<div class="carousel-item">
				<div id="home" class="first-section" style="background-image:url('${pageContext.request.contextPath }/images/slider-02.jpg');">
					<div class="dtab">
						<div class="container">
							<div class="row">
								<div class="col-md-12 col-sm-12 text-left">
									<div class="big-tagline">
										<h2><strong>Step by step</strong> goes a long way</h2>
										<p class="lead" style="font-size:17px;">- 한 걸음 한 걸음 걷는 자가 성공한다. - </p>
										<p class="lead">자격증 공부를 위한 실력 향상 프로젝트 Web Site </p>
                                        
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                       
									</div>
								</div>
							</div><!-- end row -->            
						</div><!-- end container -->
					</div>
				</div><!-- end section -->
			</div>
			<div class="carousel-item">
				<div id="home" class="first-section" style="background-image:url('${pageContext.request.contextPath }/images/slider-03.jpg');">
					<div class="dtab">
						<div class="container">
							<div class="row">
								<div class="col-md-12 col-sm-12 text-center">
									<div class="big-tagline">
										<h2><strong>No sweat</strong> , no sweet</h2>
										<p class="lead" style="font-size:17px;">- 땀이 없으면 달콤함도 없다. - </p>
										<p class="lead">자격증 공부를 위한 실력 향상 프로젝트 Web Site </p>
                                     
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        
									</div>
								</div>
							</div><!-- end row -->            
						</div><!-- end container -->
					</div>
				</div><!-- end section -->
			</div>
			<!-- Left Control -->
			<a class="new-effect carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
				<span class="fa fa-angle-left" aria-hidden="true"></span>
				<span class="sr-only">Previous</span>
			</a>

			<!-- Right Control -->
			<a class="new-effect carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
				<span class="fa fa-angle-right" aria-hidden="true"></span>
				<span class="sr-only">Next</span>
			</a>
		</div>
	</div>
	
    <div id="overviews " class="section wb">
        <div class="container">
      
            <div class="section-title row text-center" style="margin-top:-3%;" data-target="#chart">
                <div class="col-md-8 offset-md-2">
                    <h3>자격증 취득 통계</h3>
                    <p class="lead" style="margin-top:-2%;">정보처리 산업기사를 매년, 매회차 응시자와 합격자의 비율을 보시면서 회원님이 응시하신 회차 합격자 수안에 꼭! 회원님의 이름이 포함 됐으면 좋겠습니다.</p>
                </div>
            </div><!-- end title -->
            
        <div class="dropdown" style="margin-top:-3%;">
		  <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		    시험 년도 선택
		  </button>
		  <div class="examYears dropdown-menu" aria-labelledby="dropdownMenuButton">
		  <!-- ajax를 통해 a tag 삽입할 예정 -->
		  </div>
		</div> 
        <canvas id="myChart" class="chartjs-render-monitor" width="400" height="200"></canvas>
        <br /><br />
            <div class="row align-items-center">
                <div class="col-xl-6 col-lg-6 col-md-12 col-sm-12" style="height:350px;">
                    <div class="message-box">
                        <h4>2020 정보처리 산업기사 시험 일정</h4>
                        <h2>Welcome to Secret Code education Web Site</h2>
                        <p>이제 시험일정 검색을 위해 웹페이지를 이동하는 귀찮음을 최소화 하세요. <br />
                        	 부디 유용한 정보가 되어 사용자님의 합격을 기원 합니다.</p>

                        <p>현재 보이는 시험일정의 정보는 공공데이터를 REST API로 가져 왔음을 알립니다.<br> "정보처리 산업기사"를 제외한 다른 자격증의 경우 아래 버튼을 클릭하여 Qnet으로 이동해서 검색해주시기 바랍니다. </p>

                        <a href="http://www.q-net.or.kr/man001.do?gSite=Q" target="blank_" class="btn btn-secondary"><span>Qnet 링크</span></a>
                    </div><!-- end messagebox -->
                </div><!-- end col -->
               
		<div class="col-xl-6 col-lg-6 col-md-12 col-sm-12"  style="width:700px; margin-top:3%;">
           <div class="container">
              <div class="row">
                <div class="col-xs-12" style="width:100%;">
                  <nav>
                    <div class="nav nav-tabs nav-fill" id="nav-tab" role="tablist">
                      <a class="nav-item nav-link active" id="nav-home-tab" data-toggle="tab" href="#nav-home" role="tab" aria-controls="nav-home" aria-selected="true" >1회차</a>
                      <a class="nav-item nav-link" id="nav-profile-tab" data-toggle="tab" href="#nav-profile" role="tab" aria-controls="nav-profile" aria-selected="false" >2회차</a>
                      <a class="nav-item nav-link" id="nav-contact-tab" data-toggle="tab" href="#nav-contact" role="tab" aria-controls="nav-contact" aria-selected="false" >3회차</a>
                    </div>
                  </nav>
                  
                  <div class="tab-content py-3 px-3 px-sm-0" id="nav-tabContent">
                    <div class="tab-pane fade show active" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab">
                 	 <p style="margin-left:3%;">2020년 정기 1회</p>
                 	<table class="table table-sm public" style="margin-bottom:-1%;"> 
                 		<colgroup> <col width="220px"> <col width="220px"> <col> </colgroup>
                 		 <thead>
                 		  <tr>
                 		  	 	 <th scope="col">구분</th> 
                 		  	 	 <th scope="col">기간</th>
                 		 		
                 		    </thead> 
                 		    <tbody id="e0"> 
                 		    	<tr>
                 		    		 <td>필기시험 원서접수</td> 
                 		    		 <td></td> 
                 		    	</tr> 
                 		    	 <tr>
                 		     		 <td>필기시험</td> 
                 		     		 <td></td> 
                 		      	</tr> 
                 		       <tr>
                 		        <td>필기시험 합격자발표</td> 
                 		        <td></td> 
                 		       
                 		         </tr>
                 		            <tr> 
                 		            <td>실기시험</td> 
                 		            <td></td> 
                 		            
                 		            </tr>
                 		             <tr> 
                 		             <td>합격자발표</td> 
                 		             <td></td> 
                 		             </tr> 
                 		              </tbody>
                 		               </table>
                    </div>
                    <div class="tab-pane fade" id="nav-profile" role="tabpanel" aria-labelledby="nav-profile-tab">
					<p style="margin-left:3%;">2020년 정기 2회</p>
					<table class="table table-sm public" style="margin-bottom:-1%;"> 
                 		<colgroup> <col width="220px"> <col width="220px"> <col> </colgroup>
                 		 <thead>
                 		  <tr>
                 		  	 	 <th scope="col" >구분</th> <th scope="col">기간</th>
                 		    </thead> 
                 		    <tbody id="e1"> 
                 		    	<tr>
                 		    		 <td>필기시험 원서접수</td> 
                 		    		 <td></td> 
                 		    	</tr> 
                 		    	 <tr>
                 		     		 <td>필기시험</td> 
                 		     		 <td></td> 
                 		      	</tr> 
                 		       <tr>
                 		        <td>필기시험 합격자발표</td> 
                 		        <td></td> 
                 		       
                 		         </tr>
                 		            <tr> 
                 		            <td>실기시험</td> 
                 		            <td></td> 
                 		            
                 		            </tr>
                 		             <tr> 
                 		             <td>합격자발표</td> 
                 		             <td></td> 
                 		             </tr> 
                 		              </tbody>
                 		               </table>
                    </div>
                    <div class="tab-pane fade" id="nav-contact" role="tabpanel" aria-labelledby="nav-contact-tab">
					<p style="margin-left:3%;">2020년 정기 3회</p>
					<table class="table table-sm public" style="margin-bottom:-1%;"> 
                 		<colgroup> <col width="220px"> <col width="220px"> <col> </colgroup>
                 		 <thead>
                 		  <tr>
                 		  	 	 <th scope="col">구분</th> <th scope="col">기간</th>
                 		 		
                 		    </thead> 
                 		    <tbody id="e2"> 
                 		    	<tr>
                 		    		 <td>필기시험 원서접수</td> 
                 		    		 <td></td> 
                 		    	</tr> 
                 		    	 <tr>
                 		     		 <td>필기시험</td> 
                 		     		 <td></td> 
                 		      	</tr> 
                 		       <tr>
                 		        <td>필기시험 합격자발표</td> 
                 		        <td></td> 
                 		       
                 		         </tr>
                 		            <tr> 
                 		            <td>실기시험</td> 
                 		            <td></td> 
                 		            
                 		            </tr>
                 		             <tr> 
                 		             <td>합격자발표</td> 
                 		             <td></td> 
                 		             </tr> 
                 		              </tbody>
                 		               </table>
                    </div>
                  </div>
                </div>
              </div>
	        </div>
		</div>
      </div><!-- end media -->
      <br />
			<div class="row align-items-center" style="margin-top:-4%;">
				<div class="col-xl-6 col-lg-6 col-md-12 col-sm-12" >
					<h2><p style=" text-align: center;">타임어택 랭킹</p></h2>
					<table class="table table-sm public" style="margin-bottom:-1%;" id="ranking">
						<thead>
							<tr style="border-bottom: 3px solid #02876C;">
								<td>등수</td>
								<td>이름</td>
								<td>점수</td>
							</tr>
						</thead>
          
                   </table>
                </div><!-- end col -->
				
				<div class="col-xl-6 col-lg-6 col-md-12 col-sm-12">
                    <div class="message-box">
                        <h2>Time Attack Ranking</h2>
                        <p>문제풀이 에서 타임어택 모드 로 가장 많은 점수를 얻은 회원들을 상위 10위 내에 표시해 줍니다. </p>


                        <a href="${pageContext.request.contextPath}/question/getCategory.do" class="btn btn-secondary"><span>타임어택 링크</span></a>
                    </div><!-- end messagebox -->
                </div><!-- end col -->
           	</div><!-- end row -->
        </div>
     </div><!-- end container -->

<div class="section cl">
		<div class="container">
			<div class="row text-left stat-wrap">
				<div class="col-md-4 col-sm-4 col-xs-12">
					<span data-scroll class="global-radius icon_wrap effect-1 alignleft"><i class="flaticon-study"></i></span>
					<p class="stat_count" >12000</p>
					<h3>Students</h3>
				</div><!-- end col -->

				<div class="col-md-4 col-sm-4 col-xs-12">
					<span data-scroll class="global-radius icon_wrap effect-1 alignleft"><i class="flaticon-online"></i></span>
					<p class="stat_count">240</p>
					<h3>Courses</h3>
				</div><!-- end col -->

				<div class="col-md-4 col-sm-4 col-xs-12">
					<span data-scroll class="global-radius icon_wrap effect-1 alignleft"><i class="flaticon-years"></i></span>
					<p class="stat_count">55</p>
					<h3>Years Completed</h3>
				</div><!-- end col -->
			</div><!-- end row -->
		</div><!-- end container -->
	</div><!-- end section -->

    <section class="section lb page-section" >
		<div class="container">
			 <div class="section-title row text-center">
                <div class="col-md-8 offset-md-2">
                    <h3>Our Team</h3>
                    <p class="lead">2020년 1월 23일, KH 정보교육원 352Class에 그들이 온다! 코벤져스!</p>
                </div>
            </div><!-- end title -->
            <!--  
			<div class="timeline">
				<div class="timeline__wrap">
					<div class="timeline__items">
						<div class="timeline__item">
							<div class="timeline__content img-bg-01">
								<h2>2018</h2>
								<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer dignissim neque condimentum lacus dapibus. Lorem
									ipsum dolor sit amet, consectetur adipiscing elit.</p>
							</div>
						</div>
						<div class="timeline__item">
							<div class="timeline__content img-bg-02">
								<h2>2015</h2>
								<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer dignissim neque condimentum lacus dapibus. Lorem
									ipsum dolor sit amet, consectetur adipiscing elit.</p>
							</div>
						</div>
						<div class="timeline__item">
							<div class="timeline__content img-bg-03">
								<h2>2014</h2>
								<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer dignissim neque condimentum lacus dapibus. Lorem
									ipsum dolor sit amet, consectetur adipiscing elit.</p>
							</div>
						</div>
						<div class="timeline__item">
							<div class="timeline__content img-bg-04">
								<h2>2012</h2>
								<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer dignissim neque condimentum lacus dapibus. Lorem
									ipsum dolor sit amet, consectetur adipiscing elit.</p>
							</div>
						</div>
						<div class="timeline__item">
							<div class="timeline__content img-bg-01">
								<h2>2010</h2>
								<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer dignissim neque condimentum lacus dapibus. Lorem
									ipsum dolor sit amet, consectetur adipiscing elit.</p>
							</div>
						</div>
						<div class="timeline__item">
							<div class="timeline__content img-bg-02">
								<h2>2007</h2>
								<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer dignissim neque condimentum lacus dapibus. Lorem
									ipsum dolor sit amet, consectetur adipiscing elit.</p>
							</div>
						</div>
						<div class="timeline__item">
							<div class="timeline__content img-bg-03">
								<h2>2004</h2>
								<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer dignissim neque condimentum lacus dapibus. Lorem
									ipsum dolor sit amet, consectetur adipiscing elit.</p>
							</div>
						</div>
						<div class="timeline__item">
							<div class="timeline__content img-bg-04">
								<h2>2002</h2>
								<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer dignissim neque condimentum lacus dapibus. Lorem
									ipsum dolor sit amet, consectetur adipiscing elit.</p>
							</div>
						</div>
					</div>
				</div>
			</div>-->
			<div style="margin: auto;display: table; width: 100px;">
			<iframe width="700" height="500" src="https://www.youtube.com/embed/vRMYesmUCYk" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
			</div>
		</div>
	</section>

		<c:set var="now" value="<%=new java.util.Date()%>" />
		<c:set var="sysYear"><fmt:formatDate value="${now}" pattern="yyyy" /></c:set> 
<c:import url="views/common/footer.jsp" />

	<script>
		timeline(document.querySelectorAll('.timeline'), {
			forceVerticalMode: 700,
			mode: 'horizontal',
			verticalStartPosition: 'left',
			visibleItems: 4
		});
		
		$(function() {
		
			$.ajax({
				url : '${pageContext.request.contextPath}/openApi/openApiRun.do',
				type : 'get',
				dataType : 'json',
				success : function(data){
					console.log(data);
					console.log(data.test);
					var examPlan = JSON.parse(data.test).response.body.items.item;
					console.log(examPlan);
					
					/* 객체 요소 탐색 기법
					var e0 = [];
					for(var i in examPlan[0]) {
						console.log(i);
						console.log(examPlan[0][i]);
						if(i == 'examstartdt') continue;
						e0.push(examPlan[0][i]);
					}
					
					console.log(e0);
					*/
					
					var e01 = examPlan[0].description;
					var e02 = examPlan[0].examenddt;
					var e03 = examPlan[0].examregenddt;
					var e04 = examPlan[0].examregstartdt;
					var e05 = examPlan[0].passenddt;
					var e06 = examPlan[0].passstartdt;
					
					var e11 = examPlan[1].description;
					var e12 = examPlan[1].examenddt;
					var e13 = examPlan[1].examstartdt;
					var e14 = examPlan[1].examregenddt;
					var e15 = examPlan[1].examregstartdt;
					var e16 = examPlan[1].passenddt;
					var e17 = examPlan[1].passstartdt;
					
					var e21 = examPlan[2].description;
					var e22 = examPlan[2].examenddt;
					var e23 = examPlan[2].examregenddt;
					var e24 = examPlan[2].examregstartdt;
					var e25 = examPlan[2].passenddt;
					var e26 = examPlan[2].passstartdt;	
					
					var e31 = examPlan[3].description;
					var e32 = examPlan[3].examenddt;
					var e33 = examPlan[3].examstartdt;
					var e34 = examPlan[3].examregenddt;
					var e35 = examPlan[3].examregstartdt;
					var e36 = examPlan[3].passenddt;
					var e37 = examPlan[3].passstartdt;
					
					var e41 = examPlan[4].description;
					var e42 = examPlan[4].examenddt;
					var e43 = examPlan[4].examregenddt;
					var e44 = examPlan[4].examregstartdt;
					var e45 = examPlan[4].passenddt;
					var e46 = examPlan[4].passstartdt;
					
					var e51 = examPlan[5].description;
					var e52 = examPlan[5].examenddt;
					var e53 = examPlan[5].examstartdt;
					var e54 = examPlan[5].examregenddt;
					var e55 = examPlan[5].examregstartdt;
					var e56 = examPlan[5].passenddt;
					var e57 = examPlan[5].passstartdt;
					console.log(typeof(e04));
					console.log(typeof(e04.toString()));
					console.log(YMDFormatter(e04.toString()));
					$('#e0 tr:nth-child(1) td:nth-child(2)').append(YMDFormatter(e04.toString())+' ~ '+YMDFormatter(e03.toString()));
					$('#e0 tr:nth-child(2) td:nth-child(2)').append(YMDFormatter(e02.toString()));
					$('#e0 tr:nth-child(3) td:nth-child(2)').append(YMDFormatter(e06.toString()));
					$('#e0 tr:nth-child(4) td:nth-child(2)').append(YMDFormatter(e13.toString())+' ~ '+YMDFormatter(e12.toString()));
					$('#e0 tr:nth-child(5) td:nth-child(2)').append(YMDFormatter(e17.toString())+' ~ '+YMDFormatter(e16.toString()));
					
					$('#e1 tr:nth-child(1) td:nth-child(2)').append(YMDFormatter(e24.toString())+' ~ '+YMDFormatter(e23.toString()));
					$('#e1 tr:nth-child(2) td:nth-child(2)').append(YMDFormatter(e22.toString()));
					$('#e1 tr:nth-child(3) td:nth-child(2)').append(YMDFormatter(e26.toString()));
					$('#e1 tr:nth-child(4) td:nth-child(2)').append(YMDFormatter(e33.toString())+' ~ '+YMDFormatter(e32.toString()));
					$('#e1 tr:nth-child(5) td:nth-child(2)').append(YMDFormatter(e37.toString())+' ~ '+YMDFormatter(e36.toString()));
					
					$('#e2 tr:nth-child(1) td:nth-child(2)').append(YMDFormatter(e44.toString())+' ~ '+YMDFormatter(e43.toString()));
					$('#e2 tr:nth-child(2) td:nth-child(2)').append(YMDFormatter(e42.toString()));
					$('#e2 tr:nth-child(3) td:nth-child(2)').append(YMDFormatter(e46.toString()));
					$('#e2 tr:nth-child(4) td:nth-child(2)').append(YMDFormatter(e53.toString())+' ~ '+YMDFormatter(e52.toString()));
					$('#e2 tr:nth-child(5) td:nth-child(2)').append(YMDFormatter(e57.toString())+' ~ '+YMDFormatter(e56.toString()));
					
					
					}
			})
			
		fn_stat(<c:out value="${sysYear}" />-2);
		
		$.ajax({
			url : '${pageContext.request.contextPath}/tResult/selectYears.re',
			dataType : 'json',
			success : function(data){
				console.log('연도 가져오는거 확인');
				console.log(data);
				
				var yearsDiv = $('.examYears');
				
				for(var i in data){
					var aTag = $(' <a class="dropdown-item" onclick="fn_stat(' + data[i] + ');">' + data[i] + '</a>');
					
					yearsDiv.append(aTag);
				}
			}, error : function(data){
			}
		});
		
		 $.ajax({
	            url  : "${pageContext.request.contextPath}/question/highScore.do",
	            dataType: "json",
	            async : false,
	            success : function(data){
	            	var $ranking = $('#ranking');
	            	console.log($ranking);
	                console.log(data);
	               
	                console.log(data.highScore);
	                //console.log(data.highScore[0]);
	                //console.log(data.highScore[0].score);
	                //console.log(data.highScore[0].RNUM);
	                //console.log(data.highScore[0].name);
	                //console.log(data.highScore.length);
	               // $ranking.append('<tr>');
	               // $('#ranking tbody tr td:nth-child(1)').html('<tr><td>'+data.highScore[i].RNUM +  '</td><td>'+data.highScore[i].name+ '</td><td>' + data.highScore[i].score+ '</td></tr>');
	                for(var i =0;i<data.highScore.length;i++){
	                	$('#ranking').append('<tr><td>'+data.highScore[i].RNUM +  '</td><td>'+data.highScore[i].name+ '</td><td>' + data.highScore[i].score+ '</td></tr>');
	                }
	             
	            }, error : function(jqxhr, textStatus, errorThrown){
	                console.log("ajax 처리 실패");
	                //에러로그
	                console.log(jqxhr);
	                console.log(textStatus);
	                console.log(errorThrown);
	            }
     	});
		});
		
		var	myChart;
		function fn_stat(years){
			$.ajax({
				url:'${pageContext.request.contextPath}/tResult/selectList.re',
				type: 'get',
				data : {years : years},
				dataType : 'json',
				success: function(data){
					console.log(data);
					
					if(myChart != null){
						myChart.destroy();
					}
					
					var ctx = document.getElementById('myChart').getContext('2d');
					myChart = new Chart(ctx, {
					    type: 'bar',
					    data: {
					        labels: ['필기 접수자', '필기 응시자', '필기 합격자', '필기 합격률(%)', '실기 접수자', '실기 응시자', '실기 합격자', '실기 합격률(%)', '년도 종합 합격'],
					        datasets: [{
					            label: years,
					            data: data,
					            backgroundColor: [
					                'rgba(255, 99, 132, 0.5)',
					                'rgba(54, 162, 235, 0.5)',
					                'rgba(255, 99, 132, 0.5)',
					                'rgba(54, 162, 235, 0.5)',
					                'rgba(255, 99, 132, 0.5)',
					                'rgba(54, 162, 235, 0.5)',
					                'rgba(255, 99, 132, 0.5)',
					                'rgba(54, 162, 235, 0.5)',
					                'rgba(255, 99, 132, 0.5)'
					            ],
					            borderColor: [
					                'rgba(255, 99, 132, 1)',
					                'rgba(54, 162, 235, 1)',
					                'rgba(255, 99, 132, 1)',
					                'rgba(54, 162, 235, 1)',
					                'rgba(255, 99, 132, 1)',
					                'rgba(54, 162, 235, 1)',
					                'rgba(255, 99, 132, 1)',
					                'rgba(54, 162, 235, 1)',
					                'rgba(255, 99, 132, 1)'
					            ],
					            borderWidth: 3
					        }]
					    },
					    options: {
					        scales: {
					            yAxes: [{
					                ticks: {
					                    beginAtZero: true
					                }
					            }]
					        }
					    }
						})
				}, error : function(data){
				}
		})
		};
		
		function YMDFormatter(num){

		     if(!num) return "";
		     var formatNum = '';

		     // 공백제거
		     //num=num.replace(/\s/gi, "");

		     try{
		          if(num.length == 8) {
		               formatNum = num.replace(/(\d{4})(\d{2})(\d{2})/, '$1.$2.$3');
		          }
		     } catch(e) {
		          formatNum = num;
		          console.log(e);
		     }
		     return formatNum;
		}


	</script>
</body>
</html>