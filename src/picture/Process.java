package picture;

public class Process {
    Picture picture;
    public Process(Picture picture) {
        this.picture = picture;
    }

    public picture.Picture getPicture() {
        return picture;
    }

    public void invert() {
        for (int x = 0; x < picture.getWidth(); x++) {
            for (int y = 0; y < picture.getHeight(); y++) {
                Color pixel = picture.getPixel(x, y);
                picture.setPixel(x, y, new Color(255 - pixel.getRed(),255 - pixel.getGreen(),255 - pixel.getBlue()));
            }
        }
    }

    public void grayscale() {
        for (int x = 0; x < picture.getWidth(); x++) {
            for (int y = 0; y < picture.getHeight(); y++) {
                Color pixel = picture.getPixel(x, y);
                int ave = (pixel.getBlue() + pixel.getRed() + pixel.getGreen()) / 3;
                picture.setPixel(x, y, new Color(ave, ave, ave));
            }
        }
    }

    public void rotate(int rotateBy) {
        if (rotateBy == 90) {
            Picture newPic = Utils.createPicture(picture.getHeight(), picture.getWidth());
            for (int x = 0; x < picture.getWidth(); x++) {
                for (int y = 0; y < picture.getHeight(); y++) {
                    newPic.setPixel(y, x, picture.getPixel(x, y));
                }
            }
            picture = newPic;
        }
        else if (rotateBy == 180) {
            flip('H');
            flip('V');
        }
        else if (rotateBy == 270) {
            rotate(90);
            flip('H');
            flip('V');
        }
        else {
            System.err.println("Please enter a valid angle.");
        }



    }

    public void flip(char flipOn) {
        Picture newPic = Utils.createPicture(picture.getWidth(), picture.getHeight());
        if (flipOn == 'H') {
            for (int x = 0; x < picture.getWidth(); x++) {
                for (int y = 0; y < picture.getHeight(); y++) {
                    newPic.setPixel(picture.getWidth() - x, y, picture.getPixel(x, y));
                }
            }
            picture = newPic;
        }
        else if (flipOn == 'V') {
            for (int x = 0; x < picture.getWidth(); x++) {
                for (int y = 0; y < picture.getHeight(); y++) {
                    newPic.setPixel(x, picture.getHeight() - y, picture.getPixel(x, y));
                }
            }
            picture = newPic;
        }
        else {
            System.err.println("Please enter a valid direction (H/V)");
        }
    }

    public void blend() {

    }

    public static void blur() {

    }
}
