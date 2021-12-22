
public class Grid {
	// this class will manage the grid of our game

	// create a board for the game
	private int[][] tableau = new int[4][4];

	// sert a mettre toutes les valeurs de notre tableau à 0
	public void gridReset() {
		for (int i = 0; i < tableau.length; i++) {
			for (int j = 0; j < tableau[0].length; j++) {
				tableau[i][j] = 0;
			}
		}
	}

	// sert a vérifier si notre tableau est occupé par un chiffre autre que 0
	public boolean isbusy(int column, int row) {
		if (tableau[column][row] != 0)
			return true;
		return false;
	}

//vérifie si notre tableau est plein de valeurs différentes de 0;
	public boolean gridFinished() {
		int occupedCase = 0;
		for (int i = 0; i < tableau.length; i++) {
			for (int j = 0; j < tableau[0].length; j++) {
				if (tableau[i][j] != 0)
					occupedCase++;
			}
		}
		if (occupedCase == 16)
			return true;
		else
			return false;
	}

//find a random case 
	public void randomCase() {
		int column = 0;
		int row = 0;
		do {
			column = (int) (Math.random() * 4);
			row = (int) (Math.random() * 4);
			if (isbusy(column, row) == true)
				tableau[column][row] = tableau[column][row];
			else
				tableau[column][row] = 2;

		} while (isbusy(column, row) == true);

	}

//test
	public static void main(String[] args) {
		Grid a = new Grid();
		a.randomCase();
	}

}
