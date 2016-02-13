package com.azudio.teamsite.automatedtesting.utils;


public class UISnoozer {
	public static void snz(long sourceDuration) {
		try {
			Thread.sleep(sourceDuration);
		} catch (InterruptedException e) {
		}
	}
}
