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
public class Autonomous5 extends CommandGroup {
    
    public Autonomous5() {
    	
    	
    	//1 tote and 1 bin
    	//Pick up Tote 1
        addSequential(new MoveElevatorToPosition(RobotMap.elevatorPosition1, 3));
        addSequential(new DriveToDistance(-0.3,Robot.drive.InchToCount(3)));
        addSequential(new StopAndWait(0.2));
        
        //Move to Bin 1
        addSequential(new RotateToDistance(0.3,360));
        addSequential(new StopAndWait(0.2));
        addSequential(new DriveToDistance(0.3,Robot.drive.InchToCount(26)));
        addSequential(new StopAndWait(0.2));
        addSequential(new MecanumToDistance(-0.3,Robot.drive.InchToCount(30)));
        addSequential(new StopAndWait(0.2));
        
        //Pick up Bin 1
        addSequential(new DriveToDistance(-0.3,Robot.drive.InchToCount(5)));
        addSequential(new StopAndWait(0.2));
        addSequential(new MoveElevatorToPosition(RobotMap.elevatorPosition0, 3));
        addSequential(new MoveElevatorToPosition(RobotMap.elevatorPosition2, 3));
        addSequential(new DriveToDistance(.3,Robot.drive.InchToCount(10)));
        addSequential(new DriveToDistance(.5,Robot.drive.InchToCount(90)));
        addSequential(new DriveToDistance(.3,Robot.drive.InchToCount(10)));
        addSequential(new StopAndWait(2));
    }
}