package org.example;

public class MusicPlayer {
    private AudioSource source;
    private AudioOutput output;
    private AudioFormat format;
    private boolean isPlaying;

    public MusicPlayer() {
        this.source = null;
        this.output = null;
        this.format = null;
        this.isPlaying = false;
    }

    public void setAudioSource(AudioSource source) {
        this.source = source;
        source.connect();
    }

    public void setAudioOutput(AudioOutput output) {
        this.output = output;
        output.initialize();
    }

    public void setAudioFormat(AudioFormat format) {
        this.format = format;
    }

    public void playTrack(String trackId) {
        if (source == null || output == null || format == null) {
            throw new IllegalStateException("All components must be set before playing.");
        }

        byte[] rawData = source.getAudioData(trackId);
        if (!format.isCompatible(rawData)) {
            throw new IllegalArgumentException("Incompatible audio format.");
        }

        byte[] processedData = format.processAudio(rawData);
        output.playAudio(processedData);
        isPlaying = true;
    }

    public void stop() {
        if (output != null && isPlaying) {
            output.stop();
            isPlaying = false;
        }
    }

    public String getCurrentConfiguration() {
        return "MusicPlayer Configuration:" +
                "\n- Source: " + (source != null ? source.getSourceName() : "none") +
                "\n- Output: " + (output != null ? output.getDeviceName() : "none") +
                "\n- Format: " + (format != null ? format.getFormatName() : "none");
    }
}
