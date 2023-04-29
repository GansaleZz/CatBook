package genesis.bean;

import genesis.util.constant.GenesisConstants;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * Parent Bean which contain common fields for all beeans.
 *
 * @author GansaleZz
 */
@MappedSuperclass
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public abstract class GenesisBean {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long ID = GenesisConstants.EMPTY_LONG;

    @Column(name = "CreatedDate")
    private LocalDateTime createdDate = LocalDateTime.now();

    @Column(name = "ModifiedDate")
    private LocalDateTime modifiedDate = LocalDateTime.now();

    @Column(name = "ModifiedByID")
    private long modifiedByID = -1;

    @Column(name = "CreatedByID")
    private long createdByID = -1;

    @Column(name = "ActiveFlag")
    @Type(type = "yes_no")
    private boolean active = true;
}
