package Streamer;

import com.xuggle.ferry.IBuffer;
import com.xuggle.xuggler.*;
import com.xuggle.xuggler.video.ConverterFactory;
import com.xuggle.xuggler.video.IConverter;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.nio.ByteBuffer;

public class Decoder {

    protected final IStreamCoder iStreamCoder = IStreamCoder.make(IStreamCoder.Direction.DECODING, ICodec.ID.CODEC_ID_H264);
    protected final ConverterFactory.Type type = ConverterFactory.findRegisteredConverter(ConverterFactory.XUGGLER_BGR_24);
    protected final Dimension dimension;
    protected final IStreamCoder iAudioStreamCoder = IStreamCoder.make(IStreamCoder.Direction.DECODING, ICodec.ID.CODEC_ID_AAC);

//    protected final IStreamCoder iAudioStreamCoder = IStreamCoder.make(IStreamCoder.Direction.DECODING, ICodec.ID.);

//
//    protected final FrameDecoder frameDecoder;
//    protected final ExecutorService decodeWorker;

    public Decoder(Dimension dimension) {

        super();
        this.dimension = dimension;
//        if (internalFrameDecoder) {
//            frameDecoder = new FrameDecoder(4);
//        } else {
//            frameDecoder = null;
//        }
//        if (decodeInOtherThread) {
//            decodeWorker = Executors.newSingleThreadExecutor();
//        } else {
//            decodeWorker = null;
//        }

        initialize();
    }

    private void initialize() {
        // iStreamCoder.setNumPicturesInGroupOfPictures(20);
        // iStreamCoder.setBitRate(250000);
        // iStreamCoder.setBitRateTolerance(9000);
        // iStreamCoder.setPixelType(IPixelFormat.Type.YUV420P);
        // iStreamCoder.setHeight(dimension.height);
        // iStreamCoder.setWidth(dimension.width);
        // iStreamCoder.setFlag(IStreamCoder.Flags.FLAG_QSCALE, true);
        // iStreamCoder.setGlobalQuality(0);
        // rate
        // IRational rate = IRational.make(25, 1);
        // iStreamCoder.setFrameRate(rate);
        // time base
        // iStreamCoder.setAutomaticallyStampPacketsForStream(true);
        // iStreamCoder.setTimeBase(IRational.make(rate.getDenominator(),rate.getNumerator()));
        iStreamCoder.open(null, null);
        //iAudioStreamCoder.setSampleFormat(IAudioSamples.Format.FMT_S16);
    }


    public BufferedImage decode(VideoPacket videoPacket) throws Exception {

//        if (decodeWorker != null) {
//            decodeWorker.execute(new decodeTask(msg));
//            return null;
//        } else {
//            if (msg == null) {
//                throw new NullPointerException("you cannot pass into an null to the decode");
//            }
//            ChannelBuffer frameBuffer;
//            if (frameDecoder != null) {
//                frameBuffer = frameDecoder.decode((ChannelBuffer) msg);
//                if (frameBuffer == null) {
//                    return null;
//                }
//
//            } else {
//                frameBuffer = (ChannelBuffer) msg;
//            }

//        Packet packet = (Packet) msg;

//            int size = frameBuffer.readableBytes();
//            logger.info("decode the frame size :{}", size);


        byte []data = videoPacket.getData();
        ByteBuffer bufferData = ByteBuffer.wrap(data);

            // start to decode
            //IBuffer iBuffer = IBuffer.make(null, 8000);
        IBuffer iBuffer = IBuffer.make(null, data , 0, data.length);
        IPacket iPacket = IPacket.make(iBuffer);
            //iPacket.getByteBuffer().put(frameBuffer.toByteBuffer());
        iPacket.getByteBuffer().put(bufferData);
        // decode the packet
            if (!iPacket.isComplete()) {
                return null;
            }

            IVideoPicture picture = IVideoPicture.make(IPixelFormat.Type.YUV420P,
                    dimension.width, dimension.height);
            try {
                // decode the packet into the video picture
                int postion = 0;
                int packageSize = iPacket.getSize();
                while (postion < packageSize) {
                    postion += iStreamCoder.decodeVideo(picture, iPacket, postion);
                    if (postion < 0) {
//                        throw new RuntimeException("error "
//                                + " decoding video");

                        return null;
                    }
                    // if this is a complete picture, dispatch the picture
                    if (picture.isComplete()) {
                        IConverter converter = ConverterFactory.createConverter(type
                                .getDescriptor(), picture);
                        BufferedImage image = converter.toImage(picture);
                        System.out.println("Conversion completed!!");

                        // BufferedImage convertedImage = ImageUtils.convertToType(image,
                        // BufferedImage.TYPE_3BYTE_BGR);
                        // here ,put out the image
//                        if (streamFrameListener != null) {
//                            streamFrameListener.onFrameReceived(image);
//                        }
                        converter.delete();

                        return image;
                    } else {
                        picture.delete();
                        iPacket.delete();
                        return null;
                    }
                    // clean the picture and reuse it
                    //picture.getByteBuffer().clear();
                }
            } finally {
                if (picture != null) {
                    picture.delete();
                }
                iPacket.delete();
                // ByteBufferUtil.destroy(data);
            }
            return null;
        }


}
