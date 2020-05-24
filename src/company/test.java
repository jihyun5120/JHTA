package company;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Point;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class test extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test frame = new test();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public test() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		JFrame frame = new JFrame("FX");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		frame.getContentPane().setLayout(null);
		
		
		
		final JButton jButton = new JButton("Button");
		
		final JFXPanel fxPanel = new JFXPanel();
		
		
		
		frame.getContentPane().add(jButton);
		
		frame.getContentPane().add(fxPanel);
		
		frame.setVisible(true);
				
		
		jButton.setSize(new Dimension(200, 27));
		
		fxPanel.setSize(new Dimension(1000, 500));
		
		fxPanel.setLocation(new Point(0, 27));
		
		
		
		frame.getContentPane().setPreferredSize(new Dimension(1000, 500));
		
		frame.pack();
		
		frame.setResizable(true);
		
		
		
		Platform.runLater(new Runnable() {
			
			public void run() {
				
				initAndLoadWebView(fxPanel);
				
			}
			
		});
	}

	





		

	private static void initAndLoadWebView(final JFXPanel fxPanel) {

		Group group = new Group();

		Scene scene = new Scene(group);

		fxPanel.setScene(scene);



		WebView webView = new WebView();



		group.getChildren().add(webView);

		webView.setMinSize(1000, 500);

		webView.setMaxSize(1000, 500);

		

		WebEngine webEngine = webView.getEngine();

		webEngine.load("http://www.naver.com");

	}
}
