package GapiV2.Garlands.service;

import GapiV2.Garlands.entity.Like;
import GapiV2.Garlands.mapper.LikeMapper;
import GapiV2.Garlands.repository.LikeRepo;
import GapiV2.Garlands.request.LikeRequest;
import GapiV2.Garlands.response.LikeResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LikeService {
    private final LikeRepo likeRepo;
    private final LikeMapper likeMapper;


    public LikeService(LikeRepo likeRepo, LikeMapper likeMapper) {
        this.likeRepo = likeRepo;
        this.likeMapper = likeMapper;
    }
    public List<LikeResponse> getAllByPost(int postId){
        List<Like> likes = likeRepo.findAllByPost_Id(postId);
        return likeMapper.likesToLikeResponses(likes);
    }

    public List<LikeResponse> getAllByUser(int userId){
        List<Like> likes = likeRepo.findAllByUser_Id(userId);
        return likeMapper.likesToLikeResponses(likes);
    }

    public boolean isLiked(int userId,int postId){
        Optional<Like> like = likeRepo.findByUser_IdAndPost_Id(userId,postId);
        return like.isPresent();
    }

    public void add(LikeRequest likeRequest){
        if (isLiked(likeRequest.getUserId(), likeRequest.getPostId())){
            return;
        }
        Like like = likeMapper.requestToLike(likeRequest);
        likeRepo.save(like);
    }

    public void delete(LikeRequest likeRequest){
        Optional<Like> like = likeRepo.findByUser_IdAndPost_Id(likeRequest.getUserId(),likeRequest.getPostId());
        likeRepo.delete(like.get());
    }
}
