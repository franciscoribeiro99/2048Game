import java.awt.Color;

public class Game extends Display {

	Grid grille = new Grid();

	public void playagain() {
		play();
	}

	public void play() {
		grille.gridReset();
		grille.startgame();
		do {
			display.clear();
			DisplayTemplate();
			for (int j = 0; j <= 3; j++) {
				for (int i = 0; i <= 3; i++) {
					numberColor(grille.getvalue(j, i));
				}
			}
			display.setColor(Color.black);
			displayGrid1(grille);
			grille.addcase(keymanager());

			System.out.println("hello");

		} while (keymanager() != 1);// while (//grille.noMove() != true);
		if (grille.noMove() == true)

		{

		}

	}

}