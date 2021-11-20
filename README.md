# Build and set up the Romi robot
Mr. Burdette will provide you with a Romi robot kit. Please follow these instructions for assembly: [Romi Hardware & Assembly](https://docs.wpilib.org/en/stable/docs/romi-robot/hardware.html)

Once assembled, the Romi will need to be imaged: [Imaging your Romi](https://docs.wpilib.org/en/stable/docs/romi-robot/imaging-romi.html)

Once the Romi is built and imaged, we can start working on autonomous code.

# Get started with autonomous code
## Clone into our Romi starter project.

Go to the [Romi project](https://github.com/qbranch4327/romi) GitHub page. Here you should seed a green button that says Code. It'll be just above the project files table. Click that button and copy the url

Next, choose a location for the project (the desktop is fine), navigate there and right click to bring up a context menu. The menu should have an option like "Git Bash Here" or "Open Git Bash." Select that option and in the terminal that pops up execute the command `git clone [repository-url]`

The repository should clone rather quickly. Once that is done, open up the romi project in vs code.

## Start writing autonomous code
The Romi project contains just one, very boring autonomous command: Spin. Obviously we'll need the robot to do much more interesting things in the competition season. Take a looke at the [SpinCommand](./src/main/java/frc/robot/commands/SpinCommand.java), for reference when you start building your own commands.

If you want the Romi to be able to move forward and backward, you'll need to add that functionality in the [RomiDrivetrain](./src/main/java/frc/robot/subsystems/RomiDrivetrain.java) subsystem. You'll notice there are a couple of unimplemented methods in that class, which may be a good place to start.

In the [RobotContainer](./src/main/java/frc/robot/RobotContainer.java) class, you can add any new commands you write to the `commandDictionary`. Look for the `buildCommandDictionary` method. You will need to add a new entry for your command into the [Autonomous](./src/main/java/frc/robot/enums/Autonomous.java) enum before you can add it to the dictionary. See below for more on enums.

Finally we need to set the command we want to run. In the [Robot](./src/main/java/frc/robot/Robot.java) class you'll find a `autonomousInit` method that starts with this line of code `autonomousCommand = robotContainer.getAutonomousCommand(Autonomous.Spin);`. See the part that says Autonomous.Spin? That is how we're going to decide which command to run. You can add a new command name to the [Autonomous](./src/main/java/frc/robot/enums/Autonomous.java) enum found in the enums folder.

After adding a command name to the [Autonomous](./src/main/java/frc/robot/enums/Autonomous.java) enum, a command to the `commandDictionary` in [RobotContainer](./src/main/java/frc/robot/RobotContainer.java), and setting which command you would like to run in the `autonomousInit` method of the [Robot](./src/main/java/frc/robot/Robot.java) class, you are (finally) ready to run your code.

# Running your code
During setup of the robot, you had to connect to its wifi. Make sure you are connected before you attempt to run your robot code.

Once you are connected to the Romi's wireless, you can start the simulator. Open the command palette with `Ctrl+Shift+P` and search for `WPILib: Simulate Robot Code on Desktop`. Select that option and wait for the simulator ui to open.

In the upper left of the simulator ui, you should see an area to switch between autonomous, teleop, disabled, etc. When you are ready, click autonomous and, if all goes well, the Romi robot should follow whichever command you've written for it.
