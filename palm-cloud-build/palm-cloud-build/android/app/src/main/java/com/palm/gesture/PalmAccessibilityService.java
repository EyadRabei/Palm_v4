package com.palm.gesture;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.GestureDescription;
import android.graphics.Path;
import android.os.Build;
import android.view.accessibility.AccessibilityEvent;

/** Sends a short swipe through Android Accessibility. The user must enable this service manually. */
public class PalmAccessibilityService extends AccessibilityService {
    private static volatile PalmAccessibilityService instance;
    public static PalmAccessibilityService getInstance() { return instance; }

    @Override public void onServiceConnected() { super.onServiceConnected(); instance = this; }
    @Override public void onAccessibilityEvent(AccessibilityEvent event) { }
    @Override public void onInterrupt() { }
    @Override public void onDestroy() { if (instance == this) instance = null; super.onDestroy(); }

    public void scroll(String direction) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) return;
        final int w = getResources().getDisplayMetrics().widthPixels;
        final int h = getResources().getDisplayMetrics().heightPixels;
        final float x = w * 0.5f;
        final float startY = "down".equals(direction) ? h * 0.68f : h * 0.38f;
        final float endY = "down".equals(direction) ? h * 0.38f : h * 0.68f;
        Path path = new Path();
        path.moveTo(x, startY);
        path.lineTo(x, endY);
        GestureDescription.StrokeDescription stroke = new GestureDescription.StrokeDescription(path, 0, 260);
        dispatchGesture(new GestureDescription.Builder().addStroke(stroke).build(), null, null);
    }
}
