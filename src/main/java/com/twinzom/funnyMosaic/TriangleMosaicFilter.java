package com.twinzom.funnyMosaic;

import java.awt.*;
import java.awt.image.BufferedImage;

public class TriangleMosaicFilter {

    private static float TR = 0.866025f;
    private static float PI6 = 0.523599f; //PI/6

    public BufferedImage filter (BufferedImage img, float len) {
        BufferedImage outputImage = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
        int index = 0;
        for (int i = 0; i < img.getWidth(); i++) {
            for (int j = 0; j < img.getHeight(); j++) {
                outputImage.setRGB(i, j, getNewColor(img, i, j, len).getRGB());
            }
        }
        return outputImage;
    }

    public Color getNewColor (BufferedImage img, int x, int y, float len) {
        int wx = Math.round(x/1.5f/len);
        int wy = Math.round(y/TR/len);
        float[] v1 = new float[2];
        float[] v2 = new float[2];
        float[] vn = new float[2];
        if(wx/2 * 2 == wx) {
            if(wy/2 * 2 == wy) {
                v1[0] = len*1.5f*wx;
                v1[1] = len*TR*wy;
                v2[0] = len*1.5f*(wx+1);
                v2[1] = len*TR*(wy+1);
            } else {
                v1[0] = len*1.5f*wx;
                v1[1] = len*TR*(wy+1);
                v2[0] = len*1.5f*(wx+1);
                v2[1] = len*TR*wy;
            }
        } else {
            if(wy/2 * 2 == wy) {
                v1[0] = len*1.5f*wx;
                v1[1] = len*TR*(wy+1);
                v2[0] = len*1.5f*(wx+1);
                v2[1] = len*TR*wy;
            } else {
                v1[0] = len*1.5f*wx;
                v1[1] = len*TR*wy;
                v2[0] = len*1.5f*(wx+1);
                v2[1] = len*TR*(wy+1);
            }
        }
        float s1 = (float) Math.sqrt( Math.pow(v1[0]-x, 2) + Math.pow(v1[1]-y, 2) );
        float s2 = (float) Math.sqrt( Math.pow(v2[0]-x, 2) + Math.pow(v2[1]-y, 2) );
        if(s1 < s2)
            vn = v1;
        else
            vn = v2;
        float a = (float) Math.atan((x-vn[0])/(y-vn[1])); //included angle
        float[] area1 = new float[] {vn[0], vn[1]-len/TR/2};
        float[] area2 = new float[] {vn[0]+len/2, vn[1]-len/TR/4};
        float[] area3 = new float[] {vn[0]+len/2, vn[1]+len/TR/4};
        float[] area4 = new float[] {vn[0], vn[1]+len/TR/2};
        float[] area5 = new float[] {vn[0]-len/2, vn[1]+len/TR/4};
        float[] area6 = new float[] {vn[0]-len/2, vn[1]-len/TR/4};
        if(a>=PI6 && a<PI6*3)
            vn = area1;
        else if(a>=PI6*3 && a<PI6*5)
            vn = area2;
        else if((a>=PI6*5 && a<=PI6*6) || (a<-PI6*5 && a>-PI6*6))
            vn = area3;
        else if(a<-PI6*3 && a>=-PI6*5)
            vn = area4;
        else if(a<=-PI6 && a>-PI6*3)
            vn = area5;
        else if(a>-PI6 && a<PI6)
            vn = area6;

        //TODO: need to handle edge of the image properly
        if (Math.round(vn[0]) < 0 || Math.round(vn[1]) < 0) {
            return Color.BLACK;
        } else if (Math.round(vn[0]) > img.getWidth()-1 || Math.round(vn[1]) > img.getHeight()-1) {
            return Color.BLACK;
        } else {
            int rgb = img.getRGB(Math.round(vn[0]), Math.round(vn[1]));
            return new Color(rgb);
        }
    }

}
