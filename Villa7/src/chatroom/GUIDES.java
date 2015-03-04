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
import javax.swing.text.DefaultCaret;

import java.awt.Color;
import java.awt.Font;

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
private static JTextArea outputText;
private static JTextField input;
private static JScrollPane output;
private JScrollPane userList;
private JLabel userTitle,
		   userNameLabel,
		   ipLabel,
		   portLabel;
private static JButton btnSend;
private JButton btnConnect;
private Box horizontalBox;
private static JScrollPane scrollPane;

public static void main(String[] args) {
	frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setResizable(false);
	
	panel = new JPanel();
	panel.setPreferredSize(new Dimension(WIDTH_MAIN, HEIGHT_MAIN));
	
	input = new JTextField(30);
	input.setFont(new Font("Arial", Font.PLAIN, 14));
	
	output = new JScrollPane();
	output.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
	GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
	groupLayout.setHorizontalGroup(
		groupLayout.createParallelGroup(Alignment.LEADING)
			.addComponent(panel, GroupLayout.DEFAULT_SIZE, 704, Short.MAX_VALUE)
	);
	groupLayout.setVerticalGroup(
		groupLayout.createParallelGroup(Alignment.LEADING)
			.addComponent(panel, GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
	);
	
	outputText = new JTextArea();
	outputText.setFont(new Font("Arial", Font.PLAIN, 14));
	output.setViewportView(outputText);
	output.setFocusable(false);
	DefaultCaret caret = (DefaultCaret) outputText.getCaret();
	caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
			
	btnSend = new JButton("Send");
	//btnSend.addActionListener(new SendListener());
	GroupLayout gl_panel = new GroupLayout(panel);
	gl_panel.setHorizontalGroup(
		gl_panel.createParallelGroup(Alignment.TRAILING)
			.addGroup(gl_panel.createSequentialGroup()
				.addContainerGap()
				.addComponent(input, GroupLayout.DEFAULT_SIZE, 617, Short.MAX_VALUE)
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addComponent(btnSend)
				.addContainerGap())
			.addComponent(output, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
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
}
