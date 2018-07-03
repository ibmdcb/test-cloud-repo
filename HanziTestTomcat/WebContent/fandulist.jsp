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

String add = request.getParameter("add");
String inS = request.getParameter("title");
if ( inS != null ){
	System.out.println(inS);
	byte [] jiema = inS.getBytes ("iso8859-1"); 
	inS = new String (jiema, "UTF-8");// 
	System.out.println(inS);
}

String toRead = request.getParameter("content");
if ( toRead != null ){
	byte[] jiema = toRead.getBytes ("iso8859-1"); 
	toRead = new String (jiema, "UTF-8");// 
}

//inS = new String(inS.getBytes(), "UTF-8");
 
%>




<%
		Connection connection = null; 
          try {
              connection = DBUtil.getConnection();
               Statement stmt = connection.createStatement();
			PreparedStatement insertStatement = connection.prepareStatement( "insert into fandu (title, content) values (?, ?)");
               
               String msg = "Nothing";
               
               if ( inS != null && add != null && toRead != null){
               
	               insertStatement.setString(1, inS);
	               insertStatement.setString(2, toRead);
               		try{
		               insertStatement.executeUpdate();
		            	msg = "DONE : " + inS;   		               
		            }catch (Exception e){
		            	e.printStackTrace();
		            	msg = e.getMessage();
		            }
               }
%>
<%= msg %><br>




<h2>已有文章</h2>

<table>
<%

               ResultSet resultSet = stmt.executeQuery("select * from fandu");
               while (resultSet.next()) {
                    int ssn = resultSet.getInt("idfandu");
                    String zi = resultSet.getString("title");
                    int level = resultSet.getInt("status");
                    System.out.println("id " + ssn + " : " + zi);
%>

<tr>
<td>ID <%= "" + ssn %> </td>
<td>&nbsp;</td>
<td> <a href="/HanziTestTomcat/fandu.jsp?articleNo=<%=ssn%>"> <%=zi %> </a></td>
<td>&nbsp;</td>
<td> L <%= level%></td>
</tr>
<%
               }

%>
</table>
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

<br>
<h2>新添文章</h2>


	<form action="${pageContext.request.contextPath}/fandulist.jsp" id="sb_form" method="post">
			<input type="text" name="title" size="80" maxlength="1000" /><br>
			<textarea name="content" style="width: 580px" rows="15"></textarea>
			<input type="submit" id="sb_form_go" title="Search" tabIndex="0" name="add" />
	</form>


</body>
</html>