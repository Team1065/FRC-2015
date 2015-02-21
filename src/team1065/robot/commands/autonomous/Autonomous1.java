package team1065.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import team1065.robot.Robot;
import team1065.robot.RobotMap;

public class Autonomous1 extends CommandGroup {
	public Autonomous1()
	{
		//Pick up Tote 1 and drive to AZ
		addSequential(new MoveElevatorToPosition(RobotMap.elevatorPosition1, 3));
        addSequential(new StopElevator(0.2));
        addSequential(new RotateToDistance(0.3,360));
        addSequential(new StopAndWait(0.2));
        addSequential(new DriveToDistance(.3,Robot.drive.InchToCount(10)));
        addSequential(new DriveToDistance(.5,Robot.drive.InchToCount(90)));
        addSequential(new DriveToDistance(.3,Robot.drive.InchToCount(10)));
        addSequential(new StopAndWait(0.2));
	}
}
