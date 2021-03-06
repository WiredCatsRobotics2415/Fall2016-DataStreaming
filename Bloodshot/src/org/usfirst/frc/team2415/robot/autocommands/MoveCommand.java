package org.usfirst.frc.team2415.robot.autocommands;

import edu.wpi.first.wpilibj.command.CommandGroup;

//import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class MoveCommand extends CommandGroup {
	
	private final double F = 12;
	double x, y, thetaT, distance;
	
	public MoveCommand(double x, double y){
		this.x = x*F;
    	this.y = y*F;
    	distance = Math.sqrt(this.x*this.x + this.y*this.y);
    	thetaT = -Math.toDegrees(Math.atan2(this.x, this.y));
    	
    	addSequential(new TurnCommand(thetaT));
    	addSequential(new StraightDriveCommand(distance, .5));
	}
	
    public MoveCommand(double x, double y, double theta) {
    	this.x = x*F;
    	this.y = y*F;
    	distance = Math.sqrt(this.x*this.x + this.y*this.y);
    	thetaT = -Math.toDegrees(Math.atan2(this.x, this.y));
    	
    	addSequential(new TurnCommand(thetaT));
    	addSequential(new StraightDriveCommand(distance, .5));
    	addSequential(new TurnCommand(theta));
    }
}
