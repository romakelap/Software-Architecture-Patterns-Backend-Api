package GapiV2.Garlands.controller;

import GapiV2.Garlands.entity.Role;
import GapiV2.Garlands.entity.User;
import GapiV2.Garlands.repository.UserRepo;
import GapiV2.Garlands.request.RegisterRequest;
import GapiV2.Garlands.request.UpdateProfileRequest;
import GapiV2.Garlands.response.UserResponse;
import GapiV2.Garlands.security.JwtUtil;
import GapiV2.Garlands.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {
    private final UserService userService;
    private final UserRepo userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    public UsersController(UserService userService, UserRepo userRepository, AuthenticationManager authenticationManager, JwtUtil jwtUtil, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateProfile(@PathVariable int id, @RequestBody UpdateProfileRequest updateRequest) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }

        user.setFirstName(updateRequest.getFirstName());
        user.setLastName(updateRequest.getLastName());
        user.setAddress(updateRequest.getAddress());
        user.setPhoneNumber(updateRequest.getPhoneNumber());
        user.setDateOfBirth(updateRequest.getDateOfBirth());
        user.setOwnerName(updateRequest.getOwnerName());
        userRepository.save(user);

        return new ResponseEntity<>("Profile updated successfully", HttpStatus.OK);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<UserResponse>> getAll(){
        return new ResponseEntity<>(userService.getAll(),HttpStatus.OK);
    }

    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<UserResponse> getById(@PathVariable int id){
        return new ResponseEntity<>(userService.getResponseById(id),HttpStatus.OK);
    }

    @GetMapping("/is-following")
    public ResponseEntity<Boolean> isFollowing(@RequestParam int userId,@RequestParam int followingId){
        return new ResponseEntity<>(userService.isFollowing(userId,followingId),HttpStatus.OK);
    }

//    @PostMapping("/add")
//    public ResponseEntity<String> add(@RequestBody UserAddRequest userAddRequest){
//        userService.add(userAddRequest);
//        return new ResponseEntity<>("User Added",HttpStatus.CREATED);
//    }

    @PostMapping("/add")
    public ResponseEntity<String> register(@RequestBody RegisterRequest registerRequest) {
        if (userRepository.findByEmail(registerRequest.getEmail()) != null) {
            return new ResponseEntity<>("Email already exists", HttpStatus.BAD_REQUEST);
        }

        User user = new User();
        user.setFirstName(registerRequest.getFirstName());
        user.setEmail(registerRequest.getEmail());
        user.setLastName(registerRequest.getLastName());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setRole(Role.VISITOR); // Set the role to VISITOR
        userRepository.save(user);


        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(registerRequest.getEmail(), registerRequest.getPassword())
        );

        return new ResponseEntity<>(jwtUtil.generateToken(
                registerRequest.getEmail(),
                user.getId(),
                registerRequest.getFirstName() + registerRequest.getLastName() + " register success",
                user.getRole().toString()), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam int id){
        userService.delete(id);
        return new ResponseEntity<>("User with id " + id + " deleted successfully", HttpStatus.OK);
    }
}
