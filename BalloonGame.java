package miscallaneous;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BalloonGame {

	public static void main(String[] args) {
		JFrame frame = createMainWindow();
		JPanel panel = createGamePanel();
		Balloon balloon = Balloon.createBalloon(frame, panel);
		balloon.attachBalloon(panel);
		frame.add(panel, BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);
	}
	
	static JFrame createMainWindow() {
		JFrame frame = new JFrame("Balloon Game");
		frame.setSize(800, 800);
		frame.setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		return frame;
	}
	
	static JPanel createGamePanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(10, 10));
		panel.setPreferredSize(new Dimension(800, 800));
		panel.setBackground(Color.DARK_GRAY);
		return panel;
	}
}

class GameLayout {
	
	private final int BUTTON_WIDTH = 50;
	private final int BUTTON_HEIGHT = 50;
	
	public GameLayout(JFrame frame) {
		
	}
	
	private void setMainWindowListener(JFrame frame) {
		
	}
	
}

class Balloon {
	
	private JButton button;
	
	private Balloon(JButton button) {
		this.button = button;
	}
	
	void attachBalloon(JPanel panel) {
		panel.add(this.button);
	}
	
	static Balloon createBalloon(JFrame master, JPanel parent) {
		Icon icn = new ImageIcon("C:\\Users\\luvaidc\\Pictures\\balloon.jpg");
		JButton button = new JButton(icn);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				master.setVisible(false);
				parent.remove(button);
				master.setVisible(true);
			}
		});
		button.setBackground(Color.DARK_GRAY);
		button.setSize(50, 50);
		button.setOpaque(true);
		button.setVisible(true);
		return new Balloon(button);
	}
	
}