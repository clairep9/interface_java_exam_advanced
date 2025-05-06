package org.example;

public class Speakers implements AudioOutput {
    private boolean initialized;

    @Override
    public boolean initialize() {
        initialized = true;
        return true;
    }

    @Override
    public void playAudio(byte[] audioData) {
        if (!initialized) {
            throw new IllegalStateException("Speakers not initialized.");
        }
        System.out.println("Playing through speakers: " + new String(audioData));
    }

    @Override
    public void stop() {
        System.out.println("Stopping playback on speakers.");
    }

    @Override
    public String getDeviceName() {
        return "Computer Speakers";
    }
}
