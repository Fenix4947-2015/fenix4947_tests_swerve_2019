/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

/**
 * An example command.  You can replace me with your own command.
 */
public class DriveArcadeSwerve extends Command {
  Joystick exampleStick = new Joystick(0);
  
  public DriveArcadeSwerve() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.driveTrain);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
      double joyX = exampleStick.getX();
      double joyY = exampleStick.getY();
      
      Robot.driveTrain.AvanceFwdLeft.set(ControlMode.PercentOutput, joyX);
      Robot.driveTrain.SwerveFwdLeft.set(ControlMode.PercentOutput, joyY);

      Robot.driveTrain.AvanceBwdLeft.set(ControlMode.PercentOutput, joyX);
      Robot.driveTrain.SwerveBwdLeft.set(ControlMode.PercentOutput, joyY);

      Robot.driveTrain.AvanceFwdRight.set(ControlMode.PercentOutput, joyX);
      Robot.driveTrain.SwerveFwdRight.set(ControlMode.PercentOutput, joyY);

      Robot.driveTrain.AvanceBwdRight.set(ControlMode.PercentOutput, joyX);
      Robot.driveTrain.SwerveBwdRight.set(ControlMode.PercentOutput, joyY);


      
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.driveTrain.AvanceFwdLeft.set(ControlMode.PercentOutput, 0.0);
      Robot.driveTrain.SwerveFwdLeft.set(ControlMode.PercentOutput, 0.0);

  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
