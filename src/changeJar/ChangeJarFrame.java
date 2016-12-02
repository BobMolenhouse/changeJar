package changeJar;

import java.awt.*;
import javax.swing.*;

public class ChangeJarFrame {

	public static void main(String[] args){
		JFrame frame = new JFrame("Change Jar");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MasterPanel panel = new MasterPanel();
		Container pane = frame.getContentPane();
		pane.add(panel);
		
		
		frame.setSize(1000,500);
		frame.setVisible(true);
	}
}