package lab12.ex5;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.atomic.AtomicLong;

public class Visitor {
    private final String dirPath;
    private final boolean isRecursive;

    public Visitor(String dirPath, boolean isRecursive) {
        this.dirPath = dirPath;
        this.isRecursive = isRecursive;
        computeDirectorySize();
    }

    private void computeDirectorySize() {
        AtomicLong totalSize = new AtomicLong(0);

        try {
            Path startPath = Paths.get(dirPath);

            Files.walkFileTree(startPath, new SimpleFileVisitor<Path>() {

                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    if (!isRecursive && !startPath.equals(dir)) {
                        return FileVisitResult.SKIP_SUBTREE;
                    }
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    long fileSize = attrs.size();
                    totalSize.addAndGet(fileSize);
                    System.out.println(file.getFileName() + ": " + fileSize + " bytes");
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    if (startPath.equals(dir)) {
                        System.out.println("Total size: " + totalSize.get() + " bytes");
                    }
                    return FileVisitResult.CONTINUE;
                }

            });
        } catch (IOException e) {
            System.err.println("Error encountered: " + e.getMessage());
            System.exit(1);
        }
    }
}