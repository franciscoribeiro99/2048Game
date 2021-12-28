
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {
	public final int UP = 0;
	public final int LEFT = 1;
	public final int DOWN = 2;
	public final int RIGHT = 3;

	public boolean keys[] = new boolean[64];

	public void setKey(int key, boolean down) {

		int button = -1;

		if (key == KeyEvent.VK_UP)
			button = UP;
		if (key == KeyEvent.VK_LEFT)
			button = LEFT;
		if (key == KeyEvent.VK_DOWN)
			button = DOWN;
		if (key == KeyEvent.VK_RIGHT)
			button = RIGHT;

		if (button >= 0) {

			keys[button] = down;
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {

		setKey(e.getKeyCode(), true);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		setKey(e.getKeyCode(), false);
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}
