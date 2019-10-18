package com.atmecs.atmecs_automation.testscripts;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.atmecs.atmecs_automation.constants.FileConstants;
import com.atmecs.atmecs_automation.helper.SeleniumHelper;
import com.atmecs.atmecs_automation.logreports.LogReporter;
import com.atmecs.atmecs_automation.utils.DatabaseReader;
import com.atmecs.atmecs_automation.utils.PropertiesReader;

public class TestVerifyBlogs {
	LogReporter log = new LogReporter();
	SeleniumHelper help = new SeleniumHelper();
	DatabaseReader read = new DatabaseReader();
	PropertiesReader propread = new PropertiesReader();

	@Test
	public void verifyBlogsAndComments() throws IOException, ClassNotFoundException, SQLException {
		Properties prop = propread.KeyValueLoader(FileConstants.LOCATOR);
		log.logReportMessage("Step 2: mouse over the Insights menu");
		//help.mouseOver(prop., driver);
		read.dbConnection();
		//read.insertQuery(33);
		log.logReportMessage("Step 3: click the blogs sub menu");
		log.logReportMessage("Step 4: validate the blog is older the 3 months");
		log.logReportMessage("Step 5: if is older then click any one");
		log.logReportMessage("Step 6: validate the bread crumb ,blog title and date");
		log.logReportMessage("Step 7: validate the content");
		log.logReportMessage("Step 8: validate the post comment");
	}

}
