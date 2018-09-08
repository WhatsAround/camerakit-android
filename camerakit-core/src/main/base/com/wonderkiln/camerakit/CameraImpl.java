package com.wonderkiln.camerakit;

import android.support.annotation.Nullable;

import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.text.TextBlock;

import java.io.File;

abstract class CameraImpl {

    protected final EventDispatcher mEventDispatcher;
    protected final PreviewImpl mPreview;

    CameraImpl(EventDispatcher eventDispatcher, PreviewImpl preview) {
        mEventDispatcher = eventDispatcher;
        mPreview = preview;
    }

    abstract void start();
    abstract void stop();

    abstract void setDisplayAndDeviceOrientation(int displayOrientation, int deviceOrientation);

    abstract void setFacing(@Facing int facing);
    abstract @Facing int getFacing();
    abstract @Facing int getNextCameraFacing();
    abstract void toggleCamera();
    abstract void setFlash(@Flash int flash);
    abstract void setFocus(@Focus int focus);
    abstract void setMethod(@CaptureMethod int method);
    abstract void setTextDetector(Detector<TextBlock> detector);

    abstract void setVideoQuality(@VideoQuality int videoQuality);
    abstract void setJpegQuality(int jpegQuality);
    abstract void setMaxCaptureSize(Size maxCaptureSize);
    abstract void setVideoBitRate(int videoBitRate);
    abstract void setDuration(int duration);
    abstract void setLockVideoAspectRatio(boolean lockVideoAspectRatio);

    abstract void setZoom(float zoomFactor);
    abstract void modifyZoom(float modifier);
    abstract void setFocusArea(float x, float y);

    abstract void captureImage(ImageCapturedCallback callback);
    interface ImageCapturedCallback {
        void imageCaptured(byte[] jpeg);
    }

    abstract void captureVideo(File videoFile, VideoCapturedCallback callback);
    interface VideoCapturedCallback {
        void videoCaptured(File file);
    }

    abstract void stopVideo();

    abstract Size getCaptureResolution();
    abstract Size getVideoResolution();
    abstract Size getPreviewResolution();
    abstract boolean isCameraOpened();
    abstract boolean frontCameraOnly();

    @Nullable
    abstract CameraProperties getCameraProperties();

}
