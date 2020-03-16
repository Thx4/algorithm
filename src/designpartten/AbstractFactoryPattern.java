package designpartten;

public class AbstractFactoryPattern {
    public interface Shape {
        void draw();
    }

    public class Rectangle implements Shape {

        @Override
        public void draw() {
            System.out.println("Inside Rectangle::draw() method.");
        }
    }

    public class Square implements Shape {

        @Override
        public void draw() {
            System.out.println("Inside Square::draw() method.");
        }
    }

    public class Circle implements Shape {

        @Override
        public void draw() {
            System.out.println("Inside Circle::draw() method.");
        }
    }

    public interface Color {
        void fill();
    }

    public class Red implements Color {

        @Override
        public void fill() {
            System.out.println("Inside Red::fill() method.");
        }
    }

    public class Green implements Color {

        @Override
        public void fill() {
            System.out.println("Inside Green::fill() method.");
        }
    }

    public class Blue implements Color {

        @Override
        public void fill() {
            System.out.println("Inside Blue::fill() method.");
        }
    }

    public abstract class AbstractFactory {
        public abstract Color getColor(String color);
        public abstract Shape getShape(String shape) ;
    }

    public class ShapeFactory extends AbstractFactory {

        @Override
        public Shape getShape(String shapeType){
            if(shapeType == null){
                return null;
            }
            if(shapeType.equalsIgnoreCase("CIRCLE")){
                return new Circle();
            } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
                return new Rectangle();
            } else if(shapeType.equalsIgnoreCase("SQUARE")){
                return new Square();
            }
            return null;
        }

        @Override
        public Color getColor(String color) {
            return null;
        }
    }

    public class ColorFactory extends AbstractFactory {

        @Override
        public Shape getShape(String shapeType){
            return null;
        }

        @Override
        public Color getColor(String color) {
            if(color == null){
                return null;
            }
            if(color.equalsIgnoreCase("RED")){
                return new Red();
            } else if(color.equalsIgnoreCase("GREEN")){
                return new Green();
            } else if(color.equalsIgnoreCase("BLUE")){
                return new Blue();
            }
            return null;
        }
    }

    public class FactoryProducer {
        public  AbstractFactory getFactory(String choice){
            if(choice.equalsIgnoreCase("SHAPE")){
                return new ShapeFactory();
            } else if(choice.equalsIgnoreCase("COLOR")){
                return new ColorFactory();
            }
            return null;
        }
    }


}
