package com.generator.generator.template;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.generator.generator.inputgroup.InputGroupEntity;
import org.hibernate.annotations.GenericGenerator;

import com.generator.generator.category.CategoryEntity;
import com.generator.generator.input.InputEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
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
