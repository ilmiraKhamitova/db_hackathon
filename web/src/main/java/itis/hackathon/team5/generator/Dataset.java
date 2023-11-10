package itis.hackathon.team5.generator;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Dataset {
    private final List<String> dataList;
    public Dataset(String fileName) throws IOException {
        dataList = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String s;
            while ((s = reader.readLine()) != null) {
                dataList.add(s);
            }
        }
    }

    public String getNext() {
        return dataList.get((int) (Math.random() * dataList.size()));
    }

}
