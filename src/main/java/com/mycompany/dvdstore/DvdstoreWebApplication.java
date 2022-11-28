package com.mycompany.dvdstore;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DvdstoreWebApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DvdstoreWebApplication.class, args);
		DataSource ds = context.getBean(DataSource.class);
		Connection conn = null;
		try {
			conn = ds.getConnection();
			System.out.println("sucess connect");
			ResultSet rs = conn.createStatement().executeQuery("SELECT title, genre, description FROM movie");
			while(rs.next()){
				System.out.println(rs.getString("title") + " | " + rs.getString("genre") + " | " + rs.getString("description"));
			}
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			try{
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e){
				e.printStackTrace();
			}

		}
	}

}
