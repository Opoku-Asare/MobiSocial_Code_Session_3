# MobiSocial_Code_Session_3
This exercise goal is to create an application that leverages the on-device sensors. Either use the accelerometer to detect when your device is falling and play a corresponding sound cue (Wilhelm Scream) or leverage the magnetometer to turn your smartphone into a metal detector and make it beep when near metal.
https://goo.gl/forms/4rNsjhzdn1dWVegx2

# Implementation

* Create a new application in Android Studio. Choose an Empty Activity as the template. Add a TextView to show the sensor readings to the layout.
* Check if your device has a magnetometer, and select between the two options (fall detector or metal detector). Use the Android Sensors  Overview as reference when needed. The page also includes code examples.
* Retrieve the SensorManager system service, make your Activity implement the SensorEventListener, retrieve a corresponding Sensor (accelerometer or magnetometer) from the SensorManager, and then register your Activity as the SensorEventListener for the Sensor. When sensor values change, update the TextView to show the values.
* Create a new folder named ‘raw’ inside your res (resources) folder, then download a wav file of your choice and save it in this directory.
* Test and calculate a threshold for detecting a fall or metal, make your app play the sound-file when this threshold is exceeded.
