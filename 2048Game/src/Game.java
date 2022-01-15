
public class Game {

	Grid grille = new Grid();
	Display window = new Display(grille);

	public void playagain() {
		play();
	}

	public void play() {
		window.init();
		grille.playLoop();
		window.render();

	}

}
