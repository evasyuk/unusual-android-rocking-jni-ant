package com.jv.example.RockingJNI;

import android.util.Log;

/**
 * @author jv
 * @date 02.07.16
 * @version 1.0.0
 */
public class FileDumper {

    static {
        try {
            System.loadLibrary("echo");
        } catch (UnsatisfiedLinkError error) {
            Log.e(FileDumper.class.getSimpleName(), error.getMessage());
        }
    }

    native static void dumpFile(String filePathWithFullName, String textToDump);


}
