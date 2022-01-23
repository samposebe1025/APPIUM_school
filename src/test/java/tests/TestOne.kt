package tests

import constructor.classes.user
import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver
import locators.*
import main.TestMethods
import org.testng.annotations.Test
import java.util.concurrent.TimeUnit

class TestOne: TestMethods() {

    @Test
    fun testOne(){
        TimeUnit.SECONDS.sleep(1)//timeout for start

        println("~~~ SPLASH ~~~")
        clickToElement(
            locator = SplashScreenLocators().buttonExit)

        println("~~~ AUTH ~~~")
        inputTextInField(
            locator = AuthScreenLocators().textEditPhoneNumber,
            inputText = user.phoneNumber
        )
        checkTextInElement(
            locator = AuthScreenLocators().textEditPhoneNumber,
            text = user.phoneNumber
        ){
            it
                .replace(", Номер телефона","")
                .replace(" ", "")
        }

        clickToElement(
            locator = AuthScreenLocators().buttonGetCode
        )

        println("~~~ PIN CODE ~~~")
        inputTextInField(
            locator = PinCodeScreenLocators().textEditPinCode,
            inputText = user.smsCode,
            timeout = 4
        )

        println("~~~ CITY ~~~")
        clickToElement(
            locator = GeoPermissionScreenLocators().buttonDeny,
            timeout = 3
        )
        tapByCoordinates(200, 300, waitSeconds = 5)
        clickToElement(
            locator = CityScreenLocators().recyclerFirstElement
        )

        println("~~~ GO PROFILE ~~~")
        clickToElement(
            locator = TabBarScreenLocators().buttonProfile,
            timeout = 3
        )

        println("~~~ PROFILE ~~~")
        clickToElement(
            locator = ProfileScreenLocators().buttonEditProfile,
            timeout = 3
        )


        println("~~~ EDIT PROFILE ~~~")
        clickToElement(
            locator = EditProfileScreenLocators().buttonLogout,
            timeout = 3
        )

        checkAvailableElement(
            locator = SignInScreenLocators().buttonSignIn
        )

        TimeUnit.SECONDS.sleep(3)
    }


}