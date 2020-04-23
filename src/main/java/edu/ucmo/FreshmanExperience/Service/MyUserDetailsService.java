package edu.ucmo.FreshmanExperience.Service;


@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String ucmoid) {
        User user = userDao.findByUcmoid(ucmoid);
        if(user == null) {
            throw new UsernameNotFoundException(String.format("The UCMO ID %s doesn't exist", ucmoid));
        }
        List<GrantedAuthority> authorities = getUserAuthority(user.getRoles());
        return buildUserForAuthentication(user, authorities);
    }

    private List<GrantedAuthority> getUserAuthority(Set<Role> userRoles) {
        Set<GrantedAuthority> roles = new HashSet<>();
        for (Role role : userRoles) {
            roles.add(new SimpleGrantedAuthority(role.getRole()));
        }
        return new ArrayList<>(roles);
    }

    private UserDetails buildUserForAuthentication(User user, List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(user.getUcmoid(), user.getPassword(),
                user.getActive(), true, true, true, authorities);
    }



}