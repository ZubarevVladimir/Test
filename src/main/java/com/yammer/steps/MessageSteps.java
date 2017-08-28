package com.yammer.steps;

import com.yammer.business.objects.Message;
import com.yammer.pages.HomePage;
import com.yammer.pages.InboxPage;

public class MessageSteps {

  private HomePage homePage;
  private InboxPage inboxPage;

  public MessageSteps() {
    homePage = new HomePage();
    inboxPage = new InboxPage();
  }

  public void openInboxPage() {
    homePage.clickInboxPageButton();
  }

  public void sendNewPrivateMessage(Message message) {
    inboxPage.clickNewMessageButton()
        .clickPrivateMessageType()
        .fillMessage(message.getAddressee(), message.getBody())
        .clickSendMessageButton();
  }

  public boolean checkSentMessage(Message message) {
    //inboxPage.openPrivateMessagesFolder();
    return inboxPage.openLastSentMessage().checkMessageForEqual(message.getAddressee(), message.getBody());
  }
}
