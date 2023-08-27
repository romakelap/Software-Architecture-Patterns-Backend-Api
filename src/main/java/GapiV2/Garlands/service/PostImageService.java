package GapiV2.Garlands.service;

import GapiV2.Garlands.entity.PostImage;
import GapiV2.Garlands.mapper.PostImageMapper;
import GapiV2.Garlands.repository.PostImageRepo;
import GapiV2.Garlands.response.PostImageResponse;
import GapiV2.Garlands.utils.ImageUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class PostImageService {
    private final PostImageRepo postImageRepo;
    private final PostService postService;
    private final PostImageMapper postImageMapper;

    public PostImageService(PostImageRepo postImageRepo, PostService postService, PostImageMapper postImageMapper) {
        this.postImageRepo = postImageRepo;
        this.postService = postService;
        this.postImageMapper = postImageMapper;
    }
    public PostImageResponse upload(MultipartFile file, int postId) throws IOException {
        PostImage postImage = new PostImage();
        postImage.setName(file.getOriginalFilename());
        postImage.setType(file.getContentType());
        postImage.setData(ImageUtil.compressImage(file.getBytes()));
        postImage.setPost(postService.getById(postId));
        postImageRepo.save(postImage);
        return postImageMapper.imageToResponse(postImage);
    }

    public byte[] download(int id){
        Optional<PostImage> postImage = postImageRepo.findPostImageByPost_Id(id);
        if (postImage.isPresent()){
            return ImageUtil.decompressImage(postImage.get().getData());
        }
        return null;
    }
    public List<PostImage> getAllPostImages() {
        return postImageRepo.findAll();
    }

}
