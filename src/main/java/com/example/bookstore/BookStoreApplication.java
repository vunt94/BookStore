package com.example.bookstore;

import com.example.bookstore.model.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;

@SpringBootApplication
public class BookStoreApplication {

    public static void main(String[] args) {

        try {

            File file = new File("src\\main\\webapp\\WEB-INF\\xml\\book.xml");

            JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);

            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            Student student = (Student) unmarshaller.unmarshal(file);

            System.out.println(student.getFirstName());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
