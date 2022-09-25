package learningtest.template;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Calculator {

    public Integer calcSum(String filePath) throws IOException {
        BufferedReaderCallback bufferedReaderCallback = new BufferedReaderCallback() {

            @Override
            public Integer doSomethingWithReader(BufferedReader br) throws IOException {
                Integer sum = 0;
                String line = null;

                while ((line = br.readLine()) != null) {
                    sum += Integer.parseInt(line);
                }
                return sum;
            }
        };

        return fileReadTemplate(filePath, bufferedReaderCallback);
    }

    public Integer calcMultiply(String filePath) throws IOException {
        BufferedReaderCallback  bufferedReaderCallback = br -> {
            Integer multifly = 1;
            String line = null;

            while ((line = br.readLine()) != null) {
                multifly *= Integer.parseInt(line);
            }
            return multifly;
        };

        return fileReadTemplate(filePath, bufferedReaderCallback);
    }

    public Integer fileReadTemplate(String filePath, BufferedReaderCallback callback) throws IOException {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filePath));
            return callback.doSomethingWithReader(br);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw e;
        } finally {
            if (br != null) {
                br.close();
            }
        }
    }
}
