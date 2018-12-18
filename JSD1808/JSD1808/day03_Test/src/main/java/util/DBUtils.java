package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.commons.dbcp.BasicDataSource;

public class DBUtils {
	private static BasicDataSource dataSource;
	static {

	}
	public static Connection getConn() {
		return null;
	}
	public static void close(Connection conn,Statement state,ResultSet rs) {
		
		
	}
	
}
