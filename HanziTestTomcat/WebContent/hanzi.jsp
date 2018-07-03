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

<%

String listbyStatus = request.getParameter("status");

String inS = request.getParameter("q");
if ( inS != null ){
byte [] jiema = inS.getBytes ("iso8859-1"); 
inS = new String (jiema, "UTF-8");// 
//inS = new String(inS.getBytes(), "UTF-8");
 
%>



<%
 for ( int i= 0; i< inS.length(); i++){
 %>
 <%= "" + inS.charAt(i) %><br>
 <%
 }
}
%>

<%
          try {
              Connection connection = DBUtil.getConnection();
               Statement stmt = connection.createStatement();
               
               ResultSet resultSet = null;
               if ( "1".equals(listbyStatus) || "2".equals(listbyStatus) || "0".equals(listbyStatus)  ){
	               resultSet = stmt.executeQuery("select * from hanzi where status = " + listbyStatus + " order by gradelevel ASC");
	           } else {
	               resultSet = stmt.executeQuery("select * from hanzi order by gradelevel ASC");
	           }
               
%>
<table> <tr>
<%
				int iNum = 0;               
               while (resultSet.next()) {
                    int ssn = resultSet.getInt("idhanzi");
                    String zi = resultSet.getString("hanzichar");
                    int count = resultSet.getInt("count");
                    int stat = resultSet.getInt("status");
                    int grd = resultSet.getInt("gradelevel");
                    String color = "";
                    String fcolor = "";
                    if (stat == 2){
                    	fcolor = "#FFFFFF";//white, means covered
                    	color = "#008000"; // can write                    	 
                    } else if (stat == 1){
                    	color = "#FFFFFF";//white, means covered
                    	fcolor = "#FFA500";  // can read
                    } else if (stat == 0){
                    	color = "#FFFFFF";//white, means covered
                    	fcolor = "#C0C0C0";  // can read
                    } else {
                    	fcolor = "#FFFFFF";  // can read
                    	color = "#C0C0C0";//silver, means greyed out
                    }


if (iNum % 10 == 0){
%></tr><tr><%
}
%>

<td>&nbsp;</td>

<td bgcolor=<%= color%>><a href="${pageContext.request.contextPath}/zi.jsp?zi=<%=zi%>"><font color="<%=fcolor%>"><%=zi %></font></a></td>
<td>&nbsp;</td>
<td><%= "" + grd %></td>

<%
				iNum++;
               }
%>
</tr></table> 
<br>
总共 : <%=iNum %>个汉字.

<%
          } catch (NamingException e) {
               e.printStackTrace();
          } catch (SQLException e) {
               e.printStackTrace();
          }


Date date = new Date();
SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");  
SimpleDateFormat formatter3 = new SimpleDateFormat("EEE, MMM d, ''yy");  
SimpleDateFormat formatter4 = new SimpleDateFormat("h:mm a");
SimpleDateFormat formatter5 = new SimpleDateFormat("hh 'o''clock' a, zzzz");  
SimpleDateFormat formatter6 = new SimpleDateFormat("K:mm a, z"  );  
SimpleDateFormat formatter7 = new SimpleDateFormat("yyyyy.MMMMM.dd GGG hh:mm aaa" );  
SimpleDateFormat formatter8 = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");  
SimpleDateFormat formatter9 = new SimpleDateFormat("yyMMddHHmmssZ");
SimpleDateFormat formatter10 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");  


%>



	<form action="/HanziTest/articlelist.jsp" id="sb_form">
			<input type="text" name="q" size="20" maxlength="1000" />
			<input type="submit" id="sb_form_go" title="Search" tabIndex="0" name="go" />
	</form>


</body>
</html>