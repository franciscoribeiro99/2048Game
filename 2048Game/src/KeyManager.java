import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {

	@Override
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		switch (keyCode) {
		case KeyEvent.VK_UP:
			System.out.println("up");
			break;
		case KeyEvent.VK_DOWN:
			System.out.println("down");
			// handle down
			break;
		case KeyEvent.VK_LEFT:
			System.out.println("left");
			// handle left
			break;
		case KeyEvent.VK_RIGHT:
			System.out.println("right");
			// handle right
			break;
		}
	}

	public static void main(String[] args) {
		KeyManager a = new KeyManager();

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
