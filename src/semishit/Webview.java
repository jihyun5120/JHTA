package semishit;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JFrame;

import java.awt.Dimension;

import java.awt.Point;

import javafx.application.Platform;

import javafx.embed.swing.JFXPanel;

import javafx.scene.Group;

import javafx.scene.Scene;

import javafx.scene.web.WebEngine;

import javafx.scene.web.WebView;

import javax.swing.JButton;

import javax.swing.JFrame;

import javax.swing.SwingUtilities;

public class Webview extends JInternalFrame {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Webview frame = new Webview();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private static void initFX() {

		JInternalFrame frame = new JInternalFrame("FX");
		frame.getContentPane().setLayout(null);
		final JFXPanel fxPanel = new JFXPanel();
		frame.add(fxPanel);
		frame.setVisible(true);
		fxPanel.setSize(new Dimension(1600, 900));
		fxPanel.setLocation(new Point(0, 0));
		frame.getContentPane().setPreferredSize(new Dimension(1600, 900));
		frame.pack();
		frame.setResizable(false);
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
		webView.setMinSize(1600, 900);
		webView.setMaxSize(1600, 900);
		WebEngine webEngine = webView.getEngine();
		webEngine.load("http://www.naver.com/");

	}

	/**
	 * Create the frame.
	 */
	public Webview() {
		super("À¥ºä", true, true, true, true);
		setVisible(true);
		setBounds(100, 100, 786, 571);

		initFX();
	}

}
