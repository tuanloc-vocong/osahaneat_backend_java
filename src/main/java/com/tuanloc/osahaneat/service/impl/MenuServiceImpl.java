package com.tuanloc.osahaneat.service.impl;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public interface MenuServiceImpl {
    boolean createMenu(MultipartFile file, String title, String is_freeship, String time_ship, double price, int cate_id);
}
