package innerClass;

public class EX26_InheritClass {
}

class WithInner {
    class Inner {
        public Inner() {
        }
    }
}

class Inner extends WithInner.Inner {

    public Inner(WithInner withInner) {
        withInner.super();
    }
}

