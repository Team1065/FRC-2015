/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package team1065.robot.commands.autonomous;

import team1065.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;


/**
 *
 * @author atenc_000
 */

//set speed to a negative value [-1,0) to go backwards. distance should allways be positive
public class MecanumToDistance extends Command {
    private double speed, distance;
    public MecanumToDistance(double speed, double distance) {
        requires(Robot.drive);
        this.speed = speed;
	this.distance = distance;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        Robot.drive.resetEncoders();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drive.mecanumFeedback(speed-Robot.drive.getEncoderDifference(), speed+Robot.drive.getEncoderDifference());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Math.abs(Robot.drive.avgEncoderCount()) >= distance;
    }

    // Called once after isFinished returns true
    protected void end() {
        Robot.drive.tankDrive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
