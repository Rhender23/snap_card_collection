package snapDeck.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cards")

public class Card {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "name")
	private String cardName;
	
	@Column(name= "power")
	private String cardPower;
	
	@Column(name= "energy")
	private String cardEnergy;
	
	@Column(name= "ability")
	private String cardAbility;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getCardName() {
		return cardName;
	}
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	
	public String getCardPower() {
		return cardPower;
	}
	public void setCardPower(String cardPower) {
		this.cardPower = cardPower;
	}
	public String getCardEnergy() {
		return cardEnergy;
	}
	public void setCardEnergy (String cardEnergy) {
		this.cardEnergy = cardEnergy;
	}
	
	public String getCardAbility() {
		return cardAbility;
	}
	public void setCardAbility(String cardAbility) {
		this.cardAbility = cardAbility;
	}
	
}
