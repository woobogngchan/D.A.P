package com.hk2.dap.domain.academy.entity;

import com.hk2.dap.domain.lesson.entity.Lesson;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class Academy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String academyId;

    @Column(nullable = false)
    private String academyPassword;

    @Column(nullable = false)
    private String academyName;

    @Column
    private String academyInfo;

    @Column(nullable = false)
    private AcademyCiyEnum city;

    @Column(nullable = false)
    private AcademyDistrictEnum district;

    @Column(nullable = false)
    private String academyPhoneNum;

    @OneToMany(mappedBy = "academy", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Lesson> academyLesson;

    @Builder
    public Academy(String academyId, String academyPassword, String academyInfo, String academyName, String academyPhoneNum, AcademyCiyEnum city, AcademyDistrictEnum district){
        this.academyId = academyId;
        this.academyInfo = academyInfo;
        this.academyName = academyName;
        this.academyPassword = academyPassword;
        this.academyPhoneNum = academyPhoneNum;
        this.city = city;
        this.district = district;
    }
}
