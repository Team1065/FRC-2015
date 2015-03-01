/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package team1065.robot.commands.autonomous;

import team1065.robot.Robot;
import team1065.robot.RobotMap;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author Team1065
 */
public class Autonomous3 extends CommandGroup {
    
    public Autonomous3() {
    	//2 totes moving 2 bins out of the way in the process.
    	// Yellow tote 1
    	addParallel(new MoveElevatorToPosition(RobotMap.elevatorPosition3, 2));
    	addSequential(new IntakeOut(1,.05));
    	addSequential(new RotateToDistance(0.3,165));
    	addSequential(new DriveToDistance(0.3,Robot.drive.InchToCount(30)));
    	addSequential(new RotateToDistance(-0.3,200));
    	addSequential(new IntakeIn(1,.05));
    	addSequential(new DriveToDistance(0.3,Robot.drive.InchToCount(50)));
    	addSequential(new StopAndWait(.05));
    	
    	// Yellow tote 2
    	addSequential(new MoveElevatorToPosition(RobotMap.elevatorPosition0, 2));
    	
    	// Move to AZ
    	addSequential(new RotateToDistance(0.3,560));
        addSequential(new DriveToDistance(.5,Robot.drive.InchToCount(65)));
    	addSequential(new StopAndWait(.05));    	
    }
}