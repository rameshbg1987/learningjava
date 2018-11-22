package designpatterns;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ramesh BG
 *
 */
public class Subject {

    private List<Observer> observerList = new ArrayList<>();
    
    private int a;

    public int getA() {
        return this.a;
    }

    public void setA(int a) {
        this.a = a;
        notifyListeners(this.getA());
    }
    
    private void notifyListeners(int i) {
        for (Observer observer : observerList) {
            observer.update(i);
        }
    }
    
    public void registerListener(Observer observer) {
        observerList.add(observer);
    }

    public void clearListeners() {
        this.observerList.clear();
    }
}