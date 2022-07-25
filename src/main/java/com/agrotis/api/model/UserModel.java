package com.agrotis.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class UserModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="initialDate", nullable = false)
    private Date initialDate;

    @Column(name="finalDate", nullable = false)
    private Date finalDate;

    @ManyToOne
    @JoinColumn(name = "propertyinfo_id")
    private PropertyInfoModel propertyInfo;

    @ManyToOne @JoinColumn(name = "laboratory_id")
    private LaboratoryModel laboratory;

    @Column(name="notes")
    private String notes;

    public void setPropertyInfo() {
    }
}
