/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.commands.*;
import frc.robot.Constants;

public class drivetrain extends SubsystemBase {
  private final WPI_TalonSRX leftMotor1 = new WPI_TalonSRX(Constants.leftMotor1ID);
  private final WPI_TalonSRX leftMotor2 = new WPI_TalonSRX(Constants.leftMotor2ID);
  private final WPI_TalonSRX rightMotor1 = new WPI_TalonSRX(Constants.rightMotor1ID);
  private final WPI_TalonSRX rightMotor2 = new WPI_TalonSRX(Constants.rightMotor2ID);
  private final SpeedControllerGroup leftMotors = new SpeedControllerGroup(leftMotor1, leftMotor2);
  private final SpeedControllerGroup rightMotors = new SpeedControllerGroup(rightMotor1, rightMotor2);
  private final DifferentialDrive m_drive = new DifferentialDrive(leftMotors, rightMotors);

  private Joystick m_Joystick;
  private drivetrain m_Drivetrain;



  public void alphaDriveArcade(Double speed, Double rotate) {
    m_drive.arcadeDrive(speed, rotate);
  }

  public void alphaDriveTank(Double lSpeed, Double rSpeed) {
    m_drive.tankDrive(lSpeed, rSpeed);
  }

  public void initDefaultCommand() {
    setDefaultCommand(new DefaultDrive(m_Drivetrain, m_Joystick));
  }



  /**
   * Creates a new drivetrain.
   */
  public drivetrain() {
    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
