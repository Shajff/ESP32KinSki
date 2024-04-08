# Distributed under the OSI-approved BSD 3-Clause License.  See accompanying
# file Copyright.txt or https://cmake.org/licensing for details.

cmake_minimum_required(VERSION 3.5)

file(MAKE_DIRECTORY
  "C:/Espressif/frameworks/esp-idf-v5.2.1/components/bootloader/subproject"
  "E:/Diplomski/esp-iot-solution/components/sensors/imu/mpu6050/build/bootloader"
  "E:/Diplomski/esp-iot-solution/components/sensors/imu/mpu6050/build/bootloader-prefix"
  "E:/Diplomski/esp-iot-solution/components/sensors/imu/mpu6050/build/bootloader-prefix/tmp"
  "E:/Diplomski/esp-iot-solution/components/sensors/imu/mpu6050/build/bootloader-prefix/src/bootloader-stamp"
  "E:/Diplomski/esp-iot-solution/components/sensors/imu/mpu6050/build/bootloader-prefix/src"
  "E:/Diplomski/esp-iot-solution/components/sensors/imu/mpu6050/build/bootloader-prefix/src/bootloader-stamp"
)

set(configSubDirs )
foreach(subDir IN LISTS configSubDirs)
    file(MAKE_DIRECTORY "E:/Diplomski/esp-iot-solution/components/sensors/imu/mpu6050/build/bootloader-prefix/src/bootloader-stamp/${subDir}")
endforeach()
if(cfgdir)
  file(MAKE_DIRECTORY "E:/Diplomski/esp-iot-solution/components/sensors/imu/mpu6050/build/bootloader-prefix/src/bootloader-stamp${cfgdir}") # cfgdir has leading slash
endif()
