package com.yammer.business.objects;

public class Message {

  private String addressee;
  private String body;

  public Message(String addressee, String body) {
    this.addressee = addressee;
    this.body = body;
  }

  public String getAddressee() {
    return addressee;
  }

  public void setAddressee(String addressee) {
    this.addressee = addressee;
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

    Message message = (Message) o;

    if (addressee != null ? !addressee.equals(message.addressee) : message.addressee != null) {
      return false;
    }
    return body != null ? body.equals(message.body) : message.body == null;
  }

  @Override
  public int hashCode() {
    int result = addressee != null ? addressee.hashCode() : 0;
    result = 31 * result + (body != null ? body.hashCode() : 0);
    return result;
  }
}
