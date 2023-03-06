package util;


import org.monte.media.Format;
import org.monte.media.FormatKeys;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import static org.monte.media.FormatKeys.*;
import static org.monte.media.VideoFormatKeys.*;

public class ScreenCaptureTest {

    private static ScreenRecorder screenRecorder;
    public static void initScreenCapture() throws IOException, AWTException {
        GraphicsConfiguration graphicsConfiguration =
                GraphicsEnvironment
                        .getLocalGraphicsEnvironment()
                        .getDefaultScreenDevice()
                        .getDefaultConfiguration();

        screenRecorder =
                new ScreenRecorder(
                        graphicsConfiguration,
                        null,
                        new Format(
                                MediaTypeKey,
                                FormatKeys.MediaType.FILE,
                                MimeTypeKey,
                                MIME_QUICKTIME),
                        new Format(
                                MediaTypeKey,
                                MediaType.VIDEO,
                                EncodingKey,
                                ENCODING_QUICKTIME_JPEG,
                                CompressorNameKey,
                                ENCODING_QUICKTIME_JPEG,
                                DepthKey,
                                24,
                                FrameRateKey,
                                Rational.valueOf(15 ),
                                QualityKey,
                                0.5f,
                                KeyFrameIntervalKey,
                                15 * 60),
                        new Format(
                                MediaTypeKey,
                                MediaType.VIDEO,
                                EncodingKey,
                                "black",
                                FrameRateKey,
                                Rational.valueOf(30)
                        ),
                        null,
                        new File("captures/video"));
    }


    public static void startCaptureVideo() throws IOException {
        screenRecorder.start();
    }

    public static void stopCaptureVideo() throws IOException {
        screenRecorder.stop();
    }
}
