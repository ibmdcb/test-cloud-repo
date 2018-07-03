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
String toNewLevel = request.getParameter("newLevel");

int iArticleNo = -1;
int iNewLevel = 0;

if ( toRead != null && toNewLevel != null){
	try {
		iArticleNo = Integer.parseInt(toRead);
		iNewLevel = Integer.parseInt(toNewLevel);
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

 

Connection connection = null; 
try {
    connection = DBUtil.getConnection();
	Statement stmt = connection.createStatement();
	
	PreparedStatement wenzStmt = connection.prepareStatement("select * from wenzhang where idwenzhang = ?");
	PreparedStatement wenzUpdateStmt = connection.prepareStatement("update wenzhang set status = ? where idwenzhang = ?");
	wenzStmt.setInt(1, iArticleNo);	
	ResultSet rsWS = wenzStmt.executeQuery();
	if (rsWS.next()){
		String title = rsWS.getString("title");
		int oldStat = rsWS.getInt("status");
		if ( oldStat < iNewLevel){
			wenzUpdateStmt.setInt(1, iNewLevel);
			wenzUpdateStmt.setInt(2, iArticleNo);
			wenzUpdateStmt.executeUpdate();
		}		
	} else {
		//doesn't exist
		return;
	}
	
	PreparedStatement insertStmt = connection.prepareStatement("select * from yz.lines where idwenzhang = ?");
	insertStmt.setInt(1, iArticleNo);	
	ResultSet rs = insertStmt.executeQuery();
	
	PreparedStatement charQueryStmt = connection.prepareStatement("select * from yz.hanzi where hanzichar = ?");
	PreparedStatement charInsertStmt = connection.prepareStatement("insert into yz.hanzi (hanzichar, line1, count, status) values ( ?, ?, ?, ?)");
	PreparedStatement charCountIncStmt = connection.prepareStatement("update yz.hanzi set count = ? where hanzichar = ?");
	PreparedStatement charStatIncStmt = connection.prepareStatement("update yz.hanzi set status = ?, line1 = ? where hanzichar = ?");
	
	int iInserts = 0;
	int iTotal = 0;
	int iExisting = 0;
	int iCountIncr = 0;
	
	ArrayList<Character> chars = new ArrayList<Character>();
	while (rs.next()){
		int idLines = rs.getInt("idlines"); 
		String content = rs.getString("content");
		
		for ( int i = 0 ; i < content.length(); i++){
			char thisChar = content.charAt(i);			
			if (!chars.contains(Character.valueOf(thisChar))){
				iTotal++;
				chars.add(Character.valueOf(thisChar));
				charQueryStmt.setString(1, "" + thisChar);
				ResultSet charRs = charQueryStmt.executeQuery();
				if (charRs.next()){
					iExisting++;
					//Already has this letter
					int oldLine = charRs.getInt("line1");
					int oldLevel = charRs.getInt("status");
					int oldCount = charRs.getInt("count");
					
					if ( oldLine != idLines && iNewLevel == -1){
						iCountIncr++;
						oldCount ++;						
						charCountIncStmt.setInt(1, oldCount + 1);
						charCountIncStmt.setString(2, "" + thisChar);
						charCountIncStmt.executeUpdate();
					} else if (iNewLevel >= oldLevel){
						iCountIncr++;
						charStatIncStmt.setInt(1, iNewLevel);
						charStatIncStmt.setInt(2, idLines);
						charStatIncStmt.setString(3, "" + thisChar);
						charStatIncStmt.executeUpdate();
					}
					
					 
				} else {
					iInserts++;
					charInsertStmt.setString(1, "" + thisChar);
					charInsertStmt.setInt(2, idLines);
					charInsertStmt.setInt(3, 1);
					charInsertStmt.setInt(4, iNewLevel); //1 learning, 100 learned
					charInsertStmt.executeUpdate();
				}	
			} else {
				//duplicate, do nothing
			}		
		}//end for one line
	
	}//end all lines		
	
%>
Article Taken. <br>
Total Unique Characters = <%=iTotal %> <br>
Existing = <%=iExisting%> <br>
Existing count increase or stats change = <%=iCountIncr %> <br>
New = <%=iInserts %> <br>


 <a href="/HanziTest/article.jsp?read=<%= toRead %>" >Please review</a><br>
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