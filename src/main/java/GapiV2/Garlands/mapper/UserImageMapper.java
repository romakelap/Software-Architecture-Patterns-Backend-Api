package GapiV2.Garlands.mapper;

import GapiV2.Garlands.entity.UserImage;
import GapiV2.Garlands.response.UserImageResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserImageMapper {

    @Mapping(source = "user.id",target = "userId")
    UserImageResponse userImageToResponse(UserImage userImage);
}

