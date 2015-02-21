package team1065.robot.subsystems;

import team1065.robot.RobotMap;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Intake extends Subsystem {
    
	private Talon leftMotor, rightMotor;
	
    public Intake(){
    	leftMotor = new Talon(RobotMap.leftIntakeMotor);
    	rightMotor = new Talon(RobotMap.rightIntakeMotor);
    }
    
    public void SetMotors(double lSpeed, double rSpeed){
    	leftMotor.set(lSpeed);
    	rightMotor.set(rSpeed);
    }
    
    public void in(double speed){
    	SetMotors(speed, -speed);
    }
    
    public void out(double speed){
    	SetMotors(-speed, speed);
    }
    
    public void stop(){
    	SetMotors(0, 0);
    }
    
    public void rotate(double speed){
    	SetMotors(speed, speed);
    }

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
}

