package snapDeck.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import snapDeck.model.Card;
import snapDeck.service.CardService;

@Controller
public class CardController {
	
	@Autowired
	private CardService cardService;
	
	// display list of cards
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listCards", cardService.getAllCards());
		return "index";
	}
	@GetMapping("/showNewCardForm")
    public String showNewCardForm(Model model) {
        // create model attribute to bind form data
        Card card = new Card();
        model.addAttribute("card", card);
        return "new_card";
    }

    @PostMapping("/saveCard")
    public String saveCard(@ModelAttribute("card") Card card) {
        // save card to database
        cardService.saveCard(card);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        // get card from the service
        Card card = cardService.getCardById(id);

        // set card as a model attribute to pre-populate the form
        model.addAttribute("card", card);
        return "update_card";
    }

    @GetMapping("/deleteCard/{id}")
    public String deleteCard(@PathVariable(value = "id") long id) {

        // call delete card method 
        this.cardService.deleteCardById(id);
        return "redirect:/";
    }
}