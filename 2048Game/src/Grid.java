
public class Grid {
	// create a board for the game
	private Tile[][] tableau = new Tile[3][3];
	int bord = 0;
	int value;
	int score;

	public Grid() {
		tableau = new Tile[4][4];
		for (int i = 0; i <= 3; i++) {
			for (int j = 0; j <= 3; j++) {
				tableau[i][j] = new Tile();
			}
		}
	}

	public int getValue(int x, int y) {
		return tableau[y][x].getTileValue();
	}

	public void displayGrid() {
		for (int i = 0; i < tableau.length; i++) {
			for (int j = 0; j < tableau.length; j++) {
				System.out.print(tableau[j][i].Stringvalue() + " ");
			}
			System.out.println();

		}
	}

	public String displayScore() {
		int score;
		score = this.score;
		String ret = String.valueOf(score);
		return ret;

	}

	public String displayValue(int x, int y) {
		int a = tableau[x][y].getTileValue();
		String b = String.valueOf(a);
		return b;

	}

	// find a random case
	public void randomCase() {
		int x = 0;
		int y = 0;
		boolean found = false;
		while (!found) {
			x = (int) (Math.random() * 4);
			y = (int) (Math.random() * 4);
			if (tableau[x][y].getTileValue() == 0) {
				tableau[x][y] = new Tile(2);
				found = true;
			}

		}
	}

	// sert a vérifier si notre tableau est occupé par un chiffre autre que 0
	public boolean isbusy(int x, int y) {
		if (tableau[y][x].getTileValue() != 0)
			return true;
		return false;
	}

//vérifie si notre tableau est plein de valeurs différentes de 0;
	public boolean gridFinished() {
		int occupedCase = 0;
		for (int i = 0; i < tableau.length; i++) {
			for (int j = 0; j < tableau[0].length; j++) {
				if (tableau[i][j].getTileValue() != 0)
					occupedCase++;
			}
		}
		if (occupedCase == 16)
			return true;
		else
			return false;
	}

//vérifie si on peut encore faire un déplacement S'il y plus de déplacements return true !
	public boolean noMove() {
		int checkcase = 0;
		for (int i = 0; i < tableau.length; i++) {
			for (int j = 0; j < tableau[0].length; j++) {
				if (tableau[i][j].getTileValue() == 0)
					return false;

				// on va commencer par checker les coins du tableau sinon on généralise on est
				// en outofbound
				// check si on est a la pos 0,0
				if (tableau[i][j] == tableau[0][0] && gridFinished() == true && tableau[i + 1][j] != tableau[0][0]
						&& tableau[i][j + 1] != tableau[0][0]) {
					checkcase++;
				}
				// check si on est a la pos 3,0
				if (tableau[i][j] == tableau[3][0] && gridFinished() == true && tableau[i - 1][j] != tableau[3][0]
						&& tableau[i][j + 1] != tableau[3][0]) {
					checkcase++;
				}
				// check si on est a la pos 0,3
				if (tableau[i][j] == tableau[0][3] && gridFinished() == true && tableau[i + 1][j] != tableau[0][3]
						&& tableau[i][j - 1] != tableau[0][3]) {
					checkcase++;
				}
				// check si on est a la pos 3,3
				if (tableau[i][j] == tableau[3][3] && gridFinished() == true && tableau[i - 1][j] != tableau[3][3]
						&& tableau[i][j - 1] != tableau[3][3]) {
					checkcase++;
				}
				// check si on est a la pos 0,1 ou 0,2
				if (tableau[i][j] == tableau[0][1] || tableau[i][j] == tableau[0][2] && gridFinished() == true
						&& tableau[i + 1][j] != tableau[i][j] && tableau[i][j + 1] != tableau[i][j]
						&& tableau[i][j - 1] != tableau[i][j]) {
					checkcase++;
				}
				// check si on est a la pos 1,3 ou 2,3
				if (tableau[i][j] == tableau[1][3] || tableau[i][j] == tableau[2][3] && gridFinished() == true
						&& tableau[i - 1][j] != tableau[i][j] && tableau[i][j - 1] != tableau[i][j]
						&& tableau[i][j + 1] != tableau[i][j]) {
					checkcase++;
				}
				// check si on est a la pos 1,0 ou 2,0
				if (tableau[i][j] == tableau[1][0] || tableau[i][j] == tableau[2][0] && gridFinished() == true
						&& tableau[i - 1][j] != tableau[i][j] && tableau[i + 1][j] != tableau[i][j]
						&& tableau[i][j + 1] != tableau[i][j]) {
					checkcase++;
				}
				// check si on est a la pos 3,1 ou 3,2
				if (tableau[i][j] == tableau[3][1] || tableau[i][j] == tableau[3][2] && gridFinished() == true
						&& tableau[i - 1][j] != tableau[i][j] && tableau[i][j - 1] != tableau[i][j]
						&& tableau[i][j + 1] != tableau[i][j]) {
					checkcase++;
				}

//check toutes les autres
				if (tableau[i][j] != tableau[1][1] || tableau[i][j] != tableau[2][1] || tableau[i][j] != tableau[1][2]
						|| tableau[i][j] != tableau[2][2] && tableau[i][j] != tableau[i][j - 1]
								&& tableau[i][j] != tableau[i + 1][j] && tableau[i][j] != tableau[i - 1][j]
								&& gridFinished() == true) {
					checkcase++;
				}
			}
		}
		if (checkcase < 8)
			return false;
		return true;
	}

///moveUp
	public void moveUp() {
		for (int row = 0; row < 4; row++) {
			int count = 0;
			for (int col = 0; col < 4; col++) {
				if (tableau[row][col].getTileValue() != 0) {
					tableau[row][count].setValue(tableau[row][col].getTileValue());
					if (count != col) {
						tableau[row][col].setValue(0);

					}
					count++;
				}
			}
		}
		for (int row = 0; row < 4; row++) {
			for (int col = 0; col < 3; col++) {
				if (tableau[row][col].getTileValue() == tableau[row][col + 1].getTileValue())

				{
					tableau[row][col].setValue(tableau[row][col].getTileValue() + tableau[row][col + 1].getTileValue());
					tableau[row][col + 1].setValue(0);

					int sum = tableau[row][col].getTileValue();
					score += sum;

					break;

				}
			}
		}
		for (int row = 0; row < 4; row++) {
			int count = 0;
			for (int col = 0; col < 4; col++)

			{
				if (tableau[row][col].getTileValue() != 0) {
					tableau[row][count].setValue(tableau[row][col].getTileValue());

					if (count != col) {
						tableau[row][col].setValue(0);
					}
					count++;
				}
			}

		}

	}

//move Down
	public void moveDown() {
		for (int row = 0; row < 4; row++) {
			int count = 0;

			for (int col = 3; col >= 0; col--)

			{
				if (tableau[row][col].getTileValue() != 0) {
					tableau[row][3 - count].setValue(tableau[row][col].getTileValue());
					// met à 0 la case
					if ((3 - count) != col) {
						tableau[row][col].setValue(0);
						;
					}
					count++;
				}

			}

		}

		for (int row = 0; row < 4; row++) {
			for (int col = 3; col > 0; col--) {
				if (tableau[row][col].getTileValue() == tableau[row][col - 1].getTileValue())
				// somme deux cases qui ont la meme valeur
				{
					tableau[row][col].setValue(tableau[row][col].getTileValue() + tableau[row][col - 1].getTileValue());
					tableau[row][col - 1].setValue(0);
					// met à jour le score
					int sum = tableau[row][col].getTileValue();
					score += sum;

					break;

				}
			}
		}

		// déplace vers le bas
		for (int row = 0; row < 4; row++) {
			int count = 0;

			for (int col = 3; col >= 0; col--)

			{
				if (tableau[row][col].getTileValue() != 0) {
					tableau[row][3 - count].setValue(tableau[row][col].getTileValue());
					if ((3 - count) != col) {
						tableau[row][col].setValue(0);
					}
					count++;
				}

			}

		}

	}

//déplace vers la gauche
	public void moveLeft() {
		for (int col = 0; col <= 3; col++) {
			int count = 0;

			for (int row = 0; row <= 3; row++)

			{
				if (tableau[row][col].getTileValue() != 0) {
					tableau[count][col].setValue(tableau[row][col].getTileValue());

					if (count != row) {
						tableau[row][col].setValue(0);
					}
					count++;
				}

			}

		}

		for (int col = 0; col <= 3; col++) {
			for (int row = 0; row <= 2; row++) {
				if (tableau[row][col].getTileValue() == tableau[row + 1][col].getTileValue())

				{
					tableau[row][col].setValue(tableau[row][col].getTileValue() + tableau[row + 1][col].getTileValue());
					tableau[row + 1][col].setValue(0);

					int sum = tableau[row][col].getTileValue();
					score += sum;

					break;

				}
			}
		}

		for (int col = 0; col <= 3; col++) {
			int count = 0;

			for (int row = 0; row <= 3; row++)

			{
				if (tableau[row][col].getTileValue() != 0) {
					tableau[count][col].setValue(tableau[row][col].getTileValue());

					if (0 + count != row) {
						tableau[row][col].setValue(0);
					}
					count++;
				}

			}

		}

	}

//déplace vers la droite
	public void moveRight() {
		// one by one
		for (int col = 0; col < 4; col++) {
			int count = 0;

			for (int row = 3; row >= 0; row--)

			{
				if (tableau[row][col].getTileValue() != 0) {
					tableau[3 - count][col].setValue(tableau[row][col].getTileValue());

					if (3 - count != row) {
						tableau[row][col].setValue(0);
					}
					count++;
				}

			}

		}

		for (int col = 0; col < 4; col++) {
			for (int row = 3; row > 0; row--) {
				if (tableau[row][col].getTileValue() == tableau[row - 1][col].getTileValue())

				{
					tableau[row][col].setValue(tableau[row][col].getTileValue() + tableau[row - 1][col].getTileValue());
					tableau[row - 1][col].setValue(0);

					int sum = tableau[row][col].getTileValue();
					score += sum;

					break;

				}
			}
		}

		for (int col = 0; col < 4; col++) {
			int count = 0;

			for (int row = 3; row >= 0; row--)

			{
				if (tableau[row][col].getTileValue() != 0) {
					tableau[3 - count][col].setValue(tableau[row][col].getTileValue());

					if ((3 - count) != row) {
						tableau[row][col].setValue(0);
					}
					count++;
				}

			}

		}

	}

	public void startGame() {

		randomCase();
		randomCase();
	}

	public void playLoop() {
		do {
			startGame();
		} while (gridFinished());
		if (gridFinished() == true) {
			if (noMove() == true)
				System.out.println("gameOVEr");

		}
	}

}

//test
