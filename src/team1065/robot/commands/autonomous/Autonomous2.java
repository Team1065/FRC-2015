/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package team1065.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author Team1065
 */
public class Autonomous2 extends CommandGroup {
    
    public Autonomous2() {
        //distance can be changed to inches instead of counts if desired
        addSequential(new DriveToDistance(.5,100));
        addSequential(new StopAndWait(.2));
        addSequential(new MoveElevatorToPosition(1.0, 3));
        addSequential(new StopElevator(2));
    }
}