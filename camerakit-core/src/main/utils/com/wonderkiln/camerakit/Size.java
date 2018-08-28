package com.wonderkiln.camerakit;

import android.support.annotation.NonNull;
import android.util.Log;

public class Size implements Comparable<Size> {

    private final int mWidth;
    private final int mHeight;

    public Size(int width, int height) {
        mWidth = width;
        mHeight = height;
    }

    public int getWidth() {
        return mWidth;
    }

    public int getHeight() {
        return mHeight;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (this == o) {
            return true;
        }
        if (o instanceof Size) {
            Size size = (Size) o;
            return mWidth == size.mWidth && mHeight == size.mHeight;
        }
        return false;
    }

    @Override
    public String toString() {
        return mWidth + "x" + mHeight;
    }

    @Override
    public int hashCode() {
        return mHeight ^ ((mWidth << (Integer.SIZE / 2)) | (mWidth >>> (Integer.SIZE / 2)));
    }

    @Override
    public int compareTo(@NonNull Size another) {
        return mWidth * mHeight - another.mWidth * another.mHeight;
    }

    public static Size parse(String size){
        if(size != null && !size.isEmpty()){
            try {
                int x = size.indexOf('x');
                String width = size.substring(0, x);
                String height = size.substring(x + 1);
                return new Size( Integer.parseInt(width), Integer.parseInt(height));
            } catch (Exception e) {
                Log.e("Size","parse exception " + e.getMessage());
            }
        }
        return null;
    }

}
