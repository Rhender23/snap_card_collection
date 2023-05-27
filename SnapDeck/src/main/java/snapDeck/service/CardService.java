package snapDeck.service;

import java.util.List;

import snapDeck.model.Card;

public interface CardService {
	List<Card> getAllCards();
	void saveCard(Card card);
	Card getCardById(long id);
    void deleteCardById(long id);

}

