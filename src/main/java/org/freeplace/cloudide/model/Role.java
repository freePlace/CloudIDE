package org.freeplace.cloudide.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Ruslan on 04.12.2015.
 */
@Entity
@Table(name = Role.TABLE_NAME)
public class Role extends AbstractModel{
    public static final String TABLE_NAME = "role";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_ID = "id_role";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = COLUMN_ID)
    private int id;

    @Column(name = COLUMN_NAME, nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = TABLE_NAME)
    private List<User> users;
}
