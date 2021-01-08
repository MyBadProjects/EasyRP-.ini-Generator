import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Main implements ActionListener {
	private JFrame frame;
	private JPanel panel;
	private JLabel title;
	private JTextArea clientId;
	private JTextArea state;
	private JTextArea detail;
	private JTextArea largeImage;
	private JTextArea largeImageText;
	private JTextArea smallImage;
	private JTextArea smallImageText;
	private JTextArea output;
	private JButton enter;
	private JButton save;
	private int count = 0;
	
	public Main() {
		frame = new JFrame();
		
		title = new JLabel("EasyRP .ini Generator");

		clientId = new JTextArea("Client ID");
		state = new JTextArea("State");
		detail = new JTextArea("Detail");
		largeImage = new JTextArea("Large Image");
		largeImageText = new JTextArea("Large Image Text");
		smallImage = new JTextArea("Small image");
		smallImageText = new JTextArea("Small Image Text");
		output = new JTextArea("Output Text");
		
		enter = new JButton("Generate");
		enter.addActionListener(this);
		
		panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		panel.setLayout(new GridLayout(0,1));
		panel.add(title);
		panel.add(clientId);
		panel.add(state);
		panel.add(detail);
		panel.add(largeImage);
		panel.add(largeImageText);
		panel.add(smallImage);
		panel.add(smallImageText);
		panel.add(output);
		panel.add(enter);
		
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("EasyRP Generator");
		frame.pack();
		frame.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new Main();
	}
	
	
	public void actionPerformed(ActionEvent e) {	
		String generatedText = "ClientID="+clientId.getText()+"\nState="+state.getText()+"\nDetails="+detail.getText()+"\nStartTimestamp=\nEndTimestamp=\nLargeImage="+largeImage.getText()+"\nLargeImageTooltip="+largeImageText.getText()+"\nSmallImage="+smallImage.getText()+"\nSmallImageTooltip="+smallImageText.getText();
		output.setText(generatedText);
		
		if (count == 0) {
			JLabel labelTutorial = new JLabel("To change the file, go into your EasyRP file, go into config.ini and copy and paste the output into it and then save it. You can edit the file in Notepad.");

			panel.add(labelTutorial);
			
			count++;
		}
	}
}
