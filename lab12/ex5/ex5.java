package lab12.ex5;

public class ex5 {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("ERROR! No arguments provided.");
            displayUsage();
            System.exit(1);
        }

        if (args.length == 1) {
            new Visitor(args[0], false);
        } else if (args.length == 2) {
            if (args[0].equals("-r")) {
                new Visitor(args[1], true);
            } else {
                displayUsage();
                System.exit(1);
            }
        } else {
            displayUsage();
            System.exit(1);
        }
    }

    private static void displayUsage() {
        System.out.println(
                """
                        Usage:
                            java DirectorySizeVisitor [-option] path
                        Options:
                            -r: Include sizes of files within subdirectories recursively
                        """);
    }
}