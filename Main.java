import java.util.Scanner;
//Complete this program that the user will be able to choose the quadrilateral it wants to calculate its perimeter and area

public class Main {

    public static void main(String[] args) {
        //Declare a char to store the chosen quadrilateral
        Scanner scan = new Scanner(System.in);
        char quadChoice;

        //using a switch check what the user selected and use it to calculate the perimeter and area of the desired quadrilateral
            System.out.println("Select a shape to calculate by typing in the designated letter in bracket:" +
                    "\n\t1. Parallelogram (P)" +
                    "\n\t2. Trapezoid (T)" +
                    "\n\t3. Rhombus (X)" +
                    "\n\t4. Square (S)" +
                    "\n\t5. Rectangle (R) ");

        System.out.println("Enter the Letter:");

            quadChoice = scan.next().charAt(0);

            switch (quadChoice) {
                case 'P':
                    System.out.println("This program calculates the area and perimeter of the parallelogram.");
                    System.out.println("Input the base of your Parallelogram");
                    float pBase = scan.nextFloat();
                    System.out.println("Input the height of your Parallelogram");
                    float pHeight = scan.nextFloat();
                    Parallelogram p = new Parallelogram(pBase, pHeight);

                    Quadrilateral q = p;


                    System.out.println("Input the dimension of the first pair of your Parallelogram");
                    q.setLength(scan.nextFloat());
                    System.out.println("Input the second pair of your Parallelogram");
                    q.setBreadth(scan.nextFloat());

                    System.out.printf("The area of the parallelogram with base %.2f and height %.2f is %.2f", pBase, pHeight, p.Area());

                    System.out.println("");
                    System.out.printf("The perimeter of the parallelogram with First Pair: %.2f and SecondPair: %.2f is %.2f", q.getLength(), q.getBreadth(), q.calculatePerimeter());
                    System.out.println("");
                    System.out.println("");
                    System.out.println("");
                    break;

                case 'T':
                    System.out.println("Calculation for a Trapezoid");
                    System.out.println("Input first side");
                    float a = scan.nextFloat();
                    System.out.println("Input second side");
                    float b = scan.nextFloat();
                    System.out.println("Input third side");
                    float c = scan.nextFloat();
                    System.out.println("Input fourth side");
                    float d = scan.nextFloat();
                    Trapezoid t = new Trapezoid(a, b, c, d);
                    System.out.printf("The perimeter of the Trapezoid with First Side: %.2f, Second Side: %.2f, Third Side: %.2f, and Fourth Side: %.2f is %.2f", a, b, c, d, t.calculatePerimeter());
                    break;

                case 'X':
                    System.out.println("Calculation for rhombus");
                    float ra = scan.nextFloat();
                    System.out.println("Input second side");
                    float rb = scan.nextFloat();
                    System.out.println("Input third side");
                    float rc = scan.nextFloat();
                    System.out.println("Input fourth side");
                    float rd = scan.nextFloat();
                    System.out.println("Input first diagonal");
                    float rd1 = scan.nextFloat();
                    System.out.println("Input second diagonal");
                    float rd2 = scan.nextFloat();

                    Rhombus rh= new Rhombus(ra, rb, rc, rd,rd1,rd2);

                    System.out.printf("The perimeter of the rhombus with First Side: %.2f, Second Side: %.2f, Third Side: %.2f, Fourth Side: %.2f,first diagonal %.2f and second diagonal %.2f is %.2f", ra, rb, rc, rd, rd1, rd2, rh.calculatePerimeter());
                    System.out.println("");
                    System.out.printf("The area of the rhombus with First Side: %.2f, Second Side: %.2f, Third Side: %.2f, Fourth Side: %.2f,first diagonal %.2f and second diagonal %.2f is %.2f", ra, rb, rc, rd, rd1, rd2, rh.area());
                    break;

                case 'S':
                    System.out.println("Calculation for a Square");
                    System.out.println("Input the Length");
                    float xy = scan.nextFloat();
                    Square s = new Square(xy);
                    System.out.printf("The perimeter of the square with  Side: %.2f is %.2f", xy, s.calcPerimeter());
                    System.out.printf("\nThe area of the square with Side: %.2f is %.2f", xy, s.area());
                    break;

                case 'R':
                    System.out.println("Calculation for a Rectangle");
                    System.out.println("Input length");
                    float recL = scan.nextFloat();
                    System.out.println("Input breadth");
                    float recB = scan.nextFloat();
                    Rectangle rec = new Rectangle(recL,recB);
                    System.out.printf("The perimeter of the rectangle with  length: %.2f and breadth %.2f is %.2f", recL,recB, rec.perimeter());
                    System.out.println("");
                    System.out.printf("The area of the rectangle with length: %.2f and breadth %.2f is %.2f", recL,recB, rec.area());
                    break;

                default:
                    break;


            }
        }

        //this should be in the parallelogram case


        //this should be in the Trapezoid case

    }

//Create class for Rhombus
class Rhombus extends Quadrilateral{
    private float side1;
    private float side2;
    private float side3;
    private float side4;
    private float diag1;
    private float diag2;

    public Rhombus(float s1,float s2,float s3,float s4,float d1,float d2){
        side1=s1;
        side2=s2;
        side3=s3;
        side4=s4;
        diag1=d1;
        diag2=d2;
    }
    public float calculatePerimeter(){
        return side1+side2+side3+side4;
    }
    public float area(){
        return (diag1*diag2)/2;
    }


}



//Create class for square
class Square extends Quadrilateral{
    private float squareSide;

    public Square(float ss){
        if (ss <= 0) {
            System.out.println("Base returns to default (1) because you can't have a negative base");
            ss = 1;
        }
        else {
            squareSide = ss;
        }
    }
    public float calcPerimeter(){
        return 4 * squareSide;
    }

    public float area(){
        return squareSide * squareSide;
    }

}



//create class for Rectangle
class Rectangle extends Quadrilateral{
    private float length;
    private float breadth;

    public Rectangle(float l, float b){
        length = l;
        breadth = b;
    }

    public float area(){
        return length * breadth;
    }
    public float perimeter(){
        return 2 * (length + breadth);
    }

}


class Trapezoid extends Quadrilateral {
    private float side1;
    private float side2;
    private float side3;
    private float side4;
    public Trapezoid (float a, float b, float c, float d){
        side1 = a;
        side2 = b;
        side3 = c;
        side4 = d;
    }

    public float calculatePerimeter(){
        return side1+side2+side3+side4;
    }
}
class Parallelogram extends Quadrilateral {
    private float base;
    private float height;
    public Parallelogram (float b, float h){
        if (b <= 0){
            System.out.println("You cannot have a negative or zero base. Therefore base returns to default which is 1");
            base = 1;
        }
        else
            base = b;
        if (h <= 0){
            System.out.println("You cannot have a negative or zero height. Therefore height returns to default which is 1");
            height = 1;
        }
        else
            height = h;
    }
    public float Area(){
        return base*height;
    }

}
class Quadrilateral {
    private float length;
    private float breadth;

    public void setLength(float l){
        length = l;
    }

    public float getLength(){
        return length;
    }

    public void setBreadth(float b){
        breadth = b;
    }

    public float getBreadth(){
        return breadth;
    }

    public float calculatePerimeter(){
        return 2*(length+breadth);
    }

}
