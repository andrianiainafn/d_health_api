package health.d_health_api.serviceImpls;

import health.d_health_api.model.Passion;
import health.d_health_api.services.PassionService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private  final PassionService passionService;

    public UserDetailServiceImpl(PassionService passionService) {
        this.passionService = passionService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Passion passion = passionService.loadPassionByEmail(email);
        return null;
    }
}
