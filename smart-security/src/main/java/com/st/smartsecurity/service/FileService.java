package com.st.smartsecurity.service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
public interface FileService {
    Map<String, List<String>> uploadImgs(MultipartFile[] file);
}
