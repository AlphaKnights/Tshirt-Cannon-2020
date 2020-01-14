/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static final class LauncherConstants
    {
        public static final int TOP_LEFT_SOLENOID_PORT = 0;
        public static final int TOP_MID_SOLENOID_PORT = 1;
        public static final int TOP_RIGHT_SOLENOID_PORT = 2;
        public static final int BOT_LEFT_SOLENOID_PORT = 3;
        public static final int BOT_MID_SOLENOID_PORT = 4;
        public static final int BOT_RIGHT_SOLENOID_PORT = 5;
    }

    public static final class DrivetrainConstants {
        public static final int leftMotor1ID = 1;
        public static final int leftMotor2ID = 2;
        public static final int RightMotor1ID = 3;
        public static final int RightMotor2ID = 0;
    }

    public static final class OIConstants {
        public static final int joystickPort = 0;
        public static final int driveJoystickButtonID = 3;
        public static final int fireTopRowButtonID = 5;
        public static final int fireBottomRowButtonID = 6;
        public static final int fireSafetyButtonID = 1;
    }
}
