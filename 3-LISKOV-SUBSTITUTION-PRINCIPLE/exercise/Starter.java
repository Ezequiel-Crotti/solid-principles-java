// LSP Practice Exercise — starter code. Square silently breaks Rectangle's
// contract. Redesign so substituting Square for Rectangle can never surprise
// a caller. See README.md in this folder for the full task and requirements.

class Rectangle implements Area{
    protected int width;
    protected int height;

    public Rectangle(int width, int height){
        this.width = width;
        this.height = height;
    }

    public int getArea() {
        return width * height;
    }
}

class Square implements Area {

    protected int side;

    public Square(int side){
        this.side = side;
    }

    @Override
    public int getArea() {
        return this.side * this.side;
    }
}

public class Starter {
    public static void main(String[] args) {
        Square squa = new Square(5);
        Rectangle rect = new Rectangle(5,10);

        // A caller of Rectangle expects independent width/height -> area 50.
        // A Square can't honor that -> area is actually 100.
        System.out.println("Expected 50, got: " + rect.getArea());
        System.out.println("Expected 25, got: " + squa.getArea());
    }
}

interface Area{
    int getArea();
}
