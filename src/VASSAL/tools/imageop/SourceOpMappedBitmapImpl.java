/*
 * $Id: Board.java 4333 2008-10-26 14:13:58Z uckelman $
 *
 * Copyright (c) 2008 by Joel Uckelman 
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Library General Public
 * License (LGPL) as published by the Free Software Foundation.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Library General Public License for more details.
 *
 * You should have received a copy of the GNU Library General Public
 * License along with this library; if not, copies are available
 * at http://www.opensource.org.
 */
package VASSAL.tools.imageop;

import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;

import VASSAL.tools.DataArchive;
import VASSAL.tools.memmap.MappedImageUtils;

/**
 * @author Joel Uckelman
 * @since 3.1.0
 */
public class SourceOpMappedBitmapImpl extends SourceOpBitmapImpl
                                      implements SourceOp {
  public SourceOpMappedBitmapImpl(String name) {
    super(name);
  }
  
  public SourceOpMappedBitmapImpl(String name, DataArchive archive) {
    super(name, archive);
  }

  /**
   *  {@inheritDoc}
   *
   * @throws IOException if the image cannot be loaded from the image file.
   */
  @Override
  public BufferedImage eval() throws IOException {
    try {
      return MappedImageUtils.getImage(archive.getImageInputStream(name));
    }
    catch (FileNotFoundException e) {
      throw new MissingImageException(name, e);
    }
  }
}
