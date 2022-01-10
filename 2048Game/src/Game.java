
public class Game {
	Grid a = new Grid();
	Display display1 = new Display();

	public void playagain() {
		play();
	}

	public void play() {
		a.gridReset();
		a.startgame();
		do {

		} while (a.noMove() != true);
		if (a.noMove() == true) {

		}

	}

}
