package com.kh.FinalProject.member.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kh.FinalProject.member.model.dao.MemberDao;
import com.kh.FinalProject.member.model.service.MemberService;
import com.kh.FinalProject.member.model.service.MemberServiceImpl;
import com.kh.FinalProject.member.model.vo.Member;

@WebListener
@Component
public class HttpSessionCheckingListener implements HttpSessionListener {
//    Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private MemberService mService;
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	 	
    static private int activeSessions;
    
    public static int getActiveSessions() {
        return activeSessions;
    }
    
    @Override
    public void sessionCreated(HttpSessionEvent event) {
    	activeSessions++;
 	HttpSession session= event.getSession();
 	Member m= (Member) session.getAttribute("loginUser");
 	System.out.println(m);
 	System.out.println("dsfsefsffff"+session.getId());
   
    	
    }
    
    
    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
    	HttpSession session= event.getSession();
        Member m= (Member) session.getAttribute("loginUser");
        System.out.println("sdfsfeeee"+m.getId());
        Connection conn = getConnection();
        if(m.getId() !=null){
        	
        	int num = getlogoutTime(conn, m.getId());
        	if(num>0) {
        		close(conn);
        	}
        	
        	System.out.println("결과" + num);
        }
        

        close(conn);
        
    	activeSessions--;
    	
    	
               
    	System.out.println(session.getId());
    }
    
    
    public static Connection getConnection()
	{
		Connection conn = null;
		
		try {
			
		
			
			String driver = "oracle.jdbc.driver.OracleDriver";
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "travel";
			String password = "travel";
			
			Class.forName(driver);
			
			conn = DriverManager.getConnection(url,user,password);
			
			conn.setAutoCommit(false);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
    
    public int getlogoutTime(Connection conn, String id) {
    	String quary ="UPDATE TIME SET USER_TIME =TO_CHAR(SYSDATE,'YYYYMMDDHH24MISS')\r\n" + 
    			"					 WHERE USER_ID=?";
		int rs=0;
		try {
			PreparedStatement ps = conn.prepareStatement(quary);
			ps.setString(1, id);
			rs =ps.executeUpdate();
			if(rs>0) {
				commit(conn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
    
    public static void commit(Connection conn)
	{
		try {
			if(conn != null && !conn.isClosed())
			{
				conn.commit();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
    public static void close(Connection conn)
	{
		try {
			if(conn != null && !conn.isClosed())
			{
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
    
    
    
}

	

	
