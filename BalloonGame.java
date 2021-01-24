package miscallaneous;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

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
		balloon.addActionListener(frame, panel);
		frame.add(panel, BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);
	}

	public static JFrame createMainWindow() {
		JFrame frame = new JFrame("Balloon Game");
		frame.setSize(800, 800);
		frame.setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		return frame;
	}

	public static JPanel createGamePanel() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(800, 800));
		panel.setBackground(Color.DARK_GRAY);
		return panel;
	}
}

class Balloon {
	private JButton button;

	private Balloon(JButton button) {
		this.button = button;
		button.setLocation(100, 100);
	}

	public void setBalloonPosition(Dimension dimension) {
		this.button.setLocation((int) dimension.getWidth(), (int) dimension.getHeight());
	}
	
	public static Dimension createBounds(int panelWidth, int panelHeight) {
		return new Dimension((panelWidth - 100), (panelHeight - 100));
	}
	
	public void getBalloonPos(Dimension dimension) {
		Random rand = new Random(System.currentTimeMillis());
		int xAxis = (int) dimension.getWidth();
		int yAxis = (int) dimension.getHeight();
		dimension.setSize(rand.nextInt(xAxis - 100), rand.nextInt(yAxis - 100));
	}
	
	public void addActionListener(JFrame master, JPanel parent) {
		this.button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				Dimension dimension = createBounds(parent.getWidth(), parent.getHeight());
				getBalloonPos(dimension);
				setBalloonPosition(dimension);
			}
		});
	}

	public void attachBalloon(JPanel panel) {
		panel.add(this.button);
	}

	public static Balloon createBalloon(JFrame master, JPanel parent) {
		Icon icn = new ImageIcon("C:\\Users\\luvaidc\\Pictures\\balloon.jpg");
		JButton button = new JButton(icn);
		button.setBackground(Color.DARK_GRAY);
		button.setSize(new Dimension(100, 100));
		button.setOpaque(true);
		button.setVisible(true);
		return new Balloon(button);
	}

}