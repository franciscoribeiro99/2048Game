import java.util.ArrayList;
import java.util.List;
import java.awt.event.KeyEvent;

public class Grid {
	// this class will manage the grid of our game
	KeyManager b = new KeyManager();
	// create a board for the game
	private int[][] tableau = new int[4][4];

	public int getvalue(int x, int y) {

		return tableau[x][y];

	}

	public String displayValue(int x, int y) {
		int a = tableau[x][y];
		String b = String.valueOf(a);
		return b;

	}

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

//retourne la position the cellules vides
	public List<Integer> EmptyTile() {
		List<Integer> emptytiles = new ArrayList<>();
		for (int i = 0; i < tableau.length; i++) {
			for (int j = 0; j < tableau[0].length; j++) {
			}

		}
		return emptytiles;
	}

//vérifie si on peut encore faire un déplacement S'il y plus de déplacements return true !
	public boolean noMove() {

		int checkcase = 0;
		for (int i = 0; i < tableau.length; i++) {
			for (int j = 0; j < tableau[0].length; j++) {

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

	// si on fait un mouvement il faut ajouter la valeur en question si les deux
	// cases sont les mêmes
	public void addcase() {
		int a = KeyEvent.VK_UP;
		switch (a) {
		case KeyEvent.VK_UP:
			for (int i = 0; i < tableau.length; i++) {
				for (int j = 1; j < tableau[0].length; j++) {
					if (tableau[i][j] == tableau[i][j - 1]) {
						tableau[i][j - 1] = tableau[i][j] + tableau[i][j - 1];
						tableau[i][j] = 0;
					}
				}
			}
			break;
		case KeyEvent.VK_DOWN:
			for (int i = 0; i < tableau.length; i++) {
				for (int j = 1; j < tableau[0].length; j++) {
					if (tableau[i][j] == tableau[i][j + 1]) {
						tableau[i][j + 1] = tableau[i][j] + tableau[i][j + 1];
						tableau[i][j] = 0;
					}
				}
			}
			break;
		case KeyEvent.VK_LEFT:
			for (int i = 0; i < tableau.length; i++) {
				for (int j = 1; j < tableau[0].length; j++) {
					if (tableau[i][j] == tableau[i - 1][j]) {
						tableau[i - 1][j] = tableau[i][j] + tableau[i - 1][j];
						tableau[i][j] = 0;
					}
				}
			}

			break;
		case KeyEvent.VK_RIGHT:
			for (int i = 0; i < tableau.length; i++) {
				for (int j = 1; j < tableau[0].length; j++) {
					if (tableau[i][j] == tableau[i + 1][j]) {
						tableau[i + 1][j] = tableau[i][j] + tableau[i + 1][j];
						tableau[i][j] = 0;
					}
				}
			}

			break;
		default:
			break;
		}
	}

	// start case for game
	public void startgame() {
		tableau[3][1] = 2;
		tableau[3][2] = 2;
	}

//test
	public static void main(String[] args) {
		Grid a = new Grid();
		a.gridReset();
		a.addcase();

		System.out.println(a.displayValue(0, 0));

	}

}