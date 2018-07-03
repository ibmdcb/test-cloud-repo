<!DOCTYPE HTML><%@page import="com.hanzi.session.CharecterUtil"%>
<%@page import="com.hanzi.db.util.HanziUtil"%>
<%@page import="com.hanzi.db.util.DBUtil"%>
<%@page import="java.util.HashMap"%>
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

String userid = "zack";
int numCharsPerLine = 20;
int numCharsForMark = 8;

/*
change charector Status
*/

Connection connection = null; 
try {
	connection = DBUtil.getConnection();
	String[] values = request.getParameterValues("markToRead");
	if ( values != null ){
		CharecterUtil.updateStatus(connection, HanziUtil.convertStringArray(values), 1, userid);
	}

	values = request.getParameterValues("markToUnRead");
	if ( values != null ){
		CharecterUtil.updateStatus(connection, HanziUtil.convertStringArray(values), 0, userid);
	}
/*
String inS = request.getParameter("inputtext");
if ( inS != null ){
	byte [] jiema = inS.getBytes ("iso8859-1"); 
	inS = new String (jiema, "UTF-8");// 
}
*/


String toRead = request.getParameter("articleNo");
if ( toRead != null ){
	byte[] jiema = toRead.getBytes ("iso8859-1"); 
	toRead = new String (jiema, "UTF-8");// 
}

//inS = new String(inS.getBytes(), "UTF-8");
if (toRead == null){
	response.sendRedirect("/HanziTestTomcat/articlelist.jsp");
	return;
}
 


                            
               Statement stmt = connection.createStatement();
 				
 			   ResultSet rsArticle = stmt.executeQuery("select * from fandu where idfandu = '" + toRead + "'");
 			   String articleTitle = "";
 			   int currentLevel = 0;
 			   String content = null;
 			   if (rsArticle.next()){
 			   		articleTitle = rsArticle.getString("title");
 			   		currentLevel = rsArticle.getInt("status");
 			   		content = rsArticle.getString("content");
               } else {
	               articleTitle = "Article Not Found.";
               }

%>
<br>
<h2>文章标题 : <%=articleTitle %></h2>

<%

if (toRead != null && content != null){

	boolean newGraph = true;
	int j = 0;
	
	ArrayList<Character> unknownChars = new ArrayList<Character>(256);
	ArrayList<Character> knownChars = new ArrayList<Character>(256);
	 
	String zi = content;
	for (int i = 0 ; i < zi.length(); i ++){
    	char thisChar = zi.charAt(i);
    	if (thisChar == '\r' ){
    		if ( j % numCharsPerLine != 0){
    			j = j % numCharsPerLine;
				for ( int idx = (j + 1); idx <= numCharsPerLine; idx ++){
%><td></td><%		
					if ( idx == numCharsPerLine){
%></tr><%							
					}	
				}
    		}
%></table><%
    		j = 0;
			newGraph = true;
		} else {
			if (newGraph){
%><table><%
				newGraph = false;
			}
			j++;
			
			if (j % numCharsPerLine == 1){
%><tr><%			
			}
	        boolean thisCharChinese = (Character.UnicodeBlock.of(thisChar) == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS);
    	    if( thisCharChinese){            
						PreparedStatement charQueryStmt = connection.prepareStatement("select * from yz.hanzi where hanzichar = ?");
                    	charQueryStmt.setString(1, "" + zi.charAt(i));
                    	ResultSet rs = charQueryStmt.executeQuery();
                    	String fcolor = null;
                    	String color = null;
                    	String pinyin = "";
                    	String pinyinColor = "black";
		 			   	int stat = 0;
                    	if (rs.next()){
			 			   	//stat = rs.getInt("status");
                    		pinyin = rs.getString("pinyin");
			 			}
                    	
                    	PreparedStatement statusStmt = connection.prepareStatement(
						"select * from yz.userhzlvl where userhzlvl.zi = ? and userid = ?") ;
			 			statusStmt.setString(1, "" + zi.charAt(i));
			 			statusStmt.setString(2, userid);
                    	ResultSet statusRs = statusStmt.executeQuery();
                    	if (statusRs.next()){
			 			   	stat = statusRs.getInt("level");
			 			}
                    	
			 			//For Mark Words
			 			
			 			if ( stat < 1 && !unknownChars.contains(Character.valueOf(zi.charAt(i)))){
			 				unknownChars.add(Character.valueOf(zi.charAt(i)));
			 			} else if ( stat >= 1 && !knownChars.contains(Character.valueOf(zi.charAt(i)))){
			 				knownChars.add(Character.valueOf(zi.charAt(i)));
			 			}
			 			
			 			
			 			//For Display
			 			fcolor = "#008000";
	                    if (stat == 2){
	                    	color = "#FFFFFF";//white, means covered
	                    	//fcolor = "#008000"; // can write
	                    	//pinyin ="";
	                    	pinyinColor = "white";
	                    } else if (stat == 1){
	                    	color = "#FFFFFF";//white, means covered
	                    	//fcolor = "#FFA500";  // can read
	                    	//pinyin ="";                    	 
	                    	pinyinColor = "white";
	                    } else if (stat == 0){
	                    	color = "#FFFFFF";//new
	                    	//fcolor = "#000000";  // can read
	                    } else {
	                    	color = "#FFFFFF";  // new
	                    	//fcolor = "#C0C0C0";//silver, means greyed out
	                    }	                    
%><td width="5%"><font color="<%=pinyinColor%>" size="+1"><%=pinyin%></font><br>
<!-- <a href="/HanziTestTomcat/zi.jsp?zi=<%=zi.charAt(i)%>"> --><font size="+2" color="<%=fcolor%>"><%=zi.charAt(i) %></font></a>
</td> <%
			} else {
%><td width="5%"><font>&nbsp;<br><%=zi.charAt(i) %></font></td> <%
			}
			if (j % numCharsPerLine == 0){
%></tr><%			
			}				
		}//Not a new line
	}//for
	
	//Conclude the table
    	if (true ){
    		if ( j % numCharsPerLine != 0){
    			j = j % numCharsPerLine;
				for ( int idx = (j + 1); idx <= numCharsPerLine; idx ++){
%><td></td><%		
					if ( idx == numCharsPerLine){
%></tr><%							
					}	
				}
    		}
%></table><%
    		j = 0;
			newGraph = true;
		}
%>

<br>

<!-- new charectors -->
<% if ( unknownChars.size() > 0){ %>

<br>
<h2>生字列表 :</h2>

选择生字加入＂认读字表＂。加入认读字表的字将不再显示拼音。
	<form action="/HanziTestTomcat/fandu.jsp" id="sb_form_take">
	
<% 		for ( int i = 0 ; i < unknownChars.size(); i++ ){ %>
			<input type="checkbox" name="markToRead" value="<%=""+unknownChars.get(i).charValue()%>"/><%=""+unknownChars.get(i).charValue()%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;				
<%			if ( (i+1) % numCharsForMark == 0){
				%><br><%
			}
		} %>	
		<br>
		<br>
		<input type="hidden" name="articleNo" value="<%=toRead%>"/>
		<input type="submit" id="sb_form_go" title="Search" tabIndex="0" name="markAsRead"  value="加入任读字表"/>
	</form>

<% 
	} //End check on unknown words 
%>

<!-- new charectors -->

<% if ( knownChars.size() > 0){ %>

<br>
<h2>认字列表 :</h2>

选择生字加入＂认读字表＂。加入认读字表的字将不再显示拼音。
	<form action="/HanziTestTomcat/fandu.jsp" id="sb_form_take">
	
<% 		for ( int i = 0 ; i < knownChars.size(); i++ ){ %>
			<input type="checkbox" name="markToUnRead" value="<%=""+knownChars.get(i).charValue()%>"/><%=""+knownChars.get(i).charValue()%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;				
<%			if ( (i+1) % numCharsForMark == 0){
				%><br><%
			}
		} %>	
		<br>
		<br>
		<input type="hidden" name="articleNo" value="<%=toRead%>"/>
		<input type="submit" id="sb_form_go" title="Search" tabIndex="0" name="go"  value="加入任读字表"/>
	</form>

<% 
	} //End check on unknown words 
%>

<%
}//END DISPLAY CURRENT CONTENT

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

<br>

</body>
</html>