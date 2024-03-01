package com.TestJavapg;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Clone extends Clock {
	private static final long serialVersionUID = 1L;
	public String nT;

	@Override
	public void updateTime() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		dateFormat.setTimeZone(TimeZone.getTimeZone(nT));
		timeLabel.setText(dateFormat.format(new Date()));
	}
}
