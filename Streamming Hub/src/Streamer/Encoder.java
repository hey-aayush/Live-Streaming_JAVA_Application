package Streamer;

import com.xuggle.xuggler.*;
import com.xuggle.xuggler.video.ConverterFactory;
import com.xuggle.xuggler.video.IConverter;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.nio.ByteBuffer;

public class Encoder {

    protected final IStreamCoder iStreamCoder = IStreamCoder.make(IStreamCoder.Direction.ENCODING, ICodec.ID.CODEC_ID_H264);
    protected final IPacket iPacket = IPacket.make();
    protected long startTime ;
    protected final Dimension dimension;

    public Encoder(Dimension dimension) {
        this.dimension = dimension;
        initialize();
    }

    private void initialize(){
        //setup
        iStreamCoder.setNumPicturesInGroupOfPictures(25);
        iStreamCoder.setBitRate(200000);
        iStreamCoder.setBitRateTolerance(10000);
        iStreamCoder.setPixelType(IPixelFormat.Type.YUV420P);
        iStreamCoder.setHeight(dimension.height);
        iStreamCoder.setWidth(dimension.width);
        iStreamCoder.setFlag(IStreamCoder.Flags.FLAG_QSCALE, true);
        iStreamCoder.setGlobalQuality(100);
        //rate
        IRational rate = IRational.make(25, 1);
        iStreamCoder.setFrameRate(rate);
        //time base
        //iStreamCoder.setAutomaticallyStampPacketsForStream(true);
        iStreamCoder.setTimeBase(IRational.make(rate.getDenominator(),rate.getNumerator()));
        IMetaData codecOptions = IMetaData.make();
        codecOptions.setValue("tune", "zerolatency");// equals -tune zerolatency in ffmpeg
        //open it
        int revl = iStreamCoder.open(codecOptions, null);
        if (revl < 0) {
            throw new RuntimeException("could not open the coder");
        }

    }

    public VideoPacket encode(Object msg, int imageNumber, long timeStamp) throws Exception {
        if (msg == null) {
            return null;
        }
        if (!(msg instanceof BufferedImage)) {
            throw new IllegalArgumentException("Buffered image required!!");
        }

        BufferedImage bufferedImage = (BufferedImage)msg;
        //here is the encode
        //convert the image
        BufferedImage convetedImage = ImageConverter.convertToType(bufferedImage, BufferedImage.TYPE_3BYTE_BGR);


        IConverter converter = ConverterFactory.createConverter(convetedImage, IPixelFormat.Type.YUV420P);
        //to frame
        long now = System.currentTimeMillis();
        if (startTime == 0) {
            startTime = now;
        }
        IVideoPicture pFrame = converter.toPicture(convetedImage, (now - startTime)*1000);
        //pFrame.setQuality(0);
        iStreamCoder.encodeVideo(iPacket, pFrame, 0) ;
        //free the MEM
        pFrame.delete();
        converter.delete();
        //write to the container
        if (iPacket.isComplete()) {

            //iPacket.delete();
            //here we send the package to the remote peer
            try{
                ByteBuffer byteBuffer = iPacket.getByteBuffer();
                byte []data = new byte[byteBuffer.remaining()];
                byteBuffer.get(data);

                //System.out.println("Length of encoded bytes :" + data.length);

                if (iPacket.isKeyPacket()) {

                }

                return (new VideoPacket(data, imageNumber, timeStamp));

            }finally{
                iPacket.reset();
            }
        }else{
            return null;
        }
    }

}
