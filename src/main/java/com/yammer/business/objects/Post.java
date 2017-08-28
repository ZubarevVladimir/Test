package com.yammer.business.objects;

public class Post {

  private String body;

  public Post(String body) {
    this.body = body;
  }

  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Post post = (Post) o;

    return body != null ? body.equals(post.body) : post.body == null;
  }

  @Override
  public int hashCode() {
    return body != null ? body.hashCode() : 0;
  }
}
