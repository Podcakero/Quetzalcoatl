/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.kauailabs.navx.frc.AHRS;
import com.revrobotics.*;
import com.revrobotics.CANDigitalInput.LimitSwitch;
import com.revrobotics.CANDigitalInput.LimitSwitchPolarity;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.*;
import frc.robot.subsystems.*;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;

  //Hardware IDs//
    //Controllers
    /**
     * The number assigned to the driver xbox controller when it's plugged in
     */
    public static final int DRIVER_CONTROLLER_PORT = 0;
    /**
     * The number assigned to the assistant driver xbox controller when it's plugged into the computer
     */
    public static final int ASSISTANT_DRIVER_CONTROLLER_PORT = 2;
    /**
     * The number assigned to the driver's left joystick when using joystick driver
     */
    public static final int LEFT_DRIVER_JOYSTICK_PORT = 0;
    /**
     * The number assigned to the driver's right joystick when using joystick driver
     */
    public static final int RIGHT_DRIVER_JOYSTICK_PORT = 1;

    //Drivetrain//
    /**
     * The CAN ID assigned to the left front talon
     */
    public static final int LEFT_FRONT_TALON_ID = 1;
    /**
     * The CAN ID assigned to the right front talon
     */
    public static final int RIGHT_FRONT_TALON_ID = 2;
    /**
     * The CAN ID assigned to the left back talon
     */
    public static final int LEFT_BACK_TALON_ID = 3;
    /**
     * The CAN ID assigned to the right back talon
     */
    public static final int RIGHT_BACK_TALON_ID = 4;
    /**
     * The CAN ID assigned to the center talon
     */
    public static final int CENTER_TALON_ID = 5;

    //Elevator//
    /**
     * The CAN ID assigned to the elevator spark max
     */
    public static final int ELEVATOR_SPARK_MAX_ID = 6;

    //Manipulator//
      //Cargo Intake
        //Manipulator Talon
        /**
         * The CAN ID assigned to the intake
         */
        public static final int INATKE_TALON_ID = 7;

        //Manipulator Micro Switch
        /**
         * The DIO port on the roborio which the ball sucky wucky is plugged into
         */
        public static final int BALL_INTAKE_STOP_PORT = 2;

      //Hatch Holder
        //Hatch Holder Talon
        /**
         * The CAN ID assigned to the hatch holder talon
         */
        public static final int HATCH_HOLDER_TALON_ID = 8;

        //Hatch Holder Micro Switches
        /**
         * The DIO port on the roborio into which the hatch holder's upper position limit is to be plugged into
         */
        public static final int HATCH_HOLDER_UPPER_POSITION_LIMIT_SWITCH_PORT = 3;
        /**
         * The DIO port on the roborio into which the hatch holder's middle position limit is to be plugged into
         */
        public static final int HATCH_HOLDER_MIDDLE_POSITION_LIMIT_SWITCH_PORT = 4;
        /**
         * The DIO port on the roborio into which the hatch holder's middle position limit is to be plugged into
         */
        public static final int HATCH_HOLDER_LOWER_POSITION_LIMIT_SWITCH_PORT = 5;

      //Elevator Limit switches
      /**
       * The DIO port on the roborio into which the Lower Elevator limit switch is to be plugged into
       */
      public static final int LOWER_ELEVATOR_LIMIT_SWTICH_PORT = 0;
      /**
       * The DIO port on the roborio into which the Upper Elevator limit switch is to be plugged into
       */
      public static final int UPPER_ELEVATOR_LIMIT_SWTICH_PORT = 1;

  //Constants//
    //Controllers//
    /**
     * The POV ID of the dpad on the xbox controller
     */
    public static final int DPAD_ID = 0;
    /**
     * The value returned of the getPov() method if the dpad isn't pressed
     */
    public static final int DPAD_NOT_PRESSED = -1;
    /**
     * The value returned of the getPov() method if up on the dpad is pressed
     */
    public static final int DPAD_UP = 0;
    /**
     * The value returned of the getPov() method if right on the dpad is pressed
     */
    public static final int DPAD_RIGHT = 90;
    /**
     * The value returned of the getPov() method if bottom on the dpad is pressed
     */
    public static final int DPAD_BOTTOM = 180;
    /**
     * The value returned of the getPov() method if left on the dpad is pressed
     */
    public static final int DPAD_LEFT = 270;

    //Drivetrain Misc Constants//
    //public static final int DRIVETRAIN_ENCODER_TICKS_PER_REVOLUTION = 42;
    //public static final int DRIVETRAIN_WHEEL_DIAMETER = 4;

    //Drivetrain Speed Constants//
    /**
     * The value by which any speed being sent to the drivetrain will be multiplied by
     */
    public static final double DRIVETRAIN_SPEED_MODIFIER = 1.0;
    /**
     * The value by which any speed being sent to the center wheel will be multiplied by
     */
    public static final double DRIVETRAIN_STRAFE_SPEED_MODIFIER = 0.5;
    /**
     * @deprecated replaced by general full speed modifier |
     * full speed value assigned to drive train
     */
    public static final double DRIVETRAIN_FULL_SPEED = 1.0;
    /**
     * @deprecated replaced by general stop speed modifier |
     * stop speed assigned to drive train
     */
    public static final double DRIVETRAIN_STOP_SPEED = 0.0;
    /**
     * What the value returned by the arduino will be divided by to determine speed
     */
    public static final double DRIVETRAIN_CAMERA_TARGETING_SPEED_MODIFIER = 10.0;
    /**
     * What the value returned by the arduino will be divided by to determine strafe speed
     */
    public static final double DRIVETRAIN_CAMERA_TARGETING_STRAFE_SPEED_MODIFIER = 100.0;
    /**
     * The modifier that the rangefinder value will be divided by to determine speed
     */
    public static final double DRIVETRAIN_RANGEFINDER_TARGETING_SPEED_MODIFIER = 100.0; 

    //Elevator Constants//
    /**
     * The modifier that the elevator value will by divided by to determine speed
     */
    public static final double ELEVATOR_SPEED_MODIFIER = 1.0;
    /**
     * The value set to the elevator encoder
     */
    public static final double ELEVATOR_ENCODER_DEFAULT_POSITION = 0.0;
    /**
     * What the difference between the elevator target and current elevator position will be divided by to determine speed
     */
    public static final double ELEVATOR_ENCODER_TARGET_SPEED_MODIFIER = 100.0;
    /**
     * @deprecated replaced by general full speed modifier |
     * full speed assigned to elevator
     */
    public static final double ELEVATOR_FULL_SPEED = 1.0;
    /**
     * @deprecated replaced by general stop speed modifier |
     * stop speed assigned to elevator
     */
    public static final double ELEVATOR_STOP_SPEED = 0.0;
    /**
     * Time elevator take to go from 0 speed to full speed
     */
    public static final double ELEVATOR_RAMP_TIME = 0.1;
    /**
     * Value that makes the elevator not move
     */
    public static final double ELEVATOR_CONTROLLER_DEADZONE = 0.05;
    /**
     * The value assigned to the speed at which the elevator moves during autonomous
     */
    public static final double ELEVATOR_AUTONOMOUS_SPEED = 0.5;
    /**
     * Slows the elevator when it is close to the limit
     */
    public static final double ELEVATOR_APPROACHING_LOWER_LIMIT_SPEED_MODIFIER = 0.1;
    /**
     * The lowest encoder value for the elevator
     */
    public static final double ELEVATOR_LOWER_ENCODER_LIMIT = 5.0;
    /**
     * The highest encoder value for the elevator
     */
    public static final double ELEVATOR_UPPER_ENCODER_LIMIT = 10000;
    /**
     * Encoder value for the level one hatch
     */
    public static final double ELEVATOR_LEVEL_1_HATCH_VALUE = 0.0;
    /**
     * Encoder value for the level two hatch
     */
    public static final double ELEVATOR_LEVEL_2_HATCH_VALUE = 64.0;
        /**
     * Encoder value for the level three hatch
                           */
    public static final double ELEVATOR_LEVEL_3_HATCH_VALUE = 129.0;
    /**
     * Encoder value for the level one cargo
     */
    public static final double ELEVATOR_LEVEL_1_CARGO_VALUE = 0.0;
    /**
     * Encoder value for the level two cargo
     */
    public static final double ELEVATOR_LEVEL_2_CARGO_VALUE = 0.0;
    /**
     * Encoder value for the level three cargo
     */
    public static final double ELEVATOR_LEVEL_3_CARGO_VALUE = 0.0;

    //Manipulator Constants//
      //Cargo Intake
      /**
       * @deprecated replaced by general full speed modifier |
       * full speed assigned to manipulator
       */
      public static final double MANIPULATOR_FULL_SPEED = 1.0;
      /**
       * default speed assigned to manipulator
       */
      public static final double MANIPULATOR_DEFAULT_SPEED = 1.0; 
      /**
       * Value assigned to the time to release cargo
       */
      public static final double MANIPULATOR_TIME_TO_RELEASE_CARGO = 1.0;
      /**
       * @deprecated replaced by general stop speed modifier |
       * stop speed assigned to manipulator
       */
      public static final double MANIPULATOR_STOP_SPEED = 0.0;

      /**
       * The slow speed for intake
       */
      public static final double MANIPULATOR_SLOW_SPEED = 0.4;

      //Hatch Holder
      /**
       * @deprecated replaced by general stop speed modifier |
       * full speed assigned to hatch holder
       */
      public static final double HATCH_HOLDER_FULL_SPEED = 1.0;
      /**
       * @deprecated replaced by general stop speed modifier |
       * full speed assigned to hatch holder
       */
      public static final double HATCH_HOLDER_STOP_SPEED = 0.0;
      /**
       * The value by which any speed being sent to the hatch holder will be multiplied by
       */
      public static final double HATCH_HOLDER_SPEED_MODIFIER = 1.0;

    //Misc Constants//
    /**
     * maximum velocity to be applied to any motor
     */
    public static final double MAX_VELOCITY = 17.5;
    /**
     * The inverse of the maximum velocity to be applied to any motor
     */
    public static final double kV = 1.0 / MAX_VELOCITY;
    /**
     * General Full Speed for motors
     */
    public static final double MOTOR_FULL_SPEED = 1.0;
    /**
     * General Full Stop value for motors
     */
    public static final double MOTOR_FULL_STOP = 0.0;

  //Flags
  /**
   * triggers true when the ball is in the intake
   */
  public static boolean ballInIntake = true;

  //Non-constant speed modifiers//
  /**
   * The value which the speed sent to the elevator is multiplied by
   */
  public static double elevatorSpeedModifier = 1.0;
  /**
   * The value the the speed is divided by in manipulator
   */
  public static double manipulatorSpeedModifier = 0.40;

  //Objects//
    //Drivetrain//
    /**
     * Motor for the left front wheel
     */
    public static WPI_TalonSRX leftFrontTalon;
    /**
     * Motor for the right front wheel
     */
    public static WPI_TalonSRX rightFrontTalon;
    /**
     * Motor for the left back wheel
     */
    public static WPI_TalonSRX leftBackTalon;
    /**
     * Motor for the right back wheel
     */
    public static WPI_TalonSRX rightBackTalon;
    /**
     * Motor for the center wheel/strafe
     */
    public static WPI_TalonSRX centralTalon;

    //Manipulator//
      //Cargo Intake
      /**
       * Motor for the intake
       */
      public static WPI_TalonSRX intakeTalon;

      //Hatch holder
      /**
       * Motor for the hatch
       */
      public static WPI_TalonSRX hatchHolderTalon;

    //Elevator//
    /**
     * Motor for the elevator
     */
    public static CANSparkMax elevatorSparkMax;
    /**
     * The encoder used to preset the heights for autonomous 
     */
    public static CANEncoder elevatorEncoder;

    //Servos//

    //Micro Switches
      //Manipulator//
        //Ball Intake
        /**
         * Stops the ball intake
         */
        public static DigitalInput ballIntakeStopSwitch;

        //Hatch Holder
        /**
         * Limit for the hatch in the upper position
         */
        public static DigitalInput upperPositionHatchHolderLimitSwitch;
        /**
         * Limit for the hatch in the middle position
         */
        public static DigitalInput middlePositionHatchHolderLimitSwitch;
        /**
         * Limit for the hatch in the lower position
         */
        public static DigitalInput lowerPositionHatchHolderLimitSwitch;

      //Elevator
      /**
       * Limit of the lower position of the elevator
       */
      public static DigitalInput lowerElevatorLimitSwitch;
      /**
       * Limit of the lower position of the elevator
       */
      public static DigitalInput upperElevatorLimitSwitch;

    //Sensors
    /**
     * Gyro. The purple thingy on the rio
     */
    public static AHRS navX;

    //Joysticks//
    /**
     * The driver's left joystick used for joystick drive
     */
    public static Joystick leftDriverJoystick;
    /**
     * The driver's right joystick used for joystick drive
     */
    public static Joystick rightDriverJoystick;

    //Controllers//
    /**
     * The xbox controller used for the primary driver
     */
    public static XboxController driverController;
    /**
     * The xbox controller used for the assistant driver
     */
    public static XboxController assistantDriverController;

    //Subsystems//
    /**
     * declaration of driveTrainSubsystem
     */
    public static DriveTrainSubsystem driveTrainSubsystem;
    /**
     * declaration of elevatorSubsystem
     */
    public static ElevatorSubsystem elevatorSubsystem;
    /**
     * declaration of manipulatorSubsystem
     */
    public static ManipulatorSubsystem manipulatorSubsystem;
    /**
     * Declaration of automatedSubsystem
     */
    public static AutomatedSubsytem automatedSubsystem;

    //Arduino//
    /**
     * Microcontroller used for targeting
     */
    public static SerialPort arduino;

  public static void init()
  {
    //Instantiating subsystems
    driveTrainSubsystem = new DriveTrainSubsystem();
    elevatorSubsystem = new ElevatorSubsystem();
    manipulatorSubsystem = new ManipulatorSubsystem();
    automatedSubsystem = new AutomatedSubsytem();

    //Instantiate controllers
    driverController = new XboxController(DRIVER_CONTROLLER_PORT);
		assistantDriverController = new XboxController(ASSISTANT_DRIVER_CONTROLLER_PORT);

    //Instantiating motors
    leftFrontTalon = new WPI_TalonSRX(LEFT_FRONT_TALON_ID);
    rightFrontTalon = new WPI_TalonSRX(RIGHT_FRONT_TALON_ID);
    leftBackTalon = new WPI_TalonSRX(LEFT_BACK_TALON_ID);
    rightBackTalon = new WPI_TalonSRX(RIGHT_BACK_TALON_ID);
    centralTalon = new WPI_TalonSRX(CENTER_TALON_ID);

    intakeTalon = new WPI_TalonSRX(INATKE_TALON_ID);

    hatchHolderTalon = new WPI_TalonSRX(HATCH_HOLDER_TALON_ID);

    elevatorSparkMax = new CANSparkMax(ELEVATOR_SPARK_MAX_ID, MotorType.kBrushless);
    elevatorEncoder = elevatorSparkMax.getEncoder();

    //Instantiate intake stop switch
    ballIntakeStopSwitch = new DigitalInput(BALL_INTAKE_STOP_PORT);

    //Instantiating hatch position limit switches
    upperPositionHatchHolderLimitSwitch = new DigitalInput(HATCH_HOLDER_UPPER_POSITION_LIMIT_SWITCH_PORT);
    middlePositionHatchHolderLimitSwitch = new DigitalInput(HATCH_HOLDER_MIDDLE_POSITION_LIMIT_SWITCH_PORT);
    lowerPositionHatchHolderLimitSwitch = new DigitalInput(HATCH_HOLDER_LOWER_POSITION_LIMIT_SWITCH_PORT);
    lowerElevatorLimitSwitch = new DigitalInput(LOWER_ELEVATOR_LIMIT_SWTICH_PORT);
    upperElevatorLimitSwitch = new DigitalInput(UPPER_ELEVATOR_LIMIT_SWTICH_PORT);

    //Instantiating joysticks for joystick drive
    leftDriverJoystick = new Joystick(LEFT_DRIVER_JOYSTICK_PORT);
    rightDriverJoystick = new Joystick(RIGHT_DRIVER_JOYSTICK_PORT);

    //Instantiates gyro
    navX = new AHRS(SPI.Port.kMXP);
    
    //Instantiates arduino to control pixycam and other functions
    arduino = new SerialPort(115200, SerialPort.Port.kUSB);

    //Sets motors to inverted
    leftFrontTalon.setInverted(true);
    leftBackTalon.setInverted(true);
    centralTalon.setInverted(true);
    intakeTalon.setInverted(true);
    elevatorSparkMax.setInverted(true);

    leftBackTalon.follow(leftFrontTalon);
    rightBackTalon.follow(rightFrontTalon);

    elevatorSparkMax.setClosedLoopRampRate(ELEVATOR_RAMP_TIME);
    elevatorSparkMax.setIdleMode(IdleMode.kBrake);
    
    //Set names and subsystems
    //Subsystems
    driveTrainSubsystem.setName(driveTrainSubsystem.getSubsystem(), "DriveTrainSubsystem");
    manipulatorSubsystem.setName(manipulatorSubsystem.getSubsystem(), "ManipulatorSubsystem");
    elevatorSubsystem.setName(elevatorSubsystem.getSubsystem(), "ElevatorSubsystem");

    //Talons
    leftFrontTalon.setName(driveTrainSubsystem.getSubsystem(), "LeftFrontTalon");
    rightFrontTalon.setName(driveTrainSubsystem.getSubsystem(), "RightFrontTalon");
    leftBackTalon.setName(driveTrainSubsystem.getSubsystem(), "LeftBackTalon");
    rightBackTalon.setName(driveTrainSubsystem.getSubsystem(), "RightBackTalon");
    centralTalon.setName(driveTrainSubsystem.getSubsystem(), "CentralTalon");

    //Manipulator
    intakeTalon.setName(manipulatorSubsystem.getSubsystem(), "IntakeTalon");
    hatchHolderTalon.setName(manipulatorSubsystem.getSubsystem(), "HatchHolderTalon");
  }
}
