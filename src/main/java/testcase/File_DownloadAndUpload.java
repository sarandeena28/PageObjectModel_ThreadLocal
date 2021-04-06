package testcase;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseClass.ProjectSpecificMethods;
import pages.LoginPage;

public class File_DownloadAndUpload extends ProjectSpecificMethods{
	
	@BeforeTest
	public void provideTestDetail() {
		testcaseName="FileUpload & Download";
		testCaseInfo="File uploading and downloading in positive flow";
		testCaseCategory="Functional";
		testcaseAuthor="Saranya";
		sheetName="File";
	}
	@Test(dataProvider="fetchData")
	public void file_DownloadAndUpload(String Username,String Password) throws InterruptedException, AWTException, IOException {
		new LoginPage(driver)
		.enterUsernam(Username)
		.enterPassword(Password)
		.clickLoginButton()
		.clickToggle()
		.clickViewAll()
		.click_ServiceConsole()
		.click_dropdown()
		.click_FilefromDropdown()
		.click_FirstFile()
		.click_PublicLink()
		.check_Link()
		.publicLinkSharing_CopyLink()
		.check_TextFieldIsDisabled()
		.close_PublicLinkSharingPopUp()
		.click_Download()
		.click_Share()
		.click_SearchUser()
		.verify_ErrorMsgNotToShare()
		.click_CloseWindow()
		.click_CloseFileOpenedPage()
		.click_UploadFiles()
		.click_Done()
		.Click_DropdownFile()
		.click_ViewFileDetails()
		.verifyFileName()
		.verifyFileExtension()
		.closeFileDetailTab()
		.Click_DropdownFile()
		.click_Delete()
		.click_DeleteConfirm()
		.confirm_DeleteMessage();
	}
}
