package com.xiaoge.graphics.framesequencemodule;

import android.support.annotation.Nullable;
import android.support.rastermill.FrameSequence;
import android.support.rastermill.FrameSequenceDrawable;
import android.util.Log;
import android.widget.ImageView;

import com.xiaoge.graphics.animategraphics.core.Graphics;
import com.xiaoge.graphics.animategraphics.core.loader.GraphicsLoader;
import com.xiaoge.graphics.animategraphics.core.target.Target;
import com.xiaoge.graphics.framesequencemodule.wrapper.FrameWrapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Created by zhanglei on 2017/9/16.
 */

public class FrameSequenceLoader extends GraphicsLoader {

    public FrameSequenceLoader(File data, Target target) {
        super(data, target);
    }

    public FrameSequenceLoader(InputStream data, Target target) {
        super(data, target);
    }

    @Override
    public void into(ImageView view) {
        try {
            Graphics.Log("stream:"+stream);
            if(stream == null){
                stream = new FileInputStream(file);;
            }

            Graphics.Log("inputStream:" + stream);
            FrameSequence frameSequence = FrameSequence.decodeStream(stream);
            Graphics.Log("frameSequence:" + frameSequence);
            FrameSequenceDrawable drawable = new FrameSequenceDrawable(frameSequence);
            view.setImageDrawable(drawable);
            target.onResourceReady(new FrameWrapper(drawable));
        } catch (Exception var2) {
            target.onLoadFailed();
            Graphics.Log(Log.getStackTraceString(var2));
        }
    }
}
