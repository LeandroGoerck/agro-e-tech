package agro.tech.model;

import java.time.LocalDateTime;
import org.bson.types.ObjectId;

public class Measurements {

  public ObjectId idIsle;

  private double temperature;

  private double airHumidity;

  private double soilHumidity;

  private LocalDateTime measuredAt = LocalDateTime.now();

  public Measurements() {}

  public Measurements(String idIsle, double temperature, double soilHumidity, double airHumidity) {
    this.idIsle = new ObjectId(idIsle);
    this.temperature = temperature;
    this.airHumidity = airHumidity;
    this.soilHumidity = soilHumidity;
  }

  public ObjectId getIdIsle() {
    return idIsle;
  }

  public void setIdIsle(ObjectId idIsle) {
    this.idIsle = idIsle;
  }

  public double getTemperature() {
    return temperature;
  }

  public void setTemperature(double temperature) {
    this.temperature = temperature;
  }

  public double getAirHumidity() {
    return airHumidity;
  }

  public void setAirHumidity(double airHumidity) {
    this.airHumidity = airHumidity;
  }

  public double getSoilHumidity() {
    return soilHumidity;
  }

  public void setSoilHumidity(double soilHumidity) {
    this.soilHumidity = soilHumidity;
  }

  public LocalDateTime getMeasuredAt() {
    return measuredAt;
  }

  public void setMeasuredAt(LocalDateTime measuredAt) {
    this.measuredAt = measuredAt;
  }

}