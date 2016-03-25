package com.blanke.lib.scrollholdview;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import com.blanke.lib.R;
import com.blanke.lib.ShowHideOnScroll;

/**
 * Created by Blanke on 16-3-14.
 */
public class ScrollHideView extends FrameLayout {
    private int animInRes = 0, animOutRes = 0, targetViewRes = 0;
    private View targetView;

    public ScrollHideView(Context context) {
        this(context, null);
    }

    public ScrollHideView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ScrollHideView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        final TypedArray a = context.obtainStyledAttributes(
                attrs, R.styleable.ScrollHideView, defStyleAttr, 0);
        animInRes = a.getResourceId(R.styleable.ScrollHideView_animIn, 0);
        animOutRes = a.getResourceId(R.styleable.ScrollHideView_animOut, 0);
        targetViewRes = a.getResourceId(R.styleable.ScrollHideView_targetView, 0);
        a.recycle();
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        init();
    }

    private void init() {
        targetView = getRootView().findViewById(targetViewRes);
        if (targetView == null) {
            throw new IllegalStateException("targetView is null!");
        }
        if (animInRes != 0 && animOutRes != 0) {
            targetView.setOnTouchListener(new ShowHideOnScroll(ScrollHideView.this, animInRes, animOutRes));
        } else {
            targetView.setOnTouchListener(new ShowHideOnScroll(ScrollHideView.this));
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        clearAnim();
    }

    public int getAnimInRes() {
        return animInRes;
    }


    public int getAnimOutRes() {
        return animOutRes;
    }

    public void setAnimRes(int animInRes, int animOutRes) {
        this.animInRes = animInRes;
        this.animOutRes = animOutRes;
        init();
    }

    public void setDefaultAnim() {
        setAnimRes(0, 0);
    }

    public void clearAnim() {
        clearAnimation();
        if (targetView != null) {
            targetView.setOnTouchListener(null);
        }
    }
}
