package fr.natsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_Connection {

	public static Connection get_Connection() {
		Connection connection=null;
				
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cardgame?useSSL=false","root","eniot28");
			System.out.println("Connexion " + connection);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return connection;
	}
	
	public static void close_Connection(Connection connection){
        if(connection != null){
            try {
            	System.out.println("Déconnexion " + connection);
            	connection.close(); 
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
