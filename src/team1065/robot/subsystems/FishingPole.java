package team1065.robot.subsystems;

import team1065.robot.RobotMap;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class FishingPole extends Subsystem {
    
	Solenoid leftActuator, rightActuator;
	
    public FishingPole(){
    	leftActuator = new Solenoid(RobotMap.fishingPoleLeftActuator);
    	rightActuator = new Solenoid(RobotMap.fishingPoleRightActuator);
    }
    
    public void SetActuators(boolean direction){
    	leftActuator.set(direction);
    	rightActuator.set(direction);
    }
    
    public void Retract(){
    	SetActuators(false);
    }
    
    public void Extend(){
    	SetActuators(true);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

