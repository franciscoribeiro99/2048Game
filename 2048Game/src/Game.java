

public class Game {

	Grid grille = new Grid();
	Display window = new Display(grille);

	public void playagain() {
		play();
	}

	public void play() {
		window.render();
		grille.gridReset();
		grille.startgame();
		System.out.println("hello");

	}

}
