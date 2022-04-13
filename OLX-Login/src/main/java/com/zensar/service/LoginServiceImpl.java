package com.zensar.service;



import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import com.zensar.dto.User;
import com.zensar.entity.UserEntity;
import com.zensar.exception.InvalidCredentialsException;
import com.zensar.repository.UserRepo;
import com.zensar.security.JwtUtil;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	UserRepo userRepo;

	@Autowired
	ModelMapper modelMapper;

	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JwtUtil jwtUtil;

	@Override
	public String authenticate(User user) {
		try {
			this.authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword()));

		}
		
		catch(AuthenticationException ex) {
			throw new InvalidCredentialsException(ex.toString());
		}
		
		String jwt = jwtUtil.generateToken(user.getUserName());
		return jwt;
	}

	@Override
	public boolean logout(String authToken) {
		return true;

	}

	@Override
	public User registerUser(User user) {
		UserEntity userEntity = convertDTOIntoEntity(user);
		userEntity = userRepo.save(userEntity);
		return convertEntityIntoDTO(userEntity);
	}

	// get a user
	@Override
	public User getUserById(int id) {
		UserEntity uEntity = userRepo.getById(id);
		return convertEntityIntoDTO(uEntity);

	}

	@Override
	public String validateToken(String authToken) {
		return authToken;
	}

	private UserEntity convertDTOIntoEntity(User user) {
//		TypeMap<User, UserEntity> tMap = modelMapper.typeMap(User.class, UserEntity.class);
		UserEntity userEntity = modelMapper.map(user, UserEntity.class);
		return userEntity;
	}

	private User convertEntityIntoDTO(UserEntity userEntity) {
//		TypeMap<UserEntity, User> tMap = modelMapper.typeMap(UserEntity.class, User.class);
		User user = modelMapper.map(userEntity, User.class);
		return user;
	}

	@Override
	public User getUser(String authToken) {
		String username = jwtUtil.extractUsername(authToken);
		UserEntity userentity = userRepo.findByFirstName(username);
		return convertEntityIntoDTO(userentity);
	}

//  @Override
//  public User getUser() {
//	List<UserEntity> userEntityList = userRepo.findAll();
//	List<User> userDtoList = new ArrayList<User>();
//	for (UserEntity userEntity : userEntityList) {
//	    User user = convertEntityIntoDTO(userEntity);
//	    userDtoList.add(user);
//	}
//	return getUser();
//  }

}
