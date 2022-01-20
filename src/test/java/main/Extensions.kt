package main

import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.ios.IOSDriver

fun AppiumDriver<MobileElement>.find(param: String, id: Boolean?): MobileElement? {
    var result: MobileElement? = null
    when(this){
        is AndroidDriver -> {
            if (id != null){
                result = try {
                    if (id)
                        this.findElementById(param)
                    else
                        this.findElementByXPath(param)
                } catch (exception : org.openqa.selenium.NoSuchElementException) {
                    println( "element $param\n not found")
                    null
                }
            }else{
                result = try {
                    this.findElementById(param)
                } catch (exception : org.openqa.selenium.NoSuchElementException){
                    try {
                        this.findElementByXPath(param)
                    } catch (exception : org.openqa.selenium.NoSuchElementException){
                        println( "element $param\n not found")
                        null
                    }
                }
            }
        }
        is IOSDriver -> {
            //TODO
        }
    }
    return result
}