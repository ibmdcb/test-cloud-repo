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

<jsp:include page="header.jsp" />

<%

String inS = request.getParameter("inputtext");
if ( inS != null ){
	byte [] jiema = inS.getBytes ("iso8859-1"); 
	inS = new String (jiema, "UTF-8");// 
}

String toRead = request.getParameter("articleNo");
if ( toRead != null ){
	byte[] jiema = toRead.getBytes ("iso8859-1"); 
	toRead = new String (jiema, "UTF-8");// 
}

//inS = new String(inS.getBytes(), "UTF-8");
if (toRead == null){
	response.sendRedirect("/HanziTest/articlelist.jsp");
	return;
}
 
%>




<%

boolean isEmpty = true;
		Connection connection = null; 
          try {
              connection = DBUtil.getConnection();
               Statement stmt = connection.createStatement();
 				
 			   ResultSet rsArticle = stmt.executeQuery("select * from wenzhang where idwenzhang = '" + toRead + "'");
 			   String articleTitle = "";
 			   int currentLevel = 0;
 			   if (rsArticle.next()){
 			   		articleTitle = rsArticle.getString("title");
 			   		currentLevel = rsArticle.getInt("status");
               } else {
	               articleTitle = "Article Not Found.";
               }

%>
<h2>文章标题 : <%=articleTitle %></h2>

<%

if (toRead != null){
               ResultSet resultSet = stmt.executeQuery("select * from yz.lines where idwenzhang = '" + toRead +"'");
               while (resultSet.next()) {
               		isEmpty = false;	
                    int ssn = resultSet.getInt("idlines");
                    String zi = resultSet.getString("content");
                    System.out.println("id " + ssn + " : " + zi);
%>
Line <%= "" + ssn %> : 

<%
                    for (int i = 0 ; i < zi.length(); i ++){
					PreparedStatement charQueryStmt = connection.prepareStatement("select * from yz.hanzi where hanzichar = ?");
                    	charQueryStmt.setString(1, "" + zi.charAt(i));
                    	ResultSet rs = charQueryStmt.executeQuery();
                    	String fcolor = null;
                    	String color = null;
		 			   	int stat = 0;
                    	if (rs.next()){
			 			   	stat = rs.getInt("status");
			 			}
	                    if (stat == 2){
	                    	color = "#FFFFFF";//white, means covered
	                    	fcolor = "#008000"; // can write                    	 
	                    } else if (stat == 1){
	                    	color = "#FFFFFF";//white, means covered
	                    	fcolor = "#FFA500";  // can read
	                    } else if (stat == 0){
	                    	color = "#FFFFFF";//white, means covered
	                    	fcolor = "#C0C0C0";  // can read
	                    } else {
	                    	color = "#FFFFFF";  // can read
	                    	fcolor = "#C0C0C0";//silver, means greyed out
	                    }
%><font color="<%=fcolor%>"><%=zi.charAt(i) %></font> <%
                    }//for

%><br><%
		}//while
%>


<br>
<br>

	<form action="/HanziTest/article_take.jsp" id="sb_form_take">
		<input type="hidden" name="articleNo" value="<%=toRead%>"/>
Current Level : <%= "" + currentLevel %> <br>

<input type="text" name="newLevel" value="<%=currentLevel%>"/>
		<input type="submit" id="sb_form_go" title="Search" tabIndex="0" name="go"  value="Assign New Level"/>
	</form>

<%
}//END DISPLAY CURRENT CONTENT

%>


<%               
               String msg = "";
               
               if ( inS != null){
%>

<h1>保存文章</h1>

<!-- 
<%=inS %>
 -->
 
<form action="/HanziTest/article_save.jsp" id="article_save_form">
<input type="hidden" name="articleNo" value="<%=toRead%>"/>
 <% 

boolean toStart = true;
char[] thisline = new char[128];
int thislinepos = 0;
ArrayList<String> linesArray = new ArrayList<String>(128);
   
 for ( int i= 0; i< inS.length(); i++){

	char thisChar = inS.charAt(i);
	boolean thisCharChinese = (Character.UnicodeBlock.of(thisChar) == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS);
	if (thisCharChinese){
		thisline[thislinepos] = thisChar;
		thislinepos++;
			
%>
<%
	} 
	
	if ( !thisCharChinese || i == inS.length()-1){
	
		if ( thislinepos != 0){
			String lineLineStr = new String(thisline, 0, thislinepos);
			thislinepos = 0;
			linesArray.add(lineLineStr);
%>
<%= "" + lineLineStr %> <br>
<%
		}
%>
<!-- 
<%= "" + thisChar + " : " + ((int)thisChar) %> : N.<br>
-->
<%
	}
}

/*               
               		String insertStatement ="insert into lines (title) values ('" + inS + "')";
               		System.out.println(insertStatement); 
               		try{
		               stmt.executeUpdate(insertStatement);
		            	msg = "DONE : " + insertStatement;   		               
		            }catch (Exception e){
		            	e.printStackTrace();
		            	msg = e.getMessage();
		            }
*/
			session.setAttribute("FormattedLines", linesArray);

%>
<br>

			<input type="submit" id="savelines" title="Save" name="saveButton" />
</form>
<%
               }//end if processing/formatting input text

%>


<%= msg %><br>




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

<%
	if(isEmpty){
%>

<br>
<h2>更新文章内容</h2>


	<form action="/HanziTest/article.jsp" id="sb_form">
		<input type="hidden" name="articleNo" value="<%=toRead%>"/>
			<textarea name="inputtext" style="width: 580px" rows="15"></textarea>
			<input type="submit" id="sb_form_go" title="Search" tabIndex="0" name="go" />
	</form>

<%
	}
%>

</body>
</html>