package team1065.robot.commands;

import team1065.robot.Robot;
import team1065.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveWithJoysticks extends Command {

    public DriveWithJoysticks() {
    	requires (Robot.drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drive.startEncoders();
    	Robot.drive.resetEncoders();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double leftY, rightY, averageY;
        
        double rightX = Robot.oi.getRightX();

        if(Robot.oi.getHalfSpeedButton()){
        	//full speed
        	leftY = Robot.oi.getleftJoystickY()/2;
            rightY = Robot.oi.getrightJoystickY()/2;
            averageY = Robot.oi.getYAverage()/2;
            
        }
        else{
        	//reduced speed
        	leftY = Robot.oi.getleftJoystickY() * Robot.pref.getDouble("regularSpeedPercentage", RobotMap.regularSpeedPercentage);
            rightY = Robot.oi.getrightJoystickY() * Robot.pref.getDouble("regularSpeedPercentage", RobotMap.regularSpeedPercentage);
            averageY = Robot.oi.getYAverage() * Robot.pref.getDouble("regularSpeedPercentage", RobotMap.regularSpeedPercentage);
        }

        double joystickDiff = Math.abs(leftY-rightY);
        
        if(Robot.oi.getMecanumButton())
        {
            if(Math.abs(rightY)<.4 && Math.abs(leftY)<.2)
            {
            	Robot.drive.mecanumFeedback(rightX-Robot.drive.getEncoderDifference(), rightX+Robot.drive.getEncoderDifference()); 
            }
            else
            {
            	Robot.drive.mecanumDriveCartesian(rightX, -rightY, leftY,0);
            }
        }
        else
        {
            //Drive Straight Active if:
            //1) Both Joysticks are going in the same direction
            //2) The Difference between the Joysticks is not larger than a percentage of the set speed
            //As the speed is higher the is a greater forgiveness for error
            if((leftY * rightY >= 0) && joystickDiff < (Math.abs(averageY) * Robot.pref.getDouble("DriveStraightPercentage", RobotMap.driveStraightThresholdPercentage)))
            {
            	Robot.drive.driveStraight(averageY);
            }
            else
            {
            	Robot.drive.tankDrive(leftY, rightY);
            }
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
