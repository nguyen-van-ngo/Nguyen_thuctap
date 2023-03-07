package com.example.demothuctap.respositories;

import com.example.demothuctap.models.entity.Fresher;
import com.example.demothuctap.models.response.Transcript;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface FresherRepository extends JpaRepository<Fresher, String> {
    @Query("SELECT new com.example.demothuctap.models.response.Transcript" +
            "(f.fresherName, sb.lp, sc.score01, sc.score02, sc.score03, (sc.score01+sc.score02+sc.score03)/3) " +
            "From Fresher f INNER JOIN Score sc ON sc.fresher.fresherId = f.fresherId INNER JOIN " +
            "Subject sb ON sb.subjectId = sc.subject.subjectId")
    public List<Transcript> getTranscript();
    public List<Fresher> findByFresherId(String fresherId);
}

