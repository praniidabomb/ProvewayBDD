package page.objects;
import constants.ApplicationConstants;
import org.openqa.selenium.By;

public class GenericActionsObjects {


    public static By USERNAME = By.xpath("//input[@name='username']");
    public static By PASSWORD = By.xpath("//input[@name='password'] | //input[@name='pw']");
    public static By LOGIN_BUTTON = By.xpath("//*[@name='Submit']");
    public static By SALESFORCE_LOGIN_BUTTON = By.xpath("//*[@name='Login']");
    public static By APP_LAUNCHER_ICON_HOME_PAGE = By.xpath("(//div[@class='slds-icon-waffle'])[last()]");
    public static By VIEW_ALL_BUTTON = By.xpath("//button[text()='View All']");
    public static By SEARCH_APPS_OR_ITEMS_BOX = By.xpath(".//input[contains(@placeholder,'Search apps or items...')]");

    public static By BUTTON(String button) {
        By btn=By.xpath("(//span[contains(text(),'"+button+"')] | //button//*[text()='"+button+"'])[last()] | (//button[text()='"+button+"'])[last()] | //button[contains(@aria-label,'"+button+"')]");
        return btn;
    }
    public static By CONTINUE_BUTTON(String button) {
        By btn=By.xpath("//form[@id='account_lookup']//button[@type = 'submit']");
        return btn;
    }
    public static By ICON(String credentialName,String iconName) {
        By btn=By.xpath("//*[text()='"+credentialName+"']//following::*[@aria-label='"+iconName+"']");
        return btn;
    }
    public static By FillDropdownXpath(String fieldName)
    {
        By xpath=By.xpath("//label//*[text()='" +fieldName+ "']/../..//following-sibling::div//input/.. | //label[text()='" +fieldName+ "']/../following-sibling::td//select | //label[contains(text(),'" + fieldName + "')]//following-sibling::div//descendant::button | //span[contains(text(),'" + fieldName + "')]/..//following-sibling::div//descendant::a");
        return xpath;
    }
    public static By text(String txt) {
        By textXpath;
        if(txt.equalsIgnoreCase("After you submit your application, you'll be able to print the Supervisor’s Statement."))
        {
            textXpath = By.xpath("//*[text()=\"" + txt + "\"] | //*[contains(text(),\""+txt+"\")]");
        }
        else
        {
            textXpath = By.xpath("//*[text()='"+txt+"'] | //*[contains(@aria-label,'"+txt+"')] | //*[text()=\"" + txt + "\"] | //*[contains(text(),\""+txt+"\")]");
        }
        return textXpath;
    }

    public static By textHavingBreaks(String txt) {
        By xpath ;
        if(txt.equalsIgnoreCase("You must have no disciplinary history in any state or any \"Yes\" answers to the Personal Data Questions and you must be applying for a full license. The temporary permit is intended for you to be able to begin work while waiting for issuance of your full license."))
        {
             xpath = By.xpath("//*[contains(text(),'"+txt+"')]");
        }
        else
        {
            xpath = By.xpath("//*[contains(text(),\""+txt+"\")]");
        }

        return xpath;
    }

    public static By phoneFieldInput(String field)
    {
        By xpath=By.xpath("//vlocity_ins-omniscript-telephone//*[text()='"+field+"']/..//following-sibling::div//input");
        return xpath;
    }

    public static By locatorLink(String link) {
        By linkLocator = By.xpath("//a[contains(text(),'" + link + "')] | //a//*[text()='" + link + "'] | //*[text()='Add']");
        return linkLocator;
    }

    public static By locatorSection(String section) {
        By sectionLocator = By.xpath("//span[contains(text(),'" + section + "')]");
        return sectionLocator;
    }

    public static By getActualPicklistValues(String field) {
        By values = By.xpath("//label[contains(text(),'" + field + "')]/following-sibling::select/option");
        return values;
    }

    public static By verifyPicklistValuesPortal(String field) {
        By values = By.xpath("//mat-option//*[contains(text(),'" + field + "')]");
        return values;
    }

    public static By picklistField(String field) {
        By values = By.xpath("//label[contains(text(),'" + field + "')]/following-sibling::select");
        return values;
    }

    public static By clickButton(String record, String button) {
        By btn = By.xpath("//*[normalize-space()='" + record + "']/parent::tr//following-sibling::td//button//div" +
                "[normalize-space()='" + button + "']");
        return btn;
    }

    public static By tableHeader(String table_Header)
    {
        By label;
        label=By.xpath("(//th//span[text()=\""+table_Header+"\"])[last()] | //th[normalize-space(text())=\""+table_Header+"\"] | //th//div[text()=\""+table_Header+"\"]");
        return label;
    }

    public static By Button(String btn){
        if (btn.equalsIgnoreCase("Renew")) {
            String issuanceId = ApplicationConstants.globalDataMap.get("IssuanceID");
            By button = By.xpath("//a[text()='"+issuanceId+"']/..//following::td[6]//a[text()='"+btn+"']");
//            By xpath = By.xpath("//a[text()='LCD0024']/..//following::td[6]//a[text()='"+fieldName+"']");
            return button;
        }else{
            By button;
            button = By.xpath("//button[text()='" + btn + "']|//button//*[contains(text(),'" + btn + "')] | //*[normalize-space(text())='" + btn + "'] | //button//span[normalize-space(text())='" + btn + "']");
            return button;
        }
    }

    public static By radioButtonLabel(String radioButton)
    {
        By label;
        label=By.xpath("//*[@class='slds-radio__label']//span[text()='"+radioButton+"']");
        return label;
    }

    public static By filterLabel(String filter)
    {
        By label;
        label=By.xpath("//input[@placeholder='"+filter+"']");
        return label;
    }
    public static By linkLabel(String link){
        By label;
        label=By.xpath("//p[normalize-space(text())='"+link+"']|//a[normalize-space(text())='"+link+"'] | //a[text()='"+link+"']"
                + " | //a//div[normalize-space(text())='"+link+"'] | //li[normalize-space(text())='"+link+"'] | //a//span[normalize-space(text())='"+link+"']");
        return label;
    }

    public static By alert(String alert){
        By label;
        label=By.xpath("//div[contains(@class,'alert')]/small[text()='"+alert+"']");
        return label;
    }

    public static By NavBarTabs(String link) {
        By label;
        label = By.xpath("//ul[contains(@class,'Navi') or contains(@class,'NavBar')]//li[normalize-space()=" + GenericActionsObjects.fixtext(link) + "]");
        return label;
    }

    public static By ObjectPageWithListView(String link) {
        By label;
        label = By.xpath("//div[contains(@aria-label," + GenericActionsObjects.fixtext(link) + ")] | //*[contains(@class,'entityNameTitle') and normalize-space(text()) = '" + link + "'] | //img[@title = '" + link + "']");
        return label;
    }
    public static By ListViewName(String link) {
        By label;
        label = By.xpath("//ul[@role='listbox']//li//span[contains(normalize-space()," + GenericActionsObjects.fixtext(link) + ")]");
        return label;
    }

    public static By subHeaderLabel(String sub_header)
    {
        By label;
        label=By.xpath("//h2[normalize-space(text())='"+sub_header+"'] | //div[normalize-space(text())='"+sub_header+"']|"
                + "//div//p[normalize-space(text())='"+sub_header+"']|//p[normalize-space(text())='"+sub_header+"']|"
                + "//h3[normalize-space(text())='"+sub_header+"'] | //h4[normalize-space(text())='"+sub_header+"'] | "
                + "//h3//span[normalize-space(text())='"+sub_header+"'] | //h3[text()='"+sub_header+"']");

        return label;
    }

    public static By SectionLabel(String Section) {
        By label;
        label = By.xpath("//h1[normalize-space(text())='" + Section + "']" + " | //h2[normalize-space(text())='"
                + Section + "'] ");
        return label;
    }
    public static By subSectionLabel(String sub_Section)
    {
        By label;
        label=By.xpath("//h4[normalize-space(text())='"+sub_Section+"']"
                + " | //h5[normalize-space(text())='"+sub_Section+"'] ");
        return label;
    }

    public static By tableDataName(String tableData)
    {
        By data;
        data=By.xpath("//td//*[contains(text(),'"+tableData+"')]");
        return data;
    }

    public static By activeLink(String actLink)
    {
        By label = By.xpath("//div[@class='nav-items active']//a[normalize-space(text())='"+actLink+"'] | //a[@class='active']//div[normalize-space(text())='"+actLink+"']");
        return label;
    }

    public static By headerLabel(String header)
    {
        By label;
        label=By.xpath("//h1[normalize-space(text())='"+header+"'] | //h1//span[normalize-space(text())='"+header+"'] | //div[normalize-space(text())='"+header+"']"
                + " | //h2//span[normalize-space(text())='"+header+"']");
        return label;
    }


    public static By cardHeader(String cardHeader){
        By label;
        label=By.xpath("//a[@class='mvpLpActions_card']//h4[text()='"+cardHeader+"'] | //a[@class='mvpLpActions_card']//div[text()='"+cardHeader+"']");
        return label;
    }
    public static By cardDesc(String cardDesc){
        By label;
        label=By.xpath("//a[@class='mvpLpActions_card']//p[text()='"+cardDesc+"']");
        return label;
    }

    public static By read_Only(String field)
    {
        By label;
        label=By.xpath("//*[@class='slds-form-element__label slds-no-flex' and contains(text(),'"+field+"')]//following-sibling::div//input[@disabled] | //div[@class='read-only-data']//div[text()='"+field+"']" +
                "| //label[text()='"+field+"']//following-sibling::div//input[@readonly] | //span[text()="+GenericActionsObjects.fixtext(field)+"]/../following-sibling::*//*[contains(@class,'read-only') or @readonly] | //span[text()="+GenericActionsObjects.fixtext(field)+"]/../../self::*[contains(@class,'readonly') or @readonly]");
        return label;
    }


    public static By appLinkAppLauncher(String appName) {
        String xpath;

        if (appName.equalsIgnoreCase("WA DOH HELMS")) {
            xpath = "(//div[@data-name='" + appName + "']//mark[text()='" + appName + "'])[2] | (//mark[text()='" + appName + "'])[2]";
        } else {
            xpath = "//div[@data-name='" + appName + "']//mark[text()='" + appName + "'] | //mark[text()='" + appName + "']";
        }
        By appLink = By.xpath(xpath);
        return appLink;
    }

    public static By objectLinkAppLauncher(String appName) {
        By appLink = By.xpath("//mark[text()='" + appName + "']");
        return appLink;
    }
    public static By action_Btn(String offerName, String actionName) {
        By actionElement = By.xpath("//span[text() = '"+offerName+"']/parent::span/parent::td/parent::tr//div[@class = '"+actionName+"-btn']");
        return actionElement;
    }
    public static By hyperLink(String link)
    {
        By xpath=By.xpath("//a[text()='" + link+ "'] | //a//*[text()='" + link + "'] | //span[text()='" + link + "'] | //a//span[contains(text(),'" + link +"')]");
        return xpath;
    }
    public static By hyperLinkContains(String link)
    {
        By xpath=By.xpath("//a[contains(text(),'" + link+ "')] | //a//*[contains(text(),'" + link + "')]");
        return xpath;
    }


    public static By locatorLabel(String name) {
        By label = By.xpath("//*[text()=\"" + name + "\"] | //*[normalize-space(text())='À quelle race vous identifiez-vous${nbsp}?'] ");
        return label;
    }

    public static By Lightning_TAB(String tabName) {
        By tab = By.xpath("(//*[text()='" + tabName + "'])//parent::a");
        return tab;
    }

    public static By fieldLabel(String fieldName) {
        if (fieldName.equalsIgnoreCase("Renew")) {
            String issuanceId = ApplicationConstants.globalDataMap.get("IssuanceID");
            By xpath = By.xpath("//a[text()='"+issuanceId+"']/..//following::td[6]//a[text()='"+fieldName+"']");
//            By xpath = By.xpath("//a[text()='LCD0024']/..//following::td[6]//a[text()='"+fieldName+"']");
            return xpath;
        } else {
            By xpath = By.xpath("//*[text()='" + fieldName + "']");
            return xpath;
        }
    }

    public static By textFieldXpath(String textFieldName)
    {
        By xpath=By.xpath("//label[text()=\""+textFieldName+"\"]//..//following-sibling::td//input |//*[text()=\"" +textFieldName+ "\"]/../..//following-sibling::div//input | //label[text()=\"" +textFieldName+ "\"]//ancestor::div//textarea");
        return xpath;
    }
    public static By textxpath(String textFieldName)
    {
        By xpath=By.xpath("(//span[text()=\""+textFieldName+"\"])[2]//following::input");
        return xpath;
    }
    public static By NumberFieldXpath(String textFieldName)
    {
        By xpath=By.xpath("//label[text()=\""+textFieldName+"\"]//..//following-sibling::td//input |//*[text()=\"" +textFieldName+ "\"]/../..//following-sibling::div//input");
        return xpath;
    }

    public static By dateFieldXpath(String dateFieldName)
    {
        By xpath=By.xpath("//input[@aria-label='" + dateFieldName + "']");
        return xpath;
    }
    public static By requiredTheFields(String fieldName, String fieldType)
    {
        By xpath=By.xpath("(//*[text()='"+fieldType+"']//following::*[text()=\""+fieldName+"\"]//preceding-sibling::abbr[text()='*'])[1] | //*[text()=\""+fieldType+"\"]//following::*[contains(text(),\""+fieldName+"\")]//preceding::abbr[text()='*'][1]");
        return xpath;
    }
//    public static By requiredFields(String fieldName)
//    {
//        By xpath=By.xpath("//span[contains(text(),\""+fieldName+"\")]");
//        return xpath;
//    }

    public static By textFieldInSection(String textField,String sectionName) {

        if(textField.equalsIgnoreCase("MailingState"))
        {
            textField="MailingOtherState";
        }
        else
        {
            textField = textField.replace(" ","");
        }
        return By.xpath("//*[text()='"+sectionName+"']//ancestor::div//vlocity_ins-omniscript-text[@data-omni-key='"+textField+"'] |" +
                "//*[text()='"+sectionName+"']//ancestor::div//vlocity_ins-omniscript-text//*[text()='"+textField+"'] ");
    }

    public static By dropdownFieldInSection(String dropdownField,String sectionName)
    {
        dropdownField=dropdownField.replace(" ","");
        By dropdownXpath = By.xpath("//*[text()='"+sectionName+"']//ancestor::div//vlocity_ins-omniscript-select[@data-omni-key='"+dropdownField+"']");
        return dropdownXpath;
    }
    public static By phoneFieldInSection(String phone,String section)
    {
        By phoneXpath = By.xpath("//*[text()='"+section+"']//ancestor::div//*[text()='"+phone+"']");
        return phoneXpath;
    }
    public static By emailFieldInSection(String email,String section)
    {
        By emailXpath = By.xpath("//*[text()='"+section+"']//ancestor::div//*[text()='"+email+"']");
        return emailXpath;
    }
    public static By radioButtonFieldInSection(String text,String section)
    {
        By emailXpath = By.xpath("//*[text()='"+section+"']//following::div//*[text()='"+text+"']");
        return emailXpath;
    }
    public static By fillTextFieldOfSection(String fieldName,String section)
    {


        By xpath = null;
        if(fieldName.equalsIgnoreCase("Zip Code") | fieldName.equalsIgnoreCase("Zip Code Canada"))
        {
            fieldName=fieldName.replace(" ","");
            xpath=By.xpath("//*[text()='" + section + "']//ancestor::div//*[@data-omni-key='" + fieldName + "']//ancestor::label/..//following-sibling::div//input");
        }
        else {
            xpath = By.xpath("//*[text()='" + section + "']//ancestor::div//*[@data-omni-key='" + fieldName + "']//ancestor::label/..//following-sibling::div//input" +
                    "| //*[text()='" + section + "']//following-sibling::div//vlocity_ins-omniscript-text//*[text()='" + fieldName + "']//ancestor::*[@data-label='true']//following-sibling::div//input");
        }
        return xpath;
    }
    public static By readOnlyField(String fieldName)
    {
//        By xpath=By.xpath("//*[text()='"+fieldName+"']//ancestor::*[@aria-disabled='true']");
        By xpath=By.xpath("//*[text()='"+fieldName+"']//following::*[@aria-invalid='false']");

        return xpath;
    }
    public static By fillDropdownFieldOfSection(String fieldName,String section)
    {
        By xpath=By.xpath( "//*[text()='"+section+"']//ancestor::div//*[@data-omni-key='"+fieldName+"']//ancestor::label/..//following-sibling::div//input" +
                "| //*[text()='"+section+"']//following-sibling::div//vlocity_ins-omniscript-select//*[text()='"+fieldName+"']//ancestor::*[@data-label='true']//following-sibling::div//input");
        return xpath;
    }

    public static By dropdownElement(String picklistValue, String fieldName) {
        By xpath;
        if (fieldName.equalsIgnoreCase("Professions") | fieldName.equalsIgnoreCase("*Driver License State:")) {
            xpath = By.xpath("(//li//*[text()='" + picklistValue + "'])[last()] | (//option[text()='Alabama'])[last()]");
        } else if (fieldName.equalsIgnoreCase("How did you receive this credential?")) {
            xpath = By.xpath("//li//span[contains(text(),'" + picklistValue + "')]");
        } else {
            xpath = By.xpath("(//li//*[contains(text(),'" + picklistValue + "')])[last()] | //option[text()='" + picklistValue + "']");
        }
        return xpath;
    }


    public static By textarea(String fieldName)
    {
        By xpath=By.xpath("//*[text()='" +fieldName+ "']//parent::label//ancestor::vlocity_ins-omniscript-textarea[not(contains(@class,'slds-hide'))]//following-sibling::div/textarea");
        return xpath;
    }
    public static By checkBox(String checkBox)
    {
        By xpath=By.xpath( "//*[text()='"+checkBox+"']//preceding-sibling::span | //span[text()='" + checkBox + "']/..//preceding-sibling::input | " +
                "//*[contains(text(),'"+checkBox+"')]//ancestor::*//preceding-sibling::vlocity_ins-omniscript-checkbox//input");
        return xpath;
    }
    public static By checkBoxXpath(String checkBox)
    {
        By xpath;

        xpath = By.xpath("//*[contains(text(),'"+checkBox+"')]//ancestor::*//preceding-sibling::span[@class='slds-checkbox_faux']");

        return xpath;
    }
    public static By radioButton(String fieldName)
    {
        By xpath=By.xpath("//span[contains(text(),'" + fieldName + "')]/..//preceding-sibling::input | //span[text()='" + fieldName + "']/..//preceding-sibling::input " +
                "| //label[text()='"+fieldName+"']//../..//preceding-sibling::td//input");
        return xpath;
    }
    public static By helmsPortalProfile()
    {
        By xpath=By.xpath("//community_user-user-profile-menu[@class='comm-user-profile-menu']//button");
        return xpath;
    }
    public static By header(String headerValue)
    {
        By xpath;
        if(headerValue.equalsIgnoreCase("Applicant's Affidavit and Release Statement"))
        {
            xpath = By.xpath("//h1//*[text()=\"" +headerValue+ "\"] | //h1[text()=\"" +headerValue+ "\"]");
        }
        else
        {
            xpath = By.xpath("//h1//*[text()='" +headerValue+ "'] | //h1[text()='" +headerValue+ "']");
        }
        return xpath;
    }
    public static By selectPickListValueForQuestion(String pickList,String question)
    {
        By xpath=By.xpath("//*[text()='"+question+"']/../..//following-sibling::div//li//*[text()='"+pickList+"']");
        return xpath;
    }
    public static By selectPiclistValue(String picklist)
    {
        By xpath=By.xpath("//li//span[text()='" + picklist + "']/../parent::div" );
        return xpath;
    }

    public static By newPageVerification(String pgName)
    {
        By xpath;
        if(pgName.equalsIgnoreCase("Applicant's Affidavit and Release Statement"))
        {
            xpath=By.xpath("//li//*[text()=\""+pgName+"\"]");
        }
        else
        {
            xpath=By.xpath("//li//*[text()='"+pgName+"']");
        }
        return xpath;
    }
    public static By section(String section_Name)
    {
        By xpath=By.xpath("//*//strong[normalize-space(text())='"+section_Name+"'] | //*//strong[contains(text(),'"+section_Name+"')]");
        return xpath;
    }
    public static By Logout_Link=By.xpath("//a//*[text()='Log Out']");
    public static By feeXpath(String feeType,String feeAmount)
    {
        By xpath=By.xpath("//*[text()='"+feeType+"']//ancestor::div//following-sibling::div//vlocity_ins-output-field//*[text()='"+feeAmount+"']");
        return xpath;
    }
    public static By listItem(String itemInList)
    {
        By xpath=By.xpath("//button//following-sibling::*[text()='"+itemInList+"']");
        return xpath;
    }

    public static By linkOfSection(String link,String Section)
    {
        By xpath=By.xpath("//*[text()='"+Section+"']//ancestor::vlocity_ins-output-field/..//following-sibling::div//span[text()='"+link+"']");
        return xpath;
    }

    public static By checkThePageCheckbox(String pageName)
    {
        By xpath=By.xpath("//*[text()='Qualifications Attestation']//following-sibling::div//vlocity_ins-omniscript-checkbox//label//span");
        return xpath;
    }
    public static By CredentialNumber()
    {
        By xpath=By.xpath("//*[text()='Credential Number']/..//following-sibling::div//div//a");
        return xpath;
    }
    public static By header_with_quotes(String headerValue){
        By xpath= By.xpath("//h1[text()=\"" +headerValue+ "\"]");
        return xpath;
    }

    public static String fixtext(String text) {
        String concat_value = "concat(\"\",\"";
        int n = text.length();

        for (int i = 0; i < n; i++) {
            if (text.charAt(i) == '\"') {
                concat_value += "\",'\"',\"";

            } else if (text.charAt(i) == '\'') {
                concat_value += "\",\"\'\",\"";

            } else {
                concat_value += text.charAt(i);
            }
        }
        concat_value += "\")";

        return concat_value;

    }

    public static String FixDynamicValues(String text) throws Exception
    {
        if(!text.contains("{") && !text.contains("}"))
        {
            return text;
        }
        try{

            String out = "";
            int temp = 0;
            String variable;
            while(temp<text.length())
            {
                text = text.replace("{!", "{");
                if(text.charAt(temp)!='{')
                {
                    out+=text.charAt(temp);
                    temp+=1;
                    continue;
                }
                temp+=1;
                variable = "";
                while(text.charAt(temp)!='}')
                {
                    variable+=text.charAt(temp);
                    temp+=1;
                }
                //    System.out.println(variable + " : " + ApplicationConstants.globalDataMap.get(variable));
                out+= ApplicationConstants.globalDataMap.get(variable);
                temp+=1;
            }
            // System.out.println(out);
            return out;
        }
        catch (Exception E)
        {
            System.out.println("Error : "+E.getMessage()+"\n"+E.getStackTrace());
            // throw new RuntimeException("Invalid formatted text sent to FixDynamicValues");
            return text;
        }
    }

    public static By sectionLink(String fieldName) {
        By xpath = By.xpath("//*[text()='" + fieldName + "']");
        return xpath;
    }

}
