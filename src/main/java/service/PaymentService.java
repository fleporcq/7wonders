package service;

import model.*;

import java.util.ArrayList;
import java.util.List;

public class PaymentService {

    private static final int DEFAULT_RESOURCE_COST = 2;

    private Player player;

    private Player leftNeighbor;

    private Player rightNeighbor;

    private List<Resource> playerResourcesCopy = new ArrayList<>();

    private List<Resource> leftResourcesCopy = new ArrayList<>();

    private List<Resource> rightResourcesCopy = new ArrayList<>();

    public PaymentService(Player player) {
        this.player = player;
        this.leftNeighbor = player.getLeftNeighbor();
        this.rightNeighbor = player.getRightNeighbor();
        copyResources(player);
    }

    private void copyResources(Player player) {
        playerResourcesCopy.addAll(player.getResources());
        if (leftNeighbor != null)
            leftResourcesCopy.addAll(leftNeighbor.getResources());
        if (rightNeighbor != null)
            rightResourcesCopy.addAll(rightNeighbor.getResources());
    }

    public boolean pay(boolean simulate, Payment... payments) {
        for (Payment payment : payments) {
            if (payment instanceof Resource) {
                if (!payWithAResource((Resource) payment))
                    return false;
            } else if (payment instanceof Purchase) {
                if (!payWithAPurchase(simulate, (Purchase) payment))
                    return false;
            } else if (payment instanceof Coin) {
                if (!payWithACoin(simulate))
                    return false;
            } else {
                return false;
            }
        }
        return true;
    }

    private boolean payWithAPurchase(boolean simulate, Purchase purchase) {
        return purchase(purchase.getDirection(), purchase.getResource(), simulate);
    }

    private boolean purchase(Direction direction, Resource resource, boolean simulate) {
        List<Resource> resourcesCopy = direction == Direction.LEFT ? leftResourcesCopy : rightResourcesCopy;
        Player neighbor = direction == Direction.LEFT ? leftNeighbor : rightNeighbor;
        if (resourcesCopy.contains(resource) && player.getCoins() > DEFAULT_RESOURCE_COST) {
            resourcesCopy.remove(resource);
            if (!simulate) {
                neighbor.addCoins(DEFAULT_RESOURCE_COST);
                player.removeCoins(DEFAULT_RESOURCE_COST);
            }
            return true;
        }
        return false;
    }

    private boolean payWithAResource(Resource resource) {
        boolean paid = false;
        if (playerResourcesCopy.contains(resource)) {
            playerResourcesCopy.remove(resource);
            paid = true;
        }
        return paid;
    }

    private boolean payWithACoin(boolean simulate) {
        boolean paid = false;
        if (player.getCoins() > 0) {
            if (!simulate)
                player.removeCoins(1);
            paid = true;
        }
        return paid;
    }
}
