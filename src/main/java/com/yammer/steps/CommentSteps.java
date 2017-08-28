package com.yammer.steps;

import com.yammer.business.objects.Comment;
import com.yammer.pages.GroupPage;

public class CommentSteps {

  private GroupPage groupPage;

  public CommentSteps() {
    groupPage = new GroupPage();
  }

  public void createComment(Comment comment) {
    groupPage.createReplyForLastPost(comment.getBody());
  }

  public void deleteLastComment() {
    groupPage.deleteReply();
  }

  public String getLastCommentText() {
    return groupPage.getLastCommentBody();
  }
}
