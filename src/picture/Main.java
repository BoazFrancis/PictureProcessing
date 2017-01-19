package picture;

public class Main {

  public static void main(String[] args) {
    switch (args[0]) {
      case "invert": {
        Process process = new Process(Utils.loadPicture(args[1]));
        process.invert();
        Utils.savePicture(process.getPicture(), args[2]);
      } break;
      case "grayscale": {
        Process process = new Process(Utils.loadPicture(args[1]));
        process.grayscale();
        Utils.savePicture(process.getPicture(), args[2]);
      } break;
      case "rotate": {
        Process process = new Process(Utils.loadPicture(args[2]));
        process.rotate(Integer.parseInt(args[1]));
        Utils.savePicture(process.getPicture(), args[3]);

      } break;
      case "flip": {
        Process process = new Process(Utils.loadPicture(args[2]));
        process.flip(args[1].charAt(0));
      } break;
      case "blend": {
        Process process = new Process(Utils.loadPicture(args[2]));
        process.blend();
      } break;
      case "blur": {
        Process process = new Process(Utils.loadPicture(args[2]));
        process.blur();
      } break;
      default: System.err.println("Invalid input. Please try again");

    }
  }
}
