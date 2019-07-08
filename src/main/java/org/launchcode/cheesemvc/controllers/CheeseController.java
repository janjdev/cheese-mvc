package org.launchcode.cheesemvc.controllers;

import org.launchcode.cheesemvc.models.Cheese;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.ArrayList;
import java.util.HashMap;

@Controller
@RequestMapping("cheese")
public class CheeseController {

    static ArrayList<Cheese> cheeses = new ArrayList<>();

    //Request path: /cheese
    @RequestMapping("")
    public String index(Model model){

        model.addAttribute("cheeses", cheeses);
        model.addAttribute("title", "My Cheeses");
        return  "cheese/index";
    }
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model){
        model.addAttribute("title", "Add Cheese");
        return "cheese/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCheeseForm(@RequestParam String cheeseName, @RequestParam String description){
        Cheese newCheese = new Cheese(cheeseName, description);
        cheeses.add(newCheese);
        // Redirect to /cheese
        return  "redirect:";
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public  String displayRemoveCheeseForm(Model model){
        model.addAttribute("cheeses", cheeses );
        model.addAttribute("title", "Remove Cheese");
        return  "cheese/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST )
    public String processRemoveCheese(@RequestParam ArrayList<String> cheese){
       for (String aCheese: cheese){
           cheeses.remove(aCheese);
       }
        return  "redirect";
    }


}
