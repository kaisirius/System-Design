// 01-invoice-srp-ocp.cpp
#include <iostream>
#include <sstream>
#include <string>
#include <vector>
#include <map>
#include <stdexcept>

using namespace std;

struct LineItem {
    string sku;
    int quantity{0};
    double unitPrice{0.0};
};

struct InvoiceParams {
    double sub_total;
    double discount_total;
    double tax_total;
    double grand_total;
};

// MISTAKE - 1
// This method is ok as of now but can be problematic if we add more types of discount
// and those discounts depends on further params which will make our interface bulky
// violating ISP, SRP (since most of params unused), OCP to much modification
// To solve this have a discountContext struct which will have all the params
class IDiscountType {
public:
    virtual double ApplyDiscount(const double& v, const double& subtotal) = 0; 
};

class PercentOffDiscount: public IDiscountType {
public:
    double ApplyDiscount(const double& v, const double& subtotal) override {
        return subtotal * (v / 100.0);
    }
};

class FlatOffDiscount: public IDiscountType {
public:
    double ApplyDiscount(const double& v, const double& subtotal) override {
        return v;
    }
};

class InvoiceSubTotal {
public:
    double SubTotal(const vector<LineItem>& items) const {
        double subtotal = 0.0;
        for (auto& it : items) subtotal += it.unitPrice * it.quantity;
        return subtotal;
    }
}; 

class InvoiceDiscountTotal {
public: 
    double DiscountTotal(const map<IDiscountType*, double>& discounts, const double subtotal) const {
        double discount_total = 0.0;
        for (auto& kv : discounts) {
            IDiscountType* k = kv.first;
            double v = kv.second;
            discount_total += (k->ApplyDiscount(v, subtotal));
        }
        return discount_total;
    }
};

class InvoiceTaxTotal {
public: 
    double TaxTotal(const double subtotal, const double discount_total) const {
        double tax = (subtotal - discount_total) * 0.18; 
        return tax;
    }
};

class InvoiceGrandTotal {
public:
    double GrandTotal(const double subtotal, const double discount_total, const double tax) const {
        double grand = subtotal - discount_total + tax;
        return grand;
    }
};

class InvoiceCalculator {
private:
    InvoiceSubTotal subCalculator;
    InvoiceDiscountTotal discountCalculator;
    InvoiceTaxTotal taxCalculator;
    InvoiceGrandTotal grandCalculator;

public:
    InvoiceParams calculate(const vector<LineItem>& items, const map<IDiscountType*, double>& discounts) const {
        InvoiceParams params;
        params.sub_total = subCalculator.SubTotal(items);
        params.discount_total = discountCalculator.DiscountTotal(discounts, params.sub_total);
        params.tax_total = taxCalculator.TaxTotal(params.sub_total, params.discount_total);
        params.grand_total = grandCalculator.GrandTotal(params.sub_total, params.discount_total, params.tax_total);
        return params;

    }
};

class InvoicePrinter{
public:
    void printItems(ostringstream& pdf, const vector<LineItem>& items) const {
        pdf << "INVOICE\n";
        for (auto& it : items) {
            pdf << it.sku << " x" << it.quantity << " @ " << it.unitPrice << "\n";
        }
    };
    void printParams(ostringstream& pdf, const InvoiceParams& params) const {
        pdf << "Subtotal: " << params.sub_total << "\n"
            << "Discounts: " << params.discount_total << "\n"
            << "Tax: " << params.tax_total << "\n"
            << "Total: " << params.grand_total << "\n";
    }
};

class InvoiceLogger {
public:
    void Log(const string& email, const double& grand) const {
        cout << "[LOG] Invoice processed for " << email << " total=" << grand << "\n";
    }
};

class Mailer {
public:
    void Mail(const string& email) const {
        if (!email.empty()) {
            cout << "[SMTP] Sending invoice to " << email << "...\n";
        }
    }
};


// MISTAKE - 2
// DIP rule is violated because we are depending on concrete classes.
// we must depend on abstractions for eg: in future mail provider can change
// we can have different type of logger so logic can change
// here our process behavior is not generic 
class InvoiceService {
public:
    string process(const vector<LineItem>& items,
                   const map<IDiscountType*, double>& discounts,
                   const string& email,
                   const InvoiceCalculator& calculator,
                   const InvoicePrinter& printer,
                   const Mailer& mailer,
                   const InvoiceLogger& logger) const {
        InvoiceParams params = calculator.calculate(items, discounts);

        ostringstream pdf;
        printer.printItems(pdf, items);
        printer.printParams(pdf, params);

        mailer.Mail(email);
        logger.Log(email, params.grand_total);

        return pdf.str();
    }
};

int main() {
    InvoiceService svc; 
    InvoiceCalculator calculator;
    InvoicePrinter printer;
    Mailer mailer;
    InvoiceLogger logger;

    // Create items
    vector<LineItem> items = { {"ITEM-001", 3, 100.0}, {"ITEM-002", 1, 250.0} };
    map<IDiscountType*,double> discounts = { {new PercentOffDiscount(), 10.0} };
    cout << svc.process(items, discounts, "customer@example.com", calculator, printer, mailer, logger) << endl;
    return 0;
} 