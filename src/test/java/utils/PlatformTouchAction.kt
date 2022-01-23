package utils

import io.appium.java_client.PerformsTouchActions
import io.appium.java_client.TouchAction

class PlatformTouchAction(performs: PerformsTouchActions)
    : TouchAction<PlatformTouchAction>(performs)