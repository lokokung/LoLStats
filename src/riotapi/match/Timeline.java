package riotapi.match;

import java.util.ArrayList;

public class Timeline {
    private long frameInterval;
    private ArrayList<Frame> frames;

    public long get_frameInterval() {
        return frameInterval;
    }

    public void set_frameInterval(long frameInterval) {
        this.frameInterval = frameInterval;
    }

    public ArrayList<Frame> get_frames() {
        return frames;
    }

    public void set_frames(ArrayList<Frame> frames) {
        this.frames = frames;
    }
}