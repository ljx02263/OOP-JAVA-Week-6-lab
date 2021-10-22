public class AnimalA {
  void eat(AnimalA a) {
    System.out.println("A eat A");
  }
}

class AnimalB extends AnimalA {
  void eat(AnimalB b) {
    System.out.println("B eat B");
  }

  void eat(AnimalA a) {
    System.out.println("B eat A");
  }

  void dontEat() {
    System.out.println("B do not eat anything");
  }

  void dontEat(AnimalC c) {
    System.out.println("B do not eat C");
  }
}

class AnimalC extends AnimalB {
  void eat(AnimalC c) {
    System.out.println("C eat C");
  }

  void eat(AnimalB b) {
    System.out.println("C eat B");
  }

  void eat(AnimalA a) {
    System.out.println("C eat A");
  }

  void dontEat() {
    System.out.println("C do not eat anything");
  }

  void dontEat(AnimalA a) {
    System.out.println("C do not eat A");
  }

  public static void main(String[] args) {
    AnimalA a = new AnimalB(); // a reference -> B object
    AnimalC b = new AnimalC(); // b reference -> C object

    // B eat A: dynamic binding
    a.eat(new AnimalA());

    // B eat A: A do not have eat(new AnimalB) method but B has, a reference could not use this
    // method
    // but AnimalB is a type of AnimalA; then B's eat(new AnmialA) is used
    a.eat(new AnimalB());

    // C eat A: dynamic binding
    b.eat(a);

    // a.dontEat won't work: no dontEat method in AnimalA of reference a
    // need type cast to AnimalB
    ((AnimalB) a).dontEat(new AnimalC());

    /* b(Object type C) inherit both dontEat method, depends on the input type */
    // B do not eat C
    b.dontEat(new AnimalC());

    // C do not eat A
    b.dontEat(new AnimalA());

    // C do not eat anything: dynamic binding
    b.dontEat();
  }
}
