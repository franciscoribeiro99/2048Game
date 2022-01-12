
import java.awt.Color;

import hevs.graphics.FunGraphics;
import hevs.graphics.utils.GraphicsBitmap;

public class Display {
	Grid grille = new Grid();
	// Inits the graphic window
	FunGraphics display = new FunGraphics(360, 500);
	GraphicsBitmap a = new GraphicsBitmap("/marinipng.png");

//boucle pour afficher le jeu
	public void DisplayLoop() {
		display.clear();
		DisplayTemplate();
		numberColor();
		display.setColor(Color.black);
		displayGrid1();
	}

	// init displayscore and init
	public void DisplayTemplate() {
		display.drawPicture(180, 250, a);
		display.drawString(20, 50, "2048 Game With Marini", Color.red, 30);		
	}

	// display background color for different number
	public void numberColor() {
		for (int i = 0; i <= 3; i++) {
			for (int j = 0; j <= 3; j++) {
				switch (grille.getvalue(i, j)) {
				case 0:
					display.setColor(Color.magenta);
					display.drawFillRect(10 + (i + 1) * 60, 150 + (j + 1) * 60, 50, 50);
					break;
				case 2:

					break;
				case 4:

					break;
				case 8:

					break;
				case 16:

					break;
				case 32:

					break;
				case 64:

					break;
				case 128:

					break;
				case 256:

					break;
				case 512:

					break;
				case 1024:

					break;
				case 2048:

					break;
				default:
					break;
				}
			}
		}

	}

//affiche les chiffres de chaque case
	public void displayGrid1() {
		for (int x = 0; x <= 3; x++) {
			for (int y = 0; y <= 3; y++) {
				display.drawString(28 + (x + 1) * 60, 180 + (y + 1) * 60, grille.displayValue(x, y), Color.black, 20);
			}
		}
	}

	public static void main(String[] args) {
		Display b1 = new Display();
		b1.DisplayLoop();

	}
}