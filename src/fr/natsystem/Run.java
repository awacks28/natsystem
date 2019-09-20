package fr.natsystem;

import com.mysql.jdbc.Connection;

public class Run {
	
	public static void main(String[] args) {
		
		Run.loadCards();
		Run.displayCards();
		
	}

	public static void displayCards() {
		String COLORS[] = {"Pique", "Coeur", "Carreau", "Trèfle"};
		String FIGURES[] = {"Valet", "Reine", "Roi", "As"}; 
		for (String color : COLORS) {
			for (int weight = 2; weight < 11; weight++) {
				System.out.printf("%d de %s\n", weight, color );
			}
			for(String figure : FIGURES) {
				System.out.printf("%s de %s\n", figure, color );
			}
			System.out.println();
		}
	}
	
	public static void loadCards() {
			int id = 1;
			String COLORS[] = {"Pique", "Coeur", "Trèfle", "Carreau"};
			String FIGURES[] = {"Valet", "Reine", "Roi", "As"}; 
			
			Connection connection = (Connection) DB_Connection.get_Connection();
			
			for (int color=0; color<COLORS.length; color++) {
				for (int weight = 2; weight < 11; weight++) {
					// System.out.printf("%d de %s\n", weight, COLORS[color] );
					CRUD.createCard(connection, id++, Integer.toString(weight) , weight, 0, color);
				}
				for(int i=0; i<FIGURES.length; i++) {
					// System.out.printf("%s de %s\n", FIGURES[i], COLORS[i] );
					CRUD.createCard(connection, id++, FIGURES[i] , i+11, 1, color);
				}
				System.out.println();
			}
			
			DB_Connection.close_Connection(connection);
		}
	
}
