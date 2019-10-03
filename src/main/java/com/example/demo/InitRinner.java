package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
@Component
public class InitRinner implements CommandLineRunner {
    @Autowired
    JobRepository jobRepository;
    @Override
    public void run(String... args) throws Exception {
        Job m;
        String t="teacher";
        String c="teaching";
        String a="Nora";
        String p="123-456-789";
        m=new Job(t,c,a,p);
        jobRepository.save(m);
        t="Pet Care";
        c="feed rabbit";
        a="Nora";
        p="123-456-789";
        m=new Job(t,c,a,p);
        jobRepository.save(m);


        t="Just want you earn money without doing anything";
        c="Play with rabbit";
        a="Nora";
        p="123-456-789";
        m=new Job(t,c,a,p);
        jobRepository.save(m);






}
}
