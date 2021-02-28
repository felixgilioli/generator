package com.generator.generator.template;

import com.generator.generator.category.CategoryEntity;
import com.generator.generator.inputgroup.InputGroupEntity;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "template")
public class TemplateEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String location;

    @Column(name = "img_location", nullable = false)
    private String imgLocation;

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private CategoryEntity category;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private Set<ExportType> exportTypeSet;

    @OrderBy("ordem ASC")
    @OneToMany(mappedBy = "template")
    private List<InputGroupEntity> inputGroupList;

}
