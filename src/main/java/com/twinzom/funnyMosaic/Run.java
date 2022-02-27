package com.twinzom.funnyMosaic;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Paths;

public class Run {

    public static void main (String[] args) {
        if (args.length <= 1) {
            System.out.println("Usage: java Run <IMAGE_PATH>");
            System.exit(1);
        }

        String inputImagePath = args[0];
        float lenSize = Float.valueOf(args[1]);
        String outputImagePath = inputImagePath+".len"+lenSize+".png";
        BufferedImage inputImage;
        try {
            // Read in the input image
            inputImage = ImageIO.read(Paths.get(inputImagePath).toFile());
        } catch (IOException e) {
            throw new UncheckedIOException("Unable to read input image!", e);
        }

        // start to triangle mosaic
        System.out.println("start to triangle mosaic, len size: "+lenSize);
        TriangleMosaicFilter triangleMosaicFilter = new TriangleMosaicFilter();
        BufferedImage triMosaicImage = triangleMosaicFilter.filter(inputImage, lenSize);
        System.out.println("complete triangle mosaic");

        // output triangle mosaic image
        String triMosaicImagePath = inputImagePath+".tri.mosaic.png";
        System.out.println("output the mosaic image to "+triMosaicImagePath);
        try {
            ImageIO.write(triMosaicImage, "png", new File(triMosaicImagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("completed.");

        // start to hexagon mosaic
        System.out.println("start to triangle mosaic, len size: "+lenSize);
        HexgaonMosaicFilter hexgaonMosaicFilter = new HexgaonMosaicFilter();
        BufferedImage hexMosaicImage = hexgaonMosaicFilter.filter(inputImage, lenSize);
        System.out.println("complete triangle mosaic");

        // output triangle mosaic image
        String hexMosaicImagePath = inputImagePath+".hex.mosaic.png";
        System.out.println("output the mosaic image to "+triMosaicImagePath);
        try {
            ImageIO.write(hexMosaicImage, "png", new File(hexMosaicImagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("completed.");

    }

}
