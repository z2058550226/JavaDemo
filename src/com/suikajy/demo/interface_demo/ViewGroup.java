package com.suikajy.demo.interface_demo;

import javax.swing.text.View;

public class ViewGroup implements NestedScrollingParent2 {
    @Override
    public boolean onStartNestedScroll(View child, View target, int axes, int type) {
        return false;
    }

    @Override
    public void onNestedScrollAccepted(View child, View target, int axes, int type) {

    }

    @Override
    public void onStopNestedScroll(View target, int type) {

    }

    @Override
    public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type) {

    }

    @Override
    public void onNestedPreScroll(View target, int dx, int dy, int[] consumed, int type) {

    }

    @Override
    public boolean onStartNestedScroll(View child, View target, int axes) {
        return false;
    }

    @Override
    public void onNestedScrollAccepted(View child, View target, int axes) {

    }

    @Override
    public void onStopNestedScroll(View target) {

    }

    @Override
    public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {

    }

    @Override
    public void onNestedPreScroll(View target, int dx, int dy, int[] consumed) {

    }

    @Override
    public boolean onNestedFling(View target, float velocityX, float velocityY, boolean consumed) {
        return false;
    }

    @Override
    public boolean onNestedPreFling(View target, float velocityX, float velocityY) {
        return false;
    }

    @Override
    public int getNestedScrollAxes() {
        return 0;
    }
}
