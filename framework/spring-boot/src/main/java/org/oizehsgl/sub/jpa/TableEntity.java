package org.oizehsgl.sub.jpa;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * tableEntity
 *
 * @author oizehsgl
 * @since 3/19/23
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "t_table")
public class TableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "myid")
    @GenericGenerator(name = "myid", strategy = "org.oizehsgl.sub.jpa.ManualInsertGenerator")
    @Column(name = "id")
    private Long id;
    @Column(name = "string")
    private String string;
    @Column(name = "integer")
    private Integer integer;

    @Version
    private Long version;
}
