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
        String pic="https://media.edutopia.org/styles/responsive_2880px_16x9/s3/masters/d7_images/cover_media/alber-169hero-thelook-shutterstock_0.jpg";
        m=new Job(t,c,a,p,pic);
        jobRepository.save(m);
        t="Pet Care";
        c="feed rabbit";
        a="Nora";
        p="123-456-789";
        pic="https://media.npr.org/assets/img/2017/09/14/gettyimages-10141026_slide-67be9fc1bca330b26debade87690b5e84286614d-s800-c85.jpg";
        m=new Job(t,c,a,p,pic);
        jobRepository.save(m);


        t="Just want you earn money without doing anything";
        c="Play with rabbit";
        a="Nora";
        p="123-456-789";
        m=new Job(t,c,a,p);
        jobRepository.save(m);






}
}
