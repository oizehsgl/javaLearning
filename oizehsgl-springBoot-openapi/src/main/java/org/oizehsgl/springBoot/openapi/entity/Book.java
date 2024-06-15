package org.oizehsgl.springBoot.openapi.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * book
 *
 * @author oizehsgl
 */
public class Book {

  private long id;

  @NotBlank
  @Size(min = 0, max = 20)
  private String title;

  @NotBlank
  @Size(min = 0, max = 30)
  private String author;
}
