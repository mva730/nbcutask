package com.nbc.ui.driverfactory;

import org.openqa.selenium.WebDriver;

public class WebDriverSession {

    private static ThreadLocal<WebDriver> currentSession = new ThreadLocal<>();

    public static WebDriver getCurrentSession() {
		return currentSession.get();
	}

    public static void setCurrentSession(WebDriver newSession) {
		currentSession.set(newSession);
	}
}
