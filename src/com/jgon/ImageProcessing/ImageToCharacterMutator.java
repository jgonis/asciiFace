package com.jgon.ImageProcessing;

import java.awt.image.BufferedImage;

public class ImageToCharacterMutator {
	public BufferedImage bestMatchCharacter(BufferedImage baseImage) {
		BufferedImageDiffer differ = new BufferedImageDiffer();
		BufferedImage bestMatchImage = ImageAlphabet.IMAGE_ALPHABET.get(0);
		long bestMatchDiff = differ.bufferedImageDifference(baseImage,  bestMatchImage);
		for(int i = 1; i < ImageAlphabet.IMAGE_ALPHABET.size(); i++) {
			long currentDiff = differ.bufferedImageDifference(baseImage, ImageAlphabet.IMAGE_ALPHABET.get(i));
			if(currentDiff < bestMatchDiff) {
				bestMatchDiff = currentDiff;
				bestMatchImage = ImageAlphabet.IMAGE_ALPHABET.get(i);
			}
		}
		return bestMatchImage;
	}
//	long method1Diff = 0;
//		long start = System.nanoTime();
//		for (int i = 0; i < (int) ITERATIONS; i++) {
//			method1Diff = testCompareWithGetPixelInColumns(b1, b2);
//		}
//		long end = System.nanoTime();
//		long durationMethod1 = end - start;
//
//		long method2Diff = 0;
//		start = System.nanoTime();
//		for (int i = 0; i < (int) ITERATIONS; i++) {
//			method2Diff = testCompareWithGetPixelInRows(b1, b2);
//		}
//		end = System.nanoTime();
//		long durationMethod2 = end - start;
//
//		long method3Diff = 0;
//		start = System.nanoTime();
//		for (int i = 0; i < (int) ITERATIONS; i++) {
//			method3Diff = testCompareWithRasterInColumns(b1, b2);
//		}
//		end = System.nanoTime();
//		long durationMethod3 = end - start;
//
//		long method4Diff = 0;
//		start = System.nanoTime();
//		for (int i = 0; i < (int) ITERATIONS; i++) {
//			method4Diff = testCompareWithRasterInRows(b1, b2);
//		}
//		end = System.nanoTime();
//		long durationMethod4 = end - start;
//
//		long method5Diff = 0;
//		start = System.nanoTime();
//		for (int i = 0; i < (int) ITERATIONS; i++) {
//			method5Diff = testCompareWithDataBuffers(b1, b2);
//		}
//		end = System.nanoTime();
//		long durationMethod5 = end - start;
//
//		System.out.println("method 1 duration: " + (durationMethod1 / ITERATIONS) + " method 2 duration: "
//				+ (durationMethod2 / ITERATIONS) + " method 3 duration: " + (durationMethod3 / ITERATIONS)
//				+ " method 4 duration: " + (durationMethod4 / ITERATIONS) + " method 5 duration: " + (durationMethod5 / ITERATIONS));
//		System.out.println("method 1 diff: " + method1Diff + " method2Diff: " + method2Diff
//				+ " method 3 diff: " + method3Diff + " method 4 diff: " + method4Diff + " method 5 diff: " + method5Diff);

	//	private long testCompareWithGetPixelInColumns(BufferedImage b1, BufferedImage b2) {
//		long diff = 0;
//		int b1Blue;
//		int b1Green;
//		int b1Red;
//		int b2Blue;
//		int b2Green;
//		int b2Red;
//		for (int x = 0; x < b1.getWidth(); x++) {
//			for (int y = 0; y < b1.getHeight(); y++) {
//				int b1RGB = b1.getRGB(x, y);
//				int b2RGB = b2.getRGB(x, y);
//				b1Blue = b1RGB & 0xff;
//				b1Green = (b1RGB & 0xff00) >> 8;
//				b1Red = (b1RGB & 0xff0000) >> 16;
//				b2Blue = b2RGB & 0xff;
//				b2Green = (b2RGB & 0xff00) >> 8;
//				b2Red = (b2RGB & 0xff0000) >> 16;
//				diff += Math.abs(b1Blue - b2Blue) + Math.abs(b1Green - b2Green) + Math.abs(b1Red - b2Red);
//			}
//		}
//		return diff;
//	}
//
//	private long testCompareWithGetPixelInRows(BufferedImage b1, BufferedImage b2) {
//		long diff = 0;
//		int b1Blue;
//		int b1Green;
//		int b1Red;
//		int b2Blue;
//		int b2Green;
//		int b2Red;
//		for (int y = 0; y < b1.getHeight(); y++) {
//			for (int x = 0; x < b1.getWidth(); x++) {
//				int b1RGB = b1.getRGB(x, y);
//				int b2RGB = b2.getRGB(x, y);
//				b1Blue = b1RGB & 0xff;
//				b1Green = (b1RGB & 0xff00) >> 8;
//				b1Red = (b1RGB & 0xff0000) >> 16;
//				b2Blue = b2RGB & 0xff;
//				b2Green = (b2RGB & 0xff00) >> 8;
//				b2Red = (b2RGB & 0xff0000) >> 16;
//				diff += Math.abs(b1Blue - b2Blue) + Math.abs(b1Green - b2Green) + Math.abs(b1Red - b2Red);
//			}
//		}
//		return diff;
//	}
//
//	private long testCompareWithRasterInColumns(BufferedImage b1, BufferedImage b2) {
//		int[] b1Pixels = new int[3];
//		int[] b2Pixels = new int[3];
//		Raster b1Data = b1.getData();
//		Raster b2Data = b2.getData();
//		long diff = 0;
//		for (int x = 0; x < b1.getWidth(); x++) {
//			for (int y = 0; y < b1.getHeight(); y++) {
//				b1Data.getPixel(x, y, b1Pixels);
//				b2Data.getPixel(x, y, b2Pixels);
//				diff += Math.abs(b1Pixels[0] - b2Pixels[0]) + Math.abs(b1Pixels[1] - b2Pixels[1]) + Math.abs(b1Pixels[2] - b2Pixels[2]);
//			}
//		}
//		return diff;
//	}
//
//	private long testCompareWithRasterInRows(BufferedImage b1, BufferedImage b2) {
//		int[] b1Pixels = new int[3];
//		int[] b2Pixels = new int[3];
//		Raster b1Data = b1.getData();
//		Raster b2Data = b2.getData();
//		long diff = 0;
//		for (int y = 0; y < b1.getHeight(); y++) {
//			for (int x = 0; x < b1.getWidth(); x++) {
//				b1Data.getPixel(x, y, b1Pixels);
//				b2Data.getPixel(x, y, b2Pixels);
//				diff += Math.abs(b1Pixels[0] - b2Pixels[0]) + Math.abs(b1Pixels[1] - b2Pixels[1]) + Math.abs(b1Pixels[2] - b2Pixels[2]);
//			}
//		}
//		return diff;
//	}
}
