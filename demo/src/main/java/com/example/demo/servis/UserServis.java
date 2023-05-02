package com.example.demo.servis;

import com.example.demo.domen.Rols;
import com.example.demo.domen.User;
import com.example.demo.dto.RegistrationUser;
import com.example.demo.repozitory.UserRepozitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserServis implements ISave<User, RegistrationUser>, UserDetailsService {
    @Autowired
    private  final UserRepozitory userRepozitory;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserServis(UserRepozitory userRepozitory) {
        this.userRepozitory = userRepozitory;
    }


    @Override
    public User save(RegistrationUser registrationUser) {
         User user=new User(registrationUser.getFirstName(), registrationUser.getLastName(),registrationUser.getEmail(),
                 Arrays.asList(new Rols("Role_User")),bCryptPasswordEncoder.encode(registrationUser.getPassword()));
         return userRepozitory.save(user);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepozitory.findByEmail(username);
        if(user==null){
            throw new UsernameNotFoundException("Invalid password or login");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),mapRolesToAurorization(user.getRols()));
    }
    private Collection<? extends GrantedAuthority> mapRolesToAurorization(Collection<Rols> rols){
        return rols.stream().map(rols1->new SimpleGrantedAuthority(rols1.getName())).collect(Collectors.toList());

    }
}
