package com.TestJavapg;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class UI {
	private TextField tf;

	public void launch() {
		JFrame jFrame = new JFrame();
		jFrame.setTitle("Simple Clock");
		jFrame.setSize(200, 150);

		BorderLayout layout = new BorderLayout();

		jFrame.setLayout(layout);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setLocationRelativeTo(null);
		jFrame.setVisible(true);

		JButton bt = new JButton("accept");
		tf = new TextField("");

		JPanel jPanel = new JPanel();
		jPanel.setLayout(new GridLayout(1, 2));
		jPanel.add(tf);
		jPanel.add(bt);

		Clock clock = new Clock();
		clock.Start();

		bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Thread(() -> {
					String ntime = tf.getText();
					Clone clone = new Clone();
					clone.nT = ntime;
					UI ac = new UI();
					ac.launch();
					clone.Start();
					jFrame.add(clone, BorderLayout.CENTER);
				}).start();
			}
		});

		jFrame.add(clock, BorderLayout.CENTER);
		jFrame.add(jPanel, BorderLayout.SOUTH);
	}
}
