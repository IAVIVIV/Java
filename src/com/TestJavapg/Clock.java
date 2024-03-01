package com.TestJavapg;

import java.awt.FlowLayout;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Clock extends JPanel {
	private static final long serialVersionUID = 1L;
	public JLabel timeLabel;

	public Clock() {
		setBounds(0, 0, 200, 100);
		setLayout(new FlowLayout());

		timeLabel = new JLabel();
		add(timeLabel);
	}

	public void Start() {
		new Thread(() -> {
			while (true) {
				updateTime();
			}
		}).start();
	}

	public void updateTime() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		dateFormat.setTimeZone(TimeZone.getTimeZone("GMT+7"));
		timeLabel.setText(dateFormat.format(new Date()));
	}
}