// Java Program to take a Snapshot from System Camera 
// using OpenCV 

// Importing openCV modules 
package opencv; 
// importing swing and awt classes 
import java.awt.Dimension; 
import java.awt.EventQueue; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
// Importing date class of sql package 
import java.sql.Date; 
import java.text.DateFormat; 
import java.text.SimpleDateFormat; 
import javax.swing.ImageIcon; 
import javax.swing.JButton; 
import javax.swing.JFrame; 
import javax.swing.JLabel; 
import javax.swing.JOptionPane; 
import org.opencv.core.Core; 
import org.opencv.core.Mat; 
import org.opencv.core.MatOfByte; 
import org.opencv.imgcodecs.Imgcodecs; 
// Importing VideoCapture class 
// This class is responsible for taking screenshot 
import org.opencv.videoio.VideoCapture; 

// Class - Swing Class 
public class OpenCVTest extends JFrame { 

	private JLabel cameraScreen; 

	private JButton btnCapture; 

	private VideoCapture capture; 

	private Mat image; 

	private boolean clicked = false; 

	public OpenCVTest() 
	{ 

		// Designing UI 
		setLayout(null); 

		cameraScreen = new JLabel(); 
		cameraScreen.setBounds(0, 0, 640, 480); 
		add(cameraScreen); 

		btnCapture = new JButton("capture"); 
		btnCapture.setBounds(300, 480, 80, 40); 
		add(btnCapture); 

		btnCapture.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) 
			{ 

				clicked = true; 
			} 
		}); 

		setSize(new Dimension(640, 560)); 
		setLocationRelativeTo(null); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setVisible(true); 
	} 

	// Creating a camera 
	public void startCamera() 
	{ 
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
							.format(new Date( 
								HEIGHT, WIDTH, getX())); 
				} 

				// Write to file 
				Imgcodecs.imwrite("C:/Users/tanis/eclipse-workspace/OpenCVTest/src/opencv/images/" + name + ".jpg", 
								image); 

				clicked = false; 
			} 
		} 
	} 

	// Main driver method 
	public static void main(String[] args) 
	{ 
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME); 
		EventQueue.invokeLater(new Runnable() { 
			// Overriding existing run() method 
			@Override public void run() 
			{ 
				final OpenCVTest camera = new OpenCVTest(); 

				// Start camera in thread 
				try {
				new Thread(new Runnable() { 
					@Override public void run() 
					{ 
						camera.startCamera(); 
					} 
				}).start(); }
				catch(Exception e) {
					System.exit(ABORT);
				}
			} 
		}); 
		
	
	} 
}
