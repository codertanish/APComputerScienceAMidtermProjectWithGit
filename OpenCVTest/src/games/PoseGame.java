package games;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PoseGame implements GameLogic { 
	private JFrame frame;
	private JPanel originalPanel;
	public PoseGame(JFrame frame, JPanel panel) {
		this.frame = frame;
		originalPanel = panel;
	}
}
