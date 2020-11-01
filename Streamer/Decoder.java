package Streamer;

import com.xuggle.ferry.IBuffer;
import com.xuggle.xuggler.*;
import com.xuggle.xuggler.video.ConverterFactory;
import com.xuggle.xuggler.video.IConverter;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.nio.ByteBuffer;

/**
 * Class for decoding stream
 */

public class Decoder {

    private final IStreamCoder iStreamCoder = IStreamCoder.make(IStreamCoder.Direction.DECODING, ICodec.ID.CODEC_ID_H264);
    private final ConverterFactory.Type type = ConverterFactory.findRegisteredConverter(ConverterFactory.XUGGLER_BGR_24);
    private final Dimension dimension;

    public Decoder(Dimension dimension) {
        super();
        this.dimension = dimension;
        initialize();
    }

    private void initialize() {
        iStreamCoder.open(null, null);
    }


    public BufferedImage decode(VideoPacket videoPacket) throws Exception {

        byte []data = videoPacket.getData();
        ByteBuffer bufferData = ByteBuffer.wrap(data);

        IBuffer iBuffer = IBuffer.make(null, data , 0, data.length);
        IPacket iPacket = IPacket.make(iBuffer);
        iPacket.getByteBuffer().put(bufferData);

        // decode the packet
            if (!iPacket.isComplete()) {
                return null;
            }

            IVideoPicture picture = IVideoPicture.make(IPixelFormat.Type.YUV420P,
                    dimension.width, dimension.height);
            try {

                int postion = 0;
                int packageSize = iPacket.getSize();
                while (postion < packageSize) {
                    postion += iStreamCoder.decodeVideo(picture, iPacket, postion);

                    if (postion < 0) {
                        return null;
                    }

                    if (picture.isComplete()) {
                        IConverter converter = ConverterFactory.createConverter(type
                                .getDescriptor(), picture);
                        BufferedImage image = converter.toImage(picture);

                        converter.delete();

                        return image;
                    } else {
                        picture.delete();
                        iPacket.delete();
                        return null;
                    }
                }
            } finally {
                if (picture != null) {
                    picture.delete();
                }
                iPacket.delete();
            }
            return null;
        }


}
