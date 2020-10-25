package com.youcam.backend.service;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.youcam.backend.model.ImageFile;
import com.youcam.backend.repository.ImageFileRepository;

@Service
public class ImageFileService {

  @Autowired
  private ImageFileRepository fileRepository;

  public ImageFile store(MultipartFile file) throws IOException {
    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
    ImageFile FileDB = new ImageFile(fileName, file.getContentType(), file.getBytes());

    return fileRepository.save(FileDB);
  }

  public ImageFile getFile(String id) {
    return fileRepository.findById(id).get();
  }
  
  public Stream<ImageFile> getAllFiles() {
    return fileRepository.findAll().stream();
  }
}
