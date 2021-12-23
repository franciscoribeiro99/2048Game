
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

//vérifie si on peut encore faire un déplacement S'il y plus de déplacements return true
	public boolean noMove() {
		boolean ret = false;
		for (int i = 0; i < tableau.length; i++) {
			for (int j = 0; j < tableau[0].length; j++) {

				// on va commencer par checker les coins du tableau sinon on généralise on est
				// en outofbound
				// check si on est a la pos 0,0
				if (tableau[i][j] == tableau[0][0] && gridFinished() == true && tableau[i + 1][j] != tableau[0][0]
						|| tableau[i][j + 1] != tableau[0][0]) {
					ret = true;
				}
				// check si on est a la pos 3,0
				if (tableau[i][j] == tableau[3][0] && gridFinished() == true && tableau[i - 1][j] != tableau[3][0]
						|| tableau[i][j + 1] != tableau[3][0]) {
					ret = true;
				}
				// check si on est a la pos 0,3
				if (tableau[i][j] == tableau[0][3] && gridFinished() == true && tableau[i + 1][j] != tableau[0][3]
						|| tableau[i][j - 1] != tableau[0][3]) {
					ret = true;
				}
				// check si on est a la pos 3,3
				if (tableau[i][j] == tableau[3][3] && gridFinished() == true && tableau[i - 1][j] != tableau[3][3]
						|| tableau[i][j - 1] != tableau[3][3]) {
					ret = true;
				}
				// check si on est a la pos 0,1 ou 0,2
				if (tableau[i][j] == tableau[0][1] || tableau[i][j] == tableau[0][2] && gridFinished() == true
						&& tableau[i - 1][j] != tableau[3][3] || tableau[i][j + 1] != tableau[3][3]) {
					ret = true;
				}

				if (tableau[i][j] != tableau[i][j + 1] && tableau[i][j] != tableau[i + 1][j + 1]
						&& gridFinished() == true) {

				}
			}
		}
		return ret;
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
		a.gridFinished();
	}

}
