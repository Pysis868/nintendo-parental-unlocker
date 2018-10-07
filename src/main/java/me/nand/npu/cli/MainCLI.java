package me.nand.npu.cli;

import java.time.MonthDay;
import java.util.Arrays;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import me.nand.npu.core.Platform;
import me.nand.npu.core.Unlocker;
import me.nand.npu.core.UnlockerException;
import me.nand.npu.core.UnlockerFactory;;

public class MainCLI {

  private static Logger LOGGER = LogManager.getLogger(MainCLI.class.getName());

  // Declare primary variables
  private static Platform platform;
  private static String confirmationNumber;
  private static MonthDay monthDay;
  
  public static void main(String[] args) {
    LOGGER.debug(Arrays.toString(args));
    storeInput(args);
    LOGGER.debug("Input gathered and converted:");
    LOGGER.debug(" - platform: " + platform);
    LOGGER.debug(" - confirmationNumber: " + confirmationNumber);
    LOGGER.debug(" - monthDay: " + monthDay);
    
    Unlocker unlocker;
    try {
      unlocker = UnlockerFactory.createUnlocker(platform, confirmationNumber, monthDay);
      System.out.println("Your PIN code is " + unlocker.getPin() + ".");
    } catch (UnlockerException e) {
      LOGGER.info(e.getMessage());
    }
  }
  
  public static void storeInput(String[] args) {
    // Declare other intermediate variables.
    String platformName, monthDayString;
    
    // Gather input from arguments and/or user input.
    Scanner input = new Scanner(System.in);
    
    if(args.length > 0) {
      platformName = args[0];
    } else {
      System.out.print("Enter the platform's shortname: ");
      platformName = input.next();
    }
    
    // Convert into proper data types.
    platform = Platform.getPlatform(platformName);
    
    if(args.length > 1) {
      confirmationNumber = args[1];
    } else {
      System.out.print("Enter your confirmation number: ");
      confirmationNumber = input.next();
    }
    
    if(args.length > 2) {
      monthDayString = args[2];
    } else {
      System.out.print("Enter the current month and day with leading zeros (MM-DD) (leave blank to use today): ");
      monthDayString = input.nextLine();
    }
    
    if(monthDayString.equals("")) {
      monthDay = MonthDay.now();
    } else {
      monthDay = MonthDay.parse("--" + monthDayString);
    }
    
    input.close();
  }

}
