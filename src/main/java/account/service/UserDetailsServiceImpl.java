package account.service;

import account.domain.entity.Account;
import account.domain.repository.AccountRep;
import account.security.UserPrincipal;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    AccountRep accountRep;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Account> account = accountRep.findUserByEmailIgnoreCase(email);
        if (account.isEmpty()) {
            throw new UsernameNotFoundException("Not found: " + email);
        }
        return new UserPrincipal(account.get());
    }
}
