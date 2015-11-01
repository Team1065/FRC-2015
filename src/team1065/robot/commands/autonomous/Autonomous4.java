package team1065.robot.commands.autonomous;

import team1065.robot.Robot;
import team1065.robot.RobotMap;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class Autonomous4 extends CommandGroup {
	
	public Autonomous4()
	{
		//3 totes moving 2 bins out of the way in the process.
    	// Yellow tote 1
    	addParallel(new MoveElevatorToPosition(RobotMap.elevatorPosition3, 2));
    	addSequential(new MecanumToDistance(0.6,Robot.drive.InchToCount(40)));
    	//addSequential(new RotateToDistance(0.3,165));
    	addSequential(new DriveToDistance(0.3,Robot.drive.InchToCount(30)));
    	//addSequential(new MecanumToDistance(-0.6,Robot.drive.InchToCount(40)));
    	addSequential(new RotateToDistance(-0.3,80));//rotate towards the second tote
    	addSequential(new IntakeIn(1,.05));
    	addSequential(new DriveToDistance(0.3,Robot.drive.InchToCount(60)));
    	addSequential(new StopAndWait(.05));
    	
    	// Yellow tote 2
    	addParallel(new MoveElevatorToPosition(RobotMap.elevatorPosition0, 2));
    	addSequential(new RotateToDistance(0.3,150));
    	addSequential(new MecanumToDistance(0.6,Robot.drive.InchToCount(40)));
    	//addSequential(new DriveToDistance(0.3,Robot.drive.InchToCount(30)));
    	addParallel(new MoveElevatorToPosition(RobotMap.elevatorPosition3, 3));
    	addSequential(new DriveToDistance(0.3,Robot.drive.InchToCount(30)));
    	//addSequential(new MecanumToDistance(-0.6,Robot.drive.InchToCount(40)));
    	//addSequential(new DriveToDistance(0.3,Robot.drive.InchToCount(40)));
    	addSequential(new RotateToDistance(-0.3,50));//rotate towards the third tote
    	addSequential(new DriveToDistance(0.35,Robot.drive.InchToCount(60)));
    	//addSequential(new RotateToDistance(0.3,200));//rotate towards the third tote
    	//addSequential(new DriveToDistance(0.35,Robot.drive.InchToCount(27)));
    	addSequential(new StopAndWait(.05));
    	
    	//Yellow tote 3
    	addParallel(new MoveElevatorToPosition(RobotMap.elevatorPosition0, 2));
    	
    	// Move to AZ and back out
    	addSequential(new RotateToDistance(0.7,720));//speed up?
        addSequential(new DriveToDistance(.8,Robot.drive.InchToCount(55)));//increase?
    	addParallel(new IntakeOut(1,.2));
    	addSequential(new DriveToDistance(.3,Robot.drive.InchToCount(30)));
    	addSequential(new DriveToDistance(-1,Robot.drive.InchToCount(30)));
    	addSequential(new StopAndWait(.2));
	}
}
