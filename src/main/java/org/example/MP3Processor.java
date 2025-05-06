package org.example;

public class MP3Processor implements AudioFormat {
    @Override
    public byte[] processAudio(byte[] rawData) {
        return ("DECODED_MP3_" + new String(rawData)).getBytes();
    }

    @Override
    public boolean isCompatible(byte[] data) {
        return new String(data).toUpperCase().contains("MP3");
    }

    @Override
    public String getFormatName() {
        return "MP3";
    }
}
