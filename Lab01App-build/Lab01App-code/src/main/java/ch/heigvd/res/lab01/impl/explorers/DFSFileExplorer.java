package ch.heigvd.res.lab01.impl.explorers;

import ch.heigvd.res.lab01.interfaces.IFileExplorer;
import ch.heigvd.res.lab01.interfaces.IFileVisitor;

import java.io.File;
import java.util.Arrays;

/**
 * This implementation of the IFileExplorer interface performs a depth-first
 * exploration of the file system and invokes the visitor for every encountered
 * node (file and directory). When the explorer reaches a directory, it visits all
 * files in the directory and then moves into the subdirectories.
 *
 * @author Olivier Liechti
 * @author Dejvid Muaremi
 */
public class DFSFileExplorer implements IFileExplorer {
  
  @Override
  public void explore(File rootDirectory, IFileVisitor vistor) {
    vistor.visit(rootDirectory);
    File[] files = rootDirectory.listFiles();
    
    if (files != null) {
      // Unix like systems are now supported
      Arrays.sort(files);
  
      for (File file : files) {
        if (file.isDirectory()) {
          explore(file, vistor);
        } else {
          vistor.visit(file);
        }
      }
    }
  }
}

