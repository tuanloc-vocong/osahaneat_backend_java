package com.tuanloc.osahaneat.service.impl;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileServiceImpl {
    boolean saveFile(MultipartFile file);
    Resource loadFile(String fileName);
}
