package team1065.robot.commands;

import team1065.robot.Robot;
import team1065.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class IntakeControl extends Command {

    public IntakeControl() {
        requires(Robot.intake);
    }

    protected void initialize() {
    }

    protected void execute() {
    	if(Robot.oi.getIntakeOverrideButton()){
    		double stickX = Robot.oi.getIntakeJoystickX();
    		double stickY = Robot.oi.getIntakeJoystickY();
    		
    		if(Math.abs(stickY) > RobotMap.intakeJoystickDeadBand || 
    				Math.abs(stickX) > RobotMap.intakeJoystickDeadBand){
    			if(Math.abs(stickY - RobotMap.elevatorJoystickMiddle) > Math.abs(stickX - RobotMap.elevatorJoystickMiddle)){
    				Robot.intake.in((stickY - RobotMap.elevatorJoystickMiddle)/(RobotMap.elevatorJoystickMiddle - RobotMap.intakeJoystickDeadBand));
    			}
    			else{
    				Robot.intake.rotate((stickX - RobotMap.elevatorJoystickMiddle)/(RobotMap.elevatorJoystickMiddle - RobotMap.intakeJoystickDeadBand));
    			}
    		}
    		else{
    			Robot.intake.stop();
    		}
    	}
    	else{
    		if(Robot.oi.getIntakeInButton()){
    			Robot.intake.in(1);
    		}
    		else if(Robot.oi.getIntakeOutButton()){
    			Robot.intake.out(1);
    		}
    		else{
    			Robot.intake.stop();
    		}
    	}
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    	end();
    }
}
