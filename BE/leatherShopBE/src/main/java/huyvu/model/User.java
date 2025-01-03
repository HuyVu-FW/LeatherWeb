package huyvu.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@AllArgsConstructor
@Builder
@Table(name = "table_user")
@Entity
@NoArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    String username;
    String phone;
    String password;
    String name;
    String email;
    String avatar;

    @ElementCollection
    Set<String> roles;

}
