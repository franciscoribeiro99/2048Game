
public class Game {

	Grid grille = new Grid();
	Display window = new Display(grille);

	public void play() {
		window.init();
		grille.startGame();
		window.render();
	}

}
