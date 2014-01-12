package FinalProject;

import com.teamdev.jxbrowser.chromium.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class YoutubePlayer extends JFrame {

	private Browser browser;
	private JComponent browserView;
	private JList list;
	private PlayListPool listPool;

	public YoutubePlayer() throws InterruptedException, IOException {
		// 初始化選單
		listPool = new PlayListPool();

		// 初始化選單View
		list = new JList(listPool.initListView());
		list.setVisible(true);

		// 初始化瀏覽器
		browser = BrowserFactory.create();
		browserView = browser.getView().getComponent();
		browserView.setVisible(true);

		// 初始化GUI視窗
		this.setTitle("Youtube 點播機");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(list, BorderLayout.LINE_START);
		this.getContentPane().add(browserView, BorderLayout.CENTER);
		this.setSize(1024, 768);
		this.setVisible(true);

		// 讀取清單上第一段影片
		browser.loadURL(listPool.getURL(1));

		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					int itemIndex = list.locationToIndex(e.getPoint());
					if (!(itemIndex == 0 || itemIndex == listPool.getEndIndex())) {
						// 取得影片嵌入網址
						String tmpURL = listPool.getURL(itemIndex);

						System.out.println("Item Clicked: " + itemIndex + "\t"
								+ tmpURL);

						// 載入影片
						browser.loadURL(tmpURL);
					}
				}
			}
		});
	}

	public static void main(String[] args) throws InterruptedException,
			IOException {
		// TODO Auto-generated method stub
		YoutubePlayer newPlayer = new YoutubePlayer();
	}

}