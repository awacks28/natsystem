package fr.natsystem;

import com.mysql.jdbc.Connection;

public class CRUD {
	public static void createCard(Connection connection, int id, String name, int weight, int isFigure, int color) {
		
		java.sql.PreparedStatement ps = null;
		try {
			String query = "INSERT INTO cardgame.cards (idcard, name, weight, figure, colors_id) VALUES (?,?,?,?,?)";
			ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setInt(3, weight);
			ps.setInt(4, isFigure);
			ps.setInt(5, color);
			System.out.println(ps);
			ps.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		}		
	}
}
