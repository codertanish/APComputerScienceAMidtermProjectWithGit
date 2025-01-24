package games;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.*;

public class ClickFastGame implements GameLogic {
	public ClickFastGame(JFrame frame, JPanel panel) {
		this.frame = frame;
		originalPanel = panel;
		gamePanel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				Graphics2D g2d = (Graphics2D) g;
				GradientPaint color = new GradientPaint(0, 0, b1, getWidth()/2, getHeight()/2, b2);
				g2d.setPaint(color);
				g2d.fillRect(0, 0, getWidth(), getHeight());
				super.paintComponent(g);
			}};
	}
	Color c1 = new Color(201, 240, 173);
	Color c2 = new Color(198, 246, 228);
	Color b1 = new Color(246, 219, 204);
	Color b2 = new Color(246, 234, 204);
	public static int score;
	private java.util.Timer timer;
	private JPanel gamePanel;
	private JButton button;

	private boolean gameStatus = false;
	private JFrame frame;
	private JPanel originalPanel;
	private JButton endButton;
	@Override
	public void startGame() {
		gameStatus = true;
		timer = new Timer();
		End end = new End();
		timer.schedule(end, (long) 15000);
		
	}
	
	@Override
	public void endGame() {
		frame.remove(gamePanel);
		frame.add(originalPanel);
		frame.setSize(200, 200);
		frame.setTitle("Selection GUI");
		gamePanel.remove(button);
		gamePanel.remove(endButton);
		
		frame.repaint();
	}
	class End extends TimerTask{
		public void run() {
			gameStatus = false;
			button.setText("Your final score: " + score);
			button.setSize(200, 200);
			button.setLocation(400, 400);
			endButton = new JButton("Return");
			endButton.setBounds(800, 800, 100, 100);
			gamePanel.add(endButton);
			endButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					endGame();
					
				}
			});
			frame.repaint();
		}
	}
	
	@Override
	public boolean getStatus() {
		return gameStatus;
	}
	
	
@Override
public void init() {
	score = 0;
	frame.remove(originalPanel);
	frame.setTitle("Reaction Click");
	frame.setSize(1000, 1000);
	frame.repaint();
		
			button = new JButton("Click Me!") {
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
			gamePanel.setLayout(null);
			
			button.setBounds((int) (Math.random()*800+100), (int) (Math.random()*800+100), 100, 100);
			button.addActionListener(new ActionListener() { 
				@Override
				public void actionPerformed(ActionEvent e)  { 
					if(gameStatus) {
					c1 = new Color((int) (Math.random()*255+1), (int) (Math.random()*255+1), (int) (Math.random()*255+1));
					c2 = new Color((int) (Math.random()*255+1), (int) (Math.random()*255+1), (int) (Math.random()*255+1));
					score++;
					button.setLocation((int) (Math.random()*800+100), (int) (Math.random()*800+100));
					button.setText("Score: " + score);
					}
					
				}
						
				});
			button.addKeyListener(new KeyListener() {
				@Override
				public void keyTyped(KeyEvent k) {
					if(k.getKeyCode()==32 && gameStatus) {
						score--;
					}
				}
				@Override
				public void keyPressed(KeyEvent k) {
					if(k.getKeyCode()==32 && gameStatus) {
						score--;
					}
					
				}
				@Override
				public void keyReleased(KeyEvent k) {}
			});
				
	gamePanel.add(button);
	frame.add(gamePanel);
	frame.repaint();
}
}