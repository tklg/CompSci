package chatroom;

import java.awt.Dimension;

import javax.swing.*;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class GUIDES {

	private final int WIDTH_SETTINGS = 400,
	  		  HEIGHT_SETTINGS = 200;
	private static final int WIDTH_MAIN = 700;
	private final static int HEIGHT_MAIN = 500;
private final static double ver = 1.0;

private static JFrame framePre;
private static JFrame frame;
private static JPanel panelPre;
private static JPanel panel;
private static JTextField input_1;
private JTextField ipSet;
private JTextField portSet;
private JTextField input;
private JScrollPane output,
				userList;
private JLabel userTitle,
		   userNameLabel,
		   ipLabel,
		   portLabel;
private JButton btnSend;
private JButton btnConnect;
private Box horizontalBox;
private static JScrollPane scrollPane;

public static void main(String[] args) {
	frame = new JFrame("ChatServer v" + ver);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	panel = new JPanel();
	panel.setPreferredSize(new Dimension(WIDTH_MAIN, HEIGHT_MAIN));
	
	input_1 = new JTextField(30);
	
	scrollPane = new JScrollPane();
	scrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
	GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
	groupLayout.setHorizontalGroup(
		groupLayout.createParallelGroup(Alignment.LEADING)
			.addComponent(panel, GroupLayout.PREFERRED_SIZE, 434, GroupLayout.PREFERRED_SIZE)
	);
	groupLayout.setVerticalGroup(
		groupLayout.createParallelGroup(Alignment.LEADING)
			.addComponent(panel, GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE)
	);
	
	JButton btnNewButton = new JButton("Send");
	GroupLayout gl_panel = new GroupLayout(panel);
	gl_panel.setHorizontalGroup(
		gl_panel.createParallelGroup(Alignment.LEADING)
			.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
				.addComponent(input_1, GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addComponent(btnNewButton)
				.addContainerGap())
			.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
	);
	gl_panel.setVerticalGroup(
		gl_panel.createParallelGroup(Alignment.TRAILING)
			.addGroup(gl_panel.createSequentialGroup()
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
					.addComponent(input_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addComponent(btnNewButton))
				.addGap(6))
	);
	
	JTextArea textArea = new JTextArea();
	scrollPane.setViewportView(textArea);
	panel.setLayout(gl_panel);
	frame.getContentPane().setLayout(groupLayout);
}
}
