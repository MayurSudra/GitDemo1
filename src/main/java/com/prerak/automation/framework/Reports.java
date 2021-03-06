package com.prerak.automation.framework;

import java.io.File;

import com.relevantcodes.extentreports.ExtentReports;

public class Reports {

	
	public static ExtentReports report = null;

	public static String report_name = "First-" + BasePageActions.report_date + ".html";
	
	public static ExtentReports getReports(String baseDirPath) {
		
		if (report == null) {
			String reportPath = new File(baseDirPath + report_name).getAbsolutePath();
			System.out.println("reportPath "+reportPath );
			report = new ExtentReports(reportPath);			
				
		}
		return report;	
	}
	
	
	
}
