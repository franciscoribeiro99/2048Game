import java.util.ArrayList;


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

	// move up
	public void up1() {
		int moves = 0;
		for (int i = 0; i <= 3; i++) {
			ArrayList<Integer> changed = new ArrayList<Integer>(2);
			for (int j = 0; j < 3; j++) {
				int fin = j + 1;
				if (tableau[fin][i].getTileValue() != 0) {
					boolean moved = false;
					for (int k = j; k >= 0; k--) {
						if (tableau[k][i].getTileValue() == 0) {
							tableau[k][i].setValue(tableau[fin][i].getTileValue());
							tableau[fin][i].setValue(0);
							fin--;
						} else {
							if (tableau[fin][i].getTileValue() == tableau[k][i].getTileValue()
									&& !changed.contains(k)) {
								tableau[k][i].setValue(tableau[fin][i].getTileValue() * 2);
								changed.add(k);
								moved = true;

							}
							break;
						}
					}
					if (moved)
						moves++;
				}
			}
		}
		displayGrid();
	}

//move up
	public void up() {
		for (int i = 0; i <= 3; i++) {
			bord = 0;
			for (int j = 1; j <= 3; j++) {
				if (tableau[j][i].getTileValue() != 0) {
					if (bord <= j) {
						// moveVert(j, i, 0);
						moveVert1(i, j, 0);
					}
				}
			}
		}
		displayGrid();
	}

//move down
	public void down() {
		for (int i = 0; i <= 3; i++) {
			bord = 3;
			for (int j = 3; j >= 0; j--) {
				if (tableau[j][i].getTileValue() != 0) {
					if (bord >= j) {
						moveVert(j, i, 1);
					}
				}
			}
		}
		displayGrid();
	}

	private void moveVert1(int x, int y, int direction) {
		if (direction == 0) {
			for (int i = 0; i >= y; i++) {
				if (tableau[x][y - i].getTileValue() == 0) {
					if (tableau[x][y - i].getTileValue() == 0) {
						if (tableau[x][y - 1].getTileValue() == 0) {
							tableau[x][y - 1].setValue(tableau[x][y].getTileValue());
						}

					} else if (tableau[x][y - i].getTileValue() == tableau[x][y].getTileValue()) {
						int newvalue = tableau[x][y - i].getTileValue() + tableau[x][y].getTileValue();
						tableau[x][y - 2].setValue(newvalue);
					}
				}
				if (tableau[x][y - i].getTileValue() == tableau[x][y].getTileValue()) {
					int newY = y - i;
					int newvalue1 = tableau[x][y - i].getTileValue() + tableau[x][y].getTileValue();
					for (int j = newY; j >= 1; j++) {
						if (tableau[x][j - 1].getTileValue() == 0) {
							tableau[x][j - 1].setValue(newvalue1);
							tableau[x][y - i].setValue(0);
							tableau[x][y].setValue(newvalue1);

						}

					}

				}
			}

		}
	}

//mouvements verticaux
	private void moveVert(int x, int y, int direction) {
		Tile init = tableau[bord][y];
		Tile comp = tableau[x][y];
		for (int i = 0; i <= 3; i++) {
			for (int j = 0; j <= 3; j++) {
				if (x > bord || direction == 1 && x < bord) {
					int caseValue = init.getTileValue() + comp.getTileValue();
					if (init.getTileValue() != 0) {
						score += caseValue;
					}
					init.setValue(caseValue);
					comp.setValue(0);
				} else {
					if (direction == 1) {
						bord--;
					} else {
						bord++;
					}
					moveVert(x, y, direction);
				}
			}

		}
		/*
		 * if (direction == 0) { if (tableau[x][0] == tableau[x][1] && y == 1) {
		 * tableau[x][0] = tableau[x][0] + tableau[x][1]; tableau[x][1] = 0; } if
		 * (tableau[x][y] == tableau[y][y - 1] && y > 1) { for (int j = y - 1; j >= 0;
		 * j--) { if (!isbusy(x, j - 1)) { tableau[x][j - 1] = tableau[x][y] +
		 * tableau[x][y - 1]; tableau[x][y] = 0; tableau[x][y - 1] = 0; } else {
		 * tableau[x][y - 1] = tableau[x][y - 1] + tableau[x][y];
		 * 
		 * }
		 * 
		 * }
		 * 
		 * }
		 * 
		 * if (tableau[x][y] != tableau[x][y - 1]) { for (int j = y; j > 0; j--) { if
		 * (!isbusy(x, j - 1)) { tableau[x][j - 1] = tableau[x][y]; tableau[x][y] = 0; }
		 * 
		 * }
		 * 
		 * }
		 * 
		 * }
		 */
	}

	// move left
	public void left() {
		for (int i = 0; i <= 3; i++) {
			bord = 0;
			for (int j = 0; j <= 3; j++) {
				if (tableau[i][j].getTileValue() != 0)
					if (bord <= j)
						moveHori(i, j, 2);
			}
		}
		displayGrid();
	}

	// move right
	public void right() {
		for (int i = 0; i <= 3; i++) {
			bord = 0;
			for (int j = 3; j >= 0; j--) {
				if (tableau[i][j].getTileValue() != 0)
					if (bord <= j)
						moveHori(i, j, 3);
			}
		}
		displayGrid();
	}

	// mouvements verticaux
	private void moveHori(int row, int col, int direction) {

		if (tableau[bord][col].getTileValue() == 0 || tableau[bord][col] == tableau[row][col]) {
			if (row > bord || (direction == 3 && col < bord)) {
				int caseValue = tableau[bord][col].getTileValue() + tableau[row][col].getTileValue();
				if (tableau[bord][col].getTileValue() != 0)
					score += caseValue;
				tableau[bord][col].setValue(caseValue);
				tableau[row][col].setValue(0);
			}
		} else {
			if (direction == 3) {
				bord--;
			} else {
				bord++;
			}
			moveHori(row, col, direction);
		}
	}

	// si on fait un mouvement il faut ajouter la valeur en question si les deux
	// cases sont les mêmes

	/*
	 * 0-->UP 1-->DOWN 2-->LEFT 3-->Rigth public void addcase(int key) { switch
	 * (key) { // UP case 0: for (int i = 0; i < tableau.length; i++) { for (int j =
	 * 0; j < tableau[0].length; j++) { up(); randomCase(); displayGrid(); } }
	 * break;
	 * 
	 * // down case 1: for (int i = 0; i < tableau.length; i++) { for (int j = 1; j
	 * < tableau[0].length; j++) { down(); randomCase(); displayGrid(); } }
	 * 
	 * break; // left case 2: for (int i = 0; i < tableau.length; i++) { for (int j
	 * = 1; j < tableau[0].length; j++) { left(); randomCase(); displayGrid(); } }
	 * 
	 * break; // right case 3: for (int i = 0; i < tableau.length; i++) { for (int j
	 * = 1; j < tableau[0].length; j++) { right(); randomCase(); displayGrid(); } }
	 * 
	 * break; default: break; } }
	 */

	public void startGame() {

		tableau[3][3].setValue(2);
		tableau[3][2].setValue(2);
	}

	public void playLoop() {
		startGame();
	}
}
//test
