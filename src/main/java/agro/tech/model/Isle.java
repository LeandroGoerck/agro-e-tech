package agro.tech.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.bson.types.ObjectId;

public class Isle {

  public ObjectId id;

  @NotBlank(message = "O nome é necessário!")
  private String name;

  @NotNull(message = "O status é necessário!")
  private Boolean status;

  public Isle() {}

  public Isle(String name, Boolean status) {
    this.name = name;
    this.status = status;
  }

  public ObjectId getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Boolean getStatus() {
    return status;
  }

  public void setStatus(Boolean status) {
    this.status = status;
  }

}
