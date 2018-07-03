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

All the Characters <a href="/HanziTest/hanzi.jsp">Here</a>.

<%

String inS = request.getParameter("q");
if ( inS != null ){
	byte [] jiema = inS.getBytes ("iso8859-1"); 
	inS = new String (jiema, "UTF-8");// 
}

String toRead = request.getParameter("read");
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

			PreparedStatement insertIDStatement = connection.prepareStatement("insert into hztogrp (hanzi, idgrp) values (?, ? )");
               
               String msg = "Nothing";
               
               if ( inS != null){

               		String insertStatement ="insert into hanzigroup (chars) values ('" + inS + "')";
               		System.out.println(insertStatement); 
               		try{
		               stmt.executeUpdate(insertStatement, Statement.RETURN_GENERATED_KEYS);
		               ResultSet rs = stmt.getGeneratedKeys();
		               if (rs.next()){
		               		System.out.println("rs. next ----");
		               		int grpID = rs.getInt(1);
		               		System.out.println("idhanzigroup " + grpID);
		               		for ( int idx = 0 ; idx < inS.length(); idx ++){
		               			insertIDStatement.setString(1, ""+inS.charAt(idx));
		               			insertIDStatement.setInt(2, grpID);
		               			insertIDStatement.executeUpdate();
							}		               			
		               }
		            	msg = "DONE : " + insertStatement;   		               
		            }catch (Exception e){
		            	e.printStackTrace();
		            	msg = e.getMessage();
		            }
               }
%>
<%= msg %><br>




<h1>Existing Groups</h1>

<table>
<%

               ResultSet resultSet = stmt.executeQuery("select * from hanzigroup");
               while (resultSet.next()) {
                    int ssn = resultSet.getInt("idhanzigroup");
                    String zi = resultSet.getString("chars");
                    int level = resultSet.getInt("status");
                    //System.out.println("id " + ssn + " : " + zi);
%>

<tr>
<td>ID <%= "" + ssn %> </td>
<td>&nbsp;</td>
<td> <%=zi %> </td>
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
<h1>New Group</h1>


	<form action="${pageContext.request.contextPath}/hanzigroup.jsp" id="sb_form">
			<input type="text" name="q" size="20" maxlength="1000" />
			<input type="submit" id="sb_form_go" title="Search" tabIndex="0" name="go" />
	</form>


</body>
</html>