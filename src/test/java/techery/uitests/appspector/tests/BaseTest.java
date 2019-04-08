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

    String url = "";
    String NEWUSERLOGIN = prop.getProperty("NEWUSERLOGIN","email@email.com");
    String PASSWORD = prop.getProperty("PASSWORD","password");
    String DEFAULTUSER = "";
    String defaultpass = "";
    String appname = "";
    LoginPage page = open(url, LoginPage.class);



    UserCredentialsGenerator generator = new UserCredentialsGenerator();
    String username = generator.createUsername();
    String email = generator.createEmail();

}


