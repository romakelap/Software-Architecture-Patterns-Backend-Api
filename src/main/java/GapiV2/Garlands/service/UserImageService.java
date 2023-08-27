package GapiV2.Garlands.service;

import GapiV2.Garlands.entity.UserImage;
import GapiV2.Garlands.mapper.UserImageMapper;
import GapiV2.Garlands.repository.UserImageRepo;
import GapiV2.Garlands.response.UserImageResponse;
import GapiV2.Garlands.utils.ImageUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class UserImageService {

    private final UserImageRepo userImageRepository;
    private final UserService userService;
    private final UserImageMapper
            userImageMapper;

    public UserImageService(UserImageRepo userImageRepository, UserService userService, UserImageMapper userImageMapper) {
        this.userImageRepository = userImageRepository;
        this.userService = userService;
        this.userImageMapper = userImageMapper;
    }

    public UserImageResponse upload(MultipartFile file, int userId) throws IOException {
        UserImage userImage = new UserImage();
        userImage.setData(ImageUtil.compressImage(file.getBytes()));
        userImage.setName(file.getOriginalFilename());
        userImage.setType(file.getContentType());
        userImage.setUser(userService.getById(userId));
        userImageRepository.save(userImage);
        return userImageMapper.userImageToResponse(userImage);
    }

    public byte[] download(int id){
        Optional<UserImage> userImage = userImageRepository.findByUser_Id(id);
        return ImageUtil.decompressImage(userImage.get().getData());
    }
}
