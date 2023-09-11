package openMRsElements;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.Base;

public class OpenMRElements extends Base {

	public OpenMRElements() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username")
	private WebElement usernameInput;

	@FindBy(id = "password")
	private WebElement passwordInput;

	@FindBy(id = "loginButton")
	private WebElement loginButton;

	@FindBy(xpath = "//*[contains(@id,'registerPatient')]")
	private WebElement registerPatientMenu;

	@FindBy(name = "givenName")
	private WebElement givenNameInput;

	@FindBy(name = "familyName")
	private WebElement familyNameInput;

	@FindBy(id = "next-button")
	private WebElement nextButton;

	@FindBy(id = "gender-field")
	private WebElement genderfield;

	@FindBy(id = "birthdateDay-field")
	private WebElement birthdayfield;

	@FindBy(id = "birthdateMonth-field")
	private WebElement birthmonthfield;

	@FindBy(id = "birthdateYear-field")
	private WebElement birthyearfield;

	@FindBy(id = "address1")
	private WebElement address1;

	@FindBy(name = "phoneNumber")
	private WebElement phoneNumber;

	@FindBy(id = "submit")
	private WebElement confirmButton;

	@FindBy(xpath = "//*[@id='org.openmrs.module.coreapps.createVisit']/div/div[2]")
	private WebElement startVisit;

	@FindBy(xpath = "//*[@id='start-visit-with-visittype-confirm']")
	private WebElement vistConfirmButton;

	@FindBy(xpath = "//a[@id='attachments.attachments.visitActions.default']")
	private WebElement attachmentButton;

	@FindBy(xpath = "//textarea[@*='Enter a caption']")
	private WebElement caption;

	@FindBy(xpath = "//button[.='Upload file']")
	private WebElement uploadbutton;

	
	@FindBy(xpath="//*[@id='breadcrumbs']//a[contains(@href,'patient')]")
	private WebElement pageHome;
	

	public WebElement getPageHome() {
		return pageHome;
	}

	@FindBy(xpath = "//ul[@class='float-left d-none d-lg-block']//h3[.='Current Visit Actions']/following::a[1]")
	private WebElement endVistbutton;

	@FindBy(xpath = "//div[@id='end-visit-dialog']//button[.='Yes']")
	private WebElement endVisitConfirmButton;

	@FindBy(xpath = "//a[@id='referenceapplication.realTime.vitals']")
	private WebElement captureVitalsButton;

	@FindBy(id = "w8")
	private WebElement heightInput;

	@FindBy(id = "w10")
	private WebElement weightInput;

	@FindBy(id = "calculated-bmi")
	private WebElement bmiDisplay;

	@FindBy(xpath = "//*[@id='save-form']")
	private WebElement saveFormButton;

	@FindBy(xpath = "//button[@*='submit']")
	private WebElement saveButton;

	@FindBy(xpath = "//ul[@class='float-left']//*[contains(text(),'Merge')]")
	private WebElement mergeButton;

	
	public WebElement getActivevisits() {
		return activevisits;
	}

	@FindBy(id="active-visits")
	private WebElement activevisits;
	
	
	@FindBy(xpath="//input[@id='mergeVisitsBtn']")
	private WebElement mergeVisitsBtn;
	
	@FindBy(xpath="//input[@value='Return']")
	private WebElement returnButton;
	
	
	@FindBy(xpath="//a[@id='org.openmrs.module.coreapps.createRetrospectiveVisit']")
	private WebElement addPastVisit;
	
	
	
	@FindBy(xpath="//div[@*='float-sm-right']//span")
	private WebElement patientId;
	
	@FindBy(xpath="//*[@id=\"org.openmrs.module.coreapps.deletePatient\"]/div/div[2]")
	private WebElement deletepatient;
	
	
	@FindBy(xpath="//*[@id='delete-reason']")
	private WebElement reasonInput;
	
	
	@FindBy(xpath="//*[@id='delete-patient-creation-dialog']//button[.='Confirm']")
	private WebElement deleteConfirmButton;
	
	
	@FindBy(xpath="//input[@id='patient-search']")
	private WebElement patientSearch;
	
	
	
	
	public WebElement getPatientSearch() {
		return patientSearch;
	}

	public WebElement getDeleteConfirmButton() {
		return deleteConfirmButton;
	}

	public WebElement getReasonInput() {
		return reasonInput;
	}

	public WebElement getDeletepatient() {
		return deletepatient;
	}

	public WebElement getPatientId() {
		return patientId;
	}

	public WebElement getAddPastVisit() {
		return addPastVisit;
	}

	@FindBy(xpath="/html/body/div[2]/div[@*='datetimepicker-days']/table/tbody/tr/td")
	private List<WebElement> dates;
	

	@FindBy(xpath="//*[@id='retrospective-visit-creation-dialog']//button[.='Cancel']")
	private WebElement dateCancelButton;
	
	public WebElement getDateCancelButton() {
		return dateCancelButton;
	}

	public List<WebElement> getDates() {
		return dates;
	}

	public WebElement getReturnButton() {
		return returnButton;
	}

	public WebElement getMergeVisitsBtn() {
		return mergeVisitsBtn;
	}

	public WebElement getMergeButton() {
		return mergeButton;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getSaveFormButton() {
		return saveFormButton;
	}

	public WebElement getBmiDisplay() {
		return bmiDisplay;
	}

	public WebElement getWeightInput() {
		return weightInput;
	}

	public WebElement getHeightInput() {
		return heightInput;
	}

	public WebElement getCaptureVitalsButton() {
		return captureVitalsButton;
	}

	public WebElement getEndVisitConfirmButton() {
		return endVisitConfirmButton;
	}

	public WebElement getEndVistbutton() {
		return endVistbutton;
	}

	public WebElement getUploadbutton() {
		return uploadbutton;
	}

	public WebElement getCaption() {
		return caption;
	}

	public WebElement getAttachmentButton() {
		return attachmentButton;
	}

	public WebElement getVistConfirmButton() {
		return vistConfirmButton;
	}

	public WebElement getStartVisit() {
		return startVisit;
	}

	public WebElement getConfirmButton() {
		return confirmButton;
	}

	public WebElement getPhoneNumber() {
		return phoneNumber;
	}

	public WebElement getAddress1() {
		return address1;
	}

	public WebElement getBirthyearfield() {
		return birthyearfield;
	}

	public WebElement getBirthmonthfield() {
		return birthmonthfield;
	}

	public WebElement getBirthdayfield() {
		return birthdayfield;
	}

	public WebElement getGenderfield() {
		return genderfield;
	}

	public WebElement getNextButton() {
		return nextButton;
	}

	public WebElement getFamilyNameInput() {
		return familyNameInput;
	}

	public WebElement getGivenNameInput() {
		return givenNameInput;
	}

	public WebElement getRegisterPatientMenu() {
		return registerPatientMenu;
	}

	public WebElement getUsernameInput() {
		return usernameInput;
	}

	public WebElement getPasswordInput() {
		return passwordInput;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

}
