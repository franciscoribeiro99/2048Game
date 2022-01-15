import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import hevs.graphics.FunGraphics;
import hevs.graphics.utils.GraphicsBitmap;

public class Display {

	// Inits the graphic window
	Grid grille;
	FunGraphics display = new FunGraphics(360, 500);
	GraphicsBitmap image1 = new GraphicsBitmap("/marinipng.png");
	int ret;

	// liaison des touches
	public Display(Grid grille) {
		this.grille = grille;
		display.setKeyManager(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				switch (keyCode) {
				case KeyEvent.VK_UP:
					ret = 0;
					System.out.println("up");
					grille.up1();

					render();
					break;
				case KeyEvent.VK_DOWN:

					grille.down();
					System.out.println("down");
					ret = 1;
					// handle down
					break;
				case KeyEvent.VK_LEFT:

					grille.left();
					System.out.println("left");
					ret = 2;

					// handle left
					break;
				case KeyEvent.VK_RIGHT:
					System.out.println("right");
					grille.right();
					ret = 3;
					// handle right
					break;
				}
			}
		});
	}

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

	public void displayScore() {
		display.setColor(Color.cyan);
		display.drawFillRect(200, 60, 130, 100);
		display.drawString(210, 100, "SCORE", Color.black, 30);
		display.drawString(250, 150, grille.displayScore(), Color.black, 30);
	}

	// display background color for different number
	private void numberColor() {
		for (int i = 0; i <= 3; i++) {
			for (int j = 0; j <= 3; j++) {
				int value = grille.getValue(i, j);
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

//affiche les chiffres 
	private void displayGridGraphic(Grid grille) {
		for (int x = 0; x <= 3; x++) {
			for (int y = 0; y <= 3; y++) {
				if (grille.getValue(y, x) != 0) {
					display.drawString(28 + (x + 1) * 60, 180 + (y + 1) * 60, grille.displayValue(x, y), Color.black,
							20);
				}
			}
		}
	}

	public void render() {
		numberColor();
		displayGridGraphic(grille);

	}

	public void init() {
		display.clear();
		DisplayTemplate();
		displayScore();
	}
}
