package com.pzf.liaotian.view;

import java.util.Hashtable;
import java.util.Vector;

import android.content.Context;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * @desc:可以播放动画的textview
 *BLOG:http://blog.sina.com.cn/cuil11
 * @date: 2015年7月3日 下午4:40:54
 * QQ2050542273
 * @email:15162925211@163.com
 */
public class GifTextView extends TextView implements Runnable {
    public static boolean mRunning = true;
    private Vector<GifDrawalbe> drawables;
    private Hashtable<Integer, GifDrawalbe> cache;
    private final int SPEED = 100;
    private Context context = null;

    public GifTextView(Context context, AttributeSet attr) {
        super(context, attr);
        this.context = context;

        drawables = new Vector<GifDrawalbe>();
        cache = new Hashtable<Integer, GifDrawalbe>();

        new Thread(this).start();
    }

    public GifTextView(Context context) {
        super(context);
        this.context = context;

        drawables = new Vector<GifDrawalbe>();
        cache = new Hashtable<Integer, GifDrawalbe>();

        new Thread(this).start();
    }

    public void insertGif(String str) {
        if (drawables.size() > 0)
            drawables.clear();
        SpannableString spannableString = GifExpressionUtil.getExpressionString(
                context, str, cache, drawables);
        setText(spannableString);
    }

    @Override
    public void run() {
        while (mRunning) {
            if (super.hasWindowFocus()) {
                for (int i = 0; i < drawables.size(); i++) {
                    drawables.get(i).run();
                }
                postInvalidate();
            }
            sleep();
        }
    }

    private void sleep() {
        try {
            Thread.sleep(SPEED);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void destroy() {
        mRunning = false;
        drawables.clear();
        drawables = null;
    }

}
