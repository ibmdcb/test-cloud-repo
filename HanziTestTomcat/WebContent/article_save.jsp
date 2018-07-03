<!DOCTYPE HTML><%@page import="com.hanzi.db.util.DBUtil"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.util.ArrayList"%>
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


<%


String toRead = request.getParameter("articleNo");
int iArticleNo = -1;
if ( toRead != null ){
	try {
		iArticleNo = Integer.parseInt(toRead);
	}catch (NumberFormatException e){
		response.sendRedirect("/HanziTest/articlelist.jsp");
		return;
	}
}

//inS = new String(inS.getBytes(), "UTF-8");
if (toRead == null){
	response.sendRedirect("/HanziTest/articlelist.jsp");
	return;
}

ArrayList<String> lines = (ArrayList<String>)session.getAttribute("FormattedLines");

if ( lines == null || lines.size() == 0){
	response.sendRedirect("/HanziTest/articlelist.jsp");
	return;
}
 

Connection connection = null; 
try {
    connection = DBUtil.getConnection();
	Statement stmt = connection.createStatement();
	
	
		PreparedStatement insertStmt = connection.prepareStatement("insert into yz.lines (idwenzhang, content) values (?,?)");
		
		for ( int idx = 0; idx < lines.size(); idx ++){
			insertStmt.setInt(1, iArticleNo);
			insertStmt.setString(2, lines.get(idx));
			insertStmt.execute();	
		}	
	
%>
Article Saved. <a href="/HanziTest/article.jsp?read=<%= toRead %>" >Please review</a><br>
<%		
	

%>


<%               
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

<br>


</body>
</html>