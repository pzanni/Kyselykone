
package wad.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import wad.domain.Asker;
import wad.repository.AskerRepository;

@Service
public class AskerService implements UserDetailsService{
    
    @Autowired
    private AskerRepository askerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Asker account = askerRepository.findByUsername(username);
        if (account == null) {
            throw new UsernameNotFoundException("No such user: " + username);
        }
        
        List<SimpleGrantedAuthority> lista = new ArrayList<>();
        for(String auth : account.getAuthorities()) {
            lista.add(new SimpleGrantedAuthority(auth));
        }
        
        return new org.springframework.security.core.userdetails.User(
            account.getUsername(),
            account.getPassword(),
            true,
            true,
            true,
            true,
            lista);
    }
}