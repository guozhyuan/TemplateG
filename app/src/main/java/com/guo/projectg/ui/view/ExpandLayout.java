package com.guo.projectg.ui.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class ExpandLayout extends LinearLayout {
    public ExpandLayout(Context context) {
        super(context);
    }

    public ExpandLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ExpandLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    private View layoutView;
    private int viewHeight;
    private long animationDuration;
    private boolean isExpand = false;

    private void initView() {
        layoutView = this;
        animationDuration = 300;
//        setViewDimensions();
        viewHeight = layoutView.getMeasuredHeight();
    }


    /**
     * 设置动画时间
     *
     * @param animationDuration 动画时间
     */
    public void setAnimationDuration(long animationDuration) {
        this.animationDuration = animationDuration;
    }

    /**
     * 获取 subView 的总高度
     * View.post() 的 runnable 对象中的方法会在 View 的 measure、layout 等事件后触发
     */
    private void setViewDimensions() {
//        layoutView.post(new Runnable() {
//            @Override
//            public void run() {
//                if (viewHeight <= 0) {
//                    viewHeight = layoutView.getMeasuredHeight();
//                }
//            }
//        });
    }

    public void setViewHeight(int height) {
        LinearLayout.LayoutParams params = (LayoutParams) layoutView.getLayoutParams();
        params.height = height;
        requestLayout();
    }

    /**
     * 切换动画实现
     */
    private void animateToggle(long animationDuration) {
        ValueAnimator heightAnimation = isExpand ?
                ValueAnimator.ofFloat(0f, viewHeight) : ValueAnimator.ofFloat(viewHeight, 0f);
        heightAnimation.setDuration(animationDuration / 2);
        heightAnimation.setStartDelay(animationDuration / 2);

        heightAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float val = (float) animation.getAnimatedValue();
                setViewHeight((int) val);
            }
        });

        heightAnimation.start();
    }

    public boolean isExpand() {
        return isExpand;
    }

    /**
     * 折叠view
     */
    public void collapse() {
        isExpand = false;
        animateToggle(animationDuration);
    }

    public void collapseImmediately() {
        isExpand = false;
        animateToggle(0);
    }

    /**
     * 展开view
     */
    public void expand() {
        isExpand = true;
        animateToggle(animationDuration);
    }


}

