/* 
 * Copyright (c) 2014 RobotsByTheC. All rights reserved.
 *
 * Open Source Software - may be modified and shared by FRC teams. The code must
 * be accompanied by the BSD license file in the root directory of the project.
 */
package org.usfirst.frc.team2084.CMonster2016.vision;

import org.opencv.core.Mat;
import org.usfirst.frc.team2084.CMonster2016.vision.capture.CameraCapture;

/**
 * A vision processor used for testing. It does nothing, simply outputting the
 * input image.
 * 
 * @author Ben Wolsieffer
 */
public class TestVisionProcessor extends VisionProcessor {

    /**
     * Creates a new instance using the specified camera.
     *
     * @param capture the camera to capture from
     */
    public TestVisionProcessor(CameraCapture capture) {
        super(capture);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void process(Mat cameraImage, Mat outputImage) {
        debugImage("Test", cameraImage);
    }

}