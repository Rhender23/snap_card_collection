package snapDeck.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import snapDeck.model.Card;
import snapDeck.repository.CardRepository;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private CardRepository cardRepository;

    @Override
    public List < Card > getAllCards() {
        return cardRepository.findAll();
    }

    @Override
    public void saveCard(Card card) {
        this.cardRepository.save(card);
    }

    @Override
    public Card getCardById(long id) {
        Optional < Card > optional = cardRepository.findById(id);
        Card card = null;
        if (optional.isPresent()) {
            card = optional.get();
        } else {
            throw new RuntimeException(" card not found for id :: " + id);
        }
        return card;
    }

    @Override
    public void deleteCardById(long id) {
        this.cardRepository.deleteById(id);
    }
}
