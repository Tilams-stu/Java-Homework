package running;

import java.awt.*;

import javax.swing.*;
import java.awt.event.*;
import var.Vars;

public class Running {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Java Printer");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,600);
		
        MenuBar menuBar = new MenuBar();

        Menu fileMenu = new Menu("file");
        MenuItem openItem = new MenuItem("open");
        MenuItem saveItem = new MenuItem("save");
        MenuItem exitItem = new MenuItem("exit");

        fileMenu.add(openItem);
        fileMenu.addSeparator(); 
        fileMenu.add(saveItem);
        fileMenu.addSeparator(); 
        fileMenu.add(exitItem);

        Menu editMenu = new Menu("edit");
        MenuItem cutItem = new MenuItem("cut");
        MenuItem copyItem = new MenuItem("copy");
        MenuItem pasteItem = new MenuItem("paste");

        editMenu.add(cutItem);
        editMenu.addSeparator(); 
        editMenu.add(copyItem);
        editMenu.addSeparator(); 
        editMenu.add(pasteItem);
        
        Menu helpMenu = new Menu("help");
        
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);

        frame.setMenuBar(menuBar);

        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); 
            }
        });
		
		frame.getContentPane().add(Vars.paintPanel,BorderLayout.CENTER);
		frame.getContentPane().add(Vars.northPanel,BorderLayout.NORTH);
		frame.getContentPane().add(Vars.leftBar,BorderLayout.WEST);
		frame.getContentPane().add(Vars.southPanel,BorderLayout.SOUTH);
		frame.setVisible(true);
		
	}
}
