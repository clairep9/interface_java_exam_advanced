package org.example;

public class WAVProcessor implements AudioFormat {
    @Override
    public byte[] processAudio(byte[] rawData) {
        return ("DECODED_WAV_" + new String(rawData)).getBytes();
    }

    @Override
    public boolean isCompatible(byte[] data) {
        return new String(data).contains("WAV");
    }

    @Override
    public String getFormatName() {
        return "WAV";
    }
}
