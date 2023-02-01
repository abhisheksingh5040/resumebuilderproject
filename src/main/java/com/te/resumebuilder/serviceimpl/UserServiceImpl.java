package com.te.resumebuilder.serviceimpl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.te.resumebuilder.dto.RegisterUserDto;
import com.te.resumebuilder.dto.UserProfileDto;
import com.te.resumebuilder.entity.EducationDetails;
import com.te.resumebuilder.entity.RegisterUser;
import com.te.resumebuilder.entity.UserProfile;
import com.te.resumebuilder.entity.UserRole;
import com.te.resumebuilder.entity.UserSkills;
import com.te.resumebuilder.exception.UserNotFoundException;
import com.te.resumebuilder.exception.UserProfileIdNotFoundException;
import com.te.resumebuilder.repository.EducationalDetailsRepository;
import com.te.resumebuilder.repository.RegisterUserRepository;
import com.te.resumebuilder.repository.UserProfileRepository;
import com.te.resumebuilder.service.UserService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class UserServiceImpl implements UserService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private RegisterUserRepository registerUserRepository;

	@Autowired
	private EducationalDetailsRepository educationalDetailsRepository;

	@Autowired
	private UserProfileRepository userProfileRepository;

	@Override
	public UserProfileDto addDataToResume(UserProfileDto userProfileDto) {
		UserSkills userSkills = new UserSkills();
		UserProfile userProfile = new UserProfile();
		modelMapper.map(userProfileDto.getUserSkills(), userSkills);
		modelMapper.map(userProfileDto, userProfile);
		userProfile.setUserSkills(userSkills);
		UserProfile userProfileSave = userProfileRepository.save(userProfile);
		userProfileSave.getUserSkills().setUserProfile(userProfileSave);
		List<EducationDetails> educationalDetails = userProfileSave.getEducationDetails();
		UserProfile users = userProfileRepository.save(userProfileSave);
		educationalDetails.forEach(user -> user.setUserProfile(users));
		educationalDetailsRepository.saveAll(educationalDetails);

		modelMapper.map(userProfile, userProfileDto);
		return userProfileDto;
	}

	@Override
	public UserProfileDto getUserById(Integer userProfileId) {
		UserProfile userProfile = userProfileRepository.findById(userProfileId)
				.orElseThrow(() -> new UserProfileIdNotFoundException("User Id not found"));
		UserProfileDto userProfileDto = new UserProfileDto();
		modelMapper.map(userProfile, userProfileDto);
		return userProfileDto;
	}

	@Override
	public RegisterUserDto registationOfUser(RegisterUserDto registerUserDto) {
		RegisterUser registerUser = new RegisterUser();
		BeanUtils.copyProperties(registerUserDto, registerUser);
		Set<UserRole> roles = new HashSet<>();
		UserRole userRole = new UserRole();
		userRole.setUserRole("USER");
		roles.add(userRole);
		registerUser.setRoles(roles);
		registerUserRepository.save(registerUser);
		BeanUtils.copyProperties(registerUser, registerUserDto);
		return registerUserDto;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		RegisterUser registerUser = registerUserRepository.findByRegisterUserEmail(username).orElseThrow(()->new UserNotFoundException("User not found"));
		return registerUser;
	}
}
