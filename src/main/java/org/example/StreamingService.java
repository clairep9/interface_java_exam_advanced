package org.example;

public class StreamingService implements AudioSource {
    private final String serviceName;
    private boolean connected;

    public StreamingService(String serviceName) {
  this.serviceName= serviceName;
    }

    @Override
    public boolean connect() {
        connected = true;
      return true;
    }

    @Override
    public void disconnect() {
      connected = false;
    }

    @Override
    public byte[] getAudioData(String trackId) {
        return ("STREAMING_DATA_" + trackId).getBytes();
    }

    @Override
    public String getSourceName() {
       return serviceName;
    }
}