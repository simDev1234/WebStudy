<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    //Cookie 정보 읽어온다.
    Cookie[] cookie_array = request.getCookies();
    String html = "";

    if(cookie_array != null){
    	
    	StringBuffer sb = new StringBuffer("<h4>[방문 페이지]</h4>");
    	
    	for(Cookie c : cookie_array){
    		String name  = c.getName();
    		String value = c.getValue();
    		
    		/* A/A.jsp
    		JSESSIONID/984965D22F126928B1B2E4453482DE65 */
    		
    		if (!name.equals("JSESSIONID")){
    			//out.print(name+"/"+value+"<br>");
    			sb.append(String.format("<a href = '%s'>%s</a><br>",value,name));
    		}
    	}
    	
    	html = sb.toString();
    }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
   #disp{
      position : absolute;
      top      : 30px;
      right    : 50px;
      width    : 200px;
      height   : 200px;
      padding  : 30px;
      background : #333333;
      color    : yellow;
   }
</style>
</head>
<body>
   <div id = "disp"><%= html %></div>
</body>
</html>