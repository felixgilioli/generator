package com.generator.generator.inputgroup;

import com.generator.generator.input.InputEntity;
import com.generator.generator.template.TemplateEntity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

/**
 * Entidade para agrupar os inputs dentro de um fieldset
 */
@Entity
@Getter
@Setter
@Table(name = "input_group")
public class InputGroupEntity implements Serializable {

    /**
     * Id da entidade
     */
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID id;

    /**
     * Legenda que será exibida em tela
     */
    @Column(nullable = false)
    private String legend;

    /**
     * Ordem de apresentação do fieldset
     */
    @Column(nullable = false)
    private Integer ordem;

    /**
     * Template ao qual o InputGroup pertence
     */
    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private TemplateEntity template;

    /**
     * Lista de inputs filhos do fieldset
     */
    @OrderBy("ordem ASC")
    @OneToMany(mappedBy = "inputGroup", cascade = CascadeType.ALL)
    private List<InputEntity> inputList;
}
