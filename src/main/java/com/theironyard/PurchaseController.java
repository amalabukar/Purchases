package com.theironyard;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.io.File;
import java.util.Scanner;

/**
 * Created by amalabukar on 1/9/17.
 */
@Controller
public class PurchaseController {
    @Autowired
    CustomerRepository customers;

    @Autowired
    PurchaseRepository users;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model, String category) {
        List<Purchase> purchaseList;
        if(category != null) {
            purchaseList = users.findByCategory(category);
        } else {
            purchaseList = (List<Purchase>) users.findAll();
        }

        model.addAttribute("users", purchaseList);
        return "home";
    }

    @PostConstruct
    public void init() throws Exception {
        if(customers.count() == 0) {
            File f = new File("customers.csv");
            Scanner fileScanner = new Scanner(f);
            while(fileScanner.hasNext()) {
                String line = fileScanner.nextLine();
                String[] a = line.split(",");
                Customer c = new Customer(a[0], a[1]);
                customers.save(c);

            }
        }
        if(users.count() == 0) {
            File p = new File("purchases.csv");
            Scanner fileScanner = new Scanner(p);
            while (fileScanner.hasNext()) {
                String line = fileScanner.nextLine();
                String[] a = line.split(",");
                Purchase d = new Purchase(a[1], a[2], Integer.parseInt(a[3]), a[4], customers.findOne(Integer.parseInt(a[0])));
                users.save(d);
            }

        }




    }
}
