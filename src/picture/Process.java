package picture;

public class Process {
    Picture picture;
    Picture[] pics;

    public Process(Picture picture) {
        this.picture = picture;
    }

    public Process(Picture[] pictures, Picture picture) {
        this.pics = pictures;
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
                    newPic.setPixel(picture.getHeight() - y - 1, x, picture.getPixel(x, y));
                }
            }
            picture = newPic;
        }
        for (int i = 0; i < (rotateBy / 90); i++) {
            rotate(90);
        }



    }

    public void flip(char flipOn) {
        Picture newPic = Utils.createPicture(picture.getWidth(), picture.getHeight());
        if (flipOn == 'H') {
            for (int x = 0; x < picture.getWidth(); x++) {
                for (int y = 0; y < picture.getHeight(); y++) {
                    newPic.setPixel(picture.getWidth() - (x + 1), y, picture.getPixel(x, y));
                }
            }
            picture = newPic;
        }
        else if (flipOn == 'V') {
            for (int x = 0; x < picture.getWidth(); x++) {
                for (int y = 0; y < picture.getHeight(); y++) {
                    newPic.setPixel(x, picture.getHeight() - (y + 1), picture.getPixel(x, y));
                }
            }
            picture = newPic;
        }
        else {
            System.err.println("Please enter a valid direction (H/V)");
        }
    }

    public void blend() {
        Picture newPic = Utils.createPicture(picture.getWidth(), picture.getHeight());
        int r;
        int g;
        int b;
        for (int x = 0; x < picture.getWidth(); x++) {
            for (int y = 0; y < picture.getHeight(); y++) {
                r = 0;
                b = 0;
                g = 0;
                for (Picture pic : pics) {
                    r += pic.getPixel(x, y).getRed();
                    b += pic.getPixel(x, y).getBlue();
                    g += pic.getPixel(x, y).getGreen();
                }
                newPic.setPixel(x, y, new Color(r/pics.length, g/pics.length, b/pics.length));
            }
        }
        picture = newPic;
    }

    public void blur() {
        int sum;
        Picture newPic = Utils.createPicture(picture.getWidth(), picture.getHeight());
        int r;
        int g;
        int b;
        for (int x = 0; x < picture.getWidth(); x++) {
            for (int y = 0; y < picture.getHeight(); y++) {
                if (x > 0 && y > 0 && x < picture.getWidth() - 1 && y < picture.getHeight() - 1)
                {
                    r = 0;
                    b = 0;
                    g = 0;
                    for (int i = -1; i <= 1; i++)
                    {
                        for (int j = -1; j <= 1; j++)
                        {
                            r += picture.getPixel(x + i, y + j).getRed();
                            b += picture.getPixel(x + i, y + j).getBlue();
                            g += picture.getPixel(x + i, y + j).getGreen();
                        }
                        newPic.setPixel(x, y, new Color(r/9, g/9, b/9));
                    }
                }
                else
                {
                    newPic.setPixel(x, y, picture.getPixel(x, y));
                }
            }
        }
        picture = newPic;
    }
}
