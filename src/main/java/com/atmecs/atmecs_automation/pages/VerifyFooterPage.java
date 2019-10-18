package com.atmecs.atmecs_automation.pages;

import java.sql.SQLException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.atmecs.atmecs_automation.helper.SeleniumHelper;
import com.atmecs.atmecs_automation.helper.ValidaterHelper;
import com.atmecs.atmecs_automation.logreports.LogReporter;
import com.atmecs.atmecs_automation.utils.DatabaseReader;

public class VerifyFooterPage {
  SeleniumHelper help=new SeleniumHelper();
  LogReporter log=new LogReporter();
  DatabaseReader read=new DatabaseReader();
  ValidaterHelper validate=new ValidaterHelper();
	public void verifyPageFooter(WebDriver driver,Properties prop) throws SQLException, ClassNotFoundException {
		verifyEachFooter(driver, prop.getProperty("loc.container.footer"), prop.getProperty("loc.menu.aboutus"));
		log.logReportMessage("Step 5: Step 2");
		verifyEachFooter(driver, prop.getProperty("loc.container.footer"), prop.getProperty("loc.menu.services"));
		verifyEachFooter(driver, prop.getProperty("loc.container.footer"), prop.getProperty("loc.menu.partners"));
		verifyEachFooter(driver, prop.getProperty("loc.container.footer"), prop.getProperty("loc.menu.insights"));
		verifyEachFooter(driver, prop.getProperty("loc.container.footer"), prop.getProperty("loc.menu.careers"));
		verifyEachFooter(driver, prop.getProperty("loc.container.footer"), prop.getProperty("loc.menu.contactus"));
		
	}
	public void verifyEachFooter(WebDriver driver,String locator,String locator1) throws ClassNotFoundException, SQLException {
		log.logReportMessage("Step 2:loop Start> go to the footer");
		read.dbConnection();
		help.scrollPage(driver);
		log.logReportMessage("Step 3: validate footer ");
		String text=validate.textOfElement(driver, locator);
		String[] footerarray=text.split("\n");
		String[] testdata=read.insertQuery(footerarray.length,"footer1");
		for(int count=0; count<footerarray.length; count++) {
			validate.assertValidater(footerarray[count], testdata[count]);
		}
		log.logReportMessage("Step 4: loopEnd move to next page");
		help.mouseOver(locator1, driver);
		help.clickElement(driver, locator1);
	}
}
