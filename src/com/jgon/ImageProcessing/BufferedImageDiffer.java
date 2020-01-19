package com.jgon.ImageProcessing;

import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;

public class BufferedImageDiffer {
	public long bufferedImageDifference(BufferedImage b1, BufferedImage b2) {
		DataBuffer b1Data = b1.getRaster().getDataBuffer();
		DataBuffer b2Data = b2.getRaster().getDataBuffer();
		long diff = 0;
		int b1Blue;
		int b1Green;
		int b1Red;
		int b2Blue;
		int b2Green;
		int b2Red;

		for (int i = 0; i < b1Data.getSize(); i++) {
			int b1RGB = b1Data.getElem(i);
			int b2RGB = b2Data.getElem(i);
			b1Blue = b1RGB & 0xff;
			b1Green = (b1RGB & 0xff00) >> 8;
			b1Red = (b1RGB & 0xff0000) >> 16;
			b2Blue = b2RGB & 0xff;
			b2Green = (b2RGB & 0xff00) >> 8;
			b2Red = (b2RGB & 0xff0000) >> 16;
			diff += Math.abs(b1Blue - b2Blue) + Math.abs(b1Green - b2Green) + Math.abs(b1Red - b2Red);
		}
		return diff;
	}
}
