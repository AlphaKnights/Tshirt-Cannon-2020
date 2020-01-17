package frc.robot.subsystems;


import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.Constants.LauncherConstants.*;

public class LauncherSubsystem extends SubsystemBase {

// Any variables/fields used in the constructor must appear before the "INSTANCE" variable
// so that they are initialized before the constructor is called.

  private final Solenoid topLeft = new Solenoid(TOP_LEFT_SOLENOID_PORT);
  private final Solenoid topMid = new Solenoid(TOP_MID_SOLENOID_PORT);
  private final Solenoid topRight = new Solenoid(TOP_RIGHT_SOLENOID_PORT);
  private final Solenoid botLeft = new Solenoid(BOT_LEFT_SOLENOID_PORT);
  private final Solenoid botMid = new Solenoid(BOT_MID_SOLENOID_PORT);
  private final Solenoid botRight = new Solenoid(BOT_RIGHT_SOLENOID_PORT);

  private final Compressor compressor = new Compressor();

  /**
   * The Singleton instance of this LauncherSubsystem. External classes should
   * use the {@link #getInstance()} method to get the instance.
   */
  private final static LauncherSubsystem INSTANCE = new LauncherSubsystem();

  /**
   * Creates a new instance of this LauncherSubsystem.
   * This constructor is private since this class is a Singleton. External classes
   * should use the {@link #getInstance()} method to get the instance.
   */
  private LauncherSubsystem() {
    compressor.setClosedLoopControl(false);
    // TODO: Set the default command, if any, for this subsystem by calling setDefaultCommand(command)
    //       in the constructor or in the robot coordination class, such as RobotContainer.
    //       Also, you can call addChild(name, sendableChild) to associate sendables with the subsystem
    //       such as SpeedControllers, Encoders, DigitalInputs, etc.
  }

  public void OpenTop() {
    topLeft.set(true);
    topMid.set(true);
    topRight.set(true);
  }

  public void CloseTop() {
    topLeft.set(false);
    topMid.set(false);
    topRight.set(false);
  }

  public void OpenBot() {
    botLeft.set(true);
    botMid.set(true);
    botRight.set(true);
  }

  public void CloseBot() {
    botLeft.set(false);
    botMid.set(false);
    botRight.set(false);
  }

  /**
   * Returns the Singleton instance of this LauncherSubsystem. This static method
   * should be used -- {@code LauncherSubsystem.getInstance();} -- by external
   * classes, rather than the constructor to get the instance of this class.
   */
  public static LauncherSubsystem getInstance() {
    return INSTANCE;
  }

}

