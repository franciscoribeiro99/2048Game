
public class Game {
	Grid grille = new Grid();
	Display display1 = new Display(grille);

	public void playagain() {
		play();
	}

	public void play() {

		grille.gridReset();
		grille.startgame();
		display1.DisplayLoop();

		do {
			display1.DisplayLoop();

		} while (grille.noMove() != true);
		if (grille.noMove() == true) {

		}

	}

}