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
public class Autonomous2 extends CommandGroup {
    
    public Autonomous2() {
    	//Pick up Tote 1 (Bump)
		addSequential(new MoveElevatorToPosition(RobotMap.elevatorPosition1, 3));
        addSequential(new StopElevator(0.2));
        addSequential(new RotateToDistance(0.3,540));
        addSequential(new StopAndWait(0.2));
        addSequential(new DriveToDistance(.3,Robot.drive.InchToCount(10)));
        addSequential(new DriveToDistance(.5,Robot.drive.InchToCount(53)));
        addSequential(new DriveToDistance(.3,Robot.drive.InchToCount(10)));
        addSequential(new StopAndWait(0.2));
    }
}