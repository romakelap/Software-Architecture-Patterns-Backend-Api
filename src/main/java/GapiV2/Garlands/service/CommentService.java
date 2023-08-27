package GapiV2.Garlands.service;

import GapiV2.Garlands.entity.Comment;
import GapiV2.Garlands.mapper.CommentMapper;
import GapiV2.Garlands.repository.CommentRepo;
import GapiV2.Garlands.request.CommentAddRequest;
import GapiV2.Garlands.request.CommentUpdateRequest;
import GapiV2.Garlands.response.CommentGetResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private final CommentRepo commentRepo;
    private final CommentMapper commentMapper;

    public CommentService(CommentRepo commentRepo, CommentMapper commentMapper) {
        this.commentRepo = commentRepo;
        this.commentMapper = commentMapper;
    }

    public void add(CommentAddRequest commentAddRequest){
        Comment comment = commentMapper.addRequestToComment(commentAddRequest);
        commentRepo.save(comment);
    }

    public List<CommentGetResponse> getAll(){
        List<Comment> comments = commentRepo.findAll();
        return commentMapper.commentToResponse(comments);
    }

    public CommentGetResponse getById(int id){
        Comment comment = commentRepo.findById(id).orElse(null);
        return commentMapper.commentToResponse(comment);
    }

    public List<CommentGetResponse>  getAllByPost(int postId){
        List<Comment> comments = commentRepo.findAllByPost_Id(postId);
        return commentMapper.commentToResponse(comments);
    }

    public List<CommentGetResponse> getAllByUser(int userId){
        List<Comment> comments = commentRepo.findAllByUser_Id(userId);
        return commentMapper.commentToResponse(comments);
    }

    public void update(int id, CommentUpdateRequest commentUpdateRequest){
        Comment commentToUpdate = commentRepo.findById(id).orElse(null);
        if (commentToUpdate!= null){
            commentToUpdate.setDescription(commentUpdateRequest.getDescription());
        }
    }

    public void delete(int id){
        commentRepo.deleteById(id);
    }
}
