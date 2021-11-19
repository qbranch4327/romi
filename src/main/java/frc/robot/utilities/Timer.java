package frc.robot.utilities;

import java.time.LocalTime;

public class Timer {
    private final LocalTime endTime;

    public Timer(int milliseconds) {
        this.endTime = LocalTime.now().plusNanos(toNanos(milliseconds));
    }

    private long toNanos(int milliseconds) {
        return milliseconds * 1000000;
    }

    public boolean hasElapsed() {
        var now = LocalTime.now();
        return now.equals(this.endTime) || now.isAfter(this.endTime);
    }
}
