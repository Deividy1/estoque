package com.example.estoque.dto;


import com.example.estoque.model.document.User;
import com.example.estoque.model.enums.UserProfile;
import lombok.*;

@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UserDTO {

    private String id;
    private String name;
    private String email;
    private UserProfile profile;

    public static UserDTO fromUser(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .profile(user.getProfile())
                .build();
    }
}
