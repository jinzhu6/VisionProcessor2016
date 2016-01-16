/* 
 * Copyright (c) 2015 RobotsByTheC. All rights reserved.
 *
 * Open Source Software - may be modified and shared by FRC teams. The code must
 * be accompanied by the BSD license file in the root directory of the project.
 */
package org.usfirst.frc.team2084.CMonster2015.vision;

import java.io.File;
import java.util.Arrays;

import org.opencv.core.Core;

/**
 * @author ben
 */
public final class OpenCVLoader {

    private static final File[] OPENCV_SEARCH_PATHS = { new File("lib/") };

    private static <T> T[] concat(T[] first, T[] second) {
        if (second != null) {
            T[] result = Arrays.copyOf(first, first.length + second.length);
            System.arraycopy(second, 0, result, first.length, second.length);
            return result;
        } else {
            return first;
        }
    }

    public static void loadOpenCV() {
        loadOpenCV(null);
    }

    public static void loadOpenCV(File[] additionalSearchPaths) {
        String os_name = System.getProperty("os.name").toLowerCase();

        String os;
        String extension;
        String arch;

        if (System.getProperty("os.arch").contains("64")) {
            arch = "x86_64";
        } else {
            arch = "x86";
        }

        if (os_name.contains("linux")) {
            os = "linux";
        } else if (os_name.contains("windows")) {
            os = "windows";
        } else {
            throw new UnsatisfiedLinkError("Your OS is not set up to use OpenCV yet.");
        }

        if (os_name.startsWith("Windows")) {
            extension = ".dll";
        } else {
            extension = ".so";
        }

        String fileName = "lib" + Core.NATIVE_LIBRARY_NAME + "-" + os + "-" + arch + extension;

        File[] searchPaths = concat(OPENCV_SEARCH_PATHS, additionalSearchPaths);
        for (File path : searchPaths) {
            path = new File(path, fileName);
            if (path.exists()) {
                System.out.println("Loading OpenCV: " + path.getAbsolutePath());
                System.load(path.getAbsolutePath());
            }
        }
    }
}
