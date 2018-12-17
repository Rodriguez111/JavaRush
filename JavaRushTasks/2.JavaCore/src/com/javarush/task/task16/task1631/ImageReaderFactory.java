package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

public class ImageReaderFactory {
   public static ImageReader getImageReader (ImageTypes types) throws IllegalArgumentException {

       if (types==null)throw new IllegalArgumentException("Неизвестный тип картинки");

       ImageReader imgrdr=null;

switch (types){
    case BMP: imgrdr = new BmpReader();
    break;
    case JPG: imgrdr = new JpgReader();
    break;
    case PNG: imgrdr = new PngReader();
    break;
default: throw new IllegalArgumentException("Неизвестный тип картинки");

}

return imgrdr;

   }


}
