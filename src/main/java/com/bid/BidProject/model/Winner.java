package com.bid.BidProject.model;

import java.util.Date;

public class Winner {
   public int price;
   public User winner;

    public Date getProjDeadLine() {
        return projDeadLine;
    }

    public void setProjDeadLine(Date projDeadLine) {
        this.projDeadLine = projDeadLine;
    }

    public Date projDeadLine;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public User getWinner() {
        return winner;
    }

    public void setWinner(User winner) {
        this.winner = winner;
    }
}
