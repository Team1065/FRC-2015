/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package team1065.robot.commands.autonomous;

import team1065.robot.Robot;
import team1065.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author Team1065
 */
public class Autonomous5 extends CommandGroup {
    
    public Autonomous5() {
    	//1 tote and 1 bin
    	Command auto = new Autonomous1();
    	auto.start();
    }
}