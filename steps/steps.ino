#include <Wire.h> // Must include Wire library for I2C
#include <SparkFun_MMA8452Q.h> // Includes the SFE_MMA8452Q library

MMA8452Q accel;

void setup()
{
  Serial.begin(9600);
  accel.init();
}

void loop()
{
  // Use the accel.available() function to wait for new data
  //  from the accelerometer.
  if (accel.available())
  {
    // First, use accel.read() to read the new variables:
    accel.read();

    // send stream
    sendAccelData();
  }
}

void sendAccelData() {
  /* 
  Serial.write(accel.x>>8);
  Serial.write(accel.x);
  */
  Serial.print(accel.cx, 3);

  Serial.print(",");

  /*
  Serial.write(accel.y>>8);
  Serial.write(accel.y);
  */
  Serial.print(accel.cy, 3);

  Serial.print(",");

  /*
  Serial.write(accel.z>>8);
  Serial.write(accel.z);
  */
  Serial.print(accel.cz, 3);

  Serial.println();
}

