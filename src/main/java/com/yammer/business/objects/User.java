package com.yammer.business.objects;

public class User {

  private static User user;
  private String userName;
  private String password;
  private Group group;
  private Post post;
  private Comment comment;
  private Message message;
  private String searchQuery;

  private User(String userName, String password) {
    this.userName = userName;
    this.password = password;
  }

  public static User getInstance(String userName, String password) {
    if (user == null) {
      user = new User(userName, password);
    }
    return user;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Post getPost() {
    return post;
  }

  public void setPost(Post post) {
    this.post = post;
  }

  public Comment getComment() {
    return comment;
  }

  public void setComment(Comment comment) {
    this.comment = comment;
  }

  public Message getMessage() {
    return message;
  }

  public void setMessage(Message message) {
    this.message = message;
  }

  public String getSearchQuery() {
    return searchQuery;
  }

  public void setSearchQuery(String searchQuery) {
    this.searchQuery = searchQuery;
  }

  public Group getGroup() {
    return group;
  }

  public void setGroup(Group group) {
    this.group = group;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    User user = (User) o;

    if (userName != null ? !userName.equals(user.userName) : user.userName != null) {
      return false;
    }
    if (password != null ? !password.equals(user.password) : user.password != null) {
      return false;
    }
    if (group != null ? !group.equals(user.group) : user.group != null) {
      return false;
    }
    if (post != null ? !post.equals(user.post) : user.post != null) {
      return false;
    }
    if (comment != null ? !comment.equals(user.comment) : user.comment != null) {
      return false;
    }
    if (message != null ? !message.equals(user.message) : user.message != null) {
      return false;
    }
    return searchQuery != null ? searchQuery.equals(user.searchQuery) : user.searchQuery == null;
  }

  @Override
  public int hashCode() {
    int result = userName != null ? userName.hashCode() : 0;
    result = 31 * result + (password != null ? password.hashCode() : 0);
    result = 31 * result + (group != null ? group.hashCode() : 0);
    result = 31 * result + (post != null ? post.hashCode() : 0);
    result = 31 * result + (comment != null ? comment.hashCode() : 0);
    result = 31 * result + (message != null ? message.hashCode() : 0);
    result = 31 * result + (searchQuery != null ? searchQuery.hashCode() : 0);
    return result;
  }
}
