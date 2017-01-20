package picture;

public class Main {

    public static void main(String[] args) {
        switch (args[0]) {
            case "invert": {
                Process process = new Process(Utils.loadPicture(args[1]));
                process.invert();
                Utils.savePicture(process.getPicture(), args[2]);
            }
            break;
            case "grayscale": {
                Process process = new Process(Utils.loadPicture(args[1]));
                process.grayscale();
                Utils.savePicture(process.getPicture(), args[2]);
            }
            break;
            case "rotate": {
                Process process = new Process(Utils.loadPicture(args[2]));
                process.rotate(Integer.parseInt(args[1]));
                Utils.savePicture(process.getPicture(), args[3]);

            }
            break;
            case "flip": {
                Process process = new Process(Utils.loadPicture(args[2]));
                process.flip(args[1].charAt(0));
                Utils.savePicture(process.getPicture(), args[3]);
            }
            break;
            case "blend": {
                Picture[] pics = new Picture[args.length - 2];
                int minW = Integer.MAX_VALUE;
                int minH = Integer.MAX_VALUE;
                for (int i = 0; i < args.length - 2; i++) {
                    pics[i] = Utils.loadPicture(args[i + 1]);
                    minW = Math.min(minW, pics[i].getWidth());
                    minH = Math.min(minH, pics[i].getHeight());
                }
                Process process = new Process(pics, Utils.createPicture(minW, minH));
                process.blend();
                Utils.savePicture(process.getPicture(), args[args.length - 1]);
            }
            break;
            case "blur": {
                Process process = new Process(Utils.loadPicture(args[1]));
                process.blur();
                Utils.savePicture(process.getPicture(), args[2]);
            }
            break;
            default:
                System.err.println("Invalid input. Please try again");

        }
    }
}
