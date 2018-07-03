package com.hanzi.session;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.hanzi.bo.CharecterDetail;
import com.hanzi.db.util.DBUtil;

public class CharecterUtil {
	
	public static void main(String args[]){  
		try{  
			char ch1 = '大';
			char ch2 = '家';
			Connection con=DBUtil.getConnectionNonJNDI();
			
			CharecterDetail cd = getCharecterDetails(con, ch1);
			System.out.println(cd);			
			cd = getCharecterDetails(con, ch2);
			System.out.println(cd);

			String str = "大家";
			updateStatus(con, str, 1, "zack");
			
			cd = getCharecterDetails(con, ch1);
			System.out.println(cd);
			cd = getCharecterDetails(con, ch2);
			System.out.println(cd);
			
			con.close();  
		}catch(Exception e){ 
			System.out.println(e);
		}  
	}  
	
	public static CharecterDetail getCharecterDetails(Connection con, char ch){  
		CharecterDetail cd = null;
		try{  
			PreparedStatement charQueryStmt = con.prepareStatement("select * from yz.hanzi where hanzichar = ?");
        	charQueryStmt.setString(1, "" + ch);
        	ResultSet rs = charQueryStmt.executeQuery();
			while(rs.next()) {  
				cd = new CharecterDetail(ch, rs.getString("pinyin"), rs.getInt("status"));
				break;
			}
			//con.close();  
		}catch(Exception e){ 
			System.out.println(e);
		}  
		return cd;
	}  

	public static void updateStatus(Connection con, char ch, int status, String userid){  
		try{  
			//PreparedStatement charQueryStmt = con.prepareStatement("update yz.userhzlvl set status = ? where zi = ? and userid = ?");			
			PreparedStatement charQueryStmt = con.prepareStatement("insert into yz.userhzlvl (level, zi, userid) values (?, ?, ?) ON DUPLICATE KEY UPDATE level=?");			
        	charQueryStmt.setInt(1, status);
        	charQueryStmt.setString(2, "" + ch);
        	charQueryStmt.setString(3, userid);
           	charQueryStmt.setInt(4, status);
            charQueryStmt.executeUpdate();
		}catch(Exception e){ 
			System.out.println(e);
		}  
	}  

/*
	public static void updateStatus(Connection con, String chars, int status){  
		try{
			StringBuffer inStr = new StringBuffer(128); 
			inStr.append("(");
			for ( int i = 0; i< chars.length(); i++ ) {
				inStr.append("'");
				inStr.append(chars.charAt(i));
				inStr.append("'");
				if ( i < chars.length() - 1) {
					inStr.append(",");
				}
			}
			inStr.append(")");
			
			String updateString = "update yz.hanzi set status = ? where hanzichar in " + inStr.toString();
			System.out.println(updateString);
			
			PreparedStatement charQueryStmt = con.prepareStatement(updateString);
			
        	charQueryStmt.setInt(1, status);
        	//charQueryStmt.setString(2, "" + ch);
        	charQueryStmt.executeUpdate();
		}catch(Exception e){ 
			System.out.println(e);
		}  
*/
	
	public static void updateStatus(Connection con, String chars, int status, String userid){  
		try{
			StringBuffer inStr = new StringBuffer(128); 
			inStr.append("(");
			for ( int i = 0; i< chars.length(); i++ ) {
				updateStatus(con, chars.charAt(i), status, userid);
			}
		}catch(Exception e){ 
			System.out.println(e);
		}  
	}  
}
