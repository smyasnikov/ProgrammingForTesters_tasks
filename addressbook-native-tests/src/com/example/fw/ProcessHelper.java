package com.example.fw;

import java.io.IOException;

public class ProcessHelper extends HelperBase{

	private Process process;

	public ProcessHelper(ApplicationManager applicationManager) {
		super(applicationManager);
	}

	public void startAppUnderTest(String command) throws IOException {
		
		process = Runtime.getRuntime().exec(command);
	}
	
	public void stopAppUnderTest() {
		process.destroy();
	}

}
