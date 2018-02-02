package model;

import model.cards.Card;
import model.wonderboards.WonderBoard;
import service.PaymentService;

import java.util.List;

public class Player {

    private String name;

    private WonderBoard wonderBoard;

    private Hand hand = new Hand();

    private Game game;

    private boolean played;

    public Player(String name) {
        if (name == null || name.trim().equals(""))
            throw new IllegalArgumentException("The player's name cannot be null or empty");
        this.name = name;
    }

    void setGame(Game game) {
        if (this.game != null)
            throw new IllegalStateException("The game is already setted");
        this.game = game;
    }

    public String getName() {
        return name;
    }

    public void setWonderBoard(WonderBoard wonderBoard) {
        this.wonderBoard = wonderBoard;
    }

    public WonderBoard getWonderBoard() {
        return wonderBoard;
    }

    public Hand getHand() {
        return hand;
    }

    public void choose(Card card) {
        if (played)
            throw new RulesViolationException("You have already played for this turn");
        hand.choose(card);
    }

    public void cancelChoice() {
        if (played)
            throw new RulesViolationException("You have already played for this turn");
        if (game.allPlayersHaveChoosenACard())
            throw new RulesViolationException("You cannot cancel your choice because all players have chosen a card");
        hand.cancelChoice();
    }

    public boolean hasChosenACard() {
        return hand.hasChoice();
    }

    public void build(Payment... payments) {
        if (played)
            throw new RulesViolationException("You have already played for this turn");
        if (!game.allPlayersHaveChoosenACard())
            throw new RulesViolationException("All players have not yet chosen a card");

        Card card = hand.getChoice();
        if (!card.validatePayment(payments))
            throw new RulesViolationException("Your payment does not match the card's cost");

        if (validatePayment(payments)) {
            pay(payments);
            card = hand.popChoice();
            wonderBoard.build(card);
            played = true;
        } else
            throw new RulesViolationException("You cannot honour this payment");
    }


    public boolean validatePayment(Payment... payments) {
        return pay(true, payments);
    }

    public boolean pay(Payment... payments) {
        return pay(false, payments);
    }

    private boolean pay(boolean simulate, Payment... payments) {
        PaymentService paymentService = new PaymentService(this);
        return paymentService.pay(simulate, payments);
    }

    public Player getLeftNeighbor() {
        if (game == null)
            return null;
        return game.getLeftNeighbor(this);
    }

    public Player getRightNeighbor() {
        if (game == null)
            return null;
        return game.getRightNeighbor(this);
    }

    public void sell() {
        if (played)
            throw new RulesViolationException("You have already played for this turn");
        if (!game.allPlayersHaveChoosenACard())
            throw new RulesViolationException("All players have not yet chosen a card");
        game.discard(hand.popChoice());
        wonderBoard.addCoins(Game.CARD_DISCARDING_AMOUT);
        played = true;
    }

    public List<Resource> getResources() {
        if (wonderBoard != null)
            return wonderBoard.getResources();
        return null;
    }

    public int getCoins() {
        if (wonderBoard != null)
            return wonderBoard.getCoins();
        return 0;
    }

    public void addCoins(int amount) {
        if (wonderBoard == null)
            throw new IllegalStateException("The player has not yet a wonder board");
        wonderBoard.addCoins(amount);
    }

    public void removeCoins(int amount) {
        if (wonderBoard == null)
            throw new IllegalStateException("The player has not yet a wonder board");
        wonderBoard.removeCoins(amount);
    }
}
