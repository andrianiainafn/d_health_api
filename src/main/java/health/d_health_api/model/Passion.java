package health.d_health_api.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Passion {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String passionId;
    private String username;
    private String email;
    private String password;
    private Date dateOfBirth;

    @OneToMany(mappedBy = "passion")
    private List<Profile> profiles;

    private Date modifyAt;
    private Date createdAt;
}
