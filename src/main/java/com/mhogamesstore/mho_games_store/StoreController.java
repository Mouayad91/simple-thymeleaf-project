package com.mhogamesstore.mho_games_store;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class StoreController {

    List<Games> games = new ArrayList<>();

    @GetMapping("/")
    public String getForm(Model model, @RequestParam(required = false) String id) {
       
       int index=getIndexId(id);
        model.addAttribute("games", index == Constants.NOT_FOUND? new Games(): games.get(index) );
        model.addAttribute("categories", Constants.CATEGORIES);
        return "form";
    }

    @GetMapping("/inventory")
    public String getInventory(Model model) {
        model.addAttribute("games", games);
        return "inventory";
    }

    @PostMapping("/submit")
    public String submitHandle(Games game, RedirectAttributes redirectAttributes) {
        int index = getIndexId(game.getId());
        String status = Constants.Success;
        if(index == Constants.NOT_FOUND){

            games.add(game);

        }else if (within10Days(game.getDate(), games.get(index).getDate())){
            games.set(index, game);


        }else{

            status = Constants.failed;
        }
        
        redirectAttributes.addFlashAttribute("status", status);
        return "redirect:/inventory";
    }

    public int getIndexId(String id){

        for(int i=0; i< games.size();i++){

            if(games.get(i).getId().equals(id))
            return i;

}
            return Constants.NOT_FOUND;

    }

    public boolean within10Days(LocalDate newDate, LocalDate oldDate) {
        long diff = Math.abs(java.time.temporal.ChronoUnit.DAYS.between(newDate, oldDate));
        return diff <= 10;
    }
   

}
