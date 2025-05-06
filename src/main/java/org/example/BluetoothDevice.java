package org.example;

public class BluetoothDevice implements AudioOutput {
    private final String deviceName;
    private boolean initialized;

    public BluetoothDevice(String deviceName) {
        this.deviceName = deviceName;
    }

    @Override
    public boolean initialize() {
        initialized = true;
        return true;
    }

    @Override
    public void playAudio(byte[] audioData) {
        if (!initialized) {
            throw new IllegalStateException("Bluetooth device not initialized.");
        }
        System.out.println("Playing through Bluetooth: " + new String(audioData));
    }

    @Override
    public void stop() {
        System.out.println("Stopping playback on Bluetooth device.");
    }

    @Override
    public String getDeviceName() {
        return "Bluetooth: " + deviceName;
    }
}
