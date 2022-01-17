import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import hevs.graphics.FunGraphics;
import hevs.graphics.utils.GraphicsBitmap;

public class Display {

	// Inits the graphic window
	Grid grille;
	FunGraphics display = new FunGraphics(360, 500);
	GraphicsBitmap image1 = new GraphicsBitmap("/colors-featured.jpg");
	GraphicsBitmap png1 = new GraphicsBitmap("/2048 game.png");
	int ret;

	// liaison des touches
	public Display(Grid grille) {
		this.grille = grille;
		display.setKeyManager(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				switch (keyCode) {
				case KeyEvent.VK_UP:
					grille.moveUp();
					System.out.println("up");
					grille.randomCase();
					render();

					break;
				case KeyEvent.VK_DOWN:
					grille.moveDown();
					System.out.println("down");
					grille.randomCase();
					render();

					// handle down
					break;
				case KeyEvent.VK_LEFT:
					grille.moveLeft();
					System.out.println("left");
					grille.randomCase();
					render();

					// handle left
					break;
				case KeyEvent.VK_RIGHT:
					grille.moveRight();
					System.out.println("right");
					grille.randomCase();
					render();

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
		display.drawPicture(100, 100, png1);
		display.drawFillRect(0, 200, 1000,1000);
		display.drawFillRect(60, 220, 250, 250);
		display.drawPicture(185, 345, image1);

	}

	public void displayScore() {
		display.setColor(Color.black);
		display.drawFillRect(150, 0, 300, 200);
		display.drawString(210, 100, "SCORE", Color.white, 30);
		display.drawString(230, 150, grille.displayScore(), Color.white, 30);
	}

	// display background color for different number
	private void numberColor() {

		for (int i = 0; i <= 3; i++) {
			for (int j = 0; j <= 3; j++) {
				int value = grille.getValue(j, i);
				switch (value) {
				case 0:
					display.setColor(COLOR_EMPTY);
					display.drawFillRect(10 + (i + 1) * 60, 20 + 150 + (j + 1) * 60, 50, 50);
					break;
				case 2:
					display.setColor(COLOR_2);
					display.drawFillRect(10 + (i + 1) * 60, 20 + 150 + (j + 1) * 60, 50, 50);
					break;
				case 4:
					display.setColor(COLOR_4);
					display.drawFillRect(10 + (i + 1) * 60, 20 + 150 + (j + 1) * 60, 50, 50);
					break;

				case 8:
					display.setColor(COLOR_8);
					display.drawFillRect(10 + (i + 1) * 60, 20 + 150 + (j + 1) * 60, 50, 50);
					break;
				case 16:
					display.setColor(COLOR_16);
					display.drawFillRect(10 + (i + 1) * 60, 20 + 150 + (j + 1) * 60, 50, 50);
					break;
				case 32:
					display.setColor(COLOR_32);
					display.drawFillRect(10 + (i + 1) * 60, 20 + 150 + (j + 1) * 60, 50, 50);
					break;
				case 64:
					display.setColor(COLOR_64);
					display.drawFillRect(10 + (i + 1) * 60, 20 + 150 + (j + 1) * 60, 50, 50);
					break;
				case 128:
					display.setColor(COLOR_128);
					display.drawFillRect(10 + (i + 1) * 60, 20 + 150 + (j + 1) * 60, 50, 50);
					break;
				case 256:
					display.setColor(COLOR_256);
					display.drawFillRect(10 + (i + 1) * 60, 20 + 150 + (j + 1) * 60, 50, 50);
					break;
				case 512:
					display.setColor(COLOR_512);
					display.drawFillRect(10 + (i + 1) * 60, 20 + 150 + (j + 1) * 60, 50, 50);
					break;
				case 1024:
					display.setColor(COLOR_1024);
					display.drawFillRect(10 + (i + 1) * 60, 20 + 150 + (j + 1) * 60, 50, 50);
					break;
				case 2048:
					display.setColor(COLOR_2048);
					display.drawFillRect(10 + (i + 1) * 60, 20 + 150 + (j + 1) * 60, 50, 50);
					break;
				case -1:
					display.setColor(COLOR_GAME_OVER);
					display.drawFillRect(10 + (i + 1) * 60, 20 + 150 + (j + 1) * 60, 50, 50);
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

					display.drawString(30 - (grille.displayValue(x, y).length() * 4) + (x + 1) * 60, 200 + (y + 1) * 60,
							grille.displayValue(x, y), Color.black, 20);
				}
			}
		}
	}

	public void render() {

		numberColor();
		displayGridGraphic(grille);
		displayScore();

	}

	public void init() {
		display.clear();
		DisplayTemplate();
		displayScore();
	}
}
