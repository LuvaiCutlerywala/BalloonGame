package miscallaneous;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BalloonGame {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Frame");
		JPanel panel = new JPanel();
		frame.setSize(800, 800);
		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.add(createClickableBalloon(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
			}
		}));
		frame.add(panel);
		frame.setVisible(true);
	}
	
	private static JButton createClickableBalloon(ActionListener listener) {
		Icon icn = new ImageIcon("C:\\Users\\luvaidc\\Pictures\\balloon.jpg");
		JButton button = new JButton(icn);
		button.addActionListener(listener);
		button.setSize(50, 50);
		button.setOpaque(true);
		button.setVisible(true);
		return button;
	}
}

class Balloon extends Component implements ActionListener{
	
	static final long serialVersionUID = 0l;
	
	private JPanel parent;
	private JButton button;
	
	private Balloon(JPanel parent, JButton button) {
		this.parent = parent;
		this.button = button;
	}
	
	public void actionPerformed(ActionEvent event) {
		parent.remove(this);
	}
	
	static Balloon balloonFactory(JPanel parent) {
		return new Balloon(parent, new JButton());
	}
	
}