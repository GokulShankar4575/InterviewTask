package runner;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import openMRsElements.OpenMRElements;
import util.Base;

public class TestRun extends Base {

	public static WebDriverWait wait;
	public static OpenMRElements e;

	@BeforeClass
	public void bfrClas() {
		launch();
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		e = new OpenMRElements();
	}

	@AfterClass
	public void aftCls() throws InterruptedException {
		// browserClose();
	}

	@Test
	public void tc1() {
		try {

			// Step 1: Navigate to the OpenMRS login page
			driver.get("https://qa-refapp.openmrs.org/openmrs/login.htm");

			// Step 2 :Find and enter the username and password
			sendData(e.getUsernameInput(), "Admin");
			sendData(e.getPasswordInput(), "Admin123");

			// Step 3: Pick any location below and click on Login
			// Wait for the page to load and choose a location (e.g., Demo Ward 1)
			WebElement locationDropdown = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='Outpatient Clinic']")));
			locationDropdown.click();

			// Find and click the login button
			clcikElement(e.getLoginButton());

			// Step 4:Verify dashboard page redirection using assertion
			WebElement dashboardHeader = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(text(),'Outpatient')]")));
			Assert.assertTrue(dashboardHeader.isDisplayed(), "Dashboard page not displayed.");

			// Step 5:Click on the "Register a Patient" menu
			clcikElement(e.getRegisterPatientMenu());

			// Step 6: Enter patient details (Name, Gender, Birthdate, Address, Phone
			// Number)

			sendData(e.getGivenNameInput(), "John");
			sendData(e.getFamilyNameInput(), "Smith");
			clcikElement(e.getNextButton());
			sendData(e.getGenderfield(), "Male");
			clcikElement(e.getNextButton());

			sendData(e.getBirthdayfield(), "01");
			selectDDNText(e.getBirthmonthfield(), "January");
			sendData(e.getBirthyearfield(), "1990");
			clcikElement(e.getNextButton());

			sendData(e.getAddress1(), "123 Main St");
			clcikElement(e.getNextButton());

			sendData(e.getPhoneNumber(), "1234567890");
			clcikElement(e.getNextButton());

			// Step 8: Click on Confirm
			clcikElement(e.getNextButton());
			e.getConfirmButton().click();

			// Step 9: Click on Start Visit and Confirm
			WebElement startVisitButton = wait.until(ExpectedConditions.elementToBeClickable(e.getStartVisit()));
			startVisitButton.click();

			WebElement confirmVisitButton = wait
					.until(ExpectedConditions.elementToBeClickable(e.getVistConfirmButton()));
			confirmVisitButton.click();

			// Step 10: Click on Attachment and upload
			clcikElement(e.getAttachmentButton());

			// Implement the file upload process here
			driver.findElement(By.id("visit-documents-dropzone")).click();
			fileUploadRobot(
					"C:\\Users\\ibu95\\eclipse-workspace2\\InterviewTask\\Release of Patient Medical Report.pdf");
			sendData(e.getCaption(), "Test");
			WebElement uploadButton = wait.until(ExpectedConditions.elementToBeClickable(e.getUploadbutton()));
			uploadButton.click();

			// Step 11: Verify toaster message
			WebElement toasterMessage = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//div[@*='toast-item toast-type-success']//p")));
			String messageText = toasterMessage.getText();
			if (messageText.contains("successfully uploaded")) {
				System.out.println("Toaster message for successful attachment appeared.");
			} else {
				System.out.println("Toaster message for successful attachment not found.");
			}

			// Step 12: Redirect to Patient details screen
			clcikElement(e.getPageHome());

			// Step 13: Verify Attachment section has attachment
			WebElement attachmentSection = driver.findElement(By.xpath("//i[@class='icon-file-pdf-o']"));
			if (attachmentSection.isDisplayed()) {
				System.out.println("Attachment section contains attachments.");
			} else {
				System.out.println("Attachment section does not contain attachments.");
			}

			// Step 14: Verify Recent Visit has one entry
			WebElement recentVisitEntry = driver.findElement(By.xpath("//li[@class='ng-scope']//div"));
			if (recentVisitEntry.getText().contains("Attachment Upload")) {
				System.out.println("Recent Visit has one entry for current date with Attachment Upload tag.");
			} else {
				System.out.println("Recent Visit does not have the expected entry.");
			}

			// Step 15: Click on the End Visit action at RHS
			WebElement endVisitButton = wait.until(ExpectedConditions.elementToBeClickable(e.getEndVistbutton()));
			endVisitButton.click();
			clcikElement(e.getEndVisitConfirmButton());

			// Step 16: Start Visit again and Click on Capture Vitals menu

			WebElement startVisitButton1 = wait.until(ExpectedConditions.elementToBeClickable(e.getStartVisit()));
			startVisitButton1.click();

			WebElement confirmVisitButton1 = wait
					.until(ExpectedConditions.elementToBeClickable(e.getVistConfirmButton()));
			confirmVisitButton1.click();

			clcikElement(e.getCaptureVitalsButton());

			// Step 17: Enter Height & Weight and Verify BMI
			sendData(e.getHeightInput(), "175");
			clcikElement(e.getNextButton());

			sendData(e.getWeightInput(), "70");
			clcikElement(e.getNextButton());

			String displayedBMI = e.getBmiDisplay().getText();
			double calculatedBMI = (70 / ((175 * 0.01) * (175 * 0.01))); // BMI formula
			if (displayedBMI.equals(String.format("%.2f", calculatedBMI))) {
				System.out.println("BMI is calculated correctly.");
			} else {
				System.out.println("BMI calculation is incorrect.");
			}

			// Step 18: Click on Save Form and Save button
			clcikElement(e.getSaveFormButton());
			clcikElement(e.getSaveButton());

			// Step 19: Click on End Visit and redirect to Patient details page
			WebElement endVisitButton1 = wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='button task activelist'])[1]")));
			endVisitButton1.click();
			clcikElement(e.getEndVisitConfirmButton());

			driver.navigate().refresh();
			robotTab(5);
			robotEnter(1);

			// Task 20: Verify Height, Weight, and BMI
			WebElement heightElement = driver.findElement(By.xpath("//span[@id='height']//span[@class='value']"));
			WebElement weightElement = driver.findElement(By.xpath("//span[@id='weight']//span[@class='value']"));
			WebElement bmiElement = driver.findElement(By.xpath("//span[@id='calculated-bmi']"));

			String expectedHeight = "170";
			String expectedWeight = "70";
			String expectedBMI = "22.9";

			if (heightElement.getText().equals(expectedHeight) && weightElement.getText().equals(expectedWeight)
					&& bmiElement.getText().equals(expectedBMI)) {
				System.out.println("Height, Weight, and BMI are displayed correctly.");
			} else {
				System.out.println("Height, Weight, or BMI are displayed correctly.");
			}

			// Task 21: Verify Recent Visit entry
			WebElement recentVisitEntry1 = driver
					.findElement(By.xpath("//li[@class='ng-scope']//div[text()='Vitals']"));
			String expectedVisitTag = "Vitals";
			if (recentVisitEntry1.getText().contains(expectedVisitTag)) {
				System.out.println("Recent Visit has a new entry with Vitals tag.");
			} else {
				System.out.println("Recent Visit does not have a new entry with Vitals tag.");
			}

			// // Task 22: Merge Visits
			clcikElement(e.getMergeButton());

			// Select visits and click Merge Selected Visits button
			List<WebElement> visits = e.getActivevisits().findElements(By.cssSelector("input"));
			for (WebElement w : visits) {
				w.click();
			}

			WebElement mergeVisitsBtn = wait.until(ExpectedConditions.elementToBeClickable(e.getMergeVisitsBtn()));
			mergeVisitsBtn.click();

			// Task 23: Redirect to patient details page
			clcikElement(e.getReturnButton());

			// // Task 24: Verify Recent Visit entry after merge
			WebElement recentVisitMerge = driver
					.findElement(By.xpath("//li[@class='ng-scope']//div[contains(text(),'Vitals, Attachment')]"));
			Assert.assertTrue(recentVisitMerge.getText().contains("Vitals, Attachment"));

			// // Task 25: Verify future date is not clickable in the date picker

			clcikElement(e.getAddPastVisit());

			List<WebElement> dates = e.getDates();
			// Get the current date
			LocalDate currentDate = LocalDate.now();
			try {
				for (WebElement dateOption : dates) {
					String dateText = dateOption.getText();
					LocalDate date = LocalDate.parse(dateText);
					if (date.isAfter(currentDate)) {
						if (!dateOption.isEnabled()) {
							System.out.println("Date " + dateText + " is not clickable (as expected).");
						} else {
							System.out.println("Date " + dateText + " is clickable (unexpected).");
						}
					}
				}
			} catch (Exception e) {

			}
			// Task 26: Redirect to patient details page
			clcikElement(e.getDateCancelButton());

			// Task 27: Click on Delete Patient
			String patID = e.getPatientId().getText();
			clcikElement(e.getDeletepatient());

			// Task 28: Provide reason and confirm
			sendData(e.getReasonInput(), "Test Reason");
			clcikElement(e.getDeleteConfirmButton());

			// Task 29: Verify the toaster message and patient deletion
			sendData(e.getPatientSearch(), patID);
			WebElement until = wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath("//div[@*='patient-search-results-table_wrapper']//*[text()='No matching records found']")));
			Assert.assertTrue(until.isDisplayed());

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Check the code ");
		}
	}
}
