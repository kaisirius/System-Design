package LLD.Problems.LinkedInSystem.services;

import LLD.Problems.LinkedInSystem.models.Account;
import LLD.Problems.LinkedInSystem.models.Notification;

public class NotificationService {
  public void sendNotification(Account toAccount, Notification notif) {
    toAccount.update(notif);
  }
}
