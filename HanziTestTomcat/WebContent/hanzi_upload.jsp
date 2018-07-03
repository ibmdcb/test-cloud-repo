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

String inS = request.getParameter("inputtext");
String toNewLevel = request.getParameter("newLevel");
String sTest = request.getParameter("test");
boolean test = ("test".equalsIgnoreCase(sTest) );
%>

test : <%=test %><br>
<%

int iNewLevel = 0;
if ( inS != null && toNewLevel != null){
	byte [] jiema = inS.getBytes ("iso8859-1"); 
	inS = new String (jiema, "UTF-8");// 

	try {
		iNewLevel = Integer.parseInt(toNewLevel);
	}catch (NumberFormatException e){
		response.sendRedirect("/HanziTest/articlelist.jsp");
		return;
	}
}

%>




<%


		Connection connection = null; 
          try {
              connection = DBUtil.getConnection();
               Statement stmt = connection.createStatement();
 				
	PreparedStatement charQueryStmt = connection.prepareStatement("select * from yz.hanzi where hanzichar = ?");
	PreparedStatement charInsertStmt = connection.prepareStatement("insert into yz.hanzi (hanzichar, gradelevel, line1, count, status, pinyin) values ( ?, ?, ?, ?, ?, ?)");
	PreparedStatement charUpdateGradeStmt = connection.prepareStatement("update yz.hanzi set gradelevel = ?, pinyin = ? where hanzichar = ?");

               String msg = "";
               
               if ( inS != null){

 int iCount = 0;
 int iExisting = 0;
 int iInserts = 0;
 	   
 for ( int i= 0; i< inS.length(); i++){
	char thisChar = inS.charAt(i);
	boolean thisCharChinese = (Character.UnicodeBlock.of(thisChar) == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS);
	if (thisCharChinese){
	String pinyin = "";
	iCount++;
	
				if (inS.charAt(i+1) == '('){
					int j = i;
					for ( ; j < i + 10; j++ ){
						if ( inS.charAt(j) == ')'){
							pinyin = inS.substring(i+2, j);
%>
<%= "" + thisChar%> : <%= pinyin%>	<br>
<%							
							i = j;				
							break;
						}					
					}
				}
				

if(!test){				
				charQueryStmt.setString(1, "" + thisChar);
				ResultSet charRs = charQueryStmt.executeQuery();
				if (charRs.next()){
					iExisting++;
					//Already has this letter					
					charUpdateGradeStmt.setInt(1, iNewLevel);
					charUpdateGradeStmt.setString(2, pinyin);
					charUpdateGradeStmt.setString(3, "" + thisChar);
					charUpdateGradeStmt.executeUpdate();
				} else {
					iInserts++;
					charInsertStmt.setString(1, "" + thisChar);
					charInsertStmt.setInt(2, iNewLevel); //gradelevel
					charInsertStmt.setInt(3, -1);//line no. -1 means none.
					charInsertStmt.setInt(4, 0);//count
					charInsertStmt.setInt(5, -1); //-1 means never touched.
					charInsertStmt.setString(6, pinyin); //pinyin.
					charInsertStmt.executeUpdate();
				}	
}				
	} 
	
 	}
 %>
 
 Total : <%=iCount %>
 Existing : <%=iExisting %>
 New : <%=iInserts %>
 <%
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

<br>

<br>
<h1>更新文章内容</h1>


	<form action="/HanziTest/hanzi_upload.jsp" id="sb_form">
		Grade Level : <input type="text" name="newLevel" value="<%= toNewLevel %>"/><br>
			<textarea name="inputtext" style="width: 580px" rows="15" ><%=inS %></textarea><br>
		<input type="submit" id="sb_form_go" title="Search" tabIndex="0" name="test" value="test"/>
		<input type="submit" id="sb_form_go" title="Search" tabIndex="0" name="go" value="submit"/>
	</form>


</body>
</html>