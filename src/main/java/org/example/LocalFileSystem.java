package org.example;

public class LocalFileSystem implements AudioSource {
    private final String rootDirectory;
    private boolean mounted;

    public LocalFileSystem(String rootDirectory) {
        this.rootDirectory = rootDirectory;
    }

    @Override
    public boolean connect() {
        mounted = true;
        return true;
    }

    @Override
    public void disconnect() {
        mounted = false;
    }

    @Override
    public byte[] getAudioData(String trackId) {
        return ("LOCAL_FILE_DATA_" + trackId).getBytes();
    }

    @Override
    public String getSourceName() {
        return "Local Files (" + rootDirectory + ")";
    }
}
