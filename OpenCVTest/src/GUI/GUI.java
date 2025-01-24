package GUI;

import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
import javax.swing.*;

import games.*;
import opencv.ColorDetectGame;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GUI extends JFrame {
	Scanner input = new Scanner (System.in);
	private JPanel panel = new JPanel();
	private JButton clickFastGameButton;
	private JButton colorDetectGameButton;
	private JButton poseGameButton;
	private JFrame frame;
	

	//colors for background
	Color b1 = new Color(207, 236, 238);
	Color b2 = new Color(224, 238, 207);
	//colors for buttons
	Color c1 = new Color(246, 219, 204);
	Color c2 = new Color(246, 234, 204);
	Color c3 = new Color(204, 218, 246);
	Color c4 = new Color(212, 204, 246);
	Color c5 = new Color(201, 240, 173);
	Color c6 = new Color(198, 246, 228);
	Color e1 = new Color(163, 19, 21);
	Color e2 = new Color(97, 4, 5);
	public GUI() {
		setLayout(null);
		frame = new JFrame();
		frame.setSize(200, 200);
		panel = new JPanel(new FlowLayout()) {
			@Override
			protected void paintComponent(Graphics g) {
				Graphics2D g2d = (Graphics2D) g;
				GradientPaint color = new GradientPaint(0, 0, b1, getWidth()/2, getHeight()/2, b2);
				g2d.setPaint(color);
				g2d.fillRect(0, 0, getWidth(), getHeight());
				panel.setOpaque(false);
				super.paintComponent(g);
			}
			};
			ClickFastGame clickGame = new ClickFastGame(frame, panel);
			//ColorDetectGame colorGame = new ColorDetectGame(frame, panel);
			//PoseGame poseGame = new PoseGame(frame, panel);
		panel.setSize(200, 200);
		clickFastGameButton = new JButton("Reaction Click") {
			@Override
			protected void paintComponent(Graphics g) {
				Graphics2D g2d = (Graphics2D) g;
				GradientPaint color = new GradientPaint(0, 0, c1, getWidth()/2, getHeight()/2, c2);
				g2d.setPaint(color);
				g2d.fillRect(0, 0, getWidth(), getHeight());
				setContentAreaFilled(false);
				super.paintComponent(g);
			}
			};
		/*colorDetectGameButton = new JButton("Color Depiction") {
			@Override
			protected void paintComponent(Graphics g) {
				Graphics2D g2d = (Graphics2D) g;
				GradientPaint color = new GradientPaint(0, 0, c3, getWidth()/2, getHeight()/2, c4);
				g2d.setPaint(color);
				g2d.fillRect(0, 0, getWidth(), getHeight());
				setContentAreaFilled(false);
				super.paintComponent(g);
			}
			};*?
		/*poseGameButton = new JButton("Pose for The Camera") {
			@Override
			protected void paintComponent(Graphics g) {
				Graphics2D g2d = (Graphics2D) g;
				GradientPaint color = new GradientPaint(0, 0, c5, getWidth()/2, getHeight()/2, c6);
				g2d.setPaint(color);
				g2d.fillRect(0, 0, getWidth(), getHeight());
				setContentAreaFilled(false);
				super.paintComponent(g);
			}
			};*/
			clickFastGameButton.setBounds(25, 30, 50, 50);
			//colorDetectGameButton.setBounds((frame.getWidth()-getWidth())/2, 30, 50, 50);
		//	poseGameButton.setBounds(frame.getWidth()-getWidth()-25, 30, 200, 200);
			
		clickFastGameButton.setLocation(25, 30);
		//colorDetectGameButton.setLocation((frame.getWidth()-getWidth())/2, 30);
		frame.setSize(200, 200);
		//poseGameButton.setLocation(frame.getWidth()-getWidth()-25, 30);
//			colorDetectGameButton.addActionListener(new ActionListener() { 
//				@Override
//				public void actionPerformed(ActionEvent e) 
//				{ 
//					
//					colorGame.startGame();
//					colorGame.init();
//					colorGame.startCamera();
//					System.out.println("You have selected the camera game.");
//					panel.repaint();
//				}
//				});
			/* poseGameButton.addActionListener(new ActionListener() { 
				@Override
				public void actionPerformed(ActionEvent e) 
				{ 
					
					poseGame.startGame();
					poseGame.init();
					System.out.println("You have selected the color detection game.");
					panel.repaint();
				}
				});*/
			
		clickFastGameButton.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) 
			{ 
				
				clickGame.startGame();
				clickGame.init();
				System.out.println("You have selected the clicker game.");
				panel.repaint();
			}
			});
		
		JButton endButton = new JButton("Close") {
			@Override
			protected void paintComponent(Graphics g) {
				Graphics2D g2d = (Graphics2D) g;
				GradientPaint color = new GradientPaint(0, 0, e1, getWidth()/2, getHeight()/2, e2);
				g2d.setPaint(color);
				g2d.fillRect(0, 0, getWidth(), getHeight());
				setContentAreaFilled(false);
				super.paintComponent(g);
			}};
		endButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		endButton.setBounds(0,0,100, 100);
		endButton.setForeground(Color.WHITE);
		panel.add(clickFastGameButton);
		panel.add(Box.createHorizontalStrut(1));
		//panel.add(colorDetectGameButton);
		//panel.add(Box.createHorizontalStrut(1));
		/*panel.add(poseGameButton);
		panel.add(Box.createHorizontalStrut(1));*/
		panel.add(endButton);
		frame.add(panel);
		
		frame.setTitle("Game Selection GUI");
		frame.setVisible(true);
	}
	public void repaintGUI() {
		panel.repaint();
	}
public static void main(String[] args) {
	EventQueue.invokeLater(new Thread(new Runnable() {
	@Override 
	public void run() {
		GUI gui = new GUI();
		}
	
	}));};


}
	
