package GapiV2.Garlands.controller;
import GapiV2.Garlands.entity.Role;
import GapiV2.Garlands.entity.User;
import GapiV2.Garlands.repository.UserRepo;
import GapiV2.Garlands.request.LoginRequest;
import GapiV2.Garlands.request.RegisterRequest;
import GapiV2.Garlands.security.JwtUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;
    private final UserRepo userRepository;

    public AuthController(AuthenticationManager authenticationManager,  JwtUtil jwtUtil, PasswordEncoder passwordEncoder, UserRepo userRepository) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
            );

            User user = userRepository.findByEmail(loginRequest.getEmail());

            if (user == null) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Email or password is wrong");
            }
            // Menghasilkan token JWT dengan peran pengguna
            String token = jwtUtil.generateToken(
                    loginRequest.getEmail(),
                    user.getId(),
                    user.getFirstName() + " " + user.getLastName(),
                    user.getRole().toString()
            );

            return ResponseEntity.ok(token);
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Email or password is wrong");
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }



    // REGISTER VISITORr
    @PostMapping("/register/visitor")
    public ResponseEntity<String> register(@RequestBody RegisterRequest registerRequest) {
        if (userRepository.findByEmail(registerRequest.getEmail()) != null) {
            return new ResponseEntity<>("Email visitor already exists", HttpStatus.BAD_REQUEST);
        }

        // Validation for password
        String password = registerRequest.getPassword();
        if (password.length() < 3 || password.length() > 20){
            return new ResponseEntity<>("Password must be between 3 and 20 characters long", HttpStatus.BAD_REQUEST);
        }
        if (!password.matches(".*[A-Z].*") || !password.matches(".*\\d.*")){
            return new ResponseEntity<>("Password must be contain at least one Uppercase letter and one digit", HttpStatus.BAD_REQUEST);
        }

        User user = new User();
        user.setFirstName(registerRequest.getFirstName());
        user.setEmail(registerRequest.getEmail());
        user.setLastName(registerRequest.getLastName());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setRole(Role.VISITOR); // Set the role to VISITOR
        userRepository.save(user);


        return new ResponseEntity<>(jwtUtil.generateToken(
                registerRequest.getEmail(),
                user.getId(),
                registerRequest.getFirstName() + registerRequest.getLastName(),
                user.getRole().toString()), HttpStatus.OK);
    }

    // REGISTER OWNER
    @PostMapping("/register/owner")
    public ResponseEntity<String> registerOwner(@RequestBody RegisterRequest registerRequest){
        if (userRepository.findByEmail(registerRequest.getEmail()) != null){
            return new ResponseEntity<>("Email Owner is already exists",HttpStatus.BAD_REQUEST);
        }

        // Validation for password
        String password = registerRequest.getPassword();
        if (password.length() < 3 || password.length() > 20){
            return new ResponseEntity<>("Password must be between 3 and 20 characters long", HttpStatus.BAD_REQUEST);
        }
        if (!password.matches(".*[A-Z].*") || !password.matches(".*\\d.*")){
            return new ResponseEntity<>("Password must be contain at least one Uppercase letter and one digit", HttpStatus.BAD_REQUEST);
        }

        User user = new User();
        user.setFirstName(registerRequest.getFirstName());
        user.setEmail(registerRequest.getEmail());
        user.setLastName(registerRequest.getLastName());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setRole(Role.OWNER); // Set the role to OWNER
        userRepository.save(user);


        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(registerRequest.getEmail(), registerRequest.getPassword())
        );

        return new ResponseEntity<>(jwtUtil.generateToken(
                registerRequest.getEmail(),
                user.getId(),
                registerRequest.getFirstName() + registerRequest.getLastName(),
                user.getRole().toString()), HttpStatus.OK);
    }


    // REGISTER CRAFTSMAN
    @PostMapping("/register/craftsman")
    public ResponseEntity<String> registerCraftsMan(@RequestBody RegisterRequest registerRequest){
        if (userRepository.findByEmail(registerRequest.getEmail()) != null){
            return new ResponseEntity<>("Email CraftsMan is already exists",HttpStatus.BAD_REQUEST);
        }

        // Validation for password
        String password = registerRequest.getPassword();
        if (password.length() < 3 || password.length() > 20){
            return new ResponseEntity<>("Password must be between 3 and 20 characters long", HttpStatus.BAD_REQUEST);
        }
        if (!password.matches(".*[A-Z].*") || !password.matches(".*\\d.*")){
            return new ResponseEntity<>("Password must be contain at least one Uppercase letter and one digit", HttpStatus.BAD_REQUEST);
        }

        User user = new User();
        user.setFirstName(registerRequest.getFirstName());
        user.setEmail(registerRequest.getEmail());
        user.setLastName(registerRequest.getLastName());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setRole(Role.CRAFTSMAN); // Set the role to CRAFTSMAN
        userRepository.save(user);


        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(registerRequest.getEmail(), registerRequest.getPassword())
        );

        return new ResponseEntity<>(jwtUtil.generateToken(
                registerRequest.getEmail(),
                user.getId(),
                registerRequest.getFirstName() + registerRequest.getLastName(),
                user.getRole().toString()), HttpStatus.OK);
    }


    // REGISTER ADMIN
    @PostMapping("/register/admin")
    public ResponseEntity<String> registerAdmin(@RequestBody RegisterRequest registerRequest){
        if (userRepository.findByEmail(registerRequest.getEmail()) != null){
            return new ResponseEntity<>("Email CraftsMan is already exists",HttpStatus.BAD_REQUEST);
        }

        // Validation for password
        String password = registerRequest.getPassword();
        if (password.length() < 3 || password.length() > 20){
            return new ResponseEntity<>("Password must be between 3 and 20 characters long", HttpStatus.BAD_REQUEST);
        }
        if (!password.matches(".*[A-Z].*") || !password.matches(".*\\d.*")){
            return new ResponseEntity<>("Password must be contain at least one Uppercase letter and one digit", HttpStatus.BAD_REQUEST);
        }

        User user = new User();
        user.setFirstName(registerRequest.getFirstName());
        user.setEmail(registerRequest.getEmail());
        user.setLastName(registerRequest.getLastName());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setRole(Role.ADMIN); // Set the role to ADMIN
        userRepository.save(user);


        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(registerRequest.getEmail(), registerRequest.getPassword())
        );

        return new ResponseEntity<>(jwtUtil.generateToken(
                registerRequest.getEmail(),
                user.getId(),
                registerRequest.getFirstName() + registerRequest.getLastName(),
                user.getRole().toString()), HttpStatus.OK);
    }


}
