package com.yammer.business.objects;

public class Comment {

  private String body;

  public Comment(String body) {
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

    Comment comment = (Comment) o;

    return body != null ? body.equals(comment.body) : comment.body == null;
  }

  @Override
  public int hashCode() {
    return body != null ? body.hashCode() : 0;
  }
}
