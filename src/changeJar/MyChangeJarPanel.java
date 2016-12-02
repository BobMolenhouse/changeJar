package changeJar;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class MyChangeJarPanel extends JPanel {

    private Listener listen;
    private ChangeJar changeJar;
    private JLabel quarters;
    private JLabel dimes;
    private JLabel nickels;
    private JLabel pennies;
    private JLabel name;
    private JButton addQ;
    private JButton addD;
    private JButton addN;
    private JButton addP;
    private JButton subQ;
    private JButton subD;
    private JButton subN;
    private JButton subP;
    private JButton takeOutCoins;
    private JButton takeOutDouble;
    private JButton putInCoins;


    public MyChangeJarPanel(String name){
        setLayout(new GridLayout(4,4));
        setBorder(new EmptyBorder(6,6,6,6));
        changeJar = new ChangeJar();

        this.name = new JLabel(name);
        add(this.name);
        
        quarters = new JLabel(); 
        dimes = new JLabel();
        nickels = new JLabel();
        pennies = new JLabel();

        listen = new Listener();

        addButtons(); 
        add(quarters);
        add(dimes);
        add(nickels);
        add(pennies);
        
        redisplay();
        setVisible(true);
    }
    
    private void redisplay(){
    	 quarters.setText("Quarters: " + changeJar.getQuarters());
         dimes.setText("Dimes: " + changeJar.getDimes());
         nickels.setText("Nickels: " + changeJar.getNickels());
         pennies.setText("Pennies: " + changeJar.getPennies());
    }

    private void addButtons(){
    	Border b = BorderFactory.createRaisedBevelBorder();
        putInCoins = new JButton("Add Coins");
        putInCoins.addActionListener(listen);
        putInCoins.setBorder(b);
        add(putInCoins);
        
        takeOutCoins = new JButton("Take Coins");
        takeOutCoins.addActionListener(listen);
        takeOutCoins.setBorder(b);
        add(takeOutCoins);
        
        takeOutDouble = new JButton("Take Amount");
        takeOutDouble.addActionListener(listen);
        takeOutDouble.setBorder(b);
        add(takeOutDouble);
        
        addQ = new JButton("Add Quarter");
        addQ.addActionListener(listen);
        addQ.setBorder(b);
        add(addQ);
        
        addD = new JButton("Add Dime");
        addD.addActionListener(listen);
        addD.setBorder(b);
        add(addD);
        
        addN = new JButton("Add Nickel");
        addN.addActionListener(listen);
        addN.setBorder(b);
        add(addN);
        
        addP = new JButton("Add Penny");
        addP.addActionListener(listen);
        addP.setBorder(b);
        add(addP);
        
        subQ = new JButton("Take Quarter");
        subQ.addActionListener(listen);
        subQ.setBorder(b);
        add(subQ);
   
        subD = new JButton("Take Dime");
        subD.addActionListener(listen);
        subD.setBorder(b);
        add(subD);

        subN = new JButton("Take Nickel");
        subN.addActionListener(listen);
        subN.setBorder(b);
        add(subN); 

        subP = new JButton("Take Penny");
        subP.addActionListener(listen);
        subP.setBorder(b);
        add(subP);
    }

    public int[] makeCoinPanel(){
        JTextField qField = new JTextField(5);
        JTextField dField = new JTextField(5);
        JTextField nField = new JTextField(5);
        JTextField pField = new JTextField(5);

        JPanel panel = new JPanel();
        panel.add(new JLabel("Quarters:"));
        panel.add(qField);
        panel.add(Box.createHorizontalStrut(15)); 
        panel.add(new JLabel("Dimes:"));
        panel.add(dField);
        panel.add(Box.createHorizontalStrut(15));
        panel.add(new JLabel("Nickels:"));
        panel.add(nField);
        panel.add(Box.createHorizontalStrut(15));
        panel.add(new JLabel("Pennies:"));
        panel.add(pField);

        int q = 0;
        int d = 0;
        int n = 0;
        int p = 0;

        int result = JOptionPane.showConfirmDialog(null, panel, 
                "How Many?", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION){
            if(!qField.getText().equals("")){
                q = Integer.parseInt(qField.getText());
            }
            if(!dField.getText().equals("")){
                d = Integer.parseInt(dField.getText());
            }
            if(!nField.getText().equals("")){
                n = Integer.parseInt(nField.getText());
            }
            if(!pField.getText().equals("")){
                p = Integer.parseInt(pField.getText());
            }
        }
        int[] coins = {q,d,n,p};
        return coins;
    }

    public ChangeJar getChangeJar(){
        return changeJar;
    }

    private class Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == addQ){
                changeJar.putIn(1,0,0,0);
                redisplay();
            }
            else if(e.getSource() == addD){
                changeJar.putIn(0,1,0,0);
            }
            else if(e.getSource() == addN){
                changeJar.putIn(0,0,1,0);
            }
            else if(e.getSource() == addP){
                changeJar.putIn(0,0,0,1);
            }
            else if(e.getSource() == subQ){
                changeJar.takeOut(1,0,0,0);
            }
            else if(e.getSource() == subD){
                changeJar.takeOut(0,1,0,0);
            }
            else if(e.getSource() == subN){
                changeJar.takeOut(0,0,1,0);
            }
            else if(e.getSource() == subP){
                changeJar.takeOut(0,0,0,1);
            }
            else if(e.getSource() == takeOutDouble){
                String input = JOptionPane.showInputDialog
                    ("Enter Amount in Dollars:");
                double d = Double.parseDouble(input);
                changeJar.takeOut(d);
            }
            else if(e.getSource() == takeOutCoins){
                int[] c = makeCoinPanel();
                changeJar.takeOut(c[0],c[1],c[2],c[3]);
            }
            else if(e.getSource() == putInCoins){
                int[] c = makeCoinPanel();
                changeJar.putIn(c[0],c[1],c[2],c[3]);
            }
        redisplay();        
       }
    }
}	