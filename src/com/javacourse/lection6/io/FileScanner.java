package com.javacourse.lection6.io;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

class FileScanner
{
  private String path;

  FileScanner(String path)
  {
    this.path=path;
  }

  List<File> getFiles()
  {
    List<File> fileList=new ArrayList<>();

    File dir=new File(path);
    File[] files=dir.listFiles();

    if (files != null)
    {
      for (File f : files)
      {
        if (!f.isDirectory())
        {
          fileList.add(f);
        }
        else
        {
          FileScanner fs=new FileScanner(f.getPath());
          fileList.addAll(fs.getFiles());
        }
      }
    }
    return fileList;
  }
}
