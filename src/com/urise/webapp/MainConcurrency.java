package com.urise.webapp;


public class MainConcurrency {

    static class Friend {
        private final String name;
        public Friend(String name) {
            this.name = name;
        }
        public String getName() {
            return this.name;
        }
        public synchronized void bow(Friend bower) {//Alphonse locked
            System.out.format("%s: %s"
                            + "  has bowed to me!%n",
                    this.name, bower.getName());
            bower.bowBack(this);// gaston bow back Alphonse
            System.out.format("Gaston bow back Alphonse");//we never see this line cause the line before is locked

        }
        public synchronized void bowBack(Friend bower) {//gaston
            System.out.format("%s: %s"
                            + " has bowed back to me!%n",
                    this.name, bower.getName());
        }
    }

    public static void main(String[] args) {
        final Friend alphonse =
                new Friend("Alphonse");
        final Friend gaston =
                new Friend("Gaston");

        new Thread(() ->  alphonse.bow(gaston)).start(); //this line lock alphonse

        new Thread(() -> gaston.bow(alphonse)).start();//this line lock gaston
    }
}