package team1065.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;
import team1065.robot.Robot;

/**
 *
 * @author atenc_000
 */

//set speed to a negative value [-1,0) to go anti-clockwise. distance should always be positive
public class RotateToDistance extends Command {
    private double speed, distance;
    public RotateToDistance(double speed, double distance) {
        requires(Robot.drive);
	this.speed = speed;
	this.distance = distance;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        Robot.drive.startEncoders();
        Robot.drive.resetEncoders();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        Robot.drive.driveStraight(speed, true);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Math.abs(Robot.drive.avgEncoderAbsCount()) >= distance;
    }

    // Called once after isFinished returns true
    protected void end() {
        Robot.drive.tankDrive(0, 0);
        Robot.drive.stopEncoders();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}