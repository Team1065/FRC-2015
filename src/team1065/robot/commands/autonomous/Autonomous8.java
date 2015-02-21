package team1065.robot.commands.autonomous;

import team1065.robot.Robot;
import team1065.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Autonomous8 extends CommandGroup {
    
    public  Autonomous8() {
    	//ADDITIONAL AUTO MODE
    	Command auto = new Autonomous1();
    	auto.start();
    }
}
