/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import components.utilities.FormatChecker;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.RobotMap;

public class TargetingStage1RotationCommand extends Command 
{
  private String data;
  private String newData;

  public TargetingStage1RotationCommand() 
  {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(RobotMap.driveTrainSubsystem);

    data = "";
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() 
  {
    data = RobotMap.arduino.readString();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() 
  {
    //System.out.print("Stage1\t");
    //System.out.println("Data: " + data + "\tnewData: " + newData);4
    if (data.length() > 0)
      if (FormatChecker.canParseDouble(data))
        RobotMap.driveTrainSubsystem.arcadeDrive(RobotMap.DRIVETRAIN_FULL_STOP, Double.parseDouble(data) / RobotMap.DRIVETRAIN_CAMERA_TARGETING_SPEED_MODIFIER, RobotMap.DRIVETRAIN_FULL_STOP);
    //System.out.println("Data: " + data + "\tnewData: " + newData);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() 
  {
    data = RobotMap.arduino.readString();
    if (data.length() > 0)
      if (data.substring(0, 1).equals("D"))
        return true;
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() 
  {
    RobotMap.driveTrainSubsystem.arcadeDrive(RobotMap.DRIVETRAIN_FULL_STOP, RobotMap.DRIVETRAIN_FULL_STOP, RobotMap.DRIVETRAIN_FULL_STOP);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() 
  {
  }
}
