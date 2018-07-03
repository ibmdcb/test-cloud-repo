<!DOCTYPE HTML><%@page import="com.hanzi.db.util.DBUtil"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.nio.ByteBuffer"%>
<%@page import="java.nio.charset.Charset"%>
<%@page import="java.sql.SQLException"%>
<%@page import="javax.naming.NamingException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page language="java"
	contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
<title>hello</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
<jsp:include page="header.jsp" />


<%

String zi = request.getParameter("zi");
if ( zi != null ){
byte [] jiema = zi.getBytes ("iso8859-1"); 
zi = new String (jiema, "UTF-8");// 
//inS = new String(inS.getBytes(), "UTF-8");
} 

String check = request.getParameter("check");
if ( check != null ){
byte [] jiema = check.getBytes ("iso8859-1"); 
check = new String (jiema, "UTF-8");// 
//inS = new String(inS.getBytes(), "UTF-8");
} 

if(check!=null && check.equals(zi)){
						%>Excellent : You got it Right!<%  			   		

}

%>

<% if ( zi != null ){%>
<h2><%=zi %></h2>
<% }%>

<%


		Connection connection = null; 
          try {
              connection = DBUtil.getConnection();
				PreparedStatement charQueryStmt = connection.prepareStatement("select * from yz.hanzi where hanzichar = ?");
				PreparedStatement lineQueryStmt = connection.prepareStatement("select * from yz.lines where idlines = ?");
				PreparedStatement grpCharsQueryStmt = connection.prepareStatement("select * from yz.hanzigroup as t1, yz.hztogrp as t2 where t1.idhanzigroup = t2.idgrp and t2.hanzi = ?");
				
 				charQueryStmt.setString(1, zi);
 				ResultSet rsArticle = charQueryStmt.executeQuery();
 			   if (rsArticle.next()){
 			   
	 			   	String pinyin = rsArticle.getString("pinyin");
						%><%=pinyin%><br><br><%  			   		
	 			   	int nianji = rsArticle.getInt("gradelevel");
						%>Grade Level : <%=nianji%><br><%  			   		
	 			   	int iLevel = rsArticle.getInt("status");
	 			   	String sLevel = "Not Covered";
	 			   	if (iLevel == 0){
		 			   	sLevel = "Covered";
	 			   	} else if (iLevel == 1){
		 			   	sLevel = "Can Read";
	 			   	} else if (iLevel == 2){
		 			   	sLevel = "Can Write";
	 			   	}
	 			   	
						%>Level : <%=sLevel%><br><%  			   		
 			   		int iLine1 = rsArticle.getInt("line1");
 			   		lineQueryStmt.setInt(1, iLine1);
 			   		ResultSet rsL = lineQueryStmt.executeQuery();
 			   		while (rsL.next()){
						%>Example : <a href="${pageContext.request.contextPath}/article.jsp?articleNo=<%=""+rsL.getInt("idwenzhang")%>"><%=rsL.getString("content")%></a> <br><%  			   		
 			   		}
 			   		
 			   		grpCharsQueryStmt.setString(1, zi);
 			   		ResultSet rsG = grpCharsQueryStmt.executeQuery();
 			   		while (rsG.next()){
 			   			String grp = rsG.getString("chars");
						%>Group : <%=grp%><br><%  			   		 			   		
 			   		}
               } else {
						%>Cannot Find Character<br><%  			   		
               }
               
          } catch (NamingException e) {
               e.printStackTrace();
          } catch (SQLException e) {
               e.printStackTrace();
          }finally{
         
	          if ( connection != null){
	          	try {
	          	 connection.close();
	          	 connection = null;
	          	 }catch (Throwable e){
	          	 }
	          }
          }
%>
	<form action="/HanziTest/zi.jsp" id="check_form">
			<input type="hidden" name="zi" value="<%=zi %>"/>
			<input type="text" name="check" size="2" maxlength="1" />
			<input type="submit" id="sb_form_go" title="Search" tabIndex="0" name="go" value="check"/>
	</form>

</body>
</html>