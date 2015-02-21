package team1065.robot.commands.autonomous;

import team1065.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class IntakeIn extends Command {
	double speed;
    public IntakeIn(double speed, double time) {
        requires(Robot.intake);
        this.setTimeout(time);
        this.speed = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.intake.in(speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return this.isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
