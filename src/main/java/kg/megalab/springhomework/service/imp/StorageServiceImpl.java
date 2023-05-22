package kg.megalab.springhomework.service.imp;

import kg.megalab.springhomework.service.StorageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Qualifier("storageService")


public class StorageServiceImpl implements StorageService {
    private List<String> list = new ArrayList<>();

    public List<String> get() {
        return list;
    }

    public void add(String str) {
        if (!containStr(str)) {
            list.add(str);
            log.info("String {} added to the list", str);
        } else
            log.error("String {} didn't add to the list", str);
    }
    public boolean delete(String str) {
        if (!containStr(str)) {
            log.error("String {} doesn't contain in the list", str);
            return false;
        }
        boolean isDelete = list.remove(str);
        log.info("String {} deleted from list", str);
        return isDelete;
    }
    public boolean isInList(String str) {
        return containStr(str);
    }
    public String getCats() {
        return null;
    }
    public boolean containStr(String str) {
        return list.contains(str);
    }
}
