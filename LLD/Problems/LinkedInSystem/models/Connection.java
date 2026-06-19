package LLD.Problems.LinkedInSystem.models;

import java.time.LocalDateTime;

import LLD.Problems.LinkedInSystem.enums.ConnectionStatus;

public class Connection {
  private String id;
  private Account fromAccount;
  private Account toAccount;
  private LocalDateTime connectedTimeStamp;
  private ConnectionStatus currentStatus;

  public Connection(String id, Account from, Account to, LocalDateTime time) {
    this.id = id;
    fromAccount = from;
    toAccount = to;
    connectedTimeStamp = time;
    currentStatus = ConnectionStatus.PENDING;
  }

  public String getId() {
    return id;
  }

  public Account getFromAccount() {
    return fromAccount;
  }

  public Account getToAccount() {
    return toAccount;
  }

  public LocalDateTime getTimeStamp() {
    return connectedTimeStamp;
  }

  public ConnectionStatus getStatus() {
    return currentStatus;
  }

  public void setStatus(ConnectionStatus status) {
    currentStatus = status;
  }
}
