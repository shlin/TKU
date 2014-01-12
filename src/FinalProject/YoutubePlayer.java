package FinalProject;

import com.teamdev.jxbrowser.chromium.*;

import javax.swing.*;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class YoutubePlayer {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Browser browser = BrowserFactory.create();

		JFrame frame = new JFrame("Youtube 點播機");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.add(browser.getView().getComponent(), BorderLayout.CENTER);
		frame.setSize(1024, 768);
		frame.setVisible(true);

		// browser.loadHTML("<html><body><h1>Hello world!</h1></body></html>");
		browser.loadURL("http://www.youtube.com/watch?v=4D2aKrLtrl4&list=RDfNJSUT97NZk");
//		browser.loadURL("http://www.google.com");
		while (browser.isLoading()) {
		    TimeUnit.MILLISECONDS.wait(50);
		}
		// web page is loaded completely
	}

}