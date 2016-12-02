package changeJar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class MasterPanel extends JPanel{
	
	private MyChangeJarPanel panel1;
	private MyChangeJarPanel panel2;
	private MyChangeJarPanel panel3;
	private JButton suspend;
	private JButton equals;
	private JButton compare;

	public MasterPanel(){
		setLayout(new GridLayout(2,2));
		
		panel1 = new MyChangeJarPanel("          JAR 1");
		
		panel2 = new MyChangeJarPanel("          JAR 2");
		
		panel3 = new MyChangeJarPanel("          JAR 3");
		
		JPanel panel4 = makeMasterButtons();
		panel4.setBorder(new EmptyBorder(80,50,80,50));
		
		add(panel4);
		add(panel1);
		add(panel2);
		add(panel3);
		
		setVisible(true);
	}
	
	private JPanel makeMasterButtons(){
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1,3));
    	Border b = BorderFactory.createRaisedBevelBorder();
		
		suspend = new JButton("Suspend Opperation");
		suspend.setBorder(b);
		suspend.addActionListener(new Listener());
		
		equals = new JButton("Check Equals");
		equals.setBorder(b);
		equals.addActionListener(new Listener());
		panel.setBorder(new EmptyBorder(80,50,80,50));
		
		compare = new JButton("Compare Two Jars");
		compare.setBorder(b);
		compare.addActionListener(new Listener());
		
		panel.add(suspend);
		panel.add(equals);
		panel.add(compare);
		
		return panel;
		
	}
	
	private LinkedHashMap<String,ChangeJar> compareAndEquals(){
		Object[] jars = { "Jar 1", "Jar 2", "Jar 3" };

		JPanel panel = new JPanel();
		JComboBox jar1 = new JComboBox(jars);
		JComboBox jar2 = new JComboBox(jars);

		panel.add(jar1);
		panel.add(new JLabel("compared too"));
		panel.add(jar2);

		
		int result = JOptionPane.showConfirmDialog(null,
						  panel, "Compare Two Jars", 
						  JOptionPane.OK_CANCEL_OPTION);
		
		ChangeJar s1 = null;
		ChangeJar s2 = null;
		
		Object j1 = jar1.getSelectedItem();
		Object j2 = jar2.getSelectedItem();
		
	if (result == JOptionPane.OK_OPTION){	
			
			if(j1.equals("Jar 1")){
				s1 = panel1.getChangeJar();
			}
			else if(j1.equals("Jar 2")){
				s1 = panel2.getChangeJar();
			}
			else if(j1.equals("Jar 3")){
				s1 = panel3.getChangeJar();
			}
			
			if(j2.equals("Jar 1")){
				s2 = panel1.getChangeJar();
			}
			else if(j2.equals("Jar 2")){
				s2 = panel2.getChangeJar();
			}
			else if(j2.equals("Jar 3")){
				s2 = panel3.getChangeJar();
			}	
		
	}
	
	LinkedHashMap<String, ChangeJar> jarMap  = 
								new LinkedHashMap<String, ChangeJar>();
	jarMap.put((String) j1, s1);
	jarMap.put((String) j2, s2);
	
	return jarMap;
}
	
	
	

	private class Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	if(e.getSource() == suspend){
        		if(ChangeJar.isSuspend() == true)
        			ChangeJar.suspend(false);
        		else
        			ChangeJar.suspend(true);
        	}
        	else if(e.getSource() == compare){
        		LinkedHashMap<String, ChangeJar> jars = 
        											compareAndEquals();
        		ArrayList<String> names = new ArrayList<String>();
        		ArrayList<ChangeJar> x = new ArrayList<ChangeJar>();
        		
        		for(Entry<String, ChangeJar> entry : jars.entrySet()){
        			names.add(entry.getKey());
        			x.add(entry.getValue());
        		}
        	
        		int comparison = ChangeJar.compareTo(x.get(0),x.get(1));
        		
        		if(comparison > 0){
        			JOptionPane.showMessageDialog(null,names.get(0) + 
        							" is larger than " + names.get(1));
        		}
        		else if(comparison < 0){
        			JOptionPane.showMessageDialog(null, names.get(0) + 
							" is smaller than " + names.get(1));
        		}
        		else{
        			JOptionPane.showMessageDialog(null,names.get(0) + 
							" is the same as " + names.get(1));
        		}
        	}
        	else if(e.getSource() == equals){
        		LinkedHashMap<String, ChangeJar> jars = 
													compareAndEquals();
        		
        		ArrayList<String> names = new ArrayList<String>();
        		ArrayList<ChangeJar> x = new ArrayList<ChangeJar>();
        		
        		for(Entry<String, ChangeJar> entry : jars.entrySet()){
        			names.add(entry.getKey());
        			x.add(entry.getValue());
        		}
        		
        		if(ChangeJar.equals(x.get(0), x.get(1))){
        			JOptionPane.showMessageDialog(null, names.get(0) + 
        					" is equal to " + names.get(1));
        		}
        		else{
        			JOptionPane.showMessageDialog(null, names.get(0) + 
        					" is not equal to " + names.get(1));
        		}
        	}
        }
     }
}