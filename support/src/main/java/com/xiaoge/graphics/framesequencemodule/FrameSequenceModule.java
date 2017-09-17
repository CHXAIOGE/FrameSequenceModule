package com.xiaoge.graphics.framesequencemodule;

import android.support.rastermill.FrameSequenceHelper;

import com.xiaoge.graphics.animategraphics.core.Graphics;

import java.io.File;
import java.io.InputStream;

/**
 * Created by zhanglei on 2017/9/16.
 */

public class FrameSequenceModule implements Graphics.Module {

    public FrameSequenceModule() {

    }

    @Override
    public boolean isSupport(File file) {
        return FrameSequenceHelper.isSupported(file);
    }

    @Override
    public boolean isSupport(InputStream inputStream) {
        return FrameSequenceHelper.isSupported(inputStream);
    }
}
