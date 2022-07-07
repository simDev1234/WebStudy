<%@page import="java.util.Properties"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%
    //배열
    String[] fruit_array = {"딸기","수박","사과","귤","포도"};

	//Set
	Set<String> colorSet = new HashSet<String>();
	colorSet.add("Red");
	colorSet.add("Orange");
	colorSet.add("Yellow");
	colorSet.add("Green");
	colorSet.add("Blue");
	
	//List
	List<String> sido_list = new ArrayList<String>();
	sido_list.add("서울");
	sido_list.add("경기");
	sido_list.add("인천");
	sido_list.add("대전");
	sido_list.add("강원");
	
	//Map
	Map<String, String> engMap = new HashMap<String,String>();
	//          key  value      --- 객체 위주
	engMap.put("one","하나");
	engMap.put("two","둘");
	engMap.put("three","셋");
	engMap.put("four","넷");
	engMap.put("five","다섯");
	
	//Properties
	Properties prop = new Properties();
	//                 문자열(text) 위주
	prop.setProperty("driver","oracle.jdbc.driver.oracleDriver");
	prop.setProperty("url","jdbc:oracle:thin:@localhost:1521:xe");
	prop.setProperty("user","scott");
	prop.setProperty("pwd","tiger");

	//pageContext값 넣기
	pageContext.setAttribute("fruit_array",fruit_array);
	pageContext.setAttribute("colorSet",colorSet);
	pageContext.setAttribute("sido_list",sido_list);
	pageContext.setAttribute("engMap",engMap);
	pageContext.setAttribute("prop",prop);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h2>forEach 향상된 for문 - 배열/Collection/Map</h2>
   <p>items : 배열 또는 Collections(Set, List) 또는 Map</p>
   
   <h3>forEach로 Array 출력하기</h3>
   <ul>
      <!-- for(String fruit : fruit_array) -->
      <c:forEach var = "fruit" items = "${ fruit_array }" varStatus = "loop">
          <li>index[${ loop.index }](count[${ loop.count }]) : ${ pageScope.fruit }</li>
      </c:forEach>
   </ul>
   
   <h3>forEach로 Set 출력하기</h3>
   <ul>
      <!-- for(String color : colorSet) -->
      <c:forEach var = "color" items = "${ colorSet }">
           <li style = "color : ${ color }">${ color }</li>
      </c:forEach>
   </ul>
   
   <h3>forEach로 List 출력하기</h3>
   <ul>
      <!-- for(String sido : sido_list) -->
      <c:forEach var = "sido" items = "${ sido_list }">
           <li>${ sido }</li>
      </c:forEach>
   </ul>
   
   <h3>forEach로 Map 출력하기</h3>
   <ul>
      <!-- for(Entry word : engMap) -->
      <c:forEach var = "word" items = "${ engMap }">
           <li>영어로 [${ word.key }]는(은) 한글로 [${ word.value }]입니다.</li>
      </c:forEach>
   </ul>
   
   <h3>forEach로 Properties 출력하기</h3>
   <ul>
      <!-- for(Entry p : prop) -->
      <c:forEach var = "p" items = "${ prop }">
           <li>설정 중 [${ p.key }]는(은) [${ p.value }]입니다.</li>
      </c:forEach>
   </ul>
</body>
</html>