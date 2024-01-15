package ru.netology.cloud.controllers;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import ru.netology.cloud.models.FilePutRequest;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@RestController
@ResponseBody
public class FileApiImpl implements FileApi {

    @Override
    public ResponseEntity<File> fileGet(String authToken, String filename) {
        // return FileApi.super.fileGet(authToken, filename);
        /////////////////////////////////////////////////////////

        System.out.println("###########################################" + authToken);
        File file = new File("./storage/" + filename);
        System.out.println(filename);
        FileWriter fr = null;
        try {
            if (file.createNewFile()) {
                System.out.println("File created");
                fr = new FileWriter(file);
                fr.write("Hello");
            } else {
                System.out.println("File already exists");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            //close resources
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        ////////////////////////////////////////////////////////
        //return ResponseEntity.ok(new File("./storage/" + filename));
        //return ResponseEntity.ok().contentType(MediaType.TEXT_PLAIN).body(file.toString());
        //return ResponseEntity.ok(file); "application/octet-stream" MULTIPART_MIXED
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_XML).body(file);
    }

        @Override
        public ResponseEntity<Void> fileDelete(String authToken, String filename) {
                return FileApi.super.fileDelete(authToken, filename);
        }

        @Override
        public ResponseEntity<Void> filePost(String authToken, String filename, String hash, MultipartFile file) {
                return FileApi.super.filePost(authToken, filename, hash, file);
        }

        @Override
        public ResponseEntity<Void> filePut(String authToken, FilePutRequest filePutRequest, String filename) {
                return FileApi.super.filePut(authToken, filePutRequest, filename);
        }
}
