package LLD.Problems.LinkedInSystem.services;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import LLD.Problems.LinkedInSystem.enums.ConnectionStatus;
import LLD.Problems.LinkedInSystem.enums.NotificationType;
import LLD.Problems.LinkedInSystem.models.Account;
import LLD.Problems.LinkedInSystem.models.Connection;
import LLD.Problems.LinkedInSystem.models.Notification;

public class ConnectionService {
  private static int counter = 1;
  private Map<String, Connection> allConnections;
  private NotificationService notificationService;

  public ConnectionService() {
    allConnections = new HashMap<>();
    notificationService = new NotificationService();
  }

  public String addConnection(Account from, Account to, LocalDateTime time) {
    Connection connection = new Connection("random-uuid " + counter, from, to, time);
    allConnections.put(connection.getId(), connection);
    counter++;
    
    Notification notif = new Notification("random-uuid", "Connection request from: " + from.getName(), NotificationType.CONNECTION_REQUEST, time);
    notificationService.sendNotification(to, notif);

    return connection.getId();
  }

  public void acceptConnection(String id) {
    Connection connection = allConnections.get(id);
    connection.setStatus(ConnectionStatus.ACCEPTED);

    Account from = connection.getFromAccount();
    Account to = connection.getToAccount();

    Notification notif1 = new Notification("random-uuid", "Connection request accepted by: " + to.getName(), NotificationType.CONNECTION_ACCEPT, LocalDateTime.now());
    notificationService.sendNotification(from, notif1);

    from.addConnection(to);
    to.addConnection(from);
  }

}
