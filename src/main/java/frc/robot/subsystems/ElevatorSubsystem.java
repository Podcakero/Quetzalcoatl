/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import javax.lang.model.util.ElementScanner6;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Implements the methods to move the elevator and get the current position
 * of the elevator.
 */
public class ElevatorSubsystem extends Subsystem 
{
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() 
  {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  /**
   * Moves the elevator up at *full* speed
   */
  public void elevatorUp()
  {
    moveElevator(RobotMap.ELEVATOR_FULL_SPEED * RobotMap.ELEVATOR_SPEED_MODIFIER);
  }

  /**
   * Moves the elevator down at *full* speed
   */
  public void elevatorDown()
  {
    moveElevator(-RobotMap.ELEVATOR_FULL_SPEED * RobotMap.ELEVATOR_SPEED_MODIFIER);
  }

  /**
   * Moves the elevator up/down at the given speed. Positive for up, Negative for down
   * @param speed
   */
  public void moveElevator(double speed)
  {
    RobotMap.elevatorSparkMax.set(speed * RobotMap.ELEVATOR_SPEED_MODIFIER);
  }

  public double getEncoderPosition()
  {
    return RobotMap.elevatorEncoder.getPosition();
  }

  public void xboxElevatorControl()
  {
    //Left Trigger goes down
    if (RobotMap.assistantDriverController.getTriggerAxis(Hand.kLeft) > 0.01)
    {
      moveElevator(-RobotMap.assistantDriverController.getTriggerAxis(Hand.kLeft));
    }
    //Right Trigger goes up
    else if (RobotMap.assistantDriverController.getTriggerAxis(Hand.kRight) > 0.01)
    {
      moveElevator(RobotMap.assistantDriverController.getTriggerAxis(Hand.kRight));
    }
    else 
      moveElevator(RobotMap.ELEVATOR_STOP_SPEED);
  }
}
