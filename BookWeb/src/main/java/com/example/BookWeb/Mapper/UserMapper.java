package com.example.BookWeb.Mapper;

import com.example.BookWeb.Model.User;
import com.example.BookWeb.dto.UserCreationDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "usernameDTO",source = "user.username",ignore = true)
    UserCreationDTO UserToUserCreationDTO(User user);

    @Mapping(target = "username",source = "userCreationDTO.usernameDTO",ignore = true)
    User UserCreationDTOToUser(UserCreationDTO userCreationDTO);
}
