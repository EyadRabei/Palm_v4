# Palm Gesture — cloud APK build

This package lets GitHub Actions build the Android APK in the cloud, so Android Studio does not need to be installed on your laptop.

## Before building

The app opens the Palm website inside an Android WebView. It is **not an offline standalone app**. First deploy the Palm web project to an HTTPS URL, then edit:

`android/app/src/main/res/values/strings.xml`

Replace `https://YOUR-DEPLOYED-PALM-URL.example` with your real deployed HTTPS URL.

## Build the APK on GitHub

1. Sign in to GitHub and create a **private** repository.
2. Extract this ZIP on your laptop.
3. Upload the extracted `android` folder, the `.github` folder, and this `README.md` to the repository root. Do not upload the ZIP file itself as the only repository file.
4. Edit `android/app/src/main/res/values/strings.xml` on GitHub and replace the placeholder URL with the real HTTPS URL. Commit the change.
5. Open the repository's **Actions** tab and select **Build Palm Gesture APK**. If needed, press **Run workflow**.
6. When the run finishes successfully, open that run and download the `palm-gesture-debug-apk` artifact. Extract it to get `app-debug.apk`.
7. Transfer the APK to your Android phone and install it. Android may ask you to allow installation from that source.
8. Open Palm Gesture, allow camera access, then enable **Palm Gesture Scroll** in Android Settings → Accessibility.

## Gestures

- Middle finger alone extended: scroll down.
- Fist: scroll up.

Keep the camera view open in Palm Gesture while using gestures. The accessibility service can send swipe gestures to other apps, but behavior can vary by Android version and app; test it carefully. The app needs camera access and accessibility permission to work as intended.

## Important

This workflow creates a **debug APK** for testing, not a Play Store release. The build workflow validates that you replaced the placeholder URL so it does not intentionally produce an APK that opens a placeholder page.
