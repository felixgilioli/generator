package com.generator.generator.input;

import com.generator.generator.converter.BooleanNotNullConverter;
import com.generator.generator.inputgroup.InputGroupEntity;
import com.generator.generator.template.TemplateEntity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "input")
public class InputEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false)
    private String label;

    @Column(nullable = false)
    private Integer ordem;

    @Column
    private String placeholder;

    @Column
    private String title;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private InputType type;

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private InputGroupEntity inputGroup;

    /**
     * Input é obrigatório
     */
    @Column
    @Convert(converter = BooleanNotNullConverter.class)
    private Boolean required;

    /**
     * Máscara do input
     */
    @Column
    private String mask;

}
