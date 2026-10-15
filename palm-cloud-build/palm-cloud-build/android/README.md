# Palm Android wrapper (source scaffold)

This Android source adds a fullscreen WebView wrapper and an AccessibilityService bridge for system-wide swipe gestures. The React gesture detector calls `window.PalmAndroid.scroll('down'|'up')` when present; otherwise it scrolls the Palm page as before.

## Important setup before building
1. Deploy the Palm web app to HTTPS and replace `palm_url` in `app/src/main/res/values/strings.xml` with that exact URL.
2. Open this `android/` folder in Android Studio with Android SDK 35 installed, then build an APK.
3. Install the APK, open Palm, grant camera permission, and manually enable **Palm Gesture Scroll** under Android Settings → Accessibility.
4. Test on-device. Accessibility swipe gestures can behave differently between apps and Android versions.

This is source code, not a compiled APK. It requires Android Studio/Android SDK and a deployed Palm URL. Since this project uses a server-rendered React app, it is not a self-contained offline app yet; the current wrapper requires internet access to the deployed URL.
