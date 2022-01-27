package main

import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.ios.IOSDriver
import io.qameta.allure.Step
import locators.AuthScreenLocators
import locators.CityScreenLocators
import locators.GeoPermissionScreenLocators
import locators.OnboardScreenLocators
import java.util.concurrent.TimeUnit

class GeneralTestFunc: TestMethods() {

    fun denyPermission(
        scipAndroid: Boolean = false,
        scipIOS: Boolean = false){
        if ( isThereAnElement(GeoPermissionScreenLocators().buttonDontAllow))
            clickToElement(GeoPermissionScreenLocators().buttonDontAllow)
    }
@Step("asdf")
    fun skipOnBoarding(): Boolean{
        println("        skipOnBoarding")
        when (driver) {
            is IOSDriver -> {
                println("click Don't allow")
                denyPermission()
            }
            else -> {}
        }

        return if (isThereAnElement(OnboardScreenLocators().buttonExit)) {
            println("click buttonExit")
            clickToElement(
                locator = OnboardScreenLocators().buttonExit)
            false
        } else {
            true
        }
    }

    fun closeAuthorization(){
        println("        closeAuthorization")
        println("buttonClose")
        clickToElement(
            locator = AuthScreenLocators().buttonClose
        )
    }

    fun closeSelectCity(){
        println("        closeAuthorization")
        println("buttonDeny")
        clickToElement(
            locator = GeoPermissionScreenLocators().buttonDeny,
            timeout = 3
        )
        println("tapByCoordinates")
        tapByCoordinates(200, 300, waitSeconds = 5)
        println("recyclerFirstElement")
        clickToElement(
            locator = CityScreenLocators().recyclerFirstElement
        )
    }

    fun firstOn(): Boolean {
        TimeUnit.SECONDS.sleep(5)
        val result = skipOnBoarding()
        return if (result) {
            false
        } else {
            closeAuthorization()
            closeSelectCity()
            true
        }
    }



}