<!DOCTYPE HTML><%@page import="com.hanzi.db.util.DBUtil"%>
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

<ul>
<li>写字的必要性：不写记不牢。防止孩子只记部分。造成不相干的字的混淆，比如＂是＂和＂走＂。</li>
<li>什么时候开始：孩子上K后，开始写字母后，就可以写汉字了。</li>
<li>为什么会写的文章要先会背：可以自行练习，不用家长听写。同时知道所写字怎么用到句子中。</li>
<li>以＂背＂原则，建议采用歌词，诗，或者清单，如一到十。</li>
</ul>

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
               
               String msg = "Nothing";
               
               if ( inS != null){
               		String insertStatement ="insert into wenzhang (title) values ('" + inS + "')";
               		System.out.println(insertStatement); 
               		try{
		               stmt.executeUpdate(insertStatement);
		            	msg = "DONE : " + insertStatement;   		               
		            }catch (Exception e){
		            	e.printStackTrace();
		            	msg = e.getMessage();
		            }
               }
               
               System.out.println("msg");
%>




<h2>已有文章</h2>

<table>
<%

               ResultSet resultSet = stmt.executeQuery("select * from wenzhang order by status DESC");
               while (resultSet.next()) {
                    int ssn = resultSet.getInt("idwenzhang");
                    String zi = resultSet.getString("title");
                    int level = resultSet.getInt("status");
                    System.out.println("id " + ssn + " : " + zi);
%>

<tr>
<td>ID <%= "" + ssn %> </td>
<td>&nbsp;</td>
<td> <a href="${pageContext.request.contextPath}/article.jsp?articleNo=<%=ssn%>"> <%=zi %> </a></td>
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


	<form action="/HanziTest/articlelist.jsp" id="sb_form">
			<input type="text" name="q" size="20" maxlength="1000" />
			<input type="submit" id="sb_form_go" title="Search" tabIndex="0" name="go" />
	</form>


</body>
</html>