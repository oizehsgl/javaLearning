package org.oizehsgl.sub.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * emailDetail
 *
 * @author oizehsgl
 * @since 3/18/23
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "t_email_detail")
public class EmailDetail {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "email")
    private String email;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "send_time")
    private Date sendTime;
}
