
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

	public void reset() {
		score = 0;
		for (int i = 0; i <= 3; i++) {
			for (int j = 0; j <= 3; j++) {
				tableau[i][j] = new Tile();
			}
		}
		startGame();

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
				if (isbusy(i, j))
					occupedCase++;
			}
		}
		if (occupedCase == 16) {
			return true;
		} else
			return false;
	}

///moveUp
	public void moveUp() {
		if (gameOver()) {

		}
		if (canMoveUp()) {
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
						tableau[row][col]
								.setValue(tableau[row][col].getTileValue() + tableau[row][col + 1].getTileValue());
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
			if (!gridFinished())
				randomCase();

		}

	}

//move Down
	public void moveDown() {
		if (canMoveDown()) {
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
						tableau[row][col]
								.setValue(tableau[row][col].getTileValue() + tableau[row][col - 1].getTileValue());
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
		if (!gridFinished())
			randomCase();

	}

//déplace vers la gauche
	public void moveLeft() {
		if (canMoveLeft()) {
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
						tableau[row][col]
								.setValue(tableau[row][col].getTileValue() + tableau[row + 1][col].getTileValue());
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
			if (!gridFinished())
				randomCase();
		}

	}

//déplace vers la droite
	public void moveRight() {
		if (canMoveRight()) {
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
						tableau[row][col]
								.setValue(tableau[row][col].getTileValue() + tableau[row - 1][col].getTileValue());
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
		if (!gridFinished())
			randomCase();

	}

	public boolean gameOver() {
		boolean ret = false;
		if (!canMoveDown() && !canMoveLeft() && !canMoveRight() && !canMoveUp())
			ret = true;
		else
			ret = false;
		playAgain();
		return ret;
	}

	public boolean canMoveLeft() {
		int compare = 0;
		boolean ret = true;
		for (int i = 0; i < 4; i++) {
			for (int j = 1; j <= 3; j++) {
				if (gridFinished() && tableau[j][i].getTileValue() != tableau[j - 1][i].getTileValue()) {
					compare++;
				}
			}
		}

		if (compare == 12)
			ret = false;
		if (ret == false)
			System.out.println("can't go left");
		return ret;
	}

	public boolean canMoveRight() {
		int compare = 0;
		boolean ret = true;
		for (int i = 0; i < 4; i++) {
			for (int j = 3; j > 0; j--) {
				if (gridFinished() && tableau[j][i].getTileValue() != tableau[j - 1][i].getTileValue())
					compare++;
			}
		}

		if (compare == 12)
			ret = false;
		if (ret == false)
			System.out.println("can't go right");
		return ret;
	}

	public boolean canMoveUp() {
		int compare = 0;
		boolean ret = true;
		for (int i = 1; i <= 3; i++) {
			for (int j = 0; j <= 3; j++) {

				if (gridFinished() && tableau[j][i].getTileValue() != tableau[j][i - 1].getTileValue())
					compare++;
			}
		}
		if (compare == 12)
			ret = false;
		if (ret == false)
			System.out.println("can't go up");

		return ret;
	}

	public boolean canMoveDown() {
		int compare = 0;
		boolean ret = true;
		for (int i = 0; i <= 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (gridFinished() && tableau[i][j].getTileValue() != tableau[i][j + 1].getTileValue())
					compare++;
			}
		}
		if (compare == 12)
			ret = false;
		if (ret == false)
			System.out.println("can't go down");
		return ret;
	}

	public void playAgain() {

	}

	public void startGame() {

		randomCase();
		randomCase();

	}

}

//test
