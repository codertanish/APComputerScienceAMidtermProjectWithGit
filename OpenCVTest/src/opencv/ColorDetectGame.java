package opencv;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;

import games.GameLogic;

public class ColorDetectGame implements GameLogic {
	private JFrame frame;
	private JPanel originalPanel;
	private JPanel colorPanel;
	private JLabel cameraScreen; 
	private JLabel colorLabel;
	private JButton captureButton; 
	private VideoCapture capture; 
	private Mat image; 
	private boolean clicked; 
	private String[] colors = {"Red", "Blue", "Green"};
	public ColorDetectGame(JFrame frame, JPanel panel) {
		this.frame = frame;
		originalPanel = panel;
		colorPanel = new JPanel();
		frame.setLayout(null); 
		  
        cameraScreen = new JLabel(); 
        cameraScreen.setBounds(0, 0, 640, 480); 
        colorPanel.add(cameraScreen); 
  
        captureButton = new JButton("capture"); 
        captureButton.setBounds(300, 480, 80, 40); 
        colorPanel.add(captureButton); 
  
        captureButton.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) 
            { 
  
                clicked = true; 
            } 
        }); 
  
        frame.setSize(640, 560); 
        frame.setLocationRelativeTo(null); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setVisible(true);
	}
	public ColorDetectGame(JFrame frame) {
		this.frame = frame;
		colorPanel = new JPanel();
		colorPanel.setLayout(null); 
		  
        cameraScreen = new JLabel(); 
        cameraScreen.setBounds(0, 0, 640, 480); 
        colorPanel.add(cameraScreen); 
  
        captureButton = new JButton("capture"); 
        captureButton.setBounds(300, 480, 80, 40); 
        colorPanel.add(captureButton); 
  
        captureButton.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) 
            { 
  
                clicked = true; 
            } 
        }); 
  
        frame.setSize(640, 560); 
        frame.setLocationRelativeTo(null); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setVisible(true);
	}
	public void startCamera() {
	capture = new VideoCapture(0); 
    image = new Mat(); 
    byte[] imageData; 

    ImageIcon icon; 
    while (true) { 
        // read image to matrix 
        capture.read(image); 

        // convert matrix to byte 
        final MatOfByte buf = new MatOfByte(); 
        Imgcodecs.imencode(".jpg", image, buf); 

        imageData = buf.toArray(); 

        // Add to JLabel 
        icon = new ImageIcon(imageData); 
        cameraScreen.setIcon(icon); 

        // Capture and save to file 
        if (clicked) { 
            // prompt for enter image name 
            String name = JOptionPane.showInputDialog( 
                this, "Enter image name"); 
            if (name == null) { 
                name = new SimpleDateFormat( 
                           "yyyy-mm-dd-hh-mm-ss") 
                           .format(new Date(0)); 
            } 

            // Write to file 
            Imgcodecs.imwrite("images/" + name + ".jpg", 
                              image); 

            clicked = false; 
        } 
        
    } 

				
			 
		
	} 
	/*public void init() 
	{
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME); 
	
		frame.remove(originalPanel);
		colorPanel = new JPanel();
		colorPanel.setLayout(null); 
		frame.setSize(1000, 1000);

		cameraScreen = new JLabel(); 
		cameraScreen.setBounds(0, 0, 1000, 750); 
		colorPanel.add(cameraScreen); 
		colorLabel = new JLabel();
		captureButton = new JButton("capture"); 
		captureButton.setBounds(460, 800, 80, 40); 
		colorPanel.add(captureButton); 
		captureButton.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) 
			{ 

				clicked = true;
			}}); 
		
		frame.add(colorPanel);
		frame.repaint();

	}*/

	}
