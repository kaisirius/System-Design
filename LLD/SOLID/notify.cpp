// 03-notify-dip-ocp.cpp
#include <iostream>
#include <string>

using namespace std;


struct User { string email; string phone; };

class NotifyParams {
public:
  string temp1;
  string body;
  string code;
};

class SmtpMailParams: public NotifyParams {
public:
  string temp1{"welcome"};
  string body{"Welcome!"};
};

class TwilioClientParams: public NotifyParams {
public:
  string code;
};

class INotifier {
public:
  virtual void send(const User& user, const NotifyParams& params) = 0;
  virtual ~INotifier() = default;
};


class SmtpMailer: public INotifier {
public:
    void send(const User& user, const NotifyParams& params) override {
        cout << "[SMTP] template=" << params.temp1 << " to=" << user.email << " body=" << params.body << "\n";
    }
};
class TwilioClient: public INotifier {
public:
    void send(const User& user, const NotifyParams& params) override {
        cout << "[Twilio] OTP " << params.code << " -> " << user.phone << "\n";
    }
};


class SignUpService {
public:
    bool signUp(const User& u) const{
        if (u.email.empty()) return false;
        // pretend DB save here…
        return true;
        // SRP rule break if notify here happens
        // notifier = new SmtpMailer(); still DIP issue if implemented this way
        // notifier->send(u, params);

        // notifier = new TwilioClient();
        // params.code = "123456";
        // notifier->send(u, params);  
    } 
};

class NotifyService {
public:
  void notifyViaChannel(const User& u, const NotifyParams& params, INotifier& notifier) const {
    notifier.send(u, params);
  }
};

int main() {
    SignUpService svc;
    const bool res = svc.signUp({"user@example.com", "+15550001111"});
    if(res) {
      NotifyService notifsvc;

      SmtpMailer Mailer;
      SmtpMailParams smtpParams;

      TwilioClient Twilio;
      TwilioClientParams twilioParams;
      twilioParams.code = "123456"; // ideally we should have random generator for code for every signup
      notifsvc.notifyViaChannel({"user@example.com", "+15550001111"}, smtpParams, Mailer);
      notifsvc.notifyViaChannel({"user@example.com", "+15550001111"}, twilioParams, Twilio);
    }
    return 0;
}