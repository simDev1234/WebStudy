<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src = "js/content/recruitSites.js"></script>
</head>
<body>
   <!-- 네비게이션 버튼 -->
   <div class="navi_menu btn-group">
	  <button type="button" class="btn btn-primary" onclick = "siteOpen(this);">사람인</button>
	  <button type="button" class="btn btn-primary" onclick = "siteOpen(this)">잡코리아</button>
	  <button type="button" class="btn btn-primary" onclick = "siteOpen(this)">원티드</button>
	  <button type="button" class="btn btn-primary" onclick = "siteOpen(this)">워크넷</button>
	  <button type="button" class="btn btn-primary" onclick = "siteOpen(this)">커리어</button>
	  <button type="button" class="btn btn-primary" onclick = "siteOpen(this)">스카우트</button>
	  <button type="button" class="btn btn-primary" onclick = "siteOpen(this)">인디드</button>
	  <button type="button" class="btn btn-primary" onclick = "siteOpen(this)">벼룩시장</button>
	  <button type="button" class="btn btn-primary" onclick = "siteOpen(this)">피플앤잡</button>
	  <div class="btn-group">
	    <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
	    공공기관 <span class="caret"></span></button>
	    <ul class="dropdown-menu" role="menu">
	      <li><a href="https://www.alio.go.kr" target = "blank">알리오</a></li>
	      <li><a href="https://www.gojobs.go.kr" target = "blank">나라일터</a></li>
	    </ul>
	  </div>
	  <div class="btn-group">
	    <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
	    평점확인 <span class="caret"></span></button>
	    <ul class="dropdown-menu" role="menu">
	      <li><a href="https://www.jobplanet.co.kr" target = "blank">잡플래닛</a></li>
	      <li><a href="https://www.kreditjob.com" target = "blank">크레딧잡</a></li>
	      <li><a href="https://www.teamblind.com" target = "blank">블라인드</a></li>
	    </ul>
	  </div>
   </div>
   
   <!-- 지원 등록 폼 -->
   <div id = "insertRecruitBox">
      <form action="" method = "post">
	      <table id = "insertRecruitTable" class="w3-table w3-bordered">
	          <tr>
	            <th>채용사이트</th>
	            <td>
	              <input type = "text">
	            </td>
	            <th class = "leftLine">URL</th>
	            <td><input type = "text"></td>
	          </tr>
	          <tr>
	            <th>기업명</th>
	            <td>
	              <input type = "text">
	            </td>
	            <th class = "leftLine">포지션명</th>
	            <td>
	              <input type = "text">
	            </td>
	          </tr>
	          <tr>
	            <th>나의 지원</th>
	            <td colspan = "3">
	              <div class="w3-container">
	                  <!-- 현재 단계 선택 -->
					  <label>단계</label>
					  <div class="w3-dropdown-hover">
					    <button class="w3-button w3-black">어느 단계인가요?</button>
					    <div class="w3-dropdown-content w3-bar-block w3-border">
					      <a class="w3-bar-item w3-button">서류</a>
					      <a class="w3-bar-item w3-button">코딩테스트</a>
					      <a class="w3-bar-item w3-button">면접</a>
					      <a class="w3-bar-item w3-button">발표</a>
					    </div>
					  </div>
					  <!-- 현재 상태 선택 -->
					  <label>상태</label>
					  <div class="w3-dropdown-hover">
					    <button class="w3-button w3-black">어떤 상태인가요?</button>
					    <div class="w3-dropdown-content w3-bar-block w3-border">
					      <a class="w3-bar-item w3-button">진행중</a>
					      <a class="w3-bar-item w3-button">완료</a>
					      <a class="w3-bar-item w3-button">종료</a>
					    </div>
					  </div>
				  </div>
	            </td>
	          </tr>
	          <tr>
	            <th>상세 일정</th>
	            <td colspan = "3">
	              <ul id = "dates">
	                <li class = "dates_list">
	                  <label>서류마감일</label>
	                  <input type = "date" id = "paperDday">
	                  <label class = "recruitDesc">예정 일정이 없으면 일정 없이 제출해주세요(이하동문).</label>
	                </li>
	                <li class = "dates_list">
	                  <label>코테예정일</label>
	                  <input type = "date" id = "cotestDday">
	                </li>
	                <li class = "dates_list">
	                  <label>면접예정일</label>
	                  <input type = "date" id = "interviewDday">
	                </li>
	                <li class = "dates_list">
	                  <label>발표예정일</label>
	                  <input type = "date" id = "AnnounceDday">
	                </li>
	              </ul>
	            </td>
	          </tr>
	      </table>
	      <div class = "recruitButtons">
	         <button type = "submit" class = "btn btn-primary">등록</button>
			         <button type = "reset" class = "btn btn-warning">취소</button>
			         <button class = "btn btn-danger">삭제</button>
			      </div>
		      </form>
		   </div>
		   
		   <!-- 지원 사이트 뷰어 -->
		   <div class = "recView_box" id = "recSiteBox">
		   	  <div style = "height:900px; background : yellow">임시 영역</div>
		   </div>
		   
		   <!-- 지원 목록 리스트 -->
		   <div class = "recView_box" id = "recListBox">
		      <div style = "height:900px; background : blue">임시 영역</div>
		   </div>
		</body>
		</html>