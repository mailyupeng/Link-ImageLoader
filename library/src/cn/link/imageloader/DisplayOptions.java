/*******************************************************************************
 * Copyright 2011-2013 Sergey Tarasevich
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package cn.link.imageloader;

import cn.link.imageloader.assist.ImageScaleType;
import cn.link.imageloader.assist.ImageSize;
import cn.link.imageloader.display.OnLoadingListener;
import cn.link.imageloader.assist.ViewScaleType;
import cn.link.imageloader.display.BitmapDisplayer;
import cn.link.imageloader.display.BitmapProgressListener;

public final class DisplayOptions {
    public String mDisplayUrl;
    private final int mResetImage;
    private final boolean mIfCacheInMemory;
    private final boolean mIfCacheOnDisc;
    private final boolean showPressEffect;

    private final ImageScaleType mImageScaleType;

    private final BitmapDisplayer mDisplayer;

    private BitmapProgressListener mProgressListener;
    private OnLoadingListener mOnLoadingListener;

    public ImageSize mTargetSize;
    public ViewScaleType mViewScalType;

    private DisplayOptions(Builder builder) {
        mResetImage = builder.mResetImage;
        mIfCacheInMemory = builder.mIfCacheInMemory;
        mIfCacheOnDisc = builder.mIfCacheOnDisc;
        showPressEffect = builder.showPressEffect;
        mImageScaleType = builder.mImageScaleType;
        mDisplayer = builder.mDisplay;
        mDisplayUrl = builder.mDisplayUrl;
        mTargetSize = builder.mTargetSize;
        mViewScalType = builder.mViewScaleType;
    }

    public int getResetImage() {
        if (mResetImage == 0) {
            return R.drawable.transparent;
        }
        return mResetImage;
    }

    public boolean ifCacheInMemory() {
        return mIfCacheInMemory;
    }

    public boolean ifCacheOnDisc() {
        return mIfCacheOnDisc;
    }

    public boolean isShowPressEffect() {
        return showPressEffect;
    }

    public ImageScaleType getImageScaleType() {
        return mImageScaleType;
    }


    public BitmapDisplayer getDisplayer() {
        return mDisplayer;
    }

    public void setProgressListener(BitmapProgressListener listener) {
        this.mProgressListener = listener;
    }

    public BitmapProgressListener getProgressListener() {
        return mProgressListener;
    }

    public void setOnLoadingListener(OnLoadingListener ls) {
        this.mOnLoadingListener = ls;
    }

    public OnLoadingListener getOnLoadingListener() {
        return mOnLoadingListener;
    }

    public String getDisplayUrl() {
        return mDisplayUrl;
    }


    public static class Builder {
        private int mResetImage = 0;
        private boolean mIfCacheInMemory = true;
        private boolean mIfCacheOnDisc = true;
        private boolean mDispalyIfInMemory = true;
        private boolean showPressEffect = true;
        private ImageScaleType mImageScaleType = ImageScaleType.IN_SAMPLE_INT;
        private BitmapDisplayer mDisplay = DefaultConfigurationFactory.createBitmapDisplayer();
        private BitmapProgressListener mProgressListener;
        private String mDisplayUrl;
        public ImageSize mTargetSize;
        public ViewScaleType mViewScaleType;

        public Builder() {
        }

        public Builder setResetImage(int img) {
            this.mResetImage = img;
            return this;
        }


        public Builder disableCacheInMemory() {
            mIfCacheInMemory = false;
            return this;
        }


        public Builder disableCacheOnDisc() {
            mIfCacheOnDisc = false;
            return this;
        }

        public Builder disablePressEffect() {
            showPressEffect = false;
            return this;
        }


        public Builder setImageScaleType(ImageScaleType imageScaleType) {
            this.mImageScaleType = imageScaleType;
            return this;
        }


        public Builder setDisplayer(BitmapDisplayer displayer) {
            this.mDisplay = displayer;
            return this;
        }

        public Builder setProgressListener(BitmapProgressListener listener) {
            this.mProgressListener = listener;
            return this;
        }

        public Builder setDisplayIfInMemory(boolean display) {
            this.mDispalyIfInMemory = display;
            return this;
        }

        public Builder setDisplayUrl(String url) {
            this.mDisplayUrl = url;
            return this;
        }


        public Builder cloneFrom(DisplayOptions options) {
            mResetImage = options.mResetImage;
            mIfCacheInMemory = options.mIfCacheInMemory;
            mIfCacheOnDisc = options.mIfCacheOnDisc;
            mImageScaleType = options.mImageScaleType;
            mDisplay = options.mDisplayer;
            mProgressListener = options.mProgressListener;
            mDisplayUrl = options.mDisplayUrl;
            return this;
        }


        public DisplayOptions build() {
            return new DisplayOptions(this);
        }
    }


    public static DisplayOptions createSimple() {
        return new Builder().build();
    }
}
