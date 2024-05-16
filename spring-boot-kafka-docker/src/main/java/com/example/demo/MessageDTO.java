package com.example.demo;

public class MessageDTO {

    private String timestamp;

    private MeasurmentsDTO measurements;

    private Integer measurement_delay;

    public MeasurmentsDTO getMeasurements() {
        return measurements;
    }

    public void setMeasurements(MeasurmentsDTO measurements) {
        this.measurements = measurements;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getMeasurement_delay() {
        return measurement_delay;
    }

    public void setMeasurement_delay(Integer measurement_delay) {
        this.measurement_delay = measurement_delay;
    }

    @Override
    public String toString() {
        return "{" +
                "\"timestamp\":\"" + timestamp + '\"' +
                ", \"measurements\":" + measurements +
                ", \"measurement_delay\":" + measurement_delay +
                "}";
    }
}
