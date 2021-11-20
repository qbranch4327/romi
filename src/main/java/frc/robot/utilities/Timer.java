package frc.robot.utilities;

import java.time.LocalTime;

public class Timer {
    private final LocalTime endTime;

    public Timer(int milliseconds) {
        this.endTime = LocalTime.now().plusSeconds(toSeconds(milliseconds));
        System.out.println(endTime);
    }

    private long toSeconds(int milliseconds) {
        return milliseconds / 1000;
    }

    public boolean hasElapsed() {
        var now = LocalTime.now();
        return now.equals(this.endTime) || now.isAfter(this.endTime);
    }
}
