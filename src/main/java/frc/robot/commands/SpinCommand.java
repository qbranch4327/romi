package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.RomiDrivetrain;
import frc.robot.utilities.Timer;

public class SpinCommand extends CommandBase {
    private final RomiDrivetrain drivetrain;
    private Timer timer;
    private final int duration;

    public SpinCommand(RomiDrivetrain drivetrain, int milliseconds) {
        this.drivetrain = drivetrain;
        this.duration = milliseconds;
    }

    @Override
    public void initialize() {
        this.timer = new Timer(this.duration);
    }

    @Override
    public void execute() {
        this.drivetrain.spin(.5);
    }

    @Override
    public boolean isFinished() {
      return this.timer.hasElapsed();
    }
}
