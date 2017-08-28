package com.yammer.steps;

import com.yammer.business.objects.Group;
import com.yammer.business.objects.Post;
import com.yammer.pages.*;

public class PostSteps {

  private GroupPage groupPage;

  public PostSteps() {
    groupPage = new GroupPage();
  }

  public void createPost(Post post) {
    groupPage.createPost(post.getBody());
  }

  public void addPostToBookmarks() {
    groupPage.addPostToBookmark();
  }

  public void deletePostFromBookmark() {
    groupPage.removePostFromBookmark();
  }

  public void sharePostToAnotherGroup(Group group) {
    groupPage.openShareConversationPage().setAddresseeGroup(group.getGroupName()).clickSharePost();
  }

  public boolean checkSharedPostInGroup() {
    return groupPage.checkPostInGroup();
  }

  public void deleteLastPost() {
    groupPage.deletePost();
  }

  public String getLastPostText() {
    return groupPage.getLastPostBody();
  }
}
