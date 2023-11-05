package org.velezreyes.quiz.question6;

import static org.velezreyes.quiz.question6.Drinks.KarenTea;
import static org.velezreyes.quiz.question6.Drinks.ScottCola;
import static org.velezreyes.quiz.question6.Drinks.costKarenTea;
import static org.velezreyes.quiz.question6.Drinks.costScottCola;

public class VendingMachineImpl implements VendingMachine{

  double money = 0;

  public static VendingMachine getInstance() {
    // Fix me!
    return new VendingMachineImpl();
  }

  @Override
  public void insertQuarter() {

    money = money + 0.25;
  }

  @Override
  public Drink pressButton(String name) throws NotEnoughMoneyException, UnknownDrinkException {
    Drink drink = new Drink() {
      @Override
      public String getName() {
        return name;
      }

      @Override
      public boolean isFizzy() {
        if(getName()==KarenTea){
          return false;
        }
        else if (getName()== ScottCola) {
          return true;
        }
        return false;
      }
    };
    if(money == 0.0){
      throw new NotEnoughMoneyException();
    }else {
      if(name == KarenTea){
        if(money >= costKarenTea){
          return  drink;
        }else {
          throw new NotEnoughMoneyException();
        }
      }
      else if (name == ScottCola) {
        if(money >= costScottCola){
          return  drink;
        }else {
          throw new NotEnoughMoneyException();
        }
      }
      else {
        throw new UnknownDrinkException();
      }

    }

  }
}
