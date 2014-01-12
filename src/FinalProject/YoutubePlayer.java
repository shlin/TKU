package FinalProject;

import com.teamdev.jxbrowser.chromium.*;

import javax.swing.*;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class YoutubePlayer {
	static Browser browser;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		browser = BrowserFactory.create();

		JFrame frame = new JFrame("Youtube 點播機");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.add(browser.getView().getComponent(), BorderLayout.CENTER);
		frame.setSize(800, 600);
		frame.setVisible(true);

		browser.loadURL("http://www.youtube.com/embed/fNJSUT97NZk?list=PLB27E983B2D5BC4C4");
		while (browser.isLoading()) {
		    TimeUnit.MILLISECONDS.wait(50);
		}
		// web page is loaded completely
	}

}