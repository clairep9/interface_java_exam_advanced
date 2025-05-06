package org.example;

public class Headphones implements AudioOutput {
    private boolean initialized;

    @Override
    public boolean initialize() {
        initialized = true;
        return true;
    }

    @Override
    public void playAudio(byte[] audioData) {
        if (initialized) {
            System.out.println("Headphones playing: " + new String(audioData));
        } else {
            System.out.println("Headphones not initialized.");
        }
    }

    @Override
    public void stop() {
        if (initialized) {
            System.out.println("Headphones stopped.");
        }
    }

    @Override
    public String getDeviceName() {
        return "Headphones";
    }
}
