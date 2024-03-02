package health.d_health_api.serviceImpls;

import health.d_health_api.model.Passion;
import health.d_health_api.services.PassionService;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private  final PassionService passionService;

    public UserDetailServiceImpl(PassionService passionService) {
        this.passionService = passionService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Passion passion = passionService.loadPassionByEmail(email);
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        return new User(email,passion.getPassword(),true,true,true,true,authorities);
    }
}
