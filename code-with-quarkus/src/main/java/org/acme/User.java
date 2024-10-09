package org.acme;

import io.quarkus.elytron.security.common.BcryptUtil;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")

public class User extends PanacheEntity {
    @Column (unique = true)
    public String username;
    public String password;  //senha armazenada com hash
    public String role;

    // indica que a entidade deve ser mapeada em coluna
   public User (){}

    public User(String username, String password, String role) {
       this.username = username;
       this.password = BcryptUtil.bcryptHash(password);
       this.role = role;


    }


}
