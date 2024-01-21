package health.d_health_api.map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class UserCustomer extends User {
    private Long customerUserId;


    public UserCustomer(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public Long getCustomerUserId() {
        return  this.customerUserId;
    }
    public void setCustomerUserId(Long customerUserId){
        this.customerUserId = customerUserId;
    }

}
