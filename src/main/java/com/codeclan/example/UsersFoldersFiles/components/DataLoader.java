package com.codeclan.example.UsersFoldersFiles.components;

import com.codeclan.example.UsersFoldersFiles.models.*;
import com.codeclan.example.UsersFoldersFiles.repositories.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FileRepository fileRepository;

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    UserRepository userRepository;


    public DataLoader() {
    }

    public void run(ApplicationArguments args) {

        User john = new User("John");
        userRepository.save(john);

        Folder oldSchoolCool = new Folder("Old School Kool", john);
        folderRepository.save(oldSchoolCool);

        File crazyFrog = new File("CrAzY_fRoG", ".exe", 3.5, oldSchoolCool);
        fileRepository.save(crazyFrog);

        File bigTune = new File("Big_Tune", ".mp3", 16, oldSchoolCool);
        fileRepository.save(crazyFrog);

    }
}
