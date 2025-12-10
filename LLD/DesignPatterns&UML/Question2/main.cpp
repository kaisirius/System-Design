#include <iostream>
#include <string>
#include <memory>
#include <stdexcept>

class Button {
  public:
    virtual void render() = 0;
};

class TextField {
  public:
    virtual void render() = 0;
};

class Dialog {
  public:
    virtual void render() = 0;
};

class AndroidButton: public Button {
  public:
    void render() override {
      std::cout << "Android Button rendering..." << std::endl;
    }
};

class WebButton: public Button {
  public:
    void render() override {
      std::cout << "Web Button rendering..." << std::endl;
    }
};

class AndroidTextField: public TextField {
  public:
    void render() override {
      std::cout << "Android Text Field rendering..." << std::endl;
    }
};

class WebTextField: public TextField {
  public:
    void render() override {
      std::cout << "Web Text Field rendering..." << std::endl;
    }
};

class AndroidDialog: public Dialog {
  public:
    void render() override {
      std::cout << "Android Dialog rendering..." << std::endl;
    }
};

class WebDialog: public Dialog {
  public:
    void render() override {
      std::cout << "Web Dialog rendering..." << std::endl;
    }
};

class GUIFactory {
  public:
    virtual Button* createButton() = 0;
    virtual TextField* createTextField() = 0;
    virtual Dialog* createDialog() = 0;
};

class WebFactory: public GUIFactory {
  public:
    Button* createButton() override {
      return new WebButton();
    }
    TextField* createTextField() override {
      return new WebTextField();
    }
    Dialog* createDialog() override {
      return new WebDialog();
    }
};

class AndroidFactory: public GUIFactory {
  public:
    Button* createButton() override {
      return new AndroidButton();
    }
    TextField* createTextField() override {
      return new AndroidTextField();
    }
    Dialog* createDialog() override {
      return new AndroidDialog();
    }
};

class FactoryProvider {
  public:
    static GUIFactory* setupFactory(const std::string &type) {
      if(type == "Android") {
        return new AndroidFactory();
      } else if(type == "Web") {
        return new WebFactory();
      }
      throw std::invalid_argument("Invalid Factory setup argument " + type);
    }
};


int main() {
  GUIFactory* factory = FactoryProvider::setupFactory("Android");

  Button* btn = factory->createButton();
  TextField* txtField = factory->createTextField();
  Dialog* dlg = factory->createDialog();

  btn->render();
  txtField->render();
  dlg->render();
  return 0;
}