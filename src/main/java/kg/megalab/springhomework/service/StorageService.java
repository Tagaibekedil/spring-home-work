package kg.megalab.springhomework.service;

import java.util.List;

public interface StorageService {
     List<String> get();
     void add(String str);
     boolean delete(String str);
     boolean isInList(String str);
    String getCats();
}
