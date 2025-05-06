package org.example;

public class FLACProcessor implements AudioFormat {
    @Override
    public byte[] processAudio(byte[] rawData) {
        return ("DECODED_FLAC_" + new String(rawData)).getBytes();
    }

    @Override
    public boolean isCompatible(byte[] data) {
        String dataString = new String(data);
        return dataString.contains("FLAC");
    }

    @Override
    public String getFormatName() {
        return "FLAC";
    }
}
