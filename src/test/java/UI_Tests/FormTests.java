package UI_Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FormTests extends BaseClassUI {

    @Test
    public void test_form_page() {
        var FormPage = Resultspage.clickOnWeiter();
        String cookie = dataparser.getPropertyValue("cookie");
        //cookie assertion
        Assert.assertEquals(Resultspage.getCookie(cookie.split(":")[0]), cookie.split(":")[1], "Error cookie not found");
        FormPage.typeText(FormPage.email_input, dataparser.getPropertyValue("test_email"));
        FormPage.clickonElement(FormPage.btn_weiter);
        FormPage.clickonElement(FormPage.btn_ContinueAsGuest);
        FormPage.clickonElement(FormPage.btn_weiter_new_user);
        //assertion on salutaion error msg
        Assert.assertTrue(FormPage.checkTextMsgExist(FormPage.salution_error_msg));
        //assertion on firstname error msg
        Assert.assertTrue(FormPage.checkTextMsgExist(FormPage.firstname_error_msg));
        //assertion on lastname error msg
        Assert.assertTrue(FormPage.checkTextMsgExist(FormPage.lastname_error_msg));
        //assertion on birthdate error msg
        Assert.assertTrue(FormPage.checkTextMsgExist(FormPage.birthdate_error_msg));
        //assertion on mobilenumber error msg
        Assert.assertTrue(FormPage.checkTextMsgExist(FormPage.mobilenumber_error_msg));
        //fill in the form and click on continue
        FormPage.clickonElement(FormPage.herr_radiobtn);
        FormPage.typeText(FormPage.firstname_input, dataparser.getPropertyValue("First_name"));
        FormPage.typeText(FormPage.lastname_input, dataparser.getPropertyValue("last_name"));
        FormPage.typeText(FormPage.birthdate_input, dataparser.getPropertyValue("birthdate"));
        FormPage.typeText(FormPage.mobilenumber_input, dataparser.getPropertyValue("mobilenumber"));
        FormPage.clickonElement(FormPage.btn_weier_afterfillingform);
        //Assert on header text message from other personal info page
        Assert.assertTrue(FormPage.checkTextMsgExist(FormPage.other_personal_info_header));

    }
}
