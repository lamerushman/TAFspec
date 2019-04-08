package techery.uitests.appspector.tests;

import techery.uitests.appspector.Utils.FileHelper;
import techery.uitests.appspector.Utils.UserCredentialsGenerator;
import techery.uitests.appspector.pages.LoginPage;

import java.io.*;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    Properties prop = new Properties();

    public BaseTest(){

        String appConfig;
        try {
            appConfig = FileHelper.getResourceFilePath("config.properties");
            prop.load(new FileInputStream(appConfig));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    String url = "https://app.staging.appspector.com/login";
    String NEWUSERLOGIN = prop.getProperty("NEWUSERLOGIN","kirill.puhalskiy@gmail.com");
    String PASSWORD = prop.getProperty("PASSWORD","111111");
    String DEFAULTUSER = "cyril.p+atbot@techery.io";
    String defaultpass = "111111";
    String appname = "new APP test";
    LoginPage page = open(url, LoginPage.class);



    UserCredentialsGenerator generator = new UserCredentialsGenerator();
    String username = generator.createUsername();
    String email = generator.createEmail();

}


