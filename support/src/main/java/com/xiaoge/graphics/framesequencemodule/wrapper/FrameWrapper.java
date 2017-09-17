package com.xiaoge.graphics.framesequencemodule.wrapper;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.rastermill.FrameSequenceDrawable;
import android.util.Log;

import com.xiaoge.graphics.animategraphics.core.wrapper.DrawableHelper;
import com.xiaoge.graphics.animategraphics.core.wrapper.DrawableWrapper;
import com.xiaoge.graphics.animategraphics.core.wrapper.PlayListener;

import static android.support.rastermill.FrameSequenceDrawable.LOOP_FINITE;
import static android.support.rastermill.FrameSequenceDrawable.LOOP_INF;
import static com.xiaoge.graphics.animategraphics.core.wrapper.DrawableHelper.REPEAT_MODE_INFINITE;

/**
 * Created by zhanglei on 2017/9/11.
 */

public class FrameWrapper implements DrawableWrapper, FrameSequenceDrawable.OnFinishedListener {

    private FrameSequenceDrawable loadedImage;
    private PlayListener playListener;

    private static final String TAG = "FrameWrapper";

    public FrameWrapper(@NonNull FrameSequenceDrawable loadedImage) {
        this.loadedImage = loadedImage;
        loadedImage.setOnFinishedListener(this);
    }

    @Override
    public Drawable getDrawable() {
        return loadedImage;
    }

    @Override
    public void start() {
        loadedImage.start();
        Log.d(TAG,"start");
    }

    @Override
    public void stop() {
        loadedImage.stop();
        Log.d(TAG,"stop");
    }

    @Override
    public void setRepeatCount(int count) {
        loadedImage.setLoopCount(count);
    }

    @Override
    public void setLoopMode(@DrawableHelper.REPEAT_MODE int count) {
        if(REPEAT_MODE_INFINITE == count) {
            loadedImage.setLoopBehavior(LOOP_INF);
        } else {
            loadedImage.setLoopBehavior(LOOP_FINITE);
        }
    }

    @Override
    public void setPlayListener(PlayListener playListener) {
        this.playListener = playListener;
    }

    @Override
    public Bitmap getFirstFrame() {
        return loadedImage.getFirstFrame();
    }

    @Override
    public void onFinished(FrameSequenceDrawable frameSequenceDrawable) {
        Log.d(TAG,"onFinished:" + frameSequenceDrawable);
        if(playListener != null) {
            playListener.onPlayFinished();
        }
    }
}
