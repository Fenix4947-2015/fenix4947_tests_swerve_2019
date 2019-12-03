/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;

/**
 * Add your docs here.
 */
public class SpiEncoder {
    public double[] bittointeger = new double[4];

    private DigitalInput FrontRight = new DigitalInput(7); // array 3
    private DigitalInput BackRight = new DigitalInput(6); //array 2
    private DigitalInput BackLeft = new DigitalInput(5);  // array 1
    private DigitalInput FrontLeft = new DigitalInput(4); // array 0
    private DigitalOutput Clock = new DigitalOutput(8);
    private DigitalOutput ChipSelect = new DigitalOutput(9);

    public SpiEncoder() {
        ChipSelect.set(true);
    }

    public void GetAngle() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        for(int i = 0; i<4; i++) {
            bittointeger[i] = 0;
        }
        Clock.set(true);
        ChipSelect.set(false);

        waitNanoseconds(600);

        for(int i = 0; i<12; i++) {
            Clock.set(false);

            waitNanoseconds(500);

            Clock.set(true);

            waitNanoseconds(375);

            if(FrontRight.get()==true)
            {
                bittointeger[3] += Math.pow(2.0, 12.0-i);
            }
            if(BackRight.get()==true)
            {
                bittointeger[2] += Math.pow(2.0, 12.0-i);
            }
            if(BackLeft.get()==true)
            {
                bittointeger[1] += Math.pow(2.0, 12.0-i);
            }
            if(FrontLeft.get()==true)
            {
                bittointeger[0] += Math.pow(2.0, 12.0-i);
            }
        }
        ChipSelect.set(true);
    }
    public void waitNanoseconds(int nanoseconds){
        final long INTERVAL = nanoseconds;
        long start = System.nanoTime();
        long end=0;

        do {
            end = System.nanoTime();
        }
        while(start + INTERVAL >= end);
    }
    public double[] ReturnAngle(int[] MotorNumber) {
        double[] tempvar = new double[MotorNumber.length];
        for (int i = 0 ; i < MotorNumber.length; i++)
        {
            tempvar[i] = bittointeger[MotorNumber[i]]*360.0/4096.0;
        }
        
        return tempvar;
    }

}