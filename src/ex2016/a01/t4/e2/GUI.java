package ex2016.a01.t4.e2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.*;

public class GUI {
	
    public GUI(String fileName, int size){
    	Logic logic = new Logic();
        JFrame jf = new JFrame();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton[] jbuttons = new JButton[size];
        JButton jbReset = new JButton("RESET");
        jbReset.addActionListener(e -> {
			try {
				logic.reset();
				logic.read(fileName);
				int next = logic.nextInt();
				for (JButton button : jbuttons) {
					button.setEnabled(true);
					button.setText(Integer.toString(next));
				}
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IllegalStateException e2) {
				System.err.println("File is empty");
			}
		});
        JPanel jp = new JPanel();
        
        try {
			logic.read(fileName);
			int n = logic.nextInt();
			for (int i = 0; i < size; i++) {
				jbuttons[i] = new JButton(n+ "");
				jbuttons[i].addActionListener(e -> {
					try {						
						int next = logic.nextInt();
						for(JButton button : jbuttons) {
							button.setText(Integer.toString(next));
						}
					} catch (IllegalStateException e2) {
						for (JButton button : jbuttons) {
							button.setEnabled(false);
						}
					}
				});
				
				jp.add(jbuttons[i]);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
        
        
        jp.add(jbReset);
        jf.getContentPane().add(jp);
        jf.pack();
        jf.setVisible(true);
    }

}
