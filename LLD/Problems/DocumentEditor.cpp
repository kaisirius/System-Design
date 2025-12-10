#include <iostream>
#include <string>
#include <vector>
#include <fstream>

using namespace std;

class DocumentElements {
  public:
    virtual string render() = 0;
};

class TextElement: public DocumentElements {
  private:
    string text;
  public:
    TextElement(const string &text) {
      this->text = text;
    }
    string render() override {
      return text;
    }
};

class ImageElement: public DocumentElements {
  private:
    string path;
  public:
    ImageElement(const string &path) {
      this->path = path;
    }
    string render() override {
      return path;
    }
};

class NewLineElement: public DocumentElements {
  public:
    string render() override {
      return "\n"; 
    }
};

class TabElement: public DocumentElements {
  public:
    string render() override {
      return "\t"; 
    }
};

class Document {
  private:
    vector<DocumentElements*> docElements;
  public:
    void addElement(DocumentElements* element) {
      docElements.push_back(element);
    }

    string render() {
      string result = "";
      for(auto &element : docElements) {
        result += element->render();
      }
      return result;
    }
};

class Persistence {
  public: 
    virtual void save(const string &data) = 0;
};

class FileStorage: public Persistence {
  public: 
    void save(const string &data) override {
      try {
        ofstream outFile("document.txt");
        outFile << data;
        outFile.close();
        cout << "Document saved in file named document.txt" << endl;
      } catch(...) {
        cout << "Error while saving in file" << endl;
      }
    }
};

class DBStorage: public Persistence {
  public: 
    void save(const string &data) override {
      // save to db logic
      cout << "Saved to DB" << endl;
    }
};

class DocumentEditor {
  private:
    Document* document;
    Persistence* storage;
    string renderedDocument;
  public:
    DocumentEditor(Document* &document, Persistence* &storage) {
      this->document = document;
      this->storage = storage;
    }
    void addText(const string &text) {
      document->addElement(new TextElement(text));
    }
    void addImage(const string &path) {
      document->addElement(new ImageElement(path));
    }
    void addNewLine() {
      document->addElement(new NewLineElement());
    }
    void addTabSpace() {
      document->addElement(new TabElement());
    }
    string renderDoc() {
      renderedDocument = document->render();
      return renderedDocument;
    }
    void saveDocument() {
      storage->save(renderDoc());
    }
};

int main() {
  Document* doc = new Document();
  Persistence* persistence = new FileStorage();

  DocumentEditor* docEditor = new DocumentEditor(doc, persistence);
  
  docEditor->addText("Hello!!");
  docEditor->addNewLine();
  docEditor->addImage("picture.png");
  docEditor->addNewLine();
  docEditor->addText("Garvit");
  docEditor->addTabSpace();
  docEditor->addText("Khurana");

  cout << "Rendering doc..." << endl << docEditor->renderDoc() << endl;

  docEditor->saveDocument();
  return 0;
}