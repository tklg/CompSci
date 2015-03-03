package chatroom;

import java.awt.Dimension;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import javax.swing.text.DefaultCaret;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatClientGUI {
	
	private final int WIDTH_SETTINGS = 400,
			  		  HEIGHT_SETTINGS = 200,
			  		  WIDTH_MAIN = 900,
			  		  HEIGHT_MAIN = 600;
	private final double ver = 1.0;
	
	private JFrame framePre,
				   frame;
	private JPanel panelPre,
				   panel;
	private JTextField userNameSet,
					   ipSet,
					   portSet,
					   input;
	private JTextArea outputText;
	private JScrollPane output,
						userList;
	private JLabel userTitle,
				   userNameLabel,
				   ipLabel,
				   portLabel;
	private JButton btnSend;
	private JButton btnConnect;
	private Box horizontalBox;
	private String username, ip, port;
	private boolean doneSettings = false,
					doneMain = false;
	private ChatClient client;

	public ChatClientGUI(ChatClient client) {
		this.client = client;
		framePre = new JFrame("ChatServer v" + ver);
		framePre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framePre.setResizable(false);
		
		panelPre = new JPanel();
		panelPre.setPreferredSize(new Dimension(WIDTH_SETTINGS, HEIGHT_SETTINGS));
		ipSet = new JTextField(30);
		portSet = new JTextField(30);
		
		framePre.getContentPane().add(panelPre, BorderLayout.CENTER);
		panelPre.setLayout(new GridLayout(8, 4, 0, 0));
		userNameLabel = new JLabel("Set your username.");
		userNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panelPre.add(userNameLabel);
		
		userNameSet = new JTextField(30);
		panelPre.add(userNameSet);
		ipLabel = new JLabel("Server IP:");
		ipLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panelPre.add(ipLabel);
		panelPre.add(ipSet);
		portLabel = new JLabel("Server Port:");
		portLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panelPre.add(portLabel);
		panelPre.add(portSet);
		
		horizontalBox = Box.createHorizontalBox();
		panelPre.add(horizontalBox);
		
		btnConnect = new JButton("Connect");
		btnConnect.addActionListener(new SettingsListener());
		panelPre.add(btnConnect);
		
		/* --------------- Fancy stuff made with WindowBuilder -------------- */
		
		frame = new JFrame("ChatServer v" + ver + " " + getName());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(WIDTH_MAIN, HEIGHT_MAIN));
		
		input = new JTextField(30);
		
		output = new JScrollPane();
		output.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.PREFERRED_SIZE, 434, GroupLayout.PREFERRED_SIZE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE)
		);
		
		outputText = new JTextArea();
		output.setViewportView(outputText);
				
		btnSend = new JButton("Send");
		btnSend.addActionListener(new SendListener());
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addComponent(input, GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnSend)
					.addContainerGap())
				.addComponent(output, GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(output, GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(input, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSend))
					.addGap(6))
		);
		panel.setLayout(gl_panel);
		frame.getContentPane().setLayout(groupLayout);
		
	}
	
	public boolean displaySettings() {
		framePre.pack();
		frame.setVisible(false);
		framePre.setVisible(true);
		return doneSettings;
	}
	public void displayMain() {
		frame.pack();
		framePre.setVisible(false);
		frame.setVisible(true);
	}
	public String getName() {
		return (userNameSet.getText().length() > 0) ? userNameSet.getText() : "";
	}
	public String getIp() {
		return (ipSet.getText().length() > 0) ? ipSet.getText() : "";
	}
	public int getPort() {
		return (portSet.getText().length() > 0) ? Integer.parseInt(portSet.getText()) : 0;
	}
	public void pushToChat(String msg) {
		outputText.append(msg + "\n");
	}
	
	private class SettingsListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			client.host = getIp();
			client.port = getPort();
			client.user = getName();
			doneSettings = true;
		}
	}
	private class SendListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			client.send(input.getText()); //when send button pressed, send message in text box
			input.setText(""); //clear box
		}
	}

}
