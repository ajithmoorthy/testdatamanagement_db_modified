package com.atmecs.atmecs_automation.testscripts;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.atmecs.atmecs_automation.constants.FileConstants;
import com.atmecs.atmecs_automation.helper.SeleniumHelper;
import com.atmecs.atmecs_automation.helper.ValidaterHelper;
import com.atmecs.atmecs_automation.logreports.LogReporter;
import com.atmecs.atmecs_automation.pages.VerifyFooterPage;
import com.atmecs.atmecs_automation.testbase.TestBase;
import com.atmecs.atmecs_automation.utils.DatabaseReader;
import com.atmecs.atmecs_automation.utils.PropertiesReader;

public class TestVerifyFooter extends TestBase {
	LogReporter log=new LogReporter();
	SeleniumHelper help=new SeleniumHelper();
	ValidaterHelper validate=new ValidaterHelper();
	DatabaseReader read=new DatabaseReader();
	PropertiesReader propread=new PropertiesReader();
	VerifyFooterPage verify=new VerifyFooterPage();
	@Test
	public void veifyFooterData() throws IOException, SQLException, ClassNotFoundException, InterruptedException {
		Properties prop=propread.KeyValueLoader(FileConstants.LOCATOR);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		logger=extentObject.startTest("verify footer");
		read.dbConnection();
		verify.verifyPageFooter(driver, prop);
		log.logReportMessage("Step 6: mouse over the services menu");
		help.mouseOver(prop.getProperty("loc.menu.services"), driver);
		log.logReportMessage("Step 7: move to digital sub menu");
		help.mouseOver(prop.getProperty("loc.menu.digitals"), driver);
		log.logReportMessage("Step 8: validate the submenu of digital");
		String[] testdata=read.insertQuery(5, "digital");
		validate.webElementsValidater(driver, prop.getProperty("loc.menu.digitallist"),testdata);
		log.logReportMessage("Step 9: move to the infrastructure  sub menu");
		help.mouseOver(prop.getProperty("loc.menu.infrastructure"), driver);
		log.logReportMessage("Step 10: validate the sub menu of infrastructure");
		String[] testdata1=read.insertQuery(5, "infrasstruct");
		validate.webElementsValidater(driver, prop.getProperty("loc.menu.infraslist"),testdata1);
	}

}
