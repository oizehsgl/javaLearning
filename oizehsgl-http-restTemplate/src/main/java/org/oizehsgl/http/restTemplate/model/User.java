package org.oizehsgl.http.restTemplate.model;

import lombok.Builder;
import lombok.Data;

/**
 * @author oizehsgl
 */
@Data
@Builder
public class User {
  private Integer id;
  private String name;
}
