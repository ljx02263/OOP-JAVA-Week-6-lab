public class Test {
    public static void main(String[] args) {
        B b = new B();
        System.out.println(b.getI());
    }

}
class A {
    private int i = 10;
    protected int j;

  public int getI() {
    return this.i;
  }
}

class B extends A {
    private int k = 11;
    protected int m;

    public int getI(){
        return super.getI();
    }
    // some methods omitted
}