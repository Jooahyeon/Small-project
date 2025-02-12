package section03.repository;

import section03.aggregate.Cat;
import section03.aggregate.CatStatus;
import section03.aggregate.Gender;

import java.io.*;
import java.util.Date;
import java.util.ArrayList;

public class CatRepository {


    private final ArrayList<Cat> catList = new ArrayList<>();
    private final File file =
            new File("src/main/java/section03/db/catDB.dat");

    public CatRepository() {

        if (!file.exists()) {
            ArrayList<Cat> defaultCats = new ArrayList<>();
            defaultCats.add(new Cat(1, "나비", "코리안숏헤어", Gender.FEMALE, "2024-02-12", CatStatus.ACTIVE, false));
            defaultCats.add(new Cat(2, "강하돌", "브리티쉬숏헤어", Gender.MALE, "2022-05-02", CatStatus.ACTIVE, true));
            defaultCats.add(new Cat(3, "강하루", "하이랜드폴드", Gender.MALE, "2021-04-08", CatStatus.ACTIVE, true));

            saveCats(defaultCats);  // 더미데이터 저장 메소드
        }

        loadCats();
    }

    private void loadCats() {
        try (ObjectInputStream ois = new ObjectInputStream(
                new BufferedInputStream(
                        new FileInputStream(file)
                )
        )) {
            while (true) {
                catList.add((Cat)ois.readObject());
            }

        } catch (EOFException e){
            System.out.println("고양이 정보 다 읽어옴");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void saveCats(ArrayList<Cat> inputCats) {
        ObjectOutputStream oos = null;  // 객체를 직렬화하기 위해 ObjectOutputStream 사용

        try {
            oos = new ObjectOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(file)
                    )
            );

            for (Cat cat : inputCats) {
                oos.writeObject(cat);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
