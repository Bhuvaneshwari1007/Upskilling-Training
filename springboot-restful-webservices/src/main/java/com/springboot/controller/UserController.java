package com.springboot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.dto.UserDto;
import com.springboot.service.UserService;

import lombok.AllArgsConstructor;



@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {
	
	private UserService userService;
	
	  @PostMapping
	    public ResponseEntity<UserDto> createUser(@RequestBody UserDto user){
		  UserDto savedUser = userService.createUser(user);
	        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	    }
	  
	  @GetMapping("{id}")
	  public ResponseEntity<UserDto> getUserById(@PathVariable("id")Long userId){
		  UserDto user = userService.getUserById(userId);
		return new ResponseEntity<>(user, HttpStatus.OK);
	  }
	  
	  @GetMapping
	  public ResponseEntity<List<UserDto>> getAllUsers(){
		  List<UserDto>users = userService.getAllUsers();
		  return new ResponseEntity<>(users, HttpStatus.OK); 
	  }
	  
	  @PutMapping("{id}")
	  public ResponseEntity<UserDto> updateUser(@PathVariable ("id")Long userId, @RequestBody UserDto user){
		  user.setId(userId);
		  UserDto updatedUser = userService.updateUser(user);
		return new ResponseEntity<>(updatedUser, HttpStatus.OK);
	  }
	  
	  @DeleteMapping("{id}")
	  public ResponseEntity<String>deleteUser(@PathVariable("id") Long userId){
		  userService.deleteUser(userId);
		return new ResponseEntity<>("User Successfully deleted!", HttpStatus.OK);
	  }  
	  
//	  @ExceptionHandler(ResourceNotFoundException.class)
//    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception,
//                                                                        WebRequest webRequest){
//
//        ErrorDetails errorDetails = new ErrorDetails(
//                LocalDateTime.now(),
//                exception.getMessage(),
//                webRequest.getDescription(false),
//                "USER_NOT_FOUND"
//        );
//        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
//    }
}
