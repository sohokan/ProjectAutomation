package org.ti.utils.video;

import org.ti.DriverFactory.FrameworkException ;
import org.monte.media.Format;
import org.monte.media.FormatKeys.*;
import org.monte.media.Registry;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.monte.media.FormatKeys.*;
import static org.monte.media.VideoFormatKeys.*;

public class SpecializedScreenRecorder extends ScreenRecorder {
    private String name;
    private ScreenRecorder screenRecorder;

    public SpecializedScreenRecorder(GraphicsConfiguration cfg, Rectangle captureArea, Format fileFormat,
                                     Format screenFormat, Format mouseFormat, Format audioFormat, File movieFolder,
                                     String name) throws IOException, AWTException {
        super(cfg,captureArea,fileFormat,screenFormat,mouseFormat,audioFormat,movieFolder);
        this.name = name;

    }

    public void startRecording(String videoPath) {
        try{
            File file = new File(videoPath);

            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            int width = screenSize.width;
            int height = screenSize.height;

            Rectangle captureSize = new Rectangle(0,0, width, height);

            GraphicsConfiguration gc = GraphicsEnvironment
                .getLocalGraphicsEnvironment()
                .getDefaultScreenDevice()
                .getDefaultConfiguration();

            this.screenRecorder = new SpecializedScreenRecorder(gc, captureSize,
                new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
                new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                    CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                    DepthKey, 24, FrameRateKey, Rational.valueOf(15),
                    QualityKey, 1.0f,
                    KeyFrameIntervalKey, 15 * 60),
                new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black",
                    FrameRateKey, Rational.valueOf(30)),
                null, file, "ScreenRecorded");

            this.screenRecorder.start();
        }catch(Exception ex){
            new FrameworkException("Class VideoRecorder | Method startRecording | Exception desc: Error creating video"+ ex.getMessage());
        }
    }

    public void stopRecording() throws Exception
    {
        this.screenRecorder.stop();
    }

    @Override
    protected File createMovieFile(Format fileFormat) throws IOException{
        if (!movieFolder.exists()){
            movieFolder.mkdirs();
        }else if(!movieFolder.isDirectory()){
            new FrameworkException(String.format("\\%s\\ is not a directory", movieFolder));
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH");
        return new File(movieFolder, name + "-"+dateFormat.format(new Date()) + "." + Registry.getInstance().getExtension(fileFormat));
    }
}
