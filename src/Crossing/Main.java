package Crossing;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame {
	public Main() {
		Encryption a = new Encryption();
		Decryption b = new Decryption();
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Encryption");
		setSize(500,350);
		p.add(a.p1);
		p.add(b.p1);
		add(p);
		setVisible(true);
	}

	
	public static void main(String[] args) {
		Main algorigm = new Main();
		
	}
}