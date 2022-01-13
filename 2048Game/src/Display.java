import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import hevs.graphics.FunGraphics;
import hevs.graphics.utils.GraphicsBitmap;

public class Display {
	// liaison des touches
	public Display(Grid grille) {
		this.grille = grille;
		display.setKeyManager(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				switch (keyCode) {
				case KeyEvent.VK_UP:
					grille.addcase(0);
					System.out.println("up");
					break;
				case KeyEvent.VK_DOWN:
					grille.addcase(1);
					ret = 1;
					System.out.println("down");
					// handle down
					break;
				case KeyEvent.VK_LEFT:
					grille.addcase(2);
					ret = 2;
					System.out.println("left");
					// handle left
					break;
				case KeyEvent.VK_RIGHT:
					grille.addcase(3);
					ret = 3;
					System.out.println("right");
					// handle right
					break;
				}
			}
		});
	}

	// Inits the graphic window
	Grid grille;
	FunGraphics display = new FunGraphics(360, 500);
	GraphicsBitmap image1 = new GraphicsBitmap("/marinipng.png");
	int ret;

	// color for each case
	final Color COLOR_EMPTY = new Color(204, 192, 179);
	final Color COLOR_2 = new Color(238, 228, 218);
	final Color COLOR_4 = new Color(237, 224, 200);
	final Color COLOR_8 = new Color(242, 177, 121);
	final Color COLOR_16 = new Color(245, 149, 99);
	final Color COLOR_32 = new Color(246, 124, 95);
	final Color COLOR_64 = new Color(246, 94, 59);
	final Color COLOR_128 = new Color(237, 207, 114);
	final Color COLOR_256 = new Color(237, 204, 97);
	final Color COLOR_512 = new Color(237, 200, 80);
	final Color COLOR_1024 = new Color(237, 197, 63);
	final Color COLOR_2048 = new Color(237, 194, 46);
	final Color COLOR_OTHER = Color.BLACK;
	final Color COLOR_GAME_OVER = new Color(238, 228, 218);

	// init displayscore and init
	private void DisplayTemplate() {
		display.drawPicture(180, 250, image1);
		display.drawString(20, 50, "2048 Game With Marini", Color.red, 30);
	}

	// display background color for different number
	private void numberColor(int value) {
		for (int i = 0; i <= 3; i++) {
			for (int j = 0; j <= 3; j++) {
				switch (value) {
				case 0:
					display.setColor(COLOR_EMPTY);
					display.drawFillRect(10 + (i + 1) * 60, 150 + (j + 1) * 60, 50, 50);
					break;
				case 2:
					display.setColor(COLOR_2);
					display.drawFillRect(10 + (i + 1) * 60, 150 + (j + 1) * 60, 50, 50);
					break;
				case 4:
					display.setColor(COLOR_4);
					display.drawFillRect(10 + (i + 1) * 60, 150 + (j + 1) * 60, 50, 50);
					break;

				case 8:
					display.setColor(COLOR_8);
					display.drawFillRect(10 + (i + 1) * 60, 150 + (j + 1) * 60, 50, 50);
					break;
				case 16:
					display.setColor(COLOR_16);
					display.drawFillRect(10 + (i + 1) * 60, 150 + (j + 1) * 60, 50, 50);
					break;
				case 32:
					display.setColor(COLOR_32);
					display.drawFillRect(10 + (i + 1) * 60, 150 + (j + 1) * 60, 50, 50);
					break;
				case 64:
					display.setColor(COLOR_64);
					display.drawFillRect(10 + (i + 1) * 60, 150 + (j + 1) * 60, 50, 50);
					break;
				case 128:
					display.setColor(COLOR_128);
					display.drawFillRect(10 + (i + 1) * 60, 150 + (j + 1) * 60, 50, 50);
					break;
				case 256:
					display.setColor(COLOR_256);
					display.drawFillRect(10 + (i + 1) * 60, 150 + (j + 1) * 60, 50, 50);
					break;
				case 512:
					display.setColor(COLOR_512);
					display.drawFillRect(10 + (i + 1) * 60, 150 + (j + 1) * 60, 50, 50);
					break;
				case 1024:
					display.setColor(COLOR_1024);
					display.drawFillRect(10 + (i + 1) * 60, 150 + (j + 1) * 60, 50, 50);
					break;
				case 2048:
					display.setColor(COLOR_2048);
					display.drawFillRect(10 + (i + 1) * 60, 150 + (j + 1) * 60, 50, 50);
					break;
				case -1:
					display.setColor(COLOR_GAME_OVER);
					display.drawFillRect(10 + (i + 1) * 60, 150 + (j + 1) * 60, 50, 50);
					break;
				default:
					break;
				}
			}
		}

	}

//affiche les chiffres de chaque case
	private void displayGrid1(Grid grille) {
		for (int x = 0; x <= 3; x++) {
			for (int y = 0; y <= 3; y++) {
				if (grille.getvalue(x, y) != 0)
					display.drawString(28 + (x + 1) * 60, 180 + (y + 1) * 60, grille.displayValue(x, y), Color.black,
							20);
			}
		}
	}

	public void render() {
		DisplayTemplate();
		displayGrid1(grille);
		

	}
}
