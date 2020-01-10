/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class shooting extends SubsystemBase {
  /**
   * Creates a new Shooting.
   */

  private static Solenoid solenoid1 = new Solenoid(0);
  private static Solenoid solenoid2 = new Solenoid(1);
  private static Solenoid solenoid3 = new Solenoid(2);
  private static Solenoid solenoid4 = new Solenoid(3);
  private static Solenoid solenoid5 = new Solenoid(4);
  private static Solenoid solenoid6 = new Solenoid(5);
  private static Joystick m_joystick;

  public static void FireTop() {
    if (m_joystick.getRawButton(Constants.fireSafteyButtonID)) {
      solenoid1.set(true);
      solenoid2.set(true);
      solenoid3.set(true);
    }    
  }

  public static void FireBottom() {
    if (m_joystick.getRawButton(Constants.fireSafteyButtonID)) {
      solenoid4.set(false);
      solenoid5.set(false);
      solenoid6.set(false);
    }
  }
  public static void resetSolenodis() {
    solenoid1.set(false);
    solenoid2.set(false);
    solenoid3.set(false);
    solenoid4.set(false);
    solenoid5.set(false);
    solenoid6.set(false);
  }
  
  public shooting() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }


}
