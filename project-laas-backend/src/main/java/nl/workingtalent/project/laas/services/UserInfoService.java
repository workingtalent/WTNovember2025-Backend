package nl.workingtalent.project.laas.services;

import nl.workingtalent.project.laas.models.Account;
import nl.workingtalent.project.laas.models.UserInfoDetails;
import nl.workingtalent.project.laas.repositories.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Primary
public class UserInfoService implements UserDetailsService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Account> userDetail = userInfoRepository.findByUsername(username); // Assuming 'email' is used as username

        // Converting UserInfo to UserDetails
        return userDetail.map(UserInfoDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
    }

    public String addUser(Account account) {
        // Encode password before saving the user
        account.setPassword(encoder.encode(account.getPassword()));

        userInfoRepository.save(account);

        return "User Added Successfully";
    }

    public Account findAccountById(Long id) {
        Account account = userInfoRepository.findById(id).orElse(null);
        return account;
    }
}

