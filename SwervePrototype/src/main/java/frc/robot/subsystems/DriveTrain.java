/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.DriveArcadeSwerve;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class DriveTrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public TalonSRX AvanceFwdLeft = new TalonSRX(1);
  public TalonSRX SwerveFwdLeft = new TalonSRX(3);

  public TalonSRX AvanceBwdLeft = new TalonSRX(2);
  public TalonSRX SwerveBwdLeft = new TalonSRX(4);

  public TalonSRX AvanceFwdRight = new TalonSRX(8);
  public TalonSRX SwerveFwdRight = new TalonSRX(7);

  public TalonSRX AvanceBwdRight = new TalonSRX(6);
  public TalonSRX SwerveBwdRight = new TalonSRX(5);
  
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new DriveArcadeSwerve());
  }
}
