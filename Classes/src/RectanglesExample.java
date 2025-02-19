public class RectanglesExample {

    static class Rectangle{
        protected int width, height;

        public Rectangle(int wight, int height) {
            this.width = wight;
            this.height = height;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            if (width < 0)
                throw new IllegalArgumentException("Width cannot be negative.");
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            if (height < 0)
                throw new IllegalArgumentException("Height cannot be negative.");
            this.height = height;
        }

        public int calcArea(){
            return this.width * this.height;
        }

        @Override
        public String toString() {
            return "Rectangle{" +
                    "width=" + width +
                    ", height=" + height +
                    '}';
        }
    }

    static class FilledRectangle extends Rectangle{
        private String color;

        public FilledRectangle(int wight, int height, String color) {
            super(wight, height);
            if (color == null || color.equals(""))
                throw new IllegalArgumentException("Color cannot be empty.");
            this.color = color;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        @Override
        public String toString() {
            return "FilledRectangle{" +
                    "color='" + color + '\'' +
                    ", width=" + width +
                    ", height=" + height +
                    '}';
        }
    }

    public static void main(String[] args) {

        Rectangle rect = new Rectangle(3, 5);
        System.out.println(rect);

        FilledRectangle filledRect = new FilledRectangle(5, 5, "blue");
        System.out.println(filledRect);

        System.out.println("Area: " + filledRect.calcArea());
    }
}
