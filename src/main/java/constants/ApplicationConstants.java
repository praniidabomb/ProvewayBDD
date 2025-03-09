package constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

public class ApplicationConstants {

public static WebDriver driver;
    public static WebDriverWait wait;

    public static Map<Long, WebDriver> driverMap = new HashMap<Long, WebDriver>();
    public static Map<String, String> globalDataMap = new HashMap<String, String>();
    public static final String login_ADMIN_Email = "praneeth.chukarapu+co@mtxb2b.com";
    public static final String login_URL="https://accounts.shopify.com/login?rid=36edf279-ed3e-4f6f-8e82-d74d4312141a";
    public static final String SF_PASSWD="Mtx@123456";
    //    public static final String SF_PASSWD="MTX@12345";
    public static final String Portal_URL="https://dbrri--qa.sandbox.my.site.com/ricannabis/";
    public static final boolean IS_EXECUTION_ON_JENKINS=true;
    public static final String AUTH_END_POINT = "https://mtxwadoh--mtxwaqa.sandbox.my.salesforce.com//services/Soap/u/50.0";
    public static  String PARENTWINDOWID = "";
    public static String CURRENT_TIME_STAMP = "";
    public static boolean IS_SALESFORCE_LOGIN = true;
    public static String PORTAL = "";
    public static String Registered_Portal_Username = "raashi.kuna+3@mtxb2b.com.cannabis";
    public static String Registered_Portal_Password = "Kunaraashi@123";

}
