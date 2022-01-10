
import java.awt.Color;

import hevs.graphics.FunGraphics;

public class Display {
	Grid grille = new Grid();

	// Inits the graphic window
	FunGraphics display = new FunGraphics(360, 500);

//boucle pour afficher le jeu
	public void DisplayLoop() {
		display.clear();
		numberColor();
		display.setColor(Color.black);
		displayGrid1();
	}
	
	
	
	//display background color for different number
	public void numberColor() {
		switch (0) {
		case 0:
			
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

	public void displayGrid1() {
		for (int x = 0; x <= 3; x++) {
			for (int y = 0; y <= 3; y++) {
				display.drawString(10 + (x + 1) * 60, 150 + (y + 1) * 80, grille.displayValue(x, y), Color.black, 80);
			}
		}
	}

	public static void main(String[] args) {
		Display b1 = new Display();
		b1.DisplayLoop();

	}
}